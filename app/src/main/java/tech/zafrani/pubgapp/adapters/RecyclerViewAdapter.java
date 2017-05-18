package tech.zafrani.pubgapp.adapters;


import android.support.annotation.Nullable;

import java.io.Serializable;

public interface RecyclerViewAdapter<Model extends Serializable> {

    @Nullable
    Model get(int position);

}
