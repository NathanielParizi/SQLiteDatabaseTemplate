package com.example.firerpg.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firerpg.Activity.DetailsActivity;
import com.example.firerpg.Model.Grocery;
import com.example.firerpg.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private Context context;

    private List<Grocery> groceryList;


    public RecyclerViewAdapter(Context context, List<Grocery> groceryList) {
        this.context = context;
        this.groceryList = groceryList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);

        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {

        Grocery grocery = groceryList.get(position);

        holder.name.setText(grocery.getName());
        holder.quant.setText(grocery.getQuantity());
        holder.date.setText(grocery.getDateItemAdded());


    }

    @Override
    public int getItemCount() {
        return groceryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView name;
        private TextView quant;
        private TextView date;
        private Button editBtn1;
        private Button deleteBtn;
        public int id;

        public ViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);

            context = ctx;
            name = (TextView) itemView.findViewById(R.id.txt1);
            quant = (TextView) itemView.findViewById(R.id.txt2);
            date = (TextView) itemView.findViewById(R.id.date);
            editBtn1 = (Button) itemView.findViewById(R.id.editBtn);
            deleteBtn = (Button) itemView.findViewById(R.id.deleteBtn);

            editBtn1.setOnClickListener(this);
            deleteBtn.setOnClickListener(this);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();

                    Grocery grocery = groceryList.get(position);

                    Intent intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("name", grocery.getName());
                    intent.putExtra("quantity",grocery.getQuantity());
                    intent.putExtra("id",grocery.getId());
                    intent.putExtra("date", grocery.getDateItemAdded());

                    context.startActivity(intent);
                }
            });
        }

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.editBtn:
                    break;
                case R.id.deleteBtn:
                    break;

            }


        }
    }
}
