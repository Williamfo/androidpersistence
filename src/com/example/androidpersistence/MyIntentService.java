package com.example.androidpersistence;

import android.app.IntentService;
import android.content.ContentValues;
import android.content.Intent;
import android.content.Context;
import android.net.Uri;
import android.widget.Toast;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
	
	public MyIntentService() {
		super("MyIntentService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
	
		ContentValues values=new ContentValues();
		
		values.put(MediaGeoLocContract.Docs.COLUMN_NAME_DOC_NAME, "Nico" );
		values.put(MediaGeoLocContract.Docs.COLUMN_NAME_DOC_POSITIONX, 45);
		values.put(MediaGeoLocContract.Docs.COLUMN_NAME_DOC_POSITIONY, 75);
		values.put(MediaGeoLocContract.Docs.COLUMN_NAME_DOC_IMAGE, "imagelocation");
		getContentResolver().insert(Uri.parse(GeoContentProvider.URI), values);
		
		
		String where = "_ID=?";
		String[] selectionArgs = new String[1];
		selectionArgs[0] = "15";
		int Row = getContentResolver().delete(Uri.parse(GeoContentProvider.URI), where, selectionArgs);
		
		
		ContentValues values2 =new ContentValues();
		values2.put(MediaGeoLocContract.Docs.COLUMN_NAME_DOC_NAME, "MTH" + Row );
		values2.put(MediaGeoLocContract.Docs.COLUMN_NAME_DOC_POSITIONX, 45);
		values2.put(MediaGeoLocContract.Docs.COLUMN_NAME_DOC_POSITIONY, 75);
		values2.put(MediaGeoLocContract.Docs.COLUMN_NAME_DOC_IMAGE, "imagelocation");
		getContentResolver().insert(Uri.parse(GeoContentProvider.URI), values2);
		
		String[] selectionArgs2 = new String[1];
		selectionArgs2[0] = "7";
		
		int Row2 = getContentResolver().update(Uri.parse(GeoContentProvider.URI), values2, where, selectionArgs2);
		
		Toast.makeText(this, "line modified"+ Row2 , Toast.LENGTH_SHORT).show();
		
	}
	
	@Override
	public void onDestroy() {
		
	}
}