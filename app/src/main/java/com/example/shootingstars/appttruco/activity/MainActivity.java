package com.example.shootingstars.appttruco.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.shootingstars.appttruco.R;
import com.example.shootingstars.appttruco.adapter.DuplaAdapter;
import com.example.shootingstars.appttruco.model.Dupla;
import com.example.shootingstars.appttruco.repository.DuplaRepository;

import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    private ListView listaDuplas;
    private DuplaRepository repository;
    ArrayAdapter<Dupla> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDuplas = findViewById(R.id.listaDuplas);
        repository = new DuplaRepository(getApplicationContext());
        ArrayAdapter<Dupla> adapter = new DuplaAdapter(this,R.layout.dupla_item,repository.getAllDuplas());
        listaDuplas.setAdapter(adapter);
        listaDuplas.setOnItemClickListener(this);
    }

    public void novaDupla(View view){
        Intent novaDupla = new Intent(MainActivity.this,NovaDuplaActivity.class);
        startActivity(novaDupla);
    }

    private void atualizarDuplas(){
        List<Dupla> duplas = repository.getAllDuplas();
        adapter = new DuplaAdapter(getApplicationContext(), R.layout.dupla_item, duplas);
        listaDuplas.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        final Dupla dupla = (Dupla) adapterView.getItemAtPosition(i);
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("O que fazer com " + dupla.getNome_dupla()).setItems(R.array.opcoes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if(which == 0) {
                    repository.delete(dupla.getId());
                    atualizarDuplas();
                }
                else if(which == 1){
                    callActivity(dupla.getId());
                }

            }
        }).create().show();
    }

    private void callActivity(Long id) {
        Intent atualizar = new Intent(MainActivity.this,AtualizarDuplaActivity.class);
        atualizar.putExtra("ID",id);
        startActivity(atualizar);
    }


}
