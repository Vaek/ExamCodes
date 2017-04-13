package cz.vaek.unit;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

/**
 * Created by jitr on 5/17/16.
 */
public class PointsActivity extends CubeActivity {

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
        setContentView(R.layout.activity_points);
        mButtonsList.add((Button)findViewById(R.id.button));
        mButtonsList.add((Button)findViewById(R.id.switchToNumbers));
        mImage = findViewById(R.id.flipper);
    }

    /**
     * According to {@link #mLastCubeValue} get current layout from {@link RelativeLayout}
     * @return currently selected RelativeLayout
     */
    private RelativeLayout getCurrentLayout(){
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.dice_number_six);
        if(mLastCubeValue == 0 || mLastCubeValue ==  6)
            layout = (RelativeLayout) findViewById(R.id.dice_number_one);
        if(mLastCubeValue == 1)
            layout = (RelativeLayout) findViewById(R.id.dice_number_two);
        if(mLastCubeValue == 2)
            layout = (RelativeLayout) findViewById(R.id.dice_number_three);
        if(mLastCubeValue == 3)
            layout = (RelativeLayout) findViewById(R.id.dice_number_four);
        if(mLastCubeValue == 4)
            layout = (RelativeLayout) findViewById(R.id.dice_number_five);
        return layout;
    }

    /**
     * Repaint value of cube
     */
    @Override
    protected void repaintCubeValue() {
        ViewFlipper flipper = (ViewFlipper) findViewById(R.id.flipper);
        flipper.setDisplayedChild(flipper.indexOfChild(getCurrentLayout()));
    }

    /**
     * Rotate {@link #mImage}
     */
    @Override
    protected void startRotatingImage() {
        mImage = getCurrentLayout();
        super.startRotatingImage();
    }
}