package tech.zafrani.companionforpubg.adapters;


import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.models.News;
import tech.zafrani.companionforpubg.models.NewsItem;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsItemViewHolder>{
    @NonNull
    private final News news = new News();

    public void addNewsItem(@NonNull final NewsItem newsItem) {
        news.add(newsItem);
    }

    @Override
    public NewsItemViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
                                                 final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_news, parent, false);
        return new NewsItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsItemViewHolder holder,
                                 final int position) {
        final NewsItem newsItem = news.get(position);
        holder.bind(newsItem);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }


    public class NewsItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.row_item_image)
        ImageView imgImageView;

        @BindView(R.id.row_item_title)
        TextView titleTextView;

        @BindView(R.id.row_item_type)
        TextView typeTextView;

        @BindView(R.id.row_item_date)
        TextView dateTextView;

        @BindView(R.id.row_item_description)
        TextView descriptionTextView;


        public NewsItemViewHolder(@NonNull final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public void bind(final NewsItem newsItem) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(@NonNull final View view) {
                    final Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( newsItem.getLinkSrc()));
                    view.getContext().startActivity(browse);
                }
            });

            Picasso.with(itemView.getContext())
                    .load(newsItem.getImgSrc())
                    .fit()
                    .into(imgImageView);
            titleTextView.setText(newsItem.getTitle());
            typeTextView.setText(newsItem.getType());
            dateTextView.setText(newsItem.getDate());
            descriptionTextView.setText(newsItem.getDescription());
        }

    }
}
