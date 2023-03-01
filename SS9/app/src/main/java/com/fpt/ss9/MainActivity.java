package com.fpt.ss9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.fpt.ss9.config.AppDatabase;
import com.fpt.ss9.entities.BookmarkEntity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getAppDatabase(this);

//        insertBook();
        updateBookmark(1);

//        findBookmark(1);

//        deleteBookmark(4);

//        getAllBookmark();

//        deleteAllBookmark();
    }

    private void insertBook(){
        BookmarkEntity bm = new BookmarkEntity();
        bm.title = "This is title v2";
        bm.content = "this is content v2";
        db.bookmarkDao().insertBookmark(bm);
        Log.d("TAG", "New Bookmark: "+" title: " + bm.title +  " " + "content: " + bm.content);
    }

    private void updateBookmark(int id){
        BookmarkEntity bm = db.bookmarkDao().getBookmark(id);
        bm.title = "This is title ";
        db.bookmarkDao().updateBookmark(bm);
    }

    private void findBookmark(int id){
        BookmarkEntity model = db.bookmarkDao().getBookmark(id);
        Log.d("TAG", "Find Bookmark with id: " + model.id + " "+ "title: " + model.title);
    }

    private void deleteBookmark(int id){
        BookmarkEntity model = db.bookmarkDao().getBookmark(id);
        db.bookmarkDao().deleteBookmark(model);
    }

    private void deleteAllBookmark(){
        db.bookmarkDao().deleteAll();
    }

    private void getAllBookmark() {
        List<BookmarkEntity> list = db.bookmarkDao().getAllBookmark();
        for (BookmarkEntity model : list){
            Log.d("TAG", "id: " + model.id + "title: " + model.title);
        }
    }
}