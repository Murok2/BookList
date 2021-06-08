package com.minix.aidaraly.booklist;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class BookActivity extends AppCompatActivity implements BookAdapter.OnItemListener {
    private List<Item> bookList;
    private RecyclerView recyclerView;
    private BookAdapter mAdapter;
    private ProgressDialog progressDialog;
    private static final String BOOK_LIST = "book_list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);

        recyclerView = findViewById(R.id.recycler_view);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        String bookTitle = getIntent().getStringExtra(MainActivity.BOOK_TITLE);

        GoogleBooksApi api = Generator.getRetrofitInstance(GoogleBooksApi.class);

        retrofit2.Call<Items> call = api.getBooks( bookTitle );

        call.enqueue(new Callback<Items>() {
            @Override
            public void onResponse(retrofit2.Call<Items> call, Response<Items> response) {
                bookList = response.body().getItems();
                initBookList(bookList);
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(retrofit2.Call<Items> call, Throwable t) {
                Log.e("MainActivity", t.getMessage() );
                Toast.makeText(BookActivity.this, "Failure: "+t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

    }
    private void initBookList( List<Item> bookList ) {
        mAdapter = new BookAdapter(bookList, this, getApplicationContext() );
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(int i) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(bookList.get(i).getVolumeInfo().getPreviewLink()));
        startActivity(intent);
    }

    // To be implemented later
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }
}


