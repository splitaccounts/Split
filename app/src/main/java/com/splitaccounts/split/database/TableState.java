package com.splitaccounts.split.database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaellecoz on 13.11.2015.
 */ /* State */
public final class TableState extends AbstractSplitDbTable {
    public static final String PROVIDER_ID = "500";
    public static final String TABLE_NAME = "project_state";
    public String COLUMN_NAME = "name";
    private String[] SQL_CREATE = {
            SplitDbContractV1.CREATE + TABLE_NAME + " (" +
                    SplitDbContractV1.ID_PRIMARY_KEY + SplitDbContractV1.SEP_COMMA +
                    COLUMN_NAME + SplitDbContractV1.TYPE_TEXT + SplitDbContractV1.SEP_COMMA +
                    SplitDbContractV1.CONSTRAINT_UNIQUE_ID +
                    ");",
            SplitDbContractV1.getIndexUnique(TABLE_NAME, _ID)
    };

    private String[] SQL_DROP = {
            SplitDbContractV1.getIndexDrop(TABLE_NAME, _ID),
            SplitDbContractV1.getTableDrop(TABLE_NAME)
    };

    public static final String[] BASE_VALUES = {
            "open",
            "closed",
            "archived"
    };

    public String getTableName() {
        return TABLE_NAME;
    }

    public String[] getSqlCreate() {
        return SQL_CREATE;
    }

    public String[] getSqlDrop() {
        return SQL_DROP;
    }

    public String[] getBaseValues() {
        return BASE_VALUES;
    }

    public List<String> getBaseValuesInsert() {
        int count = BASE_VALUES.length;
        List<String> queries = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            queries.add("INSERT INTO " + TABLE_NAME + " (" + _ID + "," + COLUMN_NAME + ") VALUES ('" + (i + 1) + "', '" + BASE_VALUES[i] + "');");
        }
        queries.add(SplitDbContractV1.getUpdateSequenceQuery(TABLE_NAME, count));
        return queries;
    }
}
