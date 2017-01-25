package com.splitaccounts.split;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.text.TextUtils;

/**
 * Created by gaellecoz on 30.10.2015.
 */
public class SplitContentProvider extends ContentProvider {

    public boolean onCreate()
    {
        throw new UnsupportedOperationException();
    }

    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder)
    {
        throw new UnsupportedOperationException();
    }

    public Uri insert(Uri uri, ContentValues values)
    {
        throw new UnsupportedOperationException();
    }

    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs)
    {
        throw new UnsupportedOperationException();
    }

    public int delete(Uri uri, String selection, String[] selectionArgs)
    {
        throw new UnsupportedOperationException();
    }

    public String getType(Uri uri)
    {
        throw new UnsupportedOperationException();
    }

}
