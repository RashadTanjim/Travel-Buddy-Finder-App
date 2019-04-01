package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.travelbuddy.travelbuddy.R;

import java.util.List;

import model.AccountModel;




public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ViewHolder>{
    private Context context;
    private List<AccountModel> accountModels;

    public AccountAdapter(Context context, List<AccountModel> accountModels) {
        this.context = context;
        this.accountModels = accountModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_pic_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.accountpic.setImageResource(accountModels.get(position).getAccountpic());
    }

    @Override
    public int getItemCount() {
        return accountModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView accountpic;
        public ViewHolder(View itemView) {
            super(itemView);
            accountpic = itemView.findViewById(R.id.accountpic);
        }
    }
}
