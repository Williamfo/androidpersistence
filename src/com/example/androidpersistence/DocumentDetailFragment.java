package com.example.androidpersistence;

import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.androidpersistence.dummy.DummyContent;

/**
 * A fragment representing a single Document detail screen. This fragment is
 * either contained in a {@link DocumentListActivity} in two-pane mode (on
 * tablets) or a {@link DocumentDetailActivity} on handsets.
 */
public class DocumentDetailFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{
	SimpleCursorAdapter adapter;
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The dummy content this fragment is presenting.
	 */
	private DummyContent.DummyItem mItem;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public DocumentDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// data fetch
		Bundle args = new Bundle();
		args.putString("uri", getActivity().getIntent().getData().toString());
		CursorLoader cl=(CursorLoader) getLoaderManager().initLoader(1, args, this);
		
		//data bind
//		String[] uiBindFrom = {  MediaGeoLocContract.Docs.COLUMN_NAME_DOC_NAME,MediaGeoLocContract.Docs.COLUMN_NAME_DOC_IMAGE, MediaGeoLocContract.Docs.COLUMN_NAME_DOC_POSITIONX,MediaGeoLocContract.Docs.COLUMN_NAME_DOC_POSITIONY};		
//		int[] uiBindTo = {R.id.document_detail,R.id.photo,R.id.positionx,R.id.positiony};
//		adapter=new SimpleCursorAdapter(this.getActivity(),R.layout.fragment_document_detail, null, uiBindFrom, uiBindTo,0);
//		setAdapter(adapter);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_document_detail,
				container, false);

		// Show the dummy content as text in a TextView.
		
		return rootView;
	}

	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		
		return new CursorLoader( getActivity().getApplicationContext(), Uri.parse(args.getString("uri")),  null,
				null,  null, null);
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
		data.moveToFirst();
		String nom=data.getString(data.getColumnIndex(MediaGeoLocContract.Docs.COLUMN_NAME_DOC_NAME));
		String image=data.getString(data.getColumnIndex(MediaGeoLocContract.Docs.COLUMN_NAME_DOC_IMAGE));
		Double positionx=data.getDouble(data.getColumnIndex(MediaGeoLocContract.Docs.COLUMN_NAME_DOC_POSITIONX));
		Double positiony=data.getDouble(data.getColumnIndex(MediaGeoLocContract.Docs.COLUMN_NAME_DOC_POSITIONY));
		TextView txtnom=(TextView) getActivity().findViewById(R.id.nom);
		txtnom.setText(nom);
		TextView txtimage=(TextView) getActivity().findViewById(R.id.photo);
		txtimage.setText(image);
		TextView txtposx=(TextView) getActivity().findViewById(R.id.positionx);
		txtposx.setText(positionx.toString());
		TextView txtposy=(TextView) getActivity().findViewById(R.id.positiony);
		txtposy.setText(positiony.toString());
		
	}

	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
		
		
	}
}
