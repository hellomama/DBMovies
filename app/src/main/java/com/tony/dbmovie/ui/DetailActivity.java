package com.tony.dbmovie.ui;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.tony.dbmovie.R;
import com.tony.dbmovie.contract.MoviesDetailContract;
import com.tony.dbmovie.data.EmptyClass;
import com.tony.dbmovie.data.Movie;
import com.tony.dbmovie.data.MovieDetail;
import com.tony.dbmovie.data.PopularComment;
import com.tony.dbmovie.presenter.MoviesDetailPresenter;
import com.tony.dbmovie.ui.binder.DetailCastBinder;
import com.tony.dbmovie.ui.binder.DetailCastHeader;
import com.tony.dbmovie.ui.binder.DetailHeaderBinder;
import com.tony.dbmovie.ui.binder.DetailReviewHeader;
import com.tony.dbmovie.ui.binder.DetailReviewsBinder;
import com.tony.dbmovie.ui.binder.DetailSummaryBinder;

import me.drakeet.multitype.ClassLinker;
import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by dev on 2/6/18.
 */

public class DetailActivity extends AppCompatActivity implements MoviesDetailContract.View{

    private final static String EXTRA_DATA = "data";
    private Movie movie;
    private Items items;
    private MultiTypeAdapter adapter;

    public static void start(Context context, Movie movie,ActivityOptions options) {
        Intent starter = new Intent(context, DetailActivity.class);
        starter.putExtra(EXTRA_DATA,movie);
        context.startActivity(starter,options.toBundle());
    }

    private void parseExtra()
    {
        Intent intent = getIntent();
        if (intent != null)
        {
            movie = (Movie) intent.getSerializableExtra(EXTRA_DATA);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        RecyclerView recyclerView = findViewById(R.id.list_movies_detail);
        adapter = new MultiTypeAdapter();
        adapter.register(Movie.class, new DetailHeaderBinder());
        adapter.register(MovieDetail.class).
                to(new DetailSummaryBinder(),new DetailCastBinder())
                .withClassLinker(new ClassLinker<MovieDetail>() {
                    @NonNull
                    @Override
                    public Class<? extends ItemViewBinder<MovieDetail, ?>> index(int position, @NonNull MovieDetail detail) {
                        if (position == 1)
                        {
                            return DetailSummaryBinder.class;
                        }else {
                            return DetailCastBinder.class;
                        }
                    }
                });
        adapter.register(EmptyClass.class).
                to(new DetailCastHeader(),new DetailReviewHeader())
                .withClassLinker(new ClassLinker<EmptyClass>() {
                    @NonNull
                    @Override
                    public Class<? extends ItemViewBinder<EmptyClass, ?>> index(int position, @NonNull EmptyClass emptyClass) {
                        if (position == 2)
                        {
                            return DetailCastHeader.class;
                        }else {
                            return DetailReviewHeader.class;
                        }
                    }
                });
        adapter.register(PopularComment.class, new DetailReviewsBinder());
        recyclerView.setAdapter(adapter);
        parseExtra();

        if (movie != null)
        {
            MoviesDetailPresenter presenter = new MoviesDetailPresenter(this);
            presenter.getMovieDetail(movie.getId());

        }

        items = new Items();
        items.add(movie);
        adapter.setItems(items);
    }

    @Override
    public void loadingMoviesDetail() {

    }

    @Override
    public void updateMovieDetail(MovieDetail detail) {
        items.add(detail);
        items.add(new EmptyClass());
        items.add(detail);
        items.add(new EmptyClass());
        items.addAll(detail.getPopularComments());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void loadMovieFail() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAfterTransition();
    }
}
