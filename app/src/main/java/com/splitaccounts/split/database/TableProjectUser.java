package com.splitaccounts.split.database;

import java.util.List;

/**
 * Created by gaellecoz on 13.11.2015.
 */ /* ProjectUser */
public final class TableProjectUser extends AbstractSplitDbTable {
    public static final String PROVIDER_ID = "300";
    public static final String TABLE_NAME = "project_user";
    public static final String COLUMN_PROJECT_ID = "project_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_IS_CONTACT = "is_contact";
    private String[] SQL_CREATE = {
            SplitDbContractV1.CREATE + TABLE_NAME + " (" +
                    SplitDbContractV1.ID_PRIMARY_KEY + SplitDbContractV1.SEP_COMMA +
                    COLUMN_PROJECT_ID + SplitDbContractV1.TYPE_INTEGER + SplitDbContractV1.NOT_NULL + SplitDbContractV1.SEP_COMMA +
                    COLUMN_NAME + SplitDbContractV1.TYPE_TEXT + SplitDbContractV1.NOT_NULL + SplitDbContractV1.SEP_COMMA +
                    COLUMN_IS_CONTACT + SplitDbContractV1.TYPE_INTEGER + SplitDbContractV1.NOT_NULL+ SplitDbContractV1.DEFAULT_0 + SplitDbContractV1.SEP_COMMA +
                    SplitDbContractV1.CONSTRAINT_UNIQUE_ID + SplitDbContractV1.SEP_COMMA +
                    SplitDbContractV1.getConstraintForeignKey(new TableProject(), COLUMN_PROJECT_ID) +
                    ");",
            SplitDbContractV1.getIndexUnique(TABLE_NAME, _ID),
            SplitDbContractV1.getIndex(TABLE_NAME, COLUMN_PROJECT_ID)
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
