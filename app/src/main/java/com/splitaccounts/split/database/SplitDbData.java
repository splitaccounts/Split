package com.splitaccounts.split.database;

import android.database.Cursor;

import com.splitaccounts.split.helper.RandomHelper;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by gaellecoz on 13.11.2015.
 */
public final class SplitDbData {

    public static void generateData(SplitDbHelper dbHelper)
    {
        // Add projects
        generateProjects(dbHelper);

        // Link currencies with projects
        generateProjectCurrencies(dbHelper);

        // Add users
        generateUsers(dbHelper);

    }

    private static void generateProjects(SplitDbHelper dbHelper)
    {
        long minEntries = 5;
        long maxEntries = 10;
        long count = RandomHelper.rand(minEntries, maxEntries);

        for (int i = 0; i < count; i++) {
            String name = new BigInteger(130, new SecureRandom()).toString(32);
            dbHelper.addProject(name);
        }
    }

    private static void generateUsers(SplitDbHelper dbHelper)
    {
        long minEntries = 2;
        long maxEntries = 10;

        Cursor c = dbHelper.getEntry(new TableProject());

        c.moveToFirst();

        while (c.isAfterLast() == false) {
            long count = RandomHelper.rand(minEntries, maxEntries);

            for (int i = 0; i < count; i++) {
                String name = new BigInteger(130, new SecureRandom()).toString(32);
                long idUser = dbHelper.addUser(name, c.getLong(c.getColumnIndex(TableProject._ID)));
            }
            c.moveToNext();
        }

        c.close();
    }

    private static void generateProjectCurrencies(SplitDbHelper dbHelper)
    {
        long minCurrency = 1;
        long maxCurrency = dbHelper.getTableCount(TableCurrency.TABLE_NAME);

        long minEntries = 1;
        long maxEntries = 5;

        Cursor c = dbHelper.getEntry(new TableProject());

        c.moveToFirst();

        while (c.isAfterLast() == false) {
            long count = RandomHelper.rand(minEntries, maxEntries);

            for (int i = 0; i < count; i++) {
                long currency = RandomHelper.rand(minCurrency, maxCurrency);
                dbHelper.addProjectUseCurrency(c.getLong(c.getColumnIndex(TableProject._ID)), currency, 0);
            }
            c.moveToNext();
        }

        c.close();
    }
}
