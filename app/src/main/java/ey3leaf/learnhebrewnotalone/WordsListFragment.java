package ey3leaf.learnhebrewnotalone;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class WordsListFragment extends Fragment {
    private int picturePosition;


    public WordsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_words_list, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(CardsAdapter.getPictures()[picturePosition]);
        return view;
    }
    public void setPicturePosition(int position){
        this.picturePosition = position;
    }
}
