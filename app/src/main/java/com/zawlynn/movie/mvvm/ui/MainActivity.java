package com.zawlynn.movie.mvvm.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zawlynn.movie.mvvm.R;

public class MainActivity extends AppCompatActivity {
    MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel= ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.getPopularMoive(MainActivity.this);
    }
}
