package com.fpt.edu.ss10.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    long insertUser(User user);
    @Update
    int updateUser(User user);
    @Delete
    int deleteUser(User user);
    @Query("select * from user where id=:id")
    User findUser(int id);
    @Query("Select * from user")
    List<User> getAllUser();
}
