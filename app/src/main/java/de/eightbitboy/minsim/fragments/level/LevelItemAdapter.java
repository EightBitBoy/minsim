package de.eightbitboy.minsim.fragments.level;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.eightbitboy.minsim.R;
import de.eightbitboy.minsim.data.Level;
import de.eightbitboy.minsim.data.LevelDao;
import de.eightbitboy.minsim.database.Database;

import java.util.List;

class LevelItemAdapter extends RecyclerView.Adapter<LevelItemAdapter.ViewHolder> {

    private final List<Level> levels;

    LevelItemAdapter() {
	    LevelDao dao = Database.getSession().getLevelDao();
	    levels = dao.loadAll();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_level_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.level = levels.get(position);
        holder.mIdView.setText("" + levels.get(position).getNumber());
        holder.mContentView.setText("Level " + holder.level.getNumber());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				//TODO Do something on click?
            }
        });
    }

    @Override
    public int getItemCount() {
        return levels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        final TextView mIdView;
        final TextView mContentView;
        Level level;

        ViewHolder(View view) {
            super(view);
            this.view = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }
    }
}
