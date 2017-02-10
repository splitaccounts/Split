package com.splitaccounts.split.database;

import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaellecoz on 28.10.2015.
 */
public final class SplitDbContractV1 {


    /**
     * Constructor is private and empty to prevent someone from accidentally
     * instantiating the contract class
    */
    private SplitDbContractV1() {}

    public static final String CREATE = "CREATE TABLE IF NOT EXISTS ";
    public static final String TYPE_TEXT = " TEXT";
    public static final String TYPE_INTEGER = " INTEGER";
    public static final String TYPE_REAL = " REAL";
    public static final String TYPE_TIMESTAMP = " timestamp with time zone";
    public static final String SEP_COMMA = ", ";
    public static final String SEP_SEMICOLON = ";";
    public static final String PRIMARY_KEY = " PRIMARY KEY";
    public static final String AUTOINCREMENT = " AUTOINCREMENT";
    public static final String NOT_NULL = " NOT NULL";
    public static final String DEFAULT_0 = " DEFAULT 0";
    public static final String ID_PRIMARY_KEY = BaseColumns._ID + TYPE_INTEGER + PRIMARY_KEY + AUTOINCREMENT;
    public static final String CONSTRAINT_UNIQUE_ID = " CONSTRAINT " + BaseColumns._ID + "_unique UNIQUE (" + BaseColumns._ID + ")";

    public static List<AbstractSplitDbTable> getTables()
    {
        List<AbstractSplitDbTable> tables = new ArrayList<>();

        tables.add(new TableState());
        tables.add(new TableValueType());
        tables.add(new TableSetting());
        tables.add(new TableCurrency());
        tables.add(new TableProject());
        tables.add(new TableProjectUseCurrency());
        tables.add(new TableProjectUser());

        return tables;
    }

    public static List<String> getTableNames()
    {
        List<String> tables = new ArrayList<>();

        for(AbstractSplitDbTable table : getTables()){
            tables.add(table.getTableName());
        }

        return tables;
    }

    public static String getUpdateSequenceQuery(String table, int count)
    {
        return "UPDATE SQLITE_SEQUENCE SET seq = " + count + " WHERE name = '" + table + "';";
    }

    /**
     * @param column The column list that form the key
     * @return The partial statement to insert in the create table
     */
    public static String getConstraintPrimaryKey(String[] column)
    {
        StringBuilder statement = new StringBuilder("CONSTRAINT key");

        for (String c: column){
            statement.append("_" + c);
        }

        statement.append(" PRIMARY KEY (");

        boolean isFirst = true;
        for (String c: column){
            if (!isFirst){
                statement.append(", ");
            }

            statement.append(c);

            isFirst = false;
        }

        statement.append(")");

        return statement.toString();
    }

    /**
     * @param table The table to drop
     * @return The statement to drop the table
     */
    public static String getTableDrop(String table)
    {
        return "DROP TABLE IF EXISTS " + table + ";";
    }

    /**
     * @param column The column name to be unique
     * @return The partial statement to insert in the create table
     */
    public static String getConstraintUnique(String column)
    {
        return "CONSTRAINT unique_" + column + " UNIQUE (" + column + ")";
    }

    /**
     * @param table The table that provide the key
     * @param column The column name in the target table of the foreign key
     * @return The partial statement to create the table
     */
    public static String getConstraintForeignKey(AbstractSplitDbTable table, String column)
    {
        return "CONSTRAINT rel_" + column + "_" + table.getTableName() + "_" + table._ID + " FOREIGN KEY (" + column + ") REFERENCES " + table.getTableName() + "(" + table._ID + ")";
    }

    /**
     * @param table The table to create an index
     * @param column The column name to create the index
     * @return The statement to create the index
     */
    public static String getIndex(String table, String column)
    {
        return "CREATE INDEX IF NOT EXISTS index_" + table + "_" + column + " ON " + table + " (" + column + ");";
    }

    /**
     * @param table The table to create an index
     * @param column The column name to create the index
     * @return The statement to create the index
     */
    public static String getIndexUnique(String table, String column)
    {
        return "CREATE UNIQUE INDEX IF NOT EXISTS index_" + table + "_" + column + " ON " + table + " (" + column + ");";
    }

    /**
     * @param table The table attached to the index
     * @param column The column name attached to index
     * @return The statement to drop the index
     */
    public static String getIndexDrop(String table, String column)
    {
        return "DROP INDEX IF EXISTS index_" + table + "_" + column + ";";
    }

}
