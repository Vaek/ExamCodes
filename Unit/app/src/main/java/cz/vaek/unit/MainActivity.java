package cz.vaek.unit;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.widget.Button;
import android.widget.TextView;

/**
 * <h1>Storyous exam code</h1>
 * <p/>
 * <p>Find mistake(s) :-D</p>
 * <p>Checkout on Github:
 * <a href="https://github.com/Vaek/ExamCodes/tree/master/Unit">here</a></p>
 * <p>or Download app:
 * <a href="https://github.com/Vaek/ExamCodes/raw/master/Unit/app-debug.apk">here</a></p>
 */
public class MainActivity extends CubeActivity {

    /**
     * String representation of cube values
     */
    @StringRes
    private static final int[] CUBE_VALUES
            = new int[]{R.string.cube_value_1,
            R.string.cube_value_2,
            R.string.cube_value_3,
            R.string.cube_value_4,
            R.string.cube_value_5,
            R.string.cube_value_6,
            R.string.cube_value_fail};

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImage = findViewById(R.id.dice);
        mButtonsList.add((Button)findViewById(R.id.button));
        mButtonsList.add((Button)findViewById(R.id.switchToScreen));
        mButtonsList.add((Button)findViewById(R.id.switchToDots));
        repaintCubeValue();
    }


    /**
     * Repaint value of cube in {@link TextView} with id {@link R.id#text}.
     */
    protected void repaintCubeValue() {
        TextView textView = (TextView) findViewById(R.id.dice);
        textView.setText(CUBE_VALUES[mLastCubeValue]);
    }
}
