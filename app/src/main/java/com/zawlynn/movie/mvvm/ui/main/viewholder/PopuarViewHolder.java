package com.zawlynn.movie.mvvm.ui.main.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.zawlynn.movie.mvvm.R;
import com.zawlynn.movie.mvvm.constant.Constants;
import com.zawlynn.movie.mvvm.model.Movie;
import com.zawlynn.movie.mvvm.uitls.GlideApp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PopuarViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.item_poster_post)
    ImageView item_poster_post;
    @BindView(R.id.item_poster_title)
    TextView item_poster_title;
    @BindView(R.id.progress)
    ProgressBar progress;
    private Context context;
    public PopuarViewHolder(View itemLayoutView) {
        super(itemLayoutView);
        ButterKnife.bind(this, itemLayoutView);
        context=itemLayoutView.getContext();
    }

    public void bind(Movie movie) {
        item_poster_title.setText(movie.getTitle());
        String url = Constants.BASE_POSTER_PATH+movie.getPoster_path();
        GlideApp.with(context)
                .load(url).override(300, 300)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        progress.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        progress.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(item_poster_post);
    }
}
