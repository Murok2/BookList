package com.minix.aidaraly.booklist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Arrays;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>
{
    private List<Item> bookList;
    private OnItemListener mOnItemListener;
    private Context context;

    public BookAdapter( List<Item> bookList , OnItemListener onItemListener , Context context )
    {
        this.bookList = bookList;
        mOnItemListener = onItemListener;
        this.context = context;
    }

    @NonNull
    @Override
    public BookAdapter.BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new BookViewHolder(itemView, mOnItemListener );
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.BookViewHolder bookViewHolder, int i)
    {


         bookViewHolder.title.setText( bookList.get(i).getVolumeInfo().getTitle() );

         List<String> authorList = bookList.get(i).getVolumeInfo().getAuthors();
         String authors = "N/A";
         if (authorList!=null) {
             authors = Arrays.toString( authorList.toArray() );
         }
         authors = authors.substring(1, authors.length()-1);
         if (!authors.equals("/")) {
             bookViewHolder.author.setText( authors);
         } else {
             bookViewHolder.author.setText( "None" );
         }

         bookViewHolder.publishedDate.setText(bookList.get(i).getVolumeInfo().getPublishedDate());

         bookViewHolder.page_count.setText( "pages: " + bookList.get(i).getVolumeInfo().getPageCount());

         double averageRating = bookList.get(i).getVolumeInfo().getAverageRating();
         if ( averageRating==0.0 ) {
             bookViewHolder.average_rating.setText( "N/A" );
         } else {
             bookViewHolder.average_rating.setText( averageRating + "" );
         }

         ImageView thumbnail_image = bookViewHolder.thumbnail_image;
         Glide.with( context )
                 .load( bookList.get(i).getVolumeInfo().getImageLinks().getSmallThumbnail() )
                 .placeholder(R.drawable.ic_launcher_background)
                 .error(R.drawable.ic_launcher_background)
                 .dontAnimate()
                 .into(thumbnail_image);
    }

    @Override
    public int getItemCount() {
        return bookList!=null ? bookList.size() : 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title;
        public TextView author;
        public TextView page_count;
        public TextView publishedDate;
        public TextView average_rating;
        public ImageView thumbnail_image;

        OnItemListener onItemListener;

        public BookViewHolder(View view, OnItemListener onItemListener) {
            super(view);
            title = view.findViewById(R.id.title);
            author = view.findViewById(R.id.authors);
            page_count = view.findViewById(R.id.pages_count);
            publishedDate = view.findViewById(R.id.published_date);
            average_rating = view.findViewById(R.id.average_rating);
            thumbnail_image = view.findViewById(R.id.image_thumbnail);

            this.onItemListener =onItemListener;

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemListener.onItemClick(getAdapterPosition());
        }
    }


    public interface OnItemListener {
        void onItemClick (int i);
    }
}
