package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import Model.NewsMod;
import project.android_projects.com.livedataimplementation.R;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewModel> {
    private static final String TAG = "LiveDataAdapter";

    private List<NewsMod.ArticleMod> articleList;
    private Context context;

    public MyRecyclerViewAdapter(Context context, List<NewsMod.ArticleMod> list) {
        this.context = context;
        articleList = list;
    }

    @NonNull
    @Override
    public BaseViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LiveDataViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewModel holder, int position) {
        holder.bind(articleList.get(position));
    }

    @Override
    public int getItemCount() {
        //Null check
        if (articleList != null && articleList.size() > 0) {
            return articleList.size();
        }
        return 0;
    }

    public class LiveDataViewHolder extends BaseViewModel<NewsMod.ArticleMod> {

        private TextView titleTV;
        private ImageView newsImgView;

        public LiveDataViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.title_txt_view);
            newsImgView = itemView.findViewById(R.id.news_img_view);
        }

        @Override
        protected void clear() {
            newsImgView.setImageDrawable(null);
            titleTV.setText("");
        }

        @Override
        public void bind(NewsMod.ArticleMod obj) {
            titleTV.setText(obj.getTitle());
            Glide.with(context).load(obj.getUrlToImage())
                    .into(newsImgView);
        }
    }
}
