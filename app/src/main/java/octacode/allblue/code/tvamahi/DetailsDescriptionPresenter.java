package octacode.allblue.code.tvamahi;

import android.support.v17.leanback.widget.AbstractDetailsDescriptionPresenter;

public class DetailsDescriptionPresenter extends AbstractDetailsDescriptionPresenter {

    @Override
    protected void onBindDescription(ViewHolder viewHolder, Object item) {
        String movie = (String)item;

        if (movie != null) {
            viewHolder.getTitle().setText(movie);
            viewHolder.getSubtitle().setText(movie);
        //    viewHolder.getBody().setText(movie.getDescription());
        }
    }
}
