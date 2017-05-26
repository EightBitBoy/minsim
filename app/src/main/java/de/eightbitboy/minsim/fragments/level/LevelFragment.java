package de.eightbitboy.minsim.fragments.level;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.eightbitboy.minsim.R;


public class LevelFragment extends Fragment {

    public LevelFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level_item_list, container, false);
	    RecyclerView recyclerView = (RecyclerView) view;
	    Context context = view.getContext();

	    recyclerView.setLayoutManager(new LinearLayoutManager(context));
	    recyclerView.setAdapter(new LevelItemAdapter());

        return view;
    }
    // TODO
    // http://developer.android.com/training/basics/fragments/communicating.html
}
