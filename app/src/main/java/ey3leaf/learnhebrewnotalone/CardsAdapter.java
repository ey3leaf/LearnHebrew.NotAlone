package ey3leaf.learnhebrewnotalone;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CardsAdapter extends RecyclerView.Adapter<CardViewHolder> {
    private String[] themes;
    private int[] pictures;

    public CardsAdapter(String[] themes) {
        this.themes = themes;
        pictures = new int[]{
                R.drawable.alphabet,
                R.drawable.numbers,
                R.drawable.calendar,
                R.drawable.anatomy,
                R.drawable.clothing,
                R.drawable.family,
                R.drawable.furniture,
                R.drawable.kitchen,
                R.drawable.city,
                R.drawable.transport,
                R.drawable.nature,
                R.drawable.weather,
                R.drawable.weed,
                R.drawable.animals,
        };
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new CardViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        holder.imageView.setImageResource(R.drawable.weather);
        holder.title.setText(themes[position]);
    }

    @Override
    public int getItemCount() {
        return themes.length;
    }
}

class CardViewHolder extends RecyclerView.ViewHolder {
    protected ImageView imageView;
    protected TextView title, description;

    public CardViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        title = (TextView) itemView.findViewById(R.id.title);
        description = (TextView) itemView.findViewById(R.id.description);
    }
}
