package ey3leaf.learnhebrewnotalone;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatLoginFragment extends Fragment implements View.OnClickListener {
    private Button loginButton;

    public ChatLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        loginButton = (Button) view.findViewById(R.id.loginButton);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loginButton.setOnClickListener(this);
        ParseUser user = ParseUser.getCurrentUser();
        if (user != null) {
            changeWindow();
        }
    }

    @Override
    public void onClick(View view) {
        ParseFacebookUtils.logIn(getActivity(), new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if (e == null) {
                    changeWindow();
                }
            }
        });
    }

    private void changeWindow() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new ChatFragment());

        transaction.commit();
    }
}
