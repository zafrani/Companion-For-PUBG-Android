package tech.zafrani.pubgapp.adapters;


import android.support.annotation.Nullable;

public interface RecyclerViewAdapter<T> {

    @Nullable
    T get(int position);

}
