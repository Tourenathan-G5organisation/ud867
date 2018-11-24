package com.tourenathan.bakingapp.androidlib;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DisplayActivityFragment extends Fragment {

    public DisplayActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_display, container, false);

        if (getActivity().getIntent().hasExtra(Intent.EXTRA_TEXT)) {
            String message = getActivity().getIntent().getStringExtra(Intent.EXTRA_TEXT);
            ((TextView)rootView.findViewById(R.id.message_textView)).setText(message);
        }
        return rootView;
    }
}
