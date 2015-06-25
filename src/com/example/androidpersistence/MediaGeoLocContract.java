package com.example.androidpersistence;

import android.provider.BaseColumns;

public class MediaGeoLocContract {

	private MediaGeoLocContract() {	
	}
	
	public static abstract class Docs implements BaseColumns{
		public static final String TABLE_NAME="docs";
	
		public static final String COLUMN_NAME_DOC_NAME="docname";
		public static final String COLUMN_NAME_DOC_IMAGE="docimage";
		public static final String COLUMN_NAME_DOC_POSITIONX="docpositionx";
		public static final String COLUMN_NAME_DOC_POSITIONY="docpositiony";
		



	}

}
