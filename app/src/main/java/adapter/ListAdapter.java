package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.travelbuddy.travelbuddy.Book;
import com.travelbuddy.travelbuddy.Home_Map;
import com.travelbuddy.travelbuddy.In_Travel;
import com.travelbuddy.travelbuddy.Login;
import com.travelbuddy.travelbuddy.R;
import com.travelbuddy.travelbuddy.Travel_History;
import com.travelbuddy.travelbuddy.Travel_complete_rating;
import com.travelbuddy.travelbuddy.Signup;

import java.util.ArrayList;

import model.ListModel;



public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    Context context;
    private ArrayList<ListModel> listModelArrayList;

    public ListAdapter(Context context, ArrayList<ListModel> listModelArrayList) {
        this.context = context;
        this.listModelArrayList = listModelArrayList;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, final int position) {
        holder.title.setText(listModelArrayList.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position==0){
                    Intent i = new Intent(context, Login.class);
                    context.startActivity(i);}
                if(position==1){
                    Intent i = new Intent(context, Signup.class);
                    context.startActivity(i);}
                if(position==2){
                    Intent i = new Intent(context, Home_Map.class);
                    context.startActivity(i);}
                if(position==3){
                    Intent i = new Intent(context, Book.class);
                    context.startActivity(i);}
                if(position==4){
                    Intent i = new Intent(context, In_Travel.class);
                    context.startActivity(i);}

                if(position==5){
                    Intent i = new Intent(context, Travel_complete_rating.class);
                    context.startActivity(i);}
                if(position==6){
                    Intent i = new Intent(context, Travel_History.class);
                    context.startActivity(i);}


            }
        });

    }

    @Override
    public int getItemCount() {
        return listModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.title);
        }
    }
}
