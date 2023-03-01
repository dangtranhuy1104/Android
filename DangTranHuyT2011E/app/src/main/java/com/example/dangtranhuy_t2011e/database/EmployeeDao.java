package com.example.dangtranhuy_t2011e.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EmployeeDao {
    @Insert
    long insertEmployee(Employee employee);

    @Update
    int updateEmployee(Employee employee);

    @Delete
    int deleteEmployee(Employee employee);

    @Query("SELECT * FROM employee WHERE id = :id")
    Employee findEmployee (int id);

    @Query("SELECT * FROM employee")
    List<Employee> getAllEmployee();
}
