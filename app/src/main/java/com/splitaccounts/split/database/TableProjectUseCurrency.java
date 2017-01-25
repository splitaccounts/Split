package com.splitaccounts.split.database;

import java.util.List;

/**
 * Created by gaellecoz on 13.11.2015.
 */
public class TableProjectUseCurrency extends AbstractSplitDbTable {
    public static final String TABLE_NAME = "project_use_currency";
    public static final String COLUMN_PROJECT_ID = "project_id";
    public static final String COLUMN_CURRENCY_ID = "currency_id";
    public static final String COLUMN_IS_DEFAULT = "is_default";
    public static final String COLUMN_EXCHANGE_RATE = "exchange_rate";
    private String[] SQL_CREATE = {
            SplitDbContractV1.CREATE + TABLE_NAME + " (" +
                    COLUMN_PROJECT_ID + SplitDbContractV1.TYPE_INTEGER + SplitDbContractV1.NOT_NULL + SplitDbContractV1.SEP_COMMA +
                    COLUMN_CURRENCY_ID + SplitDbContractV1.TYPE_INTEGER + SplitDbContractV1.NOT_NULL + SplitDbContractV1.SEP_COMMA +
                    COLUMN_IS_DEFAULT + SplitDbContractV1.TYPE_INTEGER + SplitDbContractV1.NOT_NULL + SplitDbContractV1.SEP_COMMA +
                    COLUMN_EXCHANGE_RATE + SplitDbContractV1.TYPE_REAL + SplitDbContractV1.SEP_COMMA +
                    SplitDbContractV1.getConstraintPrimaryKey(new String[]{COLUMN_PROJECT_ID, COLUMN_CURRENCY_ID}) + SplitDbContractV1.SEP_COMMA +
                    SplitDbContractV1.getConstraintForeignKey(new TableProject(), COLUMN_PROJECT_ID) + SplitDbContractV1.SEP_COMMA +
                    SplitDbContractV1.getConstraintForeignKey(new TableCurrency(), COLUMN_CURRENCY_ID) +
                    ");"
    };

    private String[] SQL_DROP = {
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

