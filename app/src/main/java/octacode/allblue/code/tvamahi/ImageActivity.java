package octacode.allblue.code.tvamahi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;

public class ImageActivity extends AppIntro {

    Integer drawable[] = {
            R.drawable.birds,
            R.drawable.cat,
            R.drawable.eagle,
            R.drawable.kingfisher,
            R.drawable.koala,
            R.drawable.monkey,
            R.drawable.polar_bear,
            R.drawable.shark,
            R.drawable.tree_frog,
            R.drawable.wolf};

    String titles[] = {
            "Birds",
            "Cat",
            "Eagle",
            "Kingfisher",
            "Koala",
            "Monkey",
            "Polar Bear",
            "Shark",
            "Tree Frog",
            "Wolf"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for(int i=0;i<titles.length;i++)
            addSlide(new ImageViewerFragment(drawable[i],titles[i]));

        showSkipButton(false);
        setDoneText("Go Back");

        setFlowAnimation();
    }
}
