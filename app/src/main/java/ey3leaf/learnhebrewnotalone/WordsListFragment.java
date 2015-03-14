package ey3leaf.learnhebrewnotalone;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class WordsListFragment extends Fragment {
    private int picturePosition;
    private String title;
    private RecyclerView wordsList;
    private WordsListAdapter adapter;

    public WordsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_words_list, container, false);

        wordsList = (RecyclerView) view.findViewById(R.id.words_list);
        adapter = new WordsListAdapter(getResources().getStringArray(CardsAdapter.getWords()[picturePosition]));
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(CardsAdapter.getPictures()[picturePosition]);
        wordsList.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        return view;
    }
    public void setPicturePosition(int position){
        this.picturePosition = position;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        wordsList.setLayoutManager(llm);
        wordsList.setAdapter(adapter);
    }
}
