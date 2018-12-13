package ru.future.scientist.gifts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GiftDetails extends AppCompatActivity {
    private static final String EXTRA_GIFT_ID = "ru.future.scientist.gift.extras.EXTRA_GIFT_ID";


    public static Intent getStartIntent(Context context, long personId) {
        return new Intent(context, GiftDetails.class).putExtra(EXTRA_GIFT_ID, personId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift_details);
        initUi();
    }


    private void initUi() {
        TextView tvName = findViewById(R.id.tvName);
        TextView tvNote = findViewById(R.id.tvNote);
        ImageView ivAvatar = findViewById(R.id.pathImage);
        RadioButton reserved = findViewById(R.id.reserved);


        final long personId = getIntent().getLongExtra(EXTRA_GIFT_ID, 0);
        final Gift person = AppDatabase.getInstance(this).giftDao().getById(personId);
        Picasso.get().load(person.getPathImage())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .fit()
                .centerCrop()
                .into(ivAvatar);
        tvName.setText(person.getName());
        tvNote.setText(person.getNote());
        reserved.setChecked(person.isReserved());
    }

}
