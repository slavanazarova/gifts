package ru.future.scientist.gifts;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GiftAdapter extends RecyclerView.Adapter {

    public static class GiftViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGiftFoto;
        TextView tvGiftName;


        public GiftViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGiftFoto = itemView.findViewById(R.id.ivGiftFoto);
            tvGiftName = itemView.findViewById(R.id.tvGiftName);
        }

        public void bind(Gift gift) {
            tvGiftName.setText(gift.getName());
        }
    }

}
