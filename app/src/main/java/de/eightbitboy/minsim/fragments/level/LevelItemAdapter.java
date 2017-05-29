package de.eightbitboy.minsim.fragments.level;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.eightbitboy.minsim.R;
import de.eightbitboy.minsim.data.Level;
import de.eightbitboy.minsim.data.LevelDao;
import de.eightbitboy.minsim.database.Database;

import java.util.List;

class LevelItemAdapter extends RecyclerView.Adapter<LevelItemAdapter.LevelItemViewHolder> {

    private final List<Level> levels;

    LevelItemAdapter() {
	    LevelDao dao = Database.getSession().getLevelDao();
	    levels = dao.loadAll();
    }

    @Override
    public LevelItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_level_item, parent, false);
        return new LevelItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LevelItemViewHolder holder, int position) {
		holder.setLevel(levels.get(position));

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

    class LevelItemViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        private Level level;

	    @BindView(R.id.level_item_number) TextView numberTextView;
	    @BindView(R.id.level_item_content) TextView contentTextView;

	    LevelItemViewHolder(View view) {
            super(view);
	        ButterKnife.bind(this, view);
            this.view = view;
        }

	    public void setLevel(Level level) {
		    this.level = level;
		    numberTextView.setText("" + this.level.getNumber());
		    contentTextView.setText("Level " + this.level.getNumber());
	    }
    }

    class LevelItemMiningViewHolder extends RecyclerView.ViewHolder {
	    public final View view;
	    private Level level;

	    public LevelItemMiningViewHolder(View view) {
		    super(view);
		    ButterKnife.bind(this, view);
		    this.view = view;
	    }
    }
}
