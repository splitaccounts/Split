package com.splitaccounts.split.database;

import android.provider.BaseColumns;

import java.util.List;

/**
 * Created by gaellecoz on 04.11.2015.
 */
public abstract class AbstractSplitDbTable implements BaseColumns {
    public abstract String getTableName();
    public abstract String[] getSqlCreate();
    public abstract String[] getSqlDrop();

    public abstract List<String> getBaseValuesInsert();
}
