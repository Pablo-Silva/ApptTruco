package com.example.shootingstars.appttruco.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.example.shootingstars.appttruco.DAO.DuplaDAO;
import com.example.shootingstars.appttruco.database.DuplaRoomDatabase;
import com.example.shootingstars.appttruco.model.Dupla;

import java.util.List;

/**
 * Created by opet on 03/10/2018.
 */

public class DuplaRepository {

    private DuplaDAO duplaDAO;
    private List<Dupla> duplas;

    public DuplaRepository(Context context){
        DuplaRoomDatabase db = DuplaRoomDatabase.getDatabase(context);
        duplaDAO = db.duplaDAO();
        duplas = duplaDAO.loadDuplas();
    }

    public List<Dupla> getAllDuplas(){
        return duplas;
    }

    public void insert(Dupla dupla){
        new insertAsyncTask(duplaDAO).execute(dupla);
    }

    private static class insertAsyncTask extends AsyncTask<Dupla,Void,Void> {

        private DuplaDAO mAsyncTaskDAO;

        insertAsyncTask(DuplaDAO dao){
            mAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(final Dupla... params){
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }
}
