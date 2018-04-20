package com.tony.dbmovie.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.tony.dbmovie.R;


/**
 * Created by dev on 4/12/18.
 */

public class CommentDividerLine extends View {

    private Paint paint;
    private int x,y;
    private int unit;

    public CommentDividerLine(Context context) {
        super(context);
        init();
    }

    public CommentDividerLine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CommentDividerLine(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init()
    {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2);
        paint.setColor(getResources().getColor(R.color.black));
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        x = getMeasuredWidth();
        y = getMeasuredHeight()/2;
        unit = y;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0,y,x/8,y,paint);
        canvas.drawLine(x/8,y,x/8+unit,y-unit,paint);
        canvas.drawLine(x/8+unit,y-unit,x/8+3*unit,y+unit,paint);
        canvas.drawLine(x/8+3*unit,y+unit,x/8+4*unit,y,paint);
        canvas.drawLine(x/8+4*unit,y,x,y,paint);
    }
}
