package ey3leaf.learnhebrewnotalone;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class LearningFragment extends Fragment {
    private RecyclerView recyclerView;
    private GridLayoutManager glm;
    private CardsAdapter adapter;

    public LearningFragment() {
        // Required empty public constructor
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
        glm = new GridLayoutManager(getActivity(),2);
        adapter = new CardsAdapter(getResources().getStringArray(R.array.themes));
        recyclerView.setLayoutManager(glm);
        recyclerView.setAdapter(adapter);
    }
}
