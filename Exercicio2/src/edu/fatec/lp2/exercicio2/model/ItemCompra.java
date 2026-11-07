package edu.fatec.lp2.exercicio2.model;

import edu.fatec.lp2.exercicio2.interfaces.Calculavel;

public class ItemCompra implements Calculavel {

    private int quantidade;
    private Produto produto;
    private double desconto;

    public ItemCompra(Produto produto, double desconto) {

        this.quantidade = 1;

        setProduto(produto);
        setDesconto(desconto);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {

        if (quantidade <= 0) {
            throw new IllegalArgumentException(
                    "A quantidade deve ser maior que zero."
            );
        }

        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {

        if (produto == null) {
            throw new IllegalArgumentException(
                    "O produto não pode ser nulo."
            );
        }

        if (desconto > produto.getDescontoMaximo()) {
            throw new IllegalArgumentException(
                    "O desconto ultrapassa o máximo permitido pelo produto."
            );
        }

        this.produto = produto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {

        if (desconto < 0) {
            throw new IllegalArgumentException(
                    "O desconto não pode ser negativo."
            );
        }

        if (produto != null &&
                desconto > produto.getDescontoMaximo()) {

            throw new IllegalArgumentException(
                    "O desconto ultrapassa o máximo permitido pelo produto."
            );
        }

        this.desconto = desconto;
    }

    @Override
    public double calcularPreco() {

        double precoTotal = quantidade * produto.getPreco();

        return precoTotal - (precoTotal * desconto / 100);
    }

    @Override
    public String toString() {

        return produto.getNome() +
                " | Quantidade: " + quantidade +
                " | Desconto: " + desconto + "%" +
                " | Total: R$ " +
                String.format("%.2f", calcularPreco());
    }
}
