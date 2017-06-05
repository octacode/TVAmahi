package octacode.allblue.code.tvamahi;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v17.leanback.app.DetailsFragment;
import android.support.v17.leanback.widget.Action;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.ClassPresenterSelector;
import android.support.v17.leanback.widget.DetailsOverviewRow;
import android.support.v17.leanback.widget.DetailsOverviewRowPresenter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnActionClickedListener;
import android.widget.Toast;

import java.util.ArrayList;

public class VideoDetailFragment extends DetailsFragment {
    private static final String TAG = "VideoDetailsFragment";

    private static final int NUM_COLS = 10;

    private ArrayObjectAdapter mAdapter;
    private ClassPresenterSelector mPresenterSelector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupAdapter();
        //setupDetailsOverviewRow();
        //setupDetailsOverviewRowPresenter();
        setupMovieListRow();
        setupMovieListRowPresenter();
    }

    private void setupAdapter() {
        mPresenterSelector = new ClassPresenterSelector();
        mAdapter = new ArrayObjectAdapter(mPresenterSelector);
        setAdapter(mAdapter);
    }

    private void setupDetailsOverviewRow() {
        final DetailsOverviewRow row = new DetailsOverviewRow("Checking");
        row.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
        mAdapter.add(row);
    }

    private void setupDetailsOverviewRowPresenter() {
        // Set detail background and style.
        DetailsOverviewRowPresenter detailsPresenter =
                new DetailsOverviewRowPresenter(new DetailsDescriptionPresenter());
        detailsPresenter.setBackgroundColor(Color.DKGRAY);
        detailsPresenter.setStyleLarge(true);

        // Hook up transition element.
        //detailsPresenter.setSharedElementEnterTransition(getActivity(),
        //        DetailsActivity.SHARED_ELEMENT_NAME);

        detailsPresenter.setOnActionClickedListener(new OnActionClickedListener() {
            @Override
            public void onActionClicked(Action action) {
                //if (action.getId() == ACTION_WATCH_TRAILER) {
                    /*
                    Intent intent = new Intent(getActivity(), PlaybackOverlayActivity.class);
                    intent.putExtra(DetailsActivity.MOVIE, mSelectedMovie);
                    startActivity(intent);
                    */
                //} else {
                    Toast.makeText(getActivity(), action.toString(), Toast.LENGTH_SHORT).show();
                //}
            }
        });
        mPresenterSelector.addClassPresenter(DetailsOverviewRow.class, detailsPresenter);
    }

    private void setupMovieListRow() {

        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardPresenter());
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<10;i++)
            list.add("Demo");

        for (int j = 0; j < NUM_COLS; j++) {
            listRowAdapter.add(list.get(j % 5));
        }
        ArrayList<String> subcategories = new ArrayList<>();
        for(int i=0;i<10;i++)
            subcategories.add("Amahi");

        HeaderItem header = new HeaderItem(0, subcategories.get(0));
        mAdapter.add(new ListRow(header, listRowAdapter));
    }

    private void setupMovieListRowPresenter() {
        mPresenterSelector.addClassPresenter(ListRow.class, new ListRowPresenter());
    }
}