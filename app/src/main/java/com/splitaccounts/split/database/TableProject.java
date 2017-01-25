package com.splitaccounts.split.database;

import java.util.List;

/**
 * Created by gaellecoz on 13.11.2015.
 */ /* Project */
public final class TableProject extends AbstractSplitDbTable {
    public static final int PROVIDER = 200;
    public static final int PROVIDER_ID = 210;
    public static final String TABLE_NAME = "project";
    public static final String COLUMN_STATE_ID = "state_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CREATED = "created";
    private String[] SQL_CREATE = {
            SplitDbContractV1.CREATE + TABLE_NAME + " (" +
                    SplitDbContractV1.ID_PRIMARY_KEY + SplitDbContractV1.SEP_COMMA +
                    COLUMN_STATE_ID + SplitDbContractV1.TYPE_TEXT + SplitDbContractV1.NOT_NULL + SplitDbContractV1.SEP_COMMA +
                    COLUMN_NAME + SplitDbContractV1.TYPE_TEXT + SplitDbContractV1.NOT_NULL + SplitDbContractV1.SEP_COMMA +
                    COLUMN_CREATED + SplitDbContractV1.TYPE_TIMESTAMP + SplitDbContractV1.NOT_NULL + SplitDbContractV1.SEP_COMMA +
                    SplitDbContractV1.CONSTRAINT_UNIQUE_ID + SplitDbContractV1.SEP_COMMA +
                    SplitDbContractV1.getConstraintForeignKey(new TableState(), COLUMN_STATE_ID) +
                    ");",
            SplitDbContractV1.getIndexUnique(TABLE_NAME, _ID),
            };

    private String[] SQL_DROP = {
            SplitDbContractV1.getIndexDrop(TABLE_NAME, _ID),
            SplitDbContractV1.getTableDrop(TABLE_NAME)
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

    public List<String> getBaseValuesInsert() {
        return null;
    }
}
