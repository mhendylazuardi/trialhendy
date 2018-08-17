package com.example.xback.ini;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.xback.ini.model.ImageLinks;
import com.example.xback.ini.model.Item;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.http.POST;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private Context bookContext;
    private List<Item> itemList = new ArrayList<>();


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        bookContext = viewGroup.getContext();
        View view = LayoutInflater.from(bookContext).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void addBookItem(List<Item> bookItems) {
        itemList.clear();
        itemList.addAll(bookItems);
        notifyDataSetChanged();
    }
// recyclenya
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvAuthor;
        TextView tvTitle;
        RatingBar ratingBar;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageBook);
            tvTitle = (TextView) itemView.findViewById(R.id.titleBook);
            tvAuthor = (TextView) itemView.findViewById(R.id.authorBook);
            ratingBar = (RatingBar) itemView.findViewById(R.id.ratingStar);
        }

//  tampilkan data
        public void bind(int i) {

            Item item = itemList.get(i);
            if (item != null) {
                Double rating = item.getVolumeInfo().getAverageRating();
                String title = item.getVolumeInfo().getTitle();
                List<String> authors = item.getVolumeInfo().getAuthors();
                ImageLinks thumbnail = item.getVolumeInfo().getImageLinks();
//                ternary operator

                String authorNames = "";
                if (authors!= null)
                for (int a = 0; a < authors.size(); a++ ){
                    authorNames += authors.get(a);
                }
                tvAuthor.setText(authorNames);
                tvTitle.setText(title == null ? "-" : title);
                ratingBar.setRating(rating == null ? 0 : rating.floatValue());
                ImageLoader.loadImage(thumbnail == null ? "":thumbnail.getThumbnail(), imageView);
            }

        }
    }
}

