package com.zawlynn.movie.mvvm.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.zawlynn.movie.mvvm.R;
import com.zawlynn.movie.mvvm.ui.main.adapter.PopularMovieAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    MainViewModel viewModel;
    @BindView(R.id.recMovies)
    RecyclerView recMovies;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewModel= ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.getPopularMoive(MainActivity.this);
        PopularMovieAdapter adapter=new PopularMovieAdapter();
        viewModel.movies.observe(this, movies -> {
            Log.d(TAG,"DATA RECEIVES "+movies.size());
            adapter.submitList(movies);
        });
        GridLayoutManager layoutManager= new GridLayoutManager(this, 2);
        recMovies.setLayoutManager(layoutManager);
        recMovies.setAdapter(adapter);
    }
}
