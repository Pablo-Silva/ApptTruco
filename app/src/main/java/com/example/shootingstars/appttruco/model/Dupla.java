package com.example.shootingstars.appttruco.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
/**
 * Created by opet on 03/10/2018.
 */
@Entity(tableName = "dupla_table")
public class Dupla {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private long id;
    private String nome_dupla;
    private int vitorias;
    private int derrotas;
    private int pontos;

    public Dupla() {

    }

    public Dupla(long id, String nome_dupla, int vitorias, int derrotas, int pontos) {
        this.id = id;
        this.nome_dupla = nome_dupla;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.pontos = pontos;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // dupla

    public String getNome_dupla() {
        return nome_dupla;
    }

    public void setNome_dupla(String nome_dupla) {
        this.nome_dupla = nome_dupla;
    }

    // vitorias

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    // derrotas

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    // pontos

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}

