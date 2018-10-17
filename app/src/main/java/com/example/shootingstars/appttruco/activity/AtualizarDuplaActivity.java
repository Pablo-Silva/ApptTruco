package com.example.shootingstars.appttruco.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shootingstars.appttruco.R;
import com.example.shootingstars.appttruco.model.Dupla;
import com.example.shootingstars.appttruco.repository.DuplaRepository;

public class AtualizarDuplaActivity extends Activity {

    private EditText editDupla, editPontos, editVitorias, editDerrotas;
    private DuplaRepository repository;
    private Dupla dupla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_dupla);

        long extra_id = getIntent().getLongExtra("ID",0);
        Toast.makeText(this, "ID = " + extra_id, Toast.LENGTH_SHORT).show();

        editDupla = findViewById(R.id.editDupla);
        editPontos = findViewById(R.id.editPontos);
        editVitorias = findViewById(R.id.editVitorias);
        editDerrotas = findViewById(R.id.editDerrotas);
        repository = new DuplaRepository(getApplicationContext());
    }

    private void loadDupla(long extra_id) {
        dupla = repository.loadDuplaByID(extra_id);
        editDupla.setText(String.valueOf(dupla.getNome_dupla()));
        editPontos.setText(String.valueOf(dupla.getPontos()));
        editVitorias.setText(String.valueOf(dupla.getVitorias()));
        editDerrotas.setText(String.valueOf(dupla.getDerrotas()));

    }

    public void atualizarDupla(View view){
        dupla.setNome_dupla(editDupla.getText().toString());
        dupla.setPontos(Integer.parseInt(editPontos.getText().toString()));
        dupla.setVitorias(Integer.parseInt(editVitorias.getText().toString()));
        dupla.setDerrotas(Integer.parseInt(editDerrotas.getText().toString()));
        repository.update(dupla);
        callMainActivity();
    }

    private void callMainActivity() {
        Intent mainActivity = new Intent(AtualizarDuplaActivity.this,MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}
