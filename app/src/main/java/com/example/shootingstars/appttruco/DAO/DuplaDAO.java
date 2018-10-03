package com.example.shootingstars.appttruco.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.shootingstars.appttruco.model.Dupla;

import java.util.List;

/**
 * Created by opet on 03/10/2018.
 */

@Dao
public interface DuplaDAO {

    @Insert
    void insert(Dupla dupla);

    @Query("DELETE FROM dupla_table where dupla_table.ID == :id")
    void delete(long id);

    @Query("SELECT * from dupla_table ORDER BY nome_dupla DESC")
    List<Dupla> loadDuplas();
}
