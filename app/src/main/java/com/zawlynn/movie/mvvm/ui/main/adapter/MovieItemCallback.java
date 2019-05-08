package com.zawlynn.movie.mvvm.ui.main.adapter;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import com.zawlynn.movie.mvvm.model.Movie;

public class MovieItemCallback extends  DiffUtil.ItemCallback<Movie>{
    public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
        return oldItem.equals(newItem);
    }
}
