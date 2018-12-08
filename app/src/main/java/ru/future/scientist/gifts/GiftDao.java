package ru.future.scientist.gifts;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface GiftDao {
    @Query("SELECT * FROM gifts")
    List<Gift> getAll();

    @Query("SELECT * FROM gifts WHERE id = :id")
    Gift getById(long id);

    @Insert
    long insertGift(Gift gift);
}