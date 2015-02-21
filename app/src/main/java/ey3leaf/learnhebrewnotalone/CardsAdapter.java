package ey3leaf.learnhebrewnotalone;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardViewHolder> {
    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    private OnItemClickListener itemClickListener;
    private Context context;
    private String[] themes;
    private static int[] pictures;

    public CardsAdapter(Context context, String[] themes) {
        this.context = context;
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
                R.drawable.animals
        };
    }

    public static int[] getPictures() {
        return pictures;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, final int position) {
        holder.imageView.setImageResource(pictures[position]);
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(view, position);
                }
            }
        });
        holder.title.setText(themes[position]);
    }

    @Override
    public int getItemCount() {
        return themes.length;
    }

    /**
     * View Holder Class
     */
    class CardViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title;
        private View container;

        public CardViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            title = (TextView) itemView.findViewById(R.id.title);
            container = itemView.findViewById(R.id.main_container);
        }
    }
}


