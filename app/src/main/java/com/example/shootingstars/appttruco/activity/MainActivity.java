package com.example.shootingstars.appttruco.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.shootingstars.appttruco.R;
import com.example.shootingstars.appttruco.adapter.DuplaAdapter;
import com.example.shootingstars.appttruco.model.Dupla;
import com.example.shootingstars.appttruco.repository.DuplaRepository;

public class MainActivity extends Activity {

    private ListView listaDuplas;
    private DuplaRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDuplas = findViewById(R.id.listaDuplas);
        repository = new DuplaRepository(getApplicationContext());
        ArrayAdapter<Dupla> adapter = new DuplaAdapter(this,R.layout.dupla_item,repository.getAllDuplas());
        listaDuplas.setAdapter(adapter);
    }

    public void novaDupla(View view){
        Intent novaDupla = new Intent(MainActivity.this,NovaDuplaActivity.class);
        startActivity(novaDupla);
    }


}
