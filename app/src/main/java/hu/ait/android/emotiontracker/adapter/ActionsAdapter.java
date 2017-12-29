package hu.ait.android.emotiontracker.adapter;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hu.ait.android.emotiontracker.R;
import hu.ait.android.emotiontracker.data.Action;

/**
 * Created by alicetan on 12/28/17.
 */

public class ActionsAdapter extends RecyclerView.Adapter<ActionsAdapter.ViewHolder>{


    private Context context;
    private List<Action> actionList;
    private List<String> actionKeys;
    private DatabaseReference actionRef;
    private String uId;

    public ActionsAdapter(Context context, String uId){
        this.context = context;
        this.uId = uId;

        actionList = new ArrayList<Action>();
        actionKeys = new ArrayList<String>();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_action, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Action action = actionList.get(position);
        holder.tvAction.setText(action.getActionName());


    }

    @Override
    public int getItemCount() {
        return actionList.size();
    }

    public void addAction(Action action, String key) {
        actionList.add(action);
        actionKeys.add(key);

        notifyDataSetChanged();
    }

    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(actionList, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(actionList, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    public void removeItem(int index){
        actionRef = FirebaseDatabase.getInstance().getReference();
        actionRef.child("actions").child(actionKeys.get(index)).removeValue();
        actionList.remove(index);
        actionKeys.remove(index);
        notifyItemRemoved(index);
    }

    public void removeItemByKey(String key) {
        int index = actionKeys.indexOf(key);
        if (index != -1) {
            actionList.remove(index);
            actionKeys.remove(index);
            notifyItemRemoved(index);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvAction;
        public ImageView ivAction;

        public ViewHolder(View itemView) {
            super(itemView);

            tvAction = itemView.findViewById(R.id.tvAction);
            ivAction = itemView.findViewById(R.id.ivAction);
        }
    }
}
