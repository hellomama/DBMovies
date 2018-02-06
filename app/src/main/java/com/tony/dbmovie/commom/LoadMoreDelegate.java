package com.tony.dbmovie.commom;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tony.dbmovie.data.LoadMore;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

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
    private Items items;
    private MultiTypeAdapter adapter;

    public LoadMoreDelegate(LoadMoreSubject loadMoreSubject, Items items, MultiTypeAdapter adapter) {
        this.loadMoreSubject = loadMoreSubject;
        this.items = items;
        this.adapter = adapter;
    }

    public void attachRecycleView(RecyclerView recyclerView)
    {
        LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new EndlessScrollListener(manager,loadMoreSubject,items,adapter));
    }

    private static class EndlessScrollListener extends RecyclerView.OnScrollListener {

        private static final int VISIBLE_THRESHOLD = 6;
        private final LinearLayoutManager layoutManager;
        private final LoadMoreSubject loadMoreSubject;
        private final Items items;
        private MultiTypeAdapter adapter;


        private EndlessScrollListener(LinearLayoutManager layoutManager, LoadMoreSubject loadMoreSubject,Items items,MultiTypeAdapter adapter) {
            this.layoutManager = layoutManager;
            this.loadMoreSubject = loadMoreSubject;
            this.items = items;
            this.adapter = adapter;
        }


        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            if (dy < 0 || loadMoreSubject.isLoading()) return;

            final int itemCount = layoutManager.getItemCount();
            final int lastVisiblePosition = layoutManager.findLastCompletelyVisibleItemPosition();
            final boolean isBottom = (lastVisiblePosition >= itemCount - VISIBLE_THRESHOLD);
            if (isBottom) {
                items.add(new LoadMore());
                adapter.setItems(items);
                recyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyItemInserted(items.size() - 1);
                    }
                });
                loadMoreSubject.onLoadMore();
            }
        }
    }
}
