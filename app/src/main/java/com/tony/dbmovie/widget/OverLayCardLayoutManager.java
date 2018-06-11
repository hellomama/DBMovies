package com.tony.dbmovie.widget;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dev on 4/9/18.
 */

public class OverLayCardLayoutManager extends RecyclerView.LayoutManager {

    public static int MAX_SHOW_COUNT = 5;
    //每一级Scale相差0.05f，translationY相差7dp左右
    public static float SCALE_GAP = 0.05f;
    public static int TRANS_Y_GAP = 15;

    public OverLayCardLayoutManager() {
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }


    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        detachAndScrapAttachedViews(recycler);
        int itemCount = getItemCount();
        if (itemCount >= MAX_SHOW_COUNT)
        {
            for (int position = itemCount - MAX_SHOW_COUNT;position<itemCount;position++)
            {
                View view = recycler.getViewForPosition(position);
                addView(view);
                measureChildWithMargins(view,0,0);
                int widthSpace = getWidth() - getDecoratedMeasuredWidth(view);
                int heightSpace = getWidth() - getDecoratedMeasuredHeight(view);
                layoutDecoratedWithMargins(view,widthSpace/2,heightSpace/2,
                        widthSpace/2+getDecoratedMeasuredWidth(view),heightSpace/2+getDecoratedMeasuredHeight(view));
                int level = itemCount - position - 1;
                //除了顶层不需要缩小和位移
                if (level > 0 /*&& level < mShowCount - 1*/) {
                    //每一层都需要X方向的缩小
                    view.setScaleX(1 - SCALE_GAP * level);
                    //前N层，依次向下位移和Y方向的缩小
                    if (level < MAX_SHOW_COUNT - 1) {
                        view.setTranslationY(TRANS_Y_GAP * level);
                        view.setScaleY(1 - SCALE_GAP * level);
                    } else {//第N层在 向下位移和Y方向的缩小的成都与 N-1层保持一致
                        view.setTranslationY(TRANS_Y_GAP * (level - 1));
                        view.setScaleY(1 - SCALE_GAP * (level - 1));
                    }
                }
                view.setRotationX(15);
                view.setRotationY(-15);
            }
        }
    }

    class ItemTouchCallback extends ItemTouchHelper.SimpleCallback
    {

        public ItemTouchCallback(int dragDirs, int swipeDirs) {
            super(dragDirs, swipeDirs);
        }

        @Override
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return 0;
        }

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        }

        @Override
        public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    }
}
