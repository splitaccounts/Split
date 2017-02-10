package com.splitaccounts.split.test.android;

import com.splitaccounts.split.database.SplitDbData;
import com.splitaccounts.split.database.TableProject;
import com.splitaccounts.split.database.TableProjectUseCurrency;
import com.splitaccounts.split.database.TableProjectUser;
import com.splitaccounts.split.database.TableSetting;
import com.splitaccounts.split.database.TableState;
import com.splitaccounts.split.database.TableCurrency;
import com.splitaccounts.split.database.TableValueType;
import com.splitaccounts.split.helper.DateHelper;
import com.splitaccounts.split.database.SplitDbHelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by gaellecoz on 28.10.2015.
 */
public class TestDatabaseHelper extends AndroidTestCase {
    private SplitDbHelper dbHelper;
    //private SQLiteDatabase db;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        dbHelper = SplitDbHelper.getInstance(context);
        //dbHelper.onDelete();
        dbHelper.openDatabase();
    }

    @Override
    public void tearDown() throws Exception {
        dbHelper.closeDatabase();
        super.tearDown();
    }

    public void testDbInit(){
        dbHelper.openDatabase();
        HashMap<String, Long> nb = dbHelper.getNbElement();

        long nbElem;

        nbElem = nb.get((new TableState()).getTableName());
        assertEquals(nbElem, (new TableState()).getBaseValues().length);

        nbElem = nb.get((new TableValueType()).getTableName());
        assertEquals(nbElem, (new TableValueType()).getBaseValues().length);

        nbElem = nb.get((new TableSetting()).getTableName());
        assertEquals(nbElem, (new TableSetting()).getBaseValues().length);

        nbElem = nb.get((new TableCurrency()).getTableName());
        assertEquals(nbElem, (new TableCurrency()).getBaseValues().length);

        dbHelper.closeDatabase();
    }

    public void testAddProject() {
        dbHelper.openDatabase();

        String name = new BigInteger(130, new SecureRandom()).toString(32);

        long id = dbHelper.addProject(name);

        Cursor c = dbHelper.getEntry(new TableProject(), id);

        c.moveToFirst();

        assertEquals(id, c.getLong(c.getColumnIndex(TableProject._ID)));
        assertEquals(name, c.getString(c.getColumnIndex(TableProject.COLUMN_NAME)));

        c.close();

        dbHelper.closeDatabase();
    }

    public void testDeleteProject() {
        dbHelper.openDatabase();
        String name = new BigInteger(130, new SecureRandom()).toString(32);

        long id = dbHelper.addProject(name);

        dbHelper.deleteEntry(new TableProject(), id);

        Cursor c = dbHelper.getEntry(new TableProject(), id);

        assertEquals(0, c.getCount());

        c.close();
        dbHelper.closeDatabase();
    }

    public void testUpdateProject() {
        Date date = new Date();
        String name = new BigInteger(130, new SecureRandom()).toString(32);

        dbHelper.openDatabase();

        // Add project
        long id = dbHelper.addProject(name);

        // Create new data
        String newName = new BigInteger(130, new SecureRandom()).toString(32);

        ContentValues values = new ContentValues();
        values.put(TableProject.COLUMN_STATE_ID, Arrays.asList(TableState.BASE_VALUES).indexOf("closed"));
        values.put(TableProject.COLUMN_NAME, newName);
        values.put(TableProject.COLUMN_CREATED, DateHelper.toText(date));

        // Update entry
        dbHelper.updateEntry(new TableProject(), id, values);

        // Read project
        Cursor c = dbHelper.getEntry(new TableProject(), id);

        c.moveToFirst();
        assertEquals(id, c.getLong(c.getColumnIndex(TableProject._ID)));
        assertEquals(Arrays.asList(TableState.BASE_VALUES).indexOf("closed"), c.getLong(c.getColumnIndex(TableProject.COLUMN_STATE_ID)));
        assertEquals(newName, c.getString(c.getColumnIndex(TableProject.COLUMN_NAME)));
        assertEquals(DateHelper.toText(date), c.getString(c.getColumnIndex(TableProject.COLUMN_CREATED)));

        c.close();
        dbHelper.closeDatabase();
    }

    public void testAddProjectUseCurrency() {
        long currencyId = 55;
        long currencyId2 = 56;

        dbHelper.openDatabase();

        String name = new BigInteger(130, new SecureRandom()).toString(32);

        // Add a project
        long projId = dbHelper.addProject(name);

        // Link with a currency
        dbHelper.addProjectUseCurrency(projId, currencyId, 1);


        Cursor c = dbHelper.getEntry(
                new TableProjectUseCurrency(),
                null,
                TableProjectUseCurrency.COLUMN_PROJECT_ID + " = ?",
                new String[] {String.valueOf(projId)},
                null,
                null,
                null,
                null);

        c.moveToFirst();

        assertEquals(projId, c.getLong(c.getColumnIndex(TableProjectUseCurrency.COLUMN_PROJECT_ID)));
        assertEquals(currencyId, c.getLong(c.getColumnIndex(TableProjectUseCurrency.COLUMN_CURRENCY_ID)));

        c.close();

        // Link with another currency
        dbHelper.addProjectUseCurrency(projId, currencyId2, 0);

        dbHelper.closeDatabase();
    }

    public void testAddUser() {
        dbHelper.openDatabase();

        String name;
        long idProj = -1;

        name = new BigInteger(130, new SecureRandom()).toString(32);
        idProj = dbHelper.addProject(name);


        name = new BigInteger(130, new SecureRandom()).toString(32);
        long idUser = dbHelper.addUser(name, idProj);

        Cursor c = dbHelper.getEntry(new TableProjectUser(), idUser);

        c.moveToFirst();

        assertEquals(idUser, c.getLong(c.getColumnIndex(TableProjectUser._ID)));
        assertEquals(name, c.getString(c.getColumnIndex(TableProjectUser.COLUMN_NAME)));
        assertEquals(idProj, c.getLong(c.getColumnIndex(TableProjectUser.COLUMN_PROJECT_ID)));

        c.close();

        dbHelper.closeDatabase();

    }

    public void testDeleteUser() {
        dbHelper.openDatabase();

        String name;

        name = new BigInteger(130, new SecureRandom()).toString(32);
        long idProj = dbHelper.addProject(name);

        name = new BigInteger(130, new SecureRandom()).toString(32);
        long idUser = dbHelper.addUser(name, idProj);

        dbHelper.deleteEntry(new TableProjectUser(), idUser);

        Cursor c = dbHelper.getEntry(new TableProjectUser(), idUser);

        assertEquals(0, c.getCount());

        c.close();

        dbHelper.closeDatabase();
    }

    public void testUpdateUser() {
        dbHelper.openDatabase();

        // Add a project
        String name;
        long idProj = -1;

        for (int i = 0; i < 100; i++) {
            name = new BigInteger(130, new SecureRandom()).toString(32);
            idProj = dbHelper.addProject(name);
        }

        // Add a user
        name = new BigInteger(130, new SecureRandom()).toString(32);
        long idUser = dbHelper.addUser(name, idProj);

        // Create new data
        String newName = new BigInteger(130, new SecureRandom()).toString(32);

        ContentValues values = new ContentValues();
        values.put(TableProjectUser.COLUMN_NAME, newName);

        // Update entry
        dbHelper.updateEntry(new TableProjectUser(), idUser, values);

        // Read project user
        Cursor c = dbHelper.getEntry(new TableProjectUser(), idUser);

        c.moveToFirst();
        assertEquals(idUser, c.getLong(c.getColumnIndex(TableProjectUser._ID)));
        assertEquals(newName, c.getString(c.getColumnIndex(TableProjectUser.COLUMN_NAME)));

        c.close();

        dbHelper.closeDatabase();
    }

    public void testRandomData() {
        dbHelper.openDatabase();

        SplitDbData.generateData(dbHelper);

        dbHelper.closeDatabase();
    }
}