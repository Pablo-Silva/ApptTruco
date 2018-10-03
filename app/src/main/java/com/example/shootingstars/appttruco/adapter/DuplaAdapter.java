package com.example.shootingstars.appttruco.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.shootingstars.appttruco.R;
import com.example.shootingstars.appttruco.model.Dupla;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by opet on 03/10/2018.
 */

public class DuplaAdapter extends ArrayAdapter<Dupla> {

    private int rId;

    public DuplaAdapter(@NonNull Context context, int resource, @NonNull List<Dupla> objects) {
        super(context, resource, objects);
        rId = resource;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent) {
        View mView = currentView;

        if (mView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rId, null);
        }

        Dupla dupla = getItem(position);

        TextView textDupla = mView.findViewById(R.id.textNomeDupla);
        TextView textViorias = mView.findViewById(R.id.textVitorias);
        TextView textDerrotas = mView.findViewById(R.id.textDerrotas);
        TextView textPontos = mView.findViewById(R.id.textPontos);

        textDupla.setText(dupla.getNome_dupla().toUpperCase());
        textViorias.setText("Vitorias: " + String.valueOf(dupla.getVitorias()));
        textDerrotas.setText("Dettoras: " + String.valueOf(dupla.getDerrotas()));
        textPontos.setText("Pontos: " + String.valueOf(dupla.getPontos()));

        return mView;

    }
}
