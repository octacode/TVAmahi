package octacode.allblue.code.tvamahi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v17.leanback.app.VerticalGridFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.VerticalGridPresenter;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by shasha on 5/6/17.
 */

public class PresenterFragment extends VerticalGridFragment {
    private static final int NUM_COLUMNS = 4;
    private ArrayObjectAdapter mAdapter;
    private static final int GRID_ITEM_WIDTH = 400;
    private static final int GRID_ITEM_HEIGHT = 300;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(getClass().getSimpleName(), "onCreate");
        super.onCreate(savedInstanceState);

        setTitle("Mock Layouts");

        setupFragment();
    }

    private void setupFragment() {
        VerticalGridPresenter gridPresenter = new VerticalGridPresenter();
        gridPresenter.setNumberOfColumns(NUM_COLUMNS);
        setGridPresenter(gridPresenter);

        mAdapter = new ArrayObjectAdapter(new GridItemPresenter());

        mAdapter.add("Login");
        mAdapter.add("Introduction");
        mAdapter.add("Main");
        mAdapter.add("Image display");
        mAdapter.add("Web view");
        mAdapter.add("Sign out");
        mAdapter.add("Connection preference");
        mAdapter.add("Theme preference");
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
            final TextView tv = (TextView)viewHolder.view;
            tv.setText((String) item);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(tv.getText().toString().matches("Login"))
                        startActivity(new Intent(getContext(),LoginActivity.class));
                    if(tv.getText().toString().matches("Introduction"))
                        startActivity(new Intent(getContext(),IntroActivity.class));
                    if(tv.getText().toString().matches("Main"))
                        startActivity(new Intent(getContext(),MainActivity.class));
                    if(tv.getText().toString().matches("File display"))
                        startActivity(new Intent(getContext(),DetailActivity.class));
                    if(tv.getText().toString().matches("Image display"))
                        startActivity(new Intent(getContext(),ImageActivity.class));
                    if(tv.getText().toString().matches("Video player"))
                        startActivity(new Intent(getContext(),VideoDetailActivity.class));
                    if(tv.getText().toString().matches("Web view"))
                        startActivity(new Intent(getContext(),WebViewActivity.class));
                    if(tv.getText().toString().matches("Sign out"))
                        startActivity(new Intent(getContext(),SignOutStepActivity.class));
                    if(tv.getText().toString().matches("Theme preference"))
                        startActivity(new Intent(getContext(),ThemePreferenceStepActivity.class));
                    if(tv.getText().toString().matches("Connection preference"))
                        startActivity(new Intent(getContext(),ConnectionPreferenceStepActivity.class));
                }
            });
        }

        @Override
        public void onUnbindViewHolder(ViewHolder viewHolder) {
        }
    }
}
