package octacode.allblue.code.tvamahi;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //findViewById(R.id.main_browse_fragment).setBackground(new ColorDrawable(getResources().getColor(R.color.background)));
    }
}
