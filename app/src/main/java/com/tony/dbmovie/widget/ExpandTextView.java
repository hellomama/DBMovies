package com.tony.dbmovie.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tony.dbmovie.R;

/**
 * Created by dev on 2/7/18.
 */

public class ExpandTextView extends LinearLayout {

    private TextView content;
    private TextView showMore;
    private boolean showComplete = false;
    private int originalLine = 0;


    public ExpandTextView(Context context) {
        super(context);
        initLayout();
    }

    public ExpandTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initLayout();
    }

    public ExpandTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void initLayout()
    {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.expandable_text_view,this,true);
        content = view.findViewById(R.id.text_summary);
        showMore = view.findViewById(R.id.text_show_more);


        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                showComplete = !showComplete;
                updateContentLayout();
                updateText();
            }
        });
    }

    private void updateContentLayout()
    {
        if (showComplete) {
            content.setMaxLines(Integer.MAX_VALUE);
        }else {
            content.setMaxLines(4);
        }
    }


    public void initContent(String aContent)
    {
        content.setText(aContent);
        updateText();
    }

    private void updateText()
    {
        if (showComplete)
        {
            showMore.setText("收起");
        }else {
            showMore.setText("展开");
        }
    }
}
