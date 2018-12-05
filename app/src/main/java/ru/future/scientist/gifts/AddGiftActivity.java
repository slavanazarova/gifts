package ru.future.scientist.gifts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Picasso;

public class AddGiftActivity extends AppCompatActivity {

    private ImageView ivImage;
    private TextInputLayout tilName;
    private TextInputLayout tilNote;
    private GiftGenerator generator = new GiftGenerator();
    private String avatarLink = "";

    public static Intent getStartIntent(Context context) {
        return new Intent(context, AddGiftActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gift);

        ivImage = findViewById(R.id.ivAvatar);
        tilName = findViewById(R.id.tilName);
        tilNote = findViewById(R.id.tilNote);


        loadImage(generator.getAvatarLink());
        ivImage.setOnClickListener(view -> loadImage(generator.getAvatarLink()));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Gift person = generator.getGift();
            loadImage(person.getPathImage());
            tilName.getEditText().setText(person.getName());
            tilNote.getEditText().setText(person.getNote());

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_add_gift, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actionAdd) {
            String name = tilName.getEditText().getText().toString();
            String note = tilNote.getEditText().getText().toString();
            Gift person = new Gift(name, note, ivImage, false);
            AppDatabase.getInstance(this).personDao().insertPerson(person);
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void loadImage(String link) {
        avatarLink = link;
        Picasso.get().load(avatarLink)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .fit()
                .centerCrop()
                .into(ivImage);
    }



}
