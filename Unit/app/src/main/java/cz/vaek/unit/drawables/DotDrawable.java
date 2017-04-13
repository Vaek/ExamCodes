package cz.vaek.unit.drawables;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;

/**
 * Created by jitr on 5/18/16.
 */
public class DotDrawable extends ColorDrawable{

    public static final int POINTS_COUNT = 9;
    public static final int OVAL_RADIUS = 30;

    private Paint mPaint;
    private Point[] mCoordinates;
    private boolean[] mShouldDraw;

    DotDrawable(){
        super(Color.RED);
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        initPrintingInformation();
    }

    private void initPrintingInformation(){
        mShouldDraw = new boolean[POINTS_COUNT];
        for(int i = 0 ; i  < POINTS_COUNT ; i++){
            mShouldDraw[i] = false;
        }
        mCoordinates = new Point[POINTS_COUNT];
        mCoordinates[0] = new Point(getBounds().width()/4,getBounds().height()/4);
        mCoordinates[1] = new Point(getBounds().width()/2,getBounds().height()/4);
        mCoordinates[2] = new Point(getBounds().width() * 3 / 4, getBounds().height()/4);
        mCoordinates[3] = new Point(getBounds().width()/4,getBounds().height()/2);
        mCoordinates[4] = new Point(getBounds().width()/2,getBounds().height()/2);
        mCoordinates[5] = new Point(getBounds().width() * 3 / 4,getBounds().height()/2);
        mCoordinates[6] = new Point(getBounds().width()/4,getBounds().height() * 3 / 4);
        mCoordinates[7] = new Point(getBounds().width()/2,getBounds().height() * 3 / 4);
        mCoordinates[8] = new Point(getBounds().width() * 3 / 4,getBounds().height() * 3 / 4);
    }

    public void setConfiguration(boolean[] configuration){
        mShouldDraw = configuration;
    }

    @Override
    public void draw(Canvas canvas){
        for(int i = 0; i < POINTS_COUNT ; i++){
            if(mShouldDraw[i]){
                canvas.drawCircle(mCoordinates[i].x,mCoordinates[i].y,OVAL_RADIUS,mPaint);
            }
        }
    }




}
