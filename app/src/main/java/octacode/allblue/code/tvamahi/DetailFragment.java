package octacode.allblue.code.tvamahi;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v17.leanback.app.VerticalGridFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.VerticalGridPresenter;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailFragment extends VerticalGridFragment {
    private static final int NUM_COLUMNS = 4;
    private ArrayObjectAdapter mAdapter;
    private static final int GRID_ITEM_WIDTH = 400;
    private static final int GRID_ITEM_HEIGHT = 300;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(getClass().getSimpleName(), "onCreate");
        super.onCreate(savedInstanceState);

        setTitle("Miscellaneous");

        setupFragment();
    }

    private void setupFragment() {
        VerticalGridPresenter gridPresenter = new VerticalGridPresenter();
        gridPresenter.setNumberOfColumns(NUM_COLUMNS);
        setGridPresenter(gridPresenter);

        mAdapter = new ArrayObjectAdapter(new CardPresenter());

        /*
        mAdapter.add("Github link");
        mAdapter.add("Amahi Website");
        mAdapter.add("GSoC Website");
        mAdapter.add("College Website");
        mAdapter.add("Play Store Link");
        */

        /*
        * R.drawable.birds,
            R.drawable.cat,
            R.drawable.eagle,
            R.drawable.kingfisher,
            R.drawable.koala,
            R.drawable.monkey,
            R.drawable.polar_bear,
            R.drawable.shark,
            R.drawable.tree_frog,
            R.drawable.wolf};
            */

        /* Pictures Mocks
        mAdapter.add(new InfoModel("Birds","Wed 24 Jan",R.drawable.birds));
        mAdapter.add(new InfoModel("Cat","Fri 11 Mar",R.drawable.cat));
        mAdapter.add(new InfoModel("Eagle","Sun 13 Apr",R.drawable.eagle));
        mAdapter.add(new InfoModel("Kingfisher","Tue 27 Feb",R.drawable.kingfisher));
        mAdapter.add(new InfoModel("Koala","Thur 04 Jul",R.drawable.koala));
        mAdapter.add(new InfoModel("Monkey","Mon 07 Jun",R.drawable.monkey));
        mAdapter.add(new InfoModel("Polar Bear","Sat 13 Sep",R.drawable.polar_bear));
        mAdapter.add(new InfoModel("Shark","Mon 16 Oct",R.drawable.shark));
        mAdapter.add(new InfoModel("Tree Frog","Wed 01 Dec",R.drawable.tree_frog));
        mAdapter.add(new InfoModel("Wolf","Sat 15 Nov",R.drawable.wolf));
        */

        /* Music Mocks
        mAdapter.add(new InfoModel("Shake It Off","Wed 24 Jan",R.drawable.music1));
        mAdapter.add(new InfoModel("All of Me","Fri 11 Mar",R.drawable.music1));
        mAdapter.add(new InfoModel("Blank Space","Sun 13 Apr",R.drawable.music1));
        mAdapter.add(new InfoModel("Castle on the hill","Tue 27 Feb",R.drawable.music1));
        mAdapter.add(new InfoModel("Shape of you","Thur 04 Jul",R.drawable.music1));
        mAdapter.add(new InfoModel("Barcelona","Sat 13 Sep",R.drawable.music1));
        */

        /*
        mAdapter.add(new InfoModel("Search Algo","Wed 24 Jan",R.drawable.videos));
        mAdapter.add(new InfoModel("Doctor Strange Trailer","Fri 11 Mar",R.drawable.videos));
        mAdapter.add(new InfoModel("One Piece #756","Sun 13 Apr",R.drawable.videos));
        mAdapter.add(new InfoModel("Dragon Ball #194","Tue 27 Feb",R.drawable.videos));
        mAdapter.add(new InfoModel("Sherlock #9","Thur 04 Jul",R.drawable.videos));
        mAdapter.add(new InfoModel("Abominable Bride","Mon 07 Jun",R.drawable.videos));
        mAdapter.add(new InfoModel("Fairy Tail #120","Sat 13 Sep",R.drawable.videos));
        mAdapter.add(new InfoModel("One Punch Man #11","Mon 16 Oct",R.drawable.videos));
        mAdapter.add(new InfoModel("Code Geass #12","Wed 01 Dec",R.drawable.videos));
        mAdapter.add(new InfoModel("Death Note #37","Sat 15 Nov",R.drawable.videos));
        */

        mAdapter.add(new InfoModel("Search Algo","Wed 24 Jan",R.drawable.videos));
        mAdapter.add(new InfoModel("Blank Space","Sun 13 Apr",R.drawable.music1));
        mAdapter.add(new InfoModel("Anime Openings","Mon 26 Dec",R.drawable.folder));
        mAdapter.add(new InfoModel("Github link","Wed 09 Nov",R.drawable.link));
        mAdapter.add(new InfoModel("Kingfisher","Tue 27 Feb",R.drawable.kingfisher));
        mAdapter.add(new InfoModel("Sean Paul's Discography","Mon 26 Dec",R.drawable.folder));
        mAdapter.add(new InfoModel("Koala","Thur 04 Jul",R.drawable.koala));
        mAdapter.add(new InfoModel("Docs","Mon 26 Dec",R.drawable.folder));
        mAdapter.add(new InfoModel("Shape of you","Thur 04 Jul",R.drawable.music1));
        mAdapter.add(new InfoModel("Eagle","Sun 13 Apr",R.drawable.eagle));
        mAdapter.add(new InfoModel("Doctor Strange Trailer","Fri 11 Mar",R.drawable.videos));
        mAdapter.add(new InfoModel("Amahi Website","Sun 12 Mar",R.drawable.link));
        mAdapter.add(new InfoModel("One Piece #756","Sun 13 Apr",R.drawable.videos));
        mAdapter.add(new InfoModel("Castle on the hill","Tue 27 Feb",R.drawable.music1));
        mAdapter.add(new InfoModel("Dragon Ball #194","Tue 27 Feb",R.drawable.videos));
        mAdapter.add(new InfoModel("Monkey","Mon 07 Jun",R.drawable.monkey));
        mAdapter.add(new InfoModel("GSoC Website","Tue 27 Feb",R.drawable.link));


        setAdapter(mAdapter);
    }

    private class GridItemPresenter extends Presenter {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent) {
            TextView view = new TextView(parent.getContext());
            view.setLayoutParams(new ViewGroup.LayoutParams(GRID_ITEM_WIDTH, GRID_ITEM_HEIGHT));
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.setBackgroundColor(Color.DKGRAY);
            view.setTextColor(Color.WHITE);
            view.setTextSize(20);
            view.setGravity(Gravity.CENTER);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, Object item) {
            ((TextView) viewHolder.view).setText((String) item);
        }

        @Override
        public void onUnbindViewHolder(ViewHolder viewHolder) {
        }
    }
}
