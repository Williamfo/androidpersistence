package com.example.androidpersistence;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

public class GeoContentProvider extends ContentProvider {

	private static final String AUTHORITY = "com.example.androidpersistence";
	private static final String BASE_PATH = "docs";
	private static final int DOCS_LIST = 0;
	private static final int DOC_DETAILS = 1;
	public static final String URI = "content://" + AUTHORITY + "/" + BASE_PATH ;
	private MediaGeoLocHelper dbHelper;
	private static final UriMatcher matcher = new UriMatcher(
			UriMatcher.NO_MATCH);
	static {
		matcher.addURI(AUTHORITY, BASE_PATH, DOCS_LIST);
		matcher.addURI(AUTHORITY, BASE_PATH + "/#", DOC_DETAILS);
	}

	public GeoContentProvider() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public synchronized boolean onCreate() {
		dbHelper = new MediaGeoLocHelper(getContext());
		return true;
	}

	@Override
	public synchronized Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		int uriType = matcher.match(uri);
		Cursor result;
		
		switch (uriType) {
		case DOCS_LIST: {

			result = dbHelper.getReadableDatabase().query(
					MediaGeoLocContract.Docs.TABLE_NAME, projection, null,
					null, null, null, null);
			break;
			
		}
		case DOC_DETAILS: {
			selection = "_ID=?";
			if(selectionArgs==null){
				 selectionArgs=new String[1];
			}
			selectionArgs[0] = uri.getLastPathSegment();
			result = dbHelper.getReadableDatabase().query(
					MediaGeoLocContract.Docs.TABLE_NAME, projection, selection,
					selectionArgs, null, null, null);
			break;
			
		}
		default: {
			throw new IllegalArgumentException("Unknown URI: " + uri);
			
		}

		}
		 result.setNotificationUri(getContext().getContentResolver(), uri);
		return result;
	}

	@Override
	public synchronized String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public synchronized Uri insert(Uri uri, ContentValues values) {
		long newRowId;
		newRowId=dbHelper.getWritableDatabase().insert(MediaGeoLocContract.Docs.TABLE_NAME, null, values);
		return Uri.withAppendedPath(uri, Long.valueOf(newRowId).toString());
	}

	@Override
	public synchronized int delete(Uri uri, String selection, String[] selectionArgs) {
		return dbHelper.getWritableDatabase().delete(MediaGeoLocContract.Docs.TABLE_NAME, selection, selectionArgs);
		
	}

	@Override
	public synchronized int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		return dbHelper.getWritableDatabase().update(MediaGeoLocContract.Docs.TABLE_NAME, values, selection, selectionArgs);
		
	}

}
