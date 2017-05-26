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
import de.eightbitboy.minsim.fragments.level.dummy.DummyContent;
import de.eightbitboy.minsim.fragments.level.dummy.DummyContent.DummyItem;


public class LevelFragment extends Fragment {

    private OnListFragmentInteractionListener listener;

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
	    recyclerView.setAdapter(new LevelItemAdapter(DummyContent.ITEMS, listener));

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            listener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    // TODO
    // http://developer.android.com/training/basics/fragments/communicating.html
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
