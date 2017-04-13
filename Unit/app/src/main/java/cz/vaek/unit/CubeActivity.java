package cz.vaek.unit;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by jitr on 5/23/16.
 */
public abstract class CubeActivity extends AppCompatActivity {
    /**
     * The last state of cube
     */
    protected int mLastCubeValue = 0;
    /**
     * ArrayList of all buttons that should be disabled in layout during throwing
     */
    ArrayList<Button> mButtonsList;
    /**
     * The image that should be rotated
     */
    View mImage;

    /**
     * Enable button to throw.
     *
     * @param enabled {@link Boolean#TRUE} if button is enabled, {@link Boolean#FALSE} otherwise.
     */
    protected void setAllButtonsEnabled(boolean enabled){
        for(ListIterator<Button> iterator = mButtonsList.listIterator() ; iterator.hasNext() ;){
            Button button = iterator.next();
            button.setEnabled(enabled);
        }
    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mButtonsList = new ArrayList<>();
    }

    /**
     * Repaint value of cube.
     */
    abstract protected void repaintCubeValue();

    protected void startRotatingImage() {
        Animation startRotateAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotation);
        mImage.startAnimation(startRotateAnimation);
    }

    /**
     * Call when click on button in layout.
     *
     * @param view Button in layout
     */
    public void cubeThrow(View view) {
        new CubeValueGenerator().execute();
    }

    /**
     * Changes to MainActivity, where the cube is represented with numbers in a square.
     * @param view Button in layout
     */
    public void changeToNumbers(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    /**
     * Changes to PointsActivity, where the cube is represented graphically through Flipper
     * @param view Button in layout
     */
    public void changeToPoints(View view){
        Intent intent = new Intent(this,PointsActivity.class);
        startActivity(intent);
    }

    /**
     * Changes to ScreenActivity, where cube is represented graphically with Canvas
     * @param view Button in layout
     */
    public void changeToScreen(View view){
        Intent intent = new Intent(this,ScreenActivity.class);
        startActivity(intent);
    }

    /**
     * Class for generating cube states
     */
    protected class CubeValueGenerator extends AsyncTask<Object, Object, Integer> {

        /**
         * Disables all buttons and start to rotate the cube
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            setAllButtonsEnabled(false);
            startRotatingImage();
        }

        /**
         * Counts a new cube value in background and then returns it
         * @param params no parameters necessary
         * @return Integer new value of the cube
         */
        @Override
        protected Integer doInBackground(Object... params) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return (int) (Math.random() * 6.1);
        }

        /**
         * Repaints the cube with the given new cube value
         * @param cubeValue Integer new cube value
         */
        @Override
        protected void onPostExecute(Integer cubeValue) {
            super.onPostExecute(cubeValue);
            mLastCubeValue = cubeValue;
            repaintCubeValue();
            setAllButtonsEnabled(true);
        }
    }
}
