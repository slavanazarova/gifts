package ru.future.scientist.gifts;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


public class GiftsActivity extends AppCompatActivity {

    private GiftAdapter adapter;
    private GiftGenerator generator = new GiftGenerator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initList();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            final Intent intent = AddGiftActivity.getStartIntent(this);
            startActivity(intent);
        });
    }

    private  void  initList(){
        RecyclerView rvGifts = findViewById(R.id.rvGift);
        rvGifts.setHasFixedSize(true);
        rvGifts.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new GiftAdapter(generator.getGifts(15));
        rvGifts.setAdapter(adapter);
    }
}
