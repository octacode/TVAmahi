package octacode.allblue.code.tvamahi;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v17.leanback.widget.Presenter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class DetailsPresenterCard extends Presenter{

    private static final String TAG = DetailsPresenterCard.class.getSimpleName();

    private  Context mContext;
    private static int CARD_WIDTH = 1000;
    private static int CARD_HEIGHT = 176;
    private static InfoModel mMovie;

     class ViewHolder extends Presenter.ViewHolder {
        public ImageCardView mCardView;
        public Drawable mDefaultCardImage;

        public ViewHolder(View view) {
            super(view);
            mCardView = (ImageCardView) view;
            mDefaultCardImage = mContext.getResources().getDrawable(R.mipmap.ic_launcher);
        }

        public void setMovie(InfoModel m) {
            mMovie = m;
        }

        public InfoModel getMovie() {
            return mMovie;
        }

        public ImageCardView getCardView() {
            return mCardView;
        }

        public Drawable getDefaultCardImage() {
            return mDefaultCardImage;
        }

    }

    @Override
    public CardPresenter.ViewHolder onCreateViewHolder(ViewGroup parent) {
        Log.d(TAG, "onCreateViewHolder");
        mContext = parent.getContext();

        ImageCardView cardView = new ImageCardView(mContext);
        cardView.setFocusable(true);
        cardView.setFocusableInTouchMode(true);
        return new CardPresenter.ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        InfoModel movie = (InfoModel) item;
        ((CardPresenter.ViewHolder) viewHolder).setMovie(movie);

        Log.d(TAG, "onBindViewHolder");
        ((DetailsPresenterCard.ViewHolder) viewHolder).mCardView.setTitleText("Demo");
        ((DetailsPresenterCard.ViewHolder) viewHolder).mCardView.setContentText("Working??");
        ((DetailsPresenterCard.ViewHolder) viewHolder).mCardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);
        ((DetailsPresenterCard.ViewHolder) viewHolder).mCardView.setMainImage(((CardPresenter.ViewHolder) viewHolder).getDefaultCardImage());
    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        Log.d(TAG, "onUnbindViewHolder");
    }

    @Override
    public void onViewAttachedToWindow(Presenter.ViewHolder viewHolder) {
        // TO DO
    }

}