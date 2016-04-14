package cz.vaek.unit;

import android.os.AsyncTask;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * <h1>Storyous exam code</h1>
 *
 * <p>Find mistake(s) :-D</p>
 * <p>Checkout on Github:
 * <a href="https://github.com/Vaek/ExamCodes/tree/master/Unit">here</a></p>
 * <p>or Download app:
 * <a href="https://github.com/Vaek/ExamCodes/raw/master/Unit/app-debug.apk">here</a></p>
 */
public class MainActivity extends AppCompatActivity {

    @StringRes
    private static final int[] CUBE_VALUES
            = new int[] {R.string.cube_value_1,
            R.string.cube_value_2,
            R.string.cube_value_3,
            R.string.cube_value_4,
            R.string.cube_value_5,
            R.string.cube_value_6,
            R.string.cube_value_fail};

    private int mLastCubeValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repaintCubeValue();
    }

    /**
     * Call when click on button in layout.
     * @param view  Button in layout.
     */
    public void cubeThrow(View view) {
        new CubeValueGenerator().execute();
    }

    /**
     * Enable button to throw.
     * @param enabled   {@link Boolean#TRUE} if button is enabled, {@link Boolean#FALSE} otherwise.
     */
    private void enableButton(boolean enabled) {
        Button button = (Button) findViewById(R.id.button);
        button.setEnabled(enabled);
    }

    /**
     * Repaint value of cube in {@link TextView} with id {@link cz.vaek.unit.R.id#text}.
     * @param mLastCubeValue  Last value of cube.
     */
    private void repaintCubeValue() {
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(CUBE_VALUES[mLastCubeValue]);
    }

    private class CubeValueGenerator extends AsyncTask<Object, Object, Integer> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            enableButton(false);
        }

        @Override
        protected Integer doInBackground(Object... params) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return (int) (Math.random() * 6.1);
        }

        @Override
        protected void onPostExecute(Integer cubeValue) {
            super.onPostExecute(cubeValue);
            mLastCubeValue += cubeValue;
            repaintCubeValue();
            enableButton(true);
        }
    }

}
