package tech.zafrani.companionforpubg.adapters;


import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.models.NewsItem;

public class NewsAdapter extends RecyclerViewAdapter<NewsItem, NewsAdapter.NewsItemViewHolder>{

    @Override
    public NewsAdapter.NewsItemViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
                                                 final int viewType) {
        return new NewsItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_news, parent, false));
    }


    public class NewsItemViewHolder extends RecyclerViewAdapter.ViewHolder {
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

        @Override
        public void bind(int position) {
            super.bind(position);
            final NewsItem newsItem = get(position);
            Picasso.with(this.itemView.getContext())
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
