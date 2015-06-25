package com.example.androidpersistence;

import com.example.androidpersistence.MediaGeoLocContract.Docs;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MediaGeoLocHelper extends SQLiteOpenHelper {
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "MediaGeoLoc.db";
	
	private static final String SQL_CREATE_DOCS =
			"CREATE TABLE " + Docs.TABLE_NAME + " (" +
			Docs._ID + " INTEGER PRIMARY KEY," +
			Docs.COLUMN_NAME_DOC_NAME + " TEXT," +
			Docs.COLUMN_NAME_DOC_POSITIONX + " REAL," +
			Docs.COLUMN_NAME_DOC_POSITIONY + " REAL," +
			Docs.COLUMN_NAME_DOC_IMAGE + " TEXT" +
			
			" )";
	
	private static final String SQL_DELETE_DOCS = "DROP TABLE IF EXISTS "
			+ Docs.TABLE_NAME;

	public MediaGeoLocHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_DOCS);
		ContentValues values=new ContentValues();
		
		values.put(MediaGeoLocContract.Docs.COLUMN_NAME_DOC_NAME, "Will");
		values.put(MediaGeoLocContract.Docs.COLUMN_NAME_DOC_POSITIONX, 45);
		values.put(MediaGeoLocContract.Docs.COLUMN_NAME_DOC_POSITIONY, 75);
		values.put(MediaGeoLocContract.Docs.COLUMN_NAME_DOC_IMAGE, "imagelocation");
		db.insert(MediaGeoLocContract.Docs.TABLE_NAME, null, values);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(SQL_DELETE_DOCS);
		onCreate(db);

	}

}
