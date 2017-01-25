package com.splitaccounts.split.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.splitaccounts.split.helper.DateHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gaellecoz on 28.10.2015.
 */
public class SplitDbHelper extends SQLiteOpenHelper {

    // Database Name
    private static final String DATABASE_NAME = "Split.db";
    // Database Version
    private static final int DATABASE_VERSION = 1;

    private static SplitDbHelper instance = null;
    private static SQLiteDatabase db;
    private static AtomicInteger openCounter = new AtomicInteger();
    private static Context context;

    /**
     * Constructor should be private to prevent direct instantiation.
     * make call to static method "getInstance()" instead.
     */
    private SplitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    /**
     * Get the instance of a SplitDbHelper
     * @param context Important, pass the application context to avoid leaking activity context
     * @return The instance of a SplitDbHelper
     */
    public static synchronized SplitDbHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (instance == null) {
            instance = new SplitDbHelper(context);
        }
        return instance;
    }

    public synchronized void openDatabase() {
        if (instance == null) {
            throw new IllegalStateException(SplitDbHelper.class.getSimpleName() +
                    " is not initialised, call getInstance(..) method first.");
        }
        if(openCounter.incrementAndGet() == 1) {
            // Opening new database
            db = super.getWritableDatabase();

            if (db == null) {
                throw new NullPointerException("Cannot open database");
            }
        }
    }

    public static synchronized void closeDatabase() {
        if(openCounter.decrementAndGet() == 0) {
            // Closing database
            db.close();
            db = null;
        }
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        throw new UnsupportedOperationException("getWritableDatabase() must not be called, use openDatabase() instead.");

    }

    @Override
    public synchronized void onCreate(SQLiteDatabase db) {
        this.db = db;
        onEmpty();
        createTables();
        SplitDbData.generateData(this);

        Log.d("db_created", "Split database created.");
    }

    @Override
    public synchronized void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("db_upgraded", "Split database upgraded from v" + String.valueOf(oldVersion) + " to v" + String.valueOf(newVersion) + ".");
    }

    public synchronized void onEmpty() {
        dropTables();
        Log.d("db_empty", "Split database emptied.");
    }

    public synchronized void onDelete() {
        close();
        openCounter.set(0);
        context.deleteDatabase(getDatabaseName());
        Log.d("db_deleted", "Split database deleted.");
    }

    private synchronized void createTables()
    {
        try {
            db.beginTransaction();

            // create all tables
            for (AbstractSplitDbTable table : SplitDbContractV1.getTables()) {
                for (String query : table.getSqlCreate()) {
                    db.execSQL(query);
                }
            }

            initTables(db);

            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    private synchronized void initTables(SQLiteDatabase db)
    {
        for (AbstractSplitDbTable table : SplitDbContractV1.getTables()) {

            List<String> insert = table.getBaseValuesInsert();
            if(insert == null){continue;}

            for (String query : insert) {
                db.execSQL(query);
            }
        }
    }

    private synchronized void dropTables()
    {
        try {
            db.beginTransaction();

            // drop all tables
            for (AbstractSplitDbTable table : SplitDbContractV1.getTables()) {
                for(String query : table.getSqlDrop()) {
                    db.execSQL(query);
                }
            }

            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    public synchronized long getTableCount(String tableName) {
        return DatabaseUtils.queryNumEntries(db, tableName);
    }

    public synchronized HashMap<String, Long> getNbElement()
    {
        return getNbElement(SplitDbContractV1.getTableNames());
    }

    public synchronized HashMap<String, Long> getNbElement(List<String> tableList)
    {
        HashMap<String, Long> map = new HashMap<String, Long>();

        for (String table: tableList ) {
            map.put(table, getTableCount(table));
        }

        return map;
    }

    public synchronized long addEntry(AbstractSplitDbTable table, ContentValues values)
    {
        long newRowId;
        try {
            db.beginTransaction();
            newRowId = db.insert(
                    table.getTableName(),
                    null,
                    values);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
        return newRowId;
    }

    /**
     *
     * @param table The table name to compile the query against.
     * @param columns A list of which columns to return. Passing null will return all columns, which is discouraged to prevent reading data from storage that isn't going to be used.
     * @param selection A filter declaring which rows to return, formatted as an SQL WHERE clause (excluding the WHERE itself). Passing null will return all rows for the given table.
     * @param selectionArgs You may include ?s in selection, which will be replaced by the values from selectionArgs, in order that they appear in the selection. The values will be bound as Strings.
     * @param groupBy A filter declaring how to group rows, formatted as an SQL GROUP BY clause (excluding the GROUP BY itself). Passing null will cause the rows to not be grouped.
     * @param having A filter declare which row groups to include in the cursor, if row grouping is being used, formatted as an SQL HAVING clause (excluding the HAVING itself). Passing null will cause all row groups to be included, and is required when row grouping is not being used.
     * @param orderBy How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort order, which may be unordered.
     * @param limit Limits the number of rows returned by the query, formatted as LIMIT clause. Passing null denotes no LIMIT clause.
     * @return
     */
    public synchronized Cursor getEntry(AbstractSplitDbTable table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit)
    {
        Cursor c = db.query(
                table.getTableName(),
                columns,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                groupBy,                                     // don't group the rows
                having,                                     // don't filter by row groups
                orderBy,                                 // The sort order
                limit
        );

        return c;
    }

    public synchronized Cursor getEntry(AbstractSplitDbTable table, long id)
    {
        String selection = TableProject._ID + " = ?";
        String[] selectionArgs = {String.valueOf(id)};

        Cursor c = db.query(
                table.getTableName(),
                null,                               // The columns to return
                table._ID + " = ?",                                // The columns for the WHERE clause
                new String[] {String.valueOf(id)},                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null,                                 // The sort order
                null                                    // limit
        );

        return c;
    }

    public synchronized Cursor getEntry(AbstractSplitDbTable table)
    {
        Cursor c = db.query(
                table.getTableName(),
                null,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null,                                 // The sort order
                null                                    // limit
        );

        return c;
    }

    public synchronized void deleteEntry(AbstractSplitDbTable table, long id) {
        long newRowId;
        try {
            db.beginTransaction();

            // Define 'where' part of query.
            String selection = table._ID + " = ?";
            // Specify arguments in placeholder order.
            String[] selectionArgs = {String.valueOf(id)};
            // Issue SQL statement.
            db.delete(table.getTableName(), selection, selectionArgs);

            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    public synchronized long updateEntry(AbstractSplitDbTable table, long id, ContentValues values) {
        long count;
        try {
            db.beginTransaction();

            // Which row to update, based on the ID
            String selection = table._ID + " = ?";
            String[] selectionArgs = { String.valueOf(id) };

            count = db.update(
                    table.getTableName(),
                    values,
                    selection,
                    selectionArgs);

            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
        return count;
    }

    public long addProject(String name)
    {
        ContentValues values = new ContentValues();
        values.put(TableProject.COLUMN_STATE_ID, Arrays.asList(TableState.BASE_VALUES).indexOf("open"));
        values.put(TableProject.COLUMN_NAME, name);
        values.put(TableProject.COLUMN_CREATED, DateHelper.toText());

        return addEntry(new TableProject(), values);
    }

    public long addProjectUseCurrency(long project, long currency, long isDefault)
    {
        ContentValues values = new ContentValues();
        values.put(TableProjectUseCurrency.COLUMN_PROJECT_ID, project);
        values.put(TableProjectUseCurrency.COLUMN_CURRENCY_ID, currency);
        values.put(TableProjectUseCurrency.COLUMN_IS_DEFAULT, isDefault);

        return addEntry(new TableProjectUseCurrency(), values);
    }

    public long addUser(String name, long project)
    {
        ContentValues values = new ContentValues();
        values.put(TableProjectUser.COLUMN_NAME, name);
        values.put(TableProjectUser.COLUMN_PROJECT_ID, project);

        return addEntry(new TableProjectUser(), values);
    }
}
