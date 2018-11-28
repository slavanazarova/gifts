package ru.future.scientist.gifts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GiftAdapter extends RecyclerView.Adapter<GiftAdapter.GiftViewHolder>{


    List<Gift> gifts;

    public GiftAdapter(List<Gift> gifts) {
        this.gifts = gifts;
    }

    @NonNull
    @Override
    public GiftViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gift, parent, false);
        return new GiftViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GiftViewHolder holder, int position) {
        holder.bind(gifts.get(position));
    }

    @Override
    public int getItemCount() {
        return gifts.size();
    }

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
            Picasso.get().load(gift.getPathImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .fit()
                    .centerCrop()
                    .into(ivGiftFoto);

        }
    }

}
