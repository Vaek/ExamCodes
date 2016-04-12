package cz.vaek.unit;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Exam code.
 *
 * Find mistake :-D
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repaintCubeValue();
    }

    public void cubeThrow(View view) {
        mLastCubeValue += (int) (Math.random() * 6.1);
        repaintCubeValue();
    }

    private void repaintCubeValue() {
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(CUBE_VALUES[mLastCubeValue]);
    }

}
