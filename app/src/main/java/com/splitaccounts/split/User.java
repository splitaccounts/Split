package com.splitaccounts.split;

/**
 * Created by gaellecoz on 28.10.2015.
 */
public class User implements IUser {
    public int id;
    public String name;

    private String db_table_name;

    User(String table_name)
    {
        db_table_name = table_name;
    }

}
