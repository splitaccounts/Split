package com.splitaccounts.split.contentprovider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.splitaccounts.split.database.AbstractSplitDbTable;
import com.splitaccounts.split.database.SplitDbHelper;
import com.splitaccounts.split.database.TableCurrency;
import com.splitaccounts.split.database.TableProject;
import com.splitaccounts.split.database.TableProjectUser;

/**
 * Provider class for the database
 *
 * @author <a href="mailto:splitaccounts@le-coz.net">Gaël LE COZ</a>
 */
public class SplitContentProvider extends ContentProvider {

    /**
     * The database
     */
    private SplitDbHelper database;

    /**
     * The provider authority
     */
    private static final String AUTHORITY = "com.splitaccounts.split.contentprovider";

    /*
    private static final String BASE_PATH = "split";

    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY
            + "/" + BASE_PATH);

    public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
            + "/projects";
    public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE
            + "/project";

    */

    /**
     * The URI matcher of the content provider
     */
    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    /**
     * Instance of the URI matcher for all the tables
     */
    static {
        sURIMatcher.addURI(AUTHORITY, TableCurrency.TABLE_NAME, TableCurrency.PROVIDER);
        sURIMatcher.addURI(AUTHORITY, TableCurrency.TABLE_NAME + "/#", TableCurrency.PROVIDER_ID);
        sURIMatcher.addURI(AUTHORITY, TableProject.TABLE_NAME, TableProject.PROVIDER);
        sURIMatcher.addURI(AUTHORITY, TableProject.TABLE_NAME + "/#", TableProject.PROVIDER_ID);
        sURIMatcher.addURI(AUTHORITY, TableProjectUser.TABLE_NAME, TableProjectUser.PROVIDER);
        sURIMatcher.addURI(AUTHORITY, TableProjectUser.TABLE_NAME + "/#", TableProjectUser.PROVIDER_ID);
    }

    @Override
    public boolean onCreate() {
        database = SplitDbHelper.getInstance(getContext());
        return false;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {


        // Using SQLiteQueryBuilder instead of query() method
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

        // check if the caller has requested a column which does not exists
        //checkColumns(projection);

        int uriType = sURIMatcher.match(uri);
        switch (uriType) {
            case TableCurrency.PROVIDER:
                // Set the table
                queryBuilder.setTables(TableCurrency.TABLE_NAME);
                break;
            case TableCurrency.PROVIDER_ID:
                // adding the ID to the original query
                queryBuilder.appendWhere(AbstractSplitDbTable._ID + "="
                        + uri.getLastPathSegment());
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }

        SQLiteDatabase db = database.getWritableDatabase();
        Cursor cursor = queryBuilder.query(db, projection, selection,
                selectionArgs, null, null, sortOrder);
        // make sure that potential listeners are getting notified
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

}
