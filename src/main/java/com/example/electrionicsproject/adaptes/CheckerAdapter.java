package com.example.electrionicsproject.adaptes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electrionicsproject.main.BaseContract;
import com.example.electrionicsproject.R;
import com.example.electrionicsproject.models.Checker;

import java.util.ArrayList;
import java.util.List;

public class CheckerAdapter extends RecyclerView.Adapter<CheckerAdapter.ChekerViewHOlder> {

    private ArrayList<Checker> checkersList;
    private BaseContract.OnItemClickListener clickListener;


    public CheckerAdapter(BaseContract.OnItemClickListener clickListener) {
        checkersList = new ArrayList<>();
        this.clickListener = clickListener;
    }


    public void setValues(ArrayList<Checker> values) {
        checkersList.clear();
        if (values != null) {
            checkersList.addAll(values);
        }
        this.notifyDataSetChanged();
    }

    public List<Checker> getOrdersList() {
        return checkersList;
    }



    @NonNull
    @Override
    public ChekerViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChekerViewHOlder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChekerViewHOlder holder, int position) {
        holder.bind(checkersList.get(position), clickListener);
    }

    @Override
    public int getItemCount() {
        return checkersList.size();
    }

    class ChekerViewHOlder extends RecyclerView.ViewHolder {

        TextView checkerNameView;

        public ChekerViewHOlder(@NonNull View itemView) {
            super(itemView);

            checkerNameView = itemView.findViewById(R.id.checkers_name);
        }

        public void bind(final Checker checker, final BaseContract.OnItemClickListener clickListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onItemClick(checker);
                }
            });

            checkerNameView.setText(checker.getNameOfChecker());
        }
    }

}
