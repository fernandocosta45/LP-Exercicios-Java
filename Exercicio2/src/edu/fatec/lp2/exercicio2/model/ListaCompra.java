package edu.fatec.lp2.exercicio2.model;

import edu.fatec.lp2.exercicio2.interfaces.Calculavel;

import java.util.Arrays;

public class ListaCompra implements Calculavel {

    private ItemCompra[] itensCompra;
    private int qtdeMax;

    public ListaCompra(int qtdeMax) {

        if (qtdeMax <= 0) {
            throw new IllegalArgumentException(
                    "A quantidade máxima deve ser maior que zero."
            );
        }

        this.qtdeMax = qtdeMax;
        this.itensCompra = new ItemCompra[qtdeMax];
    }

    public ItemCompra[] getItensCompra() {
        return Arrays.copyOf(itensCompra, itensCompra.length);
    }

    public void setItensCompra(ItemCompra[] itensCompra) {

        if (itensCompra == null || itensCompra.length != qtdeMax) {
            throw new IllegalArgumentException(
                    "O array deve possuir o tamanho definido pela lista."
            );
        }

        this.itensCompra = Arrays.copyOf(
                itensCompra,
                itensCompra.length
        );
    }

    public int getQtdeMax() {
        return qtdeMax;
    }

    public void setQtdeMax(int qtdeMax) {

        if (qtdeMax <= 0) {
            throw new IllegalArgumentException(
                    "A quantidade máxima deve ser maior que zero."
            );
        }

        int quantidadeAtual = 0;

        for (ItemCompra item : itensCompra) {
            if (item != null) {
                quantidadeAtual++;
            }
        }

        if (qtdeMax < quantidadeAtual) {
            throw new IllegalArgumentException(
                    "O novo limite não pode ser menor que a quantidade de itens."
            );
        }

        this.qtdeMax = qtdeMax;

        this.itensCompra = Arrays.copyOf(
                itensCompra,
                qtdeMax
        );
    }

    public void incluir(ItemCompra itemCompra) {

        if (itemCompra == null) {
            throw new IllegalArgumentException(
                    "O item de compra não pode ser nulo."
            );
        }

        for (int i = 0; i < itensCompra.length; i++) {

            if (itensCompra[i] == null) {

                itensCompra[i] = itemCompra;

                return;
            }
        }

        throw new IllegalStateException(
                "A lista de compras atingiu seu limite máximo."
        );
    }

    @Override
    public double calcularPreco() {

        double total = 0;

        for (ItemCompra item : itensCompra) {

            if (item != null) {
                total += item.calcularPreco();
            }
        }

        return total;
    }
}