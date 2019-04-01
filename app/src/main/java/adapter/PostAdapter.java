package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.travelbuddy.travelbuddy.R;
import com.github.siyamed.shapeimageview.RoundedImageView;
import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import model.PostModel;



public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder>{
    private Context context;
    private List<PostModel> postModels;

    public PostAdapter(Context context, List<PostModel> postModels) {
        this.context = context;
        this.postModels = postModels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_view,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.profile.setImageResource(postModels.get(position).getProfile());
        holder.name.setText(postModels.get(position).getName());
        holder.post.setImageResource(postModels.get(position).getPost());
        holder.like.setText(postModels.get(position).getLike());
        holder.caption.setText(postModels.get(position).getCaption());
        holder.captionname.setText(postModels.get(position).getCaptionname());
    }

    @Override
    public int getItemCount() {
        return postModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        PorterShapeImageView post;
        CircleImageView profile;
        TextView name,like,caption,captionname;
        public MyViewHolder(View itemView) {
            super(itemView);

            post = itemView.findViewById(R.id.postimage);
            profile = itemView.findViewById(R.id.post_profile_image);
            name = itemView.findViewById(R.id.txtpostname);
            like = itemView.findViewById(R.id.txtlikes);
            caption = itemView.findViewById(R.id.txtcaption);
            captionname = itemView.findViewById(R.id.txtcaptionname);
        }

    }
}
