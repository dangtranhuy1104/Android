package com.example.dangtranhuy.adepter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dangtranhuy_t2011e.R;
import com.example.dangtranhuy_t2011e.database.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter {
    Activity activity;
    List<Employee> listEmployee;

    public EmployeeAdapter(Activity activity, List<Employee> listEmployee){
        this.activity= activity;
        this.listEmployee = listEmployee;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_eployee,parent, false);
        EmployeeHoler holer = new EmployeeHoler(itemView);
        return holer;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EmployeeHoler vh = (EmployeeHoler) holder;
        Employee model = listEmployee.get(position);
        vh.tvID.setText(model.id + "");
        vh.tvName.setText(model.nameEmployee);
        vh.tvDes.setText(model.des);
        vh.tvSalary.setText(model.salary);
    }

    @Override
    public int getItemCount() {
        return listEmployee.size();
    }

    public class EmployeeHoler extends RecyclerView.ViewHolder {
        TextView tvID, tvName, tvDes, tvSalary;
        public EmployeeHoler(@NonNull View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tvID);
            tvName = itemView.findViewById(R.id.tvName);
            tvDes = itemView.findViewById(R.id.tvDes);
            tvSalary = itemView.findViewById(R.id.tvSalary);
        }
    }
}
