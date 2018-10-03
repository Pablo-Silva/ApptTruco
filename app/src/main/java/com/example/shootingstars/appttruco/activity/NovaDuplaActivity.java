package com.example.shootingstars.appttruco.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

import com.example.shootingstars.appttruco.R;
import com.example.shootingstars.appttruco.model.Dupla;
import com.example.shootingstars.appttruco.repository.DuplaRepository;

/**
 * Created by opet on 03/10/2018.
 */

public class NovaDuplaActivity extends Activity {

    private EditText editDupla, editPontos, editVitorias, editDerrotas;
    private DuplaRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_dupla);

        editDupla = findViewById(R.id.editDupla);
        editPontos = findViewById(R.id.editPontos);
        editVitorias = findViewById(R.id.editVitorias);
        editDerrotas = findViewById(R.id.editDerrotas);
        repository = new DuplaRepository(getApplicationContext());
    }

    public void salvarDupla(View view){
        Dupla dupla = new Dupla();
        dupla.setNome_dupla(editDupla.getText().toString());
        dupla.setVitorias(Integer.parseInt(editVitorias.getText().toString()));
        dupla.setDerrotas(Integer.parseInt(editDerrotas.getText().toString()));
        dupla.setPontos(Integer.parseInt(editPontos.getText().toString()));

        repository.insert(dupla);
        callMainActivity();
    }

    private void callMainActivity() {
        Intent mainActivity = new Intent(NovaDuplaActivity.this,MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}
