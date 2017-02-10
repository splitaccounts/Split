package com.splitaccounts.split.database;

import android.provider.BaseColumns;

import java.util.List;

/**
 * Abstract class for the database tables.
 *
 * @author <a href="mailto:splitaccounts@le-coz.net">Gaël LE COZ</a>
 */
public abstract class AbstractSplitDbTable implements BaseColumns {
    /**
     *
     * @return The name of the table.
     */
    public abstract String getTableName();

    /**
     *
     * @return The list of SQL requests to execute to create the table.
     */
    public abstract String[] getSqlCreate();

    /**
     *
     * @return The list of SQL requests to execute to drop the table.
     */
    public abstract String[] getSqlDrop();

    /**
     *
     * @return The list of SQL requests to execute to insert the base data (if any) in the table.
     */
    public abstract List<String> getBaseValuesInsert();
}
