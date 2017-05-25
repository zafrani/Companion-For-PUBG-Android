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

import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.models.News;
import tech.zafrani.companionforpubg.models.NewsItem;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsItemViewHolder>{
    @NonNull
    private final News news = new News();

    public void addNewsItem(@NonNull final NewsItem newsItem) {
        news.add(newsItem);
    }

    public NewsAdapter() {

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
        @NonNull
        private final ImageView imgImageView;
        @NonNull
        private final TextView titleTextView;
        @NonNull
        private final TextView typeTextView;
        @NonNull
        private final TextView dateTextView;
        @NonNull
        private final TextView descriptionTextView;

        public NewsItemViewHolder(@NonNull final View itemView) {
            super(itemView);
            imgImageView = (ImageView) itemView.findViewById(R.id.row_item_image);
            titleTextView = (TextView) itemView.findViewById(R.id.row_item_title);
            typeTextView = (TextView) itemView.findViewById(R.id.row_item_type);
            dateTextView = (TextView) itemView.findViewById(R.id.row_item_date);
            descriptionTextView = (TextView) itemView.findViewById(R.id.row_item_description);
        }

        public void bind(@NonNull final NewsItem newsItem) {
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
