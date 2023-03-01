package com.example.dangtranhuy_t2011e;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.dangtranhuy_t2011e.database.AppDatabase;
import com.example.dangtranhuy_t2011e.database.EmployeeEntity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getAppDatabase(this);

        insertEmployee();

        updateEployee(2);

        getAllEmployee();

        findEmployee(1);


    }
    private void insertEmployee() {
        EmployeeEntity bm = new EmployeeEntity();
        bm.employee = "this is Employee";
        bm.designation = "this is designation";
        bm.salary = "this is salary";
        db.employeeDao().insertEmployee(bm);
    }
    private void updateEployee(int id) {
        EmployeeEntity bm = db.employeeDao().getEmployee(id);
        bm.employee = "this is employee update";
        db.employeeDao().updateEmployee(bm);
    }
    private  void findEmployee(int id){
        EmployeeEntity model = db.employeeDao().getEmployee(id);
        Log.d("TAG","Find Employee with id:"+model.id + "title: "+model.employee);
    }

    private void deleteBookmark(int id){
        EmployeeEntity model = db.employeeDao().getEmployee(id);
        db.employeeDao().deleteEmployee(model);
    }

    private void deleteAllEmployee(){
        db.employeeDao().deleteAll();
    }

    private void getAllEmployee() {
        List<EmployeeEntity> list = db.employeeDao().getAllEmployee();
        for (EmployeeEntity model : list){
            Log.d("TAG", "id: "+model.id + "employee: "+model.employee);
        }
    }
}



