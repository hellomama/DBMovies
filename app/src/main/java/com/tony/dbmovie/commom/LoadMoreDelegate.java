package com.tony.dbmovie.commom;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by dev on 2/5/18.
 */

public class LoadMoreDelegate {

    public interface LoadMoreSubject{
        void onLoadMore();
        boolean isLoading();
//        void noMoreData();
    }

    private LoadMoreSubject loadMoreSubject;
    private boolean noMoreData = false;

    public LoadMoreDelegate(LoadMoreSubject loadMoreSubject) {
        this.loadMoreSubject = loadMoreSubject;
    }

    public void attachRecycleView(RecyclerView recyclerView)
    {
        LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new EndlessScrollListener(manager,loadMoreSubject));
    }

    private static class EndlessScrollListener extends RecyclerView.OnScrollListener {

        private static final int VISIBLE_THRESHOLD = 6;
        private final LinearLayoutManager layoutManager;
        private final LoadMoreSubject loadMoreSubject;


        private EndlessScrollListener(LinearLayoutManager layoutManager, LoadMoreSubject loadMoreSubject) {
            this.layoutManager = layoutManager;
            this.loadMoreSubject = loadMoreSubject;
        }


        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            if (dy < 0 || loadMoreSubject.isLoading()) return;

            final int itemCount = layoutManager.getItemCount();
            final int lastVisiblePosition = layoutManager.findLastCompletelyVisibleItemPosition();
            final boolean isBottom = (lastVisiblePosition >= itemCount - VISIBLE_THRESHOLD);
            if (isBottom) {
                loadMoreSubject.onLoadMore();
            }
        }
    }
}
