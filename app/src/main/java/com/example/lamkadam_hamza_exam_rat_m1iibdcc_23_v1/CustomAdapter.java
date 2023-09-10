package com.example.lamkadam_hamza_exam_rat_m1iibdcc_23_v1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {


    Context context;
    ArrayList<ItemModel> arrayList;

    public CustomAdapter(Context context, ArrayList<ItemModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {


        holder.id.seText(arrayList.get(position));
        holder.name.seText(arrayList.get(position));
        holder.email.seText(arrayList.get(position));
        holder.job.seText(arrayList.get(position));
        holder.phone.seText(arrayList.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, (CharSequence) arrayList.get(position), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(View itemView) {
            super(itemView);

            TextView name, job, email, phone;
            name = (TextView) itemView.findViewById(R.id.txt_name);
            job = (TextView) itemView.findViewById(R.id.txt_job);
            email = (TextView) itemView.findViewById(R.id.txt_email);
            phone = (TextView) itemView.findViewById(R.id.txt_phone);
            Button callbtn = (Button) itemView.findViewById(R.id.btn_call);
        }
    }
}
