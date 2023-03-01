package com.example.dangtranhuy_t2011e.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EmployeeDao {
    void insertEmployee(Employee employee);

    @Update
    void updateEmployee(EmployeeEntity employee);

    @Delete
    void deleteEmployee(EmployeeEntity employee);

    @Query("SELECT * FROM Employee WHERE id = :id")
    EmployeeEntity getEmployee(int id);

    @Query("DELETE FROM Employee")
    void deleteAll();

    List<EmployeeEntity> getAllEmployee();
}
