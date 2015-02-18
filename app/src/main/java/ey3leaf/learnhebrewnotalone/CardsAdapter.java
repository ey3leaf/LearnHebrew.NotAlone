package ey3leaf.learnhebrewnotalone;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CardsAdapter extends RecyclerView.Adapter<CardViewHolder> {
    private String[] titles;


    public CardsAdapter() {
        titles = new String[]{"HHUI", "pizda", "i", "djygurda","asd","asd","sddg","xfhgf","asdf"};
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new CardViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        holder.imageView.setImageResource(R.drawable.ic_launcher);
        holder.title.setText(titles[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
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
