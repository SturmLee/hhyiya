package com.example.thirdday;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by stonegroup on 2016/9/8.
 */
public class GameItem extends View {

    int number;
    String numberValues;

    Paint mPaint;
    Rect mRect;



    public GameItem(Context context) {
        this(context,null,0);
    }

    public GameItem(Context context, AttributeSet attrs) {
       this(context, attrs,0);
    }

    public GameItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        numberValues = String.valueOf(number);

        //画笔
        mPaint.setTextSize(35f);
        //实例化矩形框
        mRect = new Rect();
        mPaint.getTextBounds(numberValues,0,numberValues.length(),mRect);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String numberColor = "";
        switch (number){
            case 2:
                break;
            case 4:
                break;
            case 8:
                break;
            case 16:
                break;
            case 32:
                break;
            case 64:
                break;
            case 128:
                break;
            case 256:
                break;
            



        }

    }
}
