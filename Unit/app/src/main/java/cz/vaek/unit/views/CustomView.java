package cz.vaek.unit.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jitr on 5/18/16.
 */
public class CustomView extends View{
    public static final int POINTS_COUNT = 9;
    public static final int OVAL_RADIUS = 30;

    private Paint mPaint;
    private Point[] mCoordinates;
    private boolean[] mShouldDraw;

    CustomView(Context context) throws Exception{
        super(context);
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        initPrintingInformation();
    }


    public CustomView(Context context, AttributeSet st) throws Exception{
        super(context, st);
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        initPrintingInformation();
    }

    private void initPrintingInformation() throws Exception{
        mShouldDraw = new boolean[POINTS_COUNT];
        for(int i = 0 ; i  < POINTS_COUNT ; i++){
            mShouldDraw[i] = false;
        }
        mCoordinates = new Point[POINTS_COUNT];
        mCoordinates[0] = new Point(600/4,600/4);
        mCoordinates[1] = new Point(600/2,600/4);
        mCoordinates[2] = new Point(600 * 3 / 4, 600/4);
        mCoordinates[3] = new Point(600/4,600/2);
        mCoordinates[4] = new Point(600/2,600/2);
        mCoordinates[5] = new Point(600 * 3 / 4,600/2);
        mCoordinates[6] = new Point(600/4,600 * 3 / 4);
        mCoordinates[7] = new Point(600/2,600 * 3 / 4);
        mCoordinates[8] = new Point(600 * 3 / 4,600 * 3 / 4);
    }

    public void setConfiguration(boolean[] configuration){
        mShouldDraw = configuration;
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        for(int i = 0; i < POINTS_COUNT ; i++){
            if(mShouldDraw[i]){
                canvas.drawCircle(mCoordinates[i].x,mCoordinates[i].y,OVAL_RADIUS,mPaint);
            }
        }
    }
}
