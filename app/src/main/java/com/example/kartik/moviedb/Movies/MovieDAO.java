//package com.example.kartik.moviedb.Movies;
//
//import android.arch.persistence.room.Dao;
//import android.arch.persistence.room.Delete;
//import android.arch.persistence.room.Insert;
//import android.arch.persistence.room.OnConflictStrategy;
//import android.arch.persistence.room.Query;
//import android.arch.persistence.room.Update;
//
//import java.util.List;
//
//@Dao
//public interface MovieDAO {
//
//    @Insert
//    void addExpenses(Movie movie);
//
//    @Delete
//    void deleteExpense(Movie movie);
//
//    @Update(onConflict = OnConflictStrategy.REPLACE)
//    void updateExpense(Movie movie);
//
//
//    @Query("select * from movies")
//    List<Movie> getMovies();
//
//
//}
