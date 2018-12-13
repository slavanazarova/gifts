package ru.future.scientist.gifts;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;


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

    @Override
    protected void onStart() {
        super.onStart();
        updateList();
    }

    private void updateList() {
        List<Gift> people = AppDatabase.getInstance(this).giftDao().getAll();
        adapter.update(people);
    }



    private  void  initList(){
        RecyclerView rvGifts = findViewById(R.id.rvGift);
        rvGifts.setHasFixedSize(true);
        rvGifts.setLayoutManager(new GridLayoutManager(this, 3));
        List<Gift> gifts = AppDatabase.getInstance(this).giftDao().getAll();
        adapter = new GiftAdapter(gifts, item -> {
            final Intent intent = GiftDetails.getStartIntent(this, item.getId());
            startActivity(intent);
        });
        rvGifts.setAdapter(adapter);
    }
}