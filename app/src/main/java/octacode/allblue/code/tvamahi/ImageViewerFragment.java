package octacode.allblue.code.tvamahi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageViewerFragment extends Fragment {

    int imageAddr;
    String title;
    public ImageViewerFragment(int imageAddr,String title){
        this.imageAddr = imageAddr;
        this.title = title;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rooView = inflater.inflate(R.layout.image_viewer,container,false);
        ImageView imageView = (ImageView)rooView.findViewById(R.id.image);
        imageView.setImageResource(imageAddr);
        TextView tv = (TextView)rooView.findViewById(R.id.textView);
        tv.setText(title);
        return rooView;
    }
}
