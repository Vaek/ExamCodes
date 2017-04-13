package cz.vaek.unit;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import cz.vaek.unit.views.CustomView;

/**
 * Created by jitr on 5/18/16.
 */
public class ScreenActivity extends CubeActivity{

    /**
     * Canvas, where the value of cube should be painted
     */
    private Canvas mCanvas;

    /**
     * Inner represantation of cube values.
     */
    public static final boolean[] FULL = {true,true,true,true,true,true,true,true,true};
    public static final boolean[] ONE = {false,false,false,false,true,false,false,false,false};
    public static final boolean[] TWO = {true,false,false,false,false,false,false,false,true};
    public static final boolean[] THREE = {true,false,false,false,true,false,false,false,true};
    public static final boolean[] FOUR = {true,false,true,false,false,false,true,false,true};
    public static final boolean[] FIVE = {true,false,true,false,false,false,true,false,true};
    public static final boolean[] SIX = {true,false,true,true,false,true,true,false,true};
    public static final boolean[] ZET = {true,true,true,false,true,false,true,true,true};
    public static final boolean[][] CUBE_VALUES = {ONE,TWO,THREE,FOUR,FIVE,SIX,ZET};

    /**
     * Starts rotating the {@link #mImage} when pressing it.
     */
    public View.OnClickListener evOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            cubeThrow(view);
            Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(2000);
        }
    };

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        mCanvas = new Canvas();
        CustomView customView = (CustomView) findViewById(R.id.sview);
        customView.setConfiguration(FULL);
        customView.draw(mCanvas);
        customView.setOnClickListener(evOnClick);
        mButtonsList.add(0,(Button)findViewById(R.id.switchToNumbers));
        mImage = findViewById(R.id.sview);
    }

    /**
     * Repaint value of cube.
     */
    protected void repaintCubeValue() {
        CustomView customView = (CustomView) findViewById(R.id.sview);
        customView.setConfiguration(CUBE_VALUES[mLastCubeValue]);
        customView.draw(mCanvas);
    }


}
