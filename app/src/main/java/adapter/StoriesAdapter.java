package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.travelbuddy.travelbuddy.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import model.StoriesModel;



public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.ViewHolder>{
    private Context context;
    private List<StoriesModel> storiesModels;

    public StoriesAdapter(Context context, List<StoriesModel> storiesModels) {
        this.context = context;
        this.storiesModels = storiesModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stories_view,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.profile.setImageResource(storiesModels.get(position).getProfile());
        holder.name.setText(storiesModels.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return storiesModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView profile;
        TextView name;
        public ViewHolder(View itemView) {
            super(itemView);

            profile = itemView.findViewById(R.id.profile_image);
            name = itemView.findViewById(R.id.txtname);
        }
    }
}
