package com.minix.aidaraly.booklist;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private boolean isConnectedToInternet = false;
    private EditText editText;
    private String bookTitle;
    public static final String BOOK_TITLE = "book_title";
    public static final String MAIN_ACTIVITY = "main_activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState()==NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED )  {
            // connection is available
            isConnectedToInternet = true;
        } else {
            isConnectedToInternet = false;
            Toast.makeText(this, "You don't have internet, please connect and try again", Toast.LENGTH_LONG).show();
        }

        editText = findViewById(R.id.editText);

    }
    public void search(View view) {
        bookTitle = editText.getText().toString();
        if (isConnectedToInternet) {
        if ( !bookTitle.isEmpty() )
        {
            Intent intent = new Intent(this, BookActivity.class);
            intent.putExtra(BOOK_TITLE, bookTitle.trim().replace(' ', '+'));
            Log.i( MAIN_ACTIVITY  , "User input: "+bookTitle );
            startActivity(intent);
        } else {
            Toast.makeText(this , "Enter Book name, please." , Toast.LENGTH_SHORT).show();
        }} else {
            Toast.makeText(this, "\"You don't have internet, please connect and try again", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putString( BOOK_TITLE , bookTitle );
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        editText.setText(savedInstanceState.getString(BOOK_TITLE));
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }
}
