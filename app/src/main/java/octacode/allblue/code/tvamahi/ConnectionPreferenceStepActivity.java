package octacode.allblue.code.tvamahi;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v17.leanback.app.GuidedStepFragment;
import android.support.v17.leanback.widget.GuidanceStylist;
import android.support.v17.leanback.widget.GuidedAction;
import android.util.Log;
import android.widget.Toast;

import java.util.List;


public class ConnectionPreferenceStepActivity extends Activity {

    private final String TAG = getClass().getSimpleName();

    /* Action ID definition */
    private static final int ACTION_CONTINUE = 0;
    private static final int ACTION_BACK = 1;

    private static final int OPTION_CHECK_SET_ID = 10;

    /* Options of SecondStepFragment */
    private static final String[] OPTION_NAMES = {"Autodetect", "Remote", "Local Area Network","Cancel"};

    private static final String[] OPTION_DESCRIPTIONS = {"",
            "", "","Go Back"};

    private static final int[] OPTION_DRAWABLES = {R.drawable.logo_amahi};

    private static final boolean[] OPTION_CHECKED = {true, false, false,false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        if (null == savedInstanceState) {
            GuidedStepFragment.add(getFragmentManager(), new ConnectionPreferenceStepActivity.FirstStepFragment());
        }
    }

    private static void addCheckedAction(List<GuidedAction> actions, int iconResId, Context context,
                                         String title, String desc, boolean checked) {
        GuidedAction guidedAction = new GuidedAction.Builder()
                .title(title)
                .description(desc)
                .checkSetId(OPTION_CHECK_SET_ID)
                .iconResourceId(iconResId, context)
                .build();
        guidedAction.setChecked(checked);
        actions.add(guidedAction);
    }

    public static class FirstStepFragment extends GuidedStepFragment {
        @NonNull
        @Override
        public GuidanceStylist.Guidance onCreateGuidance(Bundle savedInstanceState) {
            String title = "Connection";
            String breadcrumb = "";
            String description ="Select from AutoDetect, Remote or LAN.";
            Drawable icon = getActivity().getDrawable(R.drawable.logo_amahi);
            return new GuidanceStylist.Guidance(title, description, breadcrumb, icon);
        }

        @Override
        public void onCreateActions(List<GuidedAction> actions, Bundle savedInstanceState) {
            String title = "Connection";
            String desc = "Select the type of connection you want. You can set it as Auto detect, Remote or Local Area Network.";
            actions.add(new GuidedAction.Builder()
                    .title(title)
                    .description(desc)
                    .multilineDescription(true)
                    .infoOnly(true)
                    .enabled(false)
                    .build());
            for (int i = 0; i < OPTION_NAMES.length; i++) {
                addCheckedAction(actions,
                        OPTION_DRAWABLES[0],
                        getActivity(),
                        OPTION_NAMES[i],
                        OPTION_DESCRIPTIONS[i],
                        OPTION_CHECKED[i]);
            }
        }

        @Override
        public void onGuidedActionClicked(GuidedAction action) {
            String text = OPTION_NAMES[getSelectedActionPosition() - 1] + " clicked";
            Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
        }
    }
}
