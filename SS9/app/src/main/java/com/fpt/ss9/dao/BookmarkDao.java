package com.fpt.ss9.dao;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.fpt.ss9.entities.BookmarkEntity;

import java.util.List;

@Dao
public interface BookmarkDao {
    @Insert(onConflict = REPLACE)
    void insertBookmark(BookmarkEntity bookmark);

    @Update
    void updateBookmark(BookmarkEntity bookmark);

    @Delete
    void deleteBookmark(BookmarkEntity bookmark);

    @Query("SELECT * FROM Bookmark")
    List<BookmarkEntity> getAllBookmark();

    @Query("SELECT * FROM Bookmark WHERE id = :id")
    BookmarkEntity getBookmark(int id);

    @Query("DELETE FROM Bookmark")
    void deleteAll();
}
