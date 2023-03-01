package com.example.dangtranhuy_t2011e.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "employee")
public class Employee {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "nameEmployee")
    public String nameEmployee;

    @ColumnInfo(name = "des")
    public String des;

    @ColumnInfo(name = "salary")
    public String salary;
}
