package ey3leaf.learnhebrewnotalone;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

public class WordsListAdapter extends RecyclerView.Adapter<WordsListAdapter.ViewHolder> {
    private String[] wordsArray;

    public WordsListAdapter(String[] wordsArray) {
        this.wordsArray = wordsArray;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_item,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String[] split = wordsArray[position].split(";");
        holder.original.setText(split[0]);
        holder.translation.setText(split[1]);
    }

    @Override
    public int getItemCount() {
        return wordsArray.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CheckBox original;
        private TextView translation;
        public ViewHolder(View itemView) {
            super(itemView);
            original = (CheckBox) itemView.findViewById(R.id.original);
            translation = (TextView) itemView.findViewById(R.id.translation);
        }
    }
}
