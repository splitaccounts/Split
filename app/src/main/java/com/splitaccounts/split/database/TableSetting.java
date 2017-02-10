package com.splitaccounts.split.database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaellecoz on 13.11.2015.
 */ /* Setting */
public final class TableSetting extends AbstractSplitDbTable {
    /**
     * The ID for the provider of all the entries
     */
    public static final String PROVIDER = "400";

    /**
     * The ID of the provider for a single entry
     */
    public static final String PROVIDER_ID = "410";
    public static final String TABLE_NAME = "setting";
    public static final String COLUMN_VALUE_TYPE_ID = "value_type_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_VALUE = "value";
    private String[] SQL_CREATE = {
            SplitDbContractV1.CREATE + TABLE_NAME + " (" +
                    SplitDbContractV1.ID_PRIMARY_KEY + SplitDbContractV1.SEP_COMMA +
                    COLUMN_VALUE_TYPE_ID + SplitDbContractV1.TYPE_TEXT + SplitDbContractV1.NOT_NULL + SplitDbContractV1.SEP_COMMA +
                    COLUMN_NAME + SplitDbContractV1.TYPE_TEXT + SplitDbContractV1.SEP_COMMA +
                    COLUMN_VALUE + SplitDbContractV1.TYPE_TEXT + SplitDbContractV1.NOT_NULL + SplitDbContractV1.SEP_COMMA +
                    SplitDbContractV1.CONSTRAINT_UNIQUE_ID + SplitDbContractV1.SEP_COMMA +
                    SplitDbContractV1.getConstraintForeignKey(new TableValueType(), COLUMN_VALUE_TYPE_ID) +
                    ");",
            SplitDbContractV1.getIndexUnique(TABLE_NAME, _ID)
            };

    private String[] SQL_DROP = {
            SplitDbContractV1.getIndexDrop(TABLE_NAME, _ID),
            SplitDbContractV1.getTableDrop(TABLE_NAME)
    };

    public static final String[][] BASE_VALUES = {
            {"boolean", "display_help", "false"},
            {"boolean", "activate_history", "false"},
            {"boolean", "display_external_tool_error", "false"}
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
        String[] res = new String[BASE_VALUES.length];
        for (int i = 0; i < BASE_VALUES.length; i++) {
            res[i] = BASE_VALUES[i][1];
        }
        return res;
    }

    public List<String> getBaseValuesInsert() {
        int count = BASE_VALUES.length;
        List<String> queries = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            queries.add("INSERT INTO " + TABLE_NAME + " (" + _ID + SplitDbContractV1.SEP_COMMA + COLUMN_VALUE_TYPE_ID + SplitDbContractV1.SEP_COMMA + COLUMN_NAME + SplitDbContractV1.SEP_COMMA + COLUMN_VALUE + ") VALUES ('" + (i + 1) + "', '" + BASE_VALUES[i][0] + "', '" + BASE_VALUES[i][1] + "', '" + BASE_VALUES[i][2] + "');");
        }
        queries.add(SplitDbContractV1.getUpdateSequenceQuery(TABLE_NAME, count));
        return queries;
    }
}
