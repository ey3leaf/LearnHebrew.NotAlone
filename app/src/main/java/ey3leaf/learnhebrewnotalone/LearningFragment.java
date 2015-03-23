package ey3leaf.learnhebrewnotalone;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class LearningFragment extends Fragment {
    private RecyclerView recyclerView;

    public LearningFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.card_list);
        recyclerView.setHasFixedSize(true);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        CardsAdapter adapter = new CardsAdapter(getResources().getStringArray(R.array.themes));
        adapter.setItemClickListener(new CardsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                WordsListFragment wordsListFragment = new WordsListFragment();
                wordsListFragment.setPicturePosition(position);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    setExitTransition(TransitionInflater.from(getActivity()).inflateTransition(android.R.transition.explode));
                    wordsListFragment.setEnterTransition(TransitionInflater.from(getActivity()).inflateTransition(android.R.transition.explode));
                }
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                trans.replace(R.id.container, wordsListFragment);
                trans.addToBackStack(null);
                trans.commit();
            }
        });
        recyclerView.setLayoutManager(glm);
        recyclerView.setAdapter(adapter);
    }
}