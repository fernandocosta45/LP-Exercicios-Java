package edu.fatec.lp2.exercicio2.model;

public class Supermercado {

    private String nome;

    public Supermercado() {
    }

    public Supermercado(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}