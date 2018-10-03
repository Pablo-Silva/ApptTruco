package com.example.shootingstars.appttruco.database;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.shootingstars.appttruco.DAO.DuplaDAO;
import com.example.shootingstars.appttruco.model.Dupla;

/**
 * Created by opet on 03/10/2018.
 */


@Database(entities = {Dupla.class},version = 1)
public abstract class DuplaRoomDatabase extends RoomDatabase {

    private static volatile DuplaRoomDatabase INSTANCE;
    public abstract DuplaDAO duplaDAO();

    public static DuplaRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (DuplaRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),DuplaRoomDatabase.class,
                            "dupla_database").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}
