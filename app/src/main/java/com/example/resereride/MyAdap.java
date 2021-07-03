package com.example.resereride;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.zip.Inflater;

public class MyAdap extends RecyclerView.Adapter<MyAdap.ViewHolder> {
    String [] mylist;
    public MyAdap(String [] list)
    {
        mylist=list;
    }
    @NonNull
    @Override
    public MyAdap.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdap.ViewHolder viewHolder,final int i) {
        viewHolder.textView.setText(mylist[i]);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(v.getContext(),BookingActivity.class);
                it.putExtra("serviceName",mylist[i]);
                ((Activity) v.getContext()).setResult(((Activity) v.getContext()).RESULT_OK,it);
               // Toast.makeText(v.getContext(),mylist[i]+ ((Activity) v.getContext()).getLocalClassName(),Toast.LENGTH_SHORT).show();
                ((Activity) v.getContext()).finish();
            }
        });

    }
    @Override
    public int getItemCount() {
        return mylist.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.txtview1);
            relativeLayout=(RelativeLayout) itemView.findViewById(R.id.relativelayout);
        }
    }
}
