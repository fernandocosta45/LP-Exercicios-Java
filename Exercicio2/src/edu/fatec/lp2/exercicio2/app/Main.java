package edu.fatec.lp2.exercicio2.app;

import edu.fatec.lp2.exercicio2.model.*;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        // 1. Criando o supermercado

        Supermercado supermercado = new Supermercado(
                "Supermercado do Astolfo"
        );


        // 2. Criando os produtos

        Produto produto1 = new Produto(supermercado);

        produto1.setNome("Arroz");
        produto1.setUnidade("Pacote 5 kg");
        produto1.setDescricao("Arroz branco tipo 1");
        produto1.setPreco(25.00);
        produto1.setDescontoMaximo(10);


        Produto produto2 = new Produto(supermercado);

        produto2.setNome("Feijão");
        produto2.setUnidade("Pacote 1 kg");
        produto2.setDescricao("Feijão carioca");
        produto2.setPreco(8.00);
        produto2.setDescontoMaximo(5);


        Produto produto3 = new Produto(supermercado);

        produto3.setNome("Óleo");
        produto3.setUnidade("Garrafa 900 ml");
        produto3.setDescricao("Óleo de soja");
        produto3.setPreco(7.00);
        produto3.setDescontoMaximo(10);


        // 3. Criando os itens de compra

        ItemCompra item1 = new ItemCompra(produto1, 10);
        item1.setQuantidade(2);

        ItemCompra item2 = new ItemCompra(produto2, 5);
        item2.setQuantidade(3);

        ItemCompra item3 = new ItemCompra(produto3, 0);
        item3.setQuantidade(2);


        // 4. Calculando os preços individuais

        System.out.println("========== PREÇOS INDIVIDUAIS ==========");

        System.out.printf(
                Locale.US,
                "Arroz: R$ %.2f%n",
                item1.calcularPreco()
        );

        System.out.printf(
                Locale.US,
                "Feijão: R$ %.2f%n",
                item2.calcularPreco()
        );

        System.out.printf(
                Locale.US,
                "Óleo: R$ %.2f%n",
                item3.calcularPreco()
        );


        // 5. Criando a lista de compras

        ListaCompra lista = new ListaCompra(3);


        // 6. Incluindo os itens na lista

        lista.incluir(item1);
        lista.incluir(item2);
        lista.incluir(item3);


        // 7. Exibindo a lista de compras

        System.out.println("\n========== LISTA DE COMPRAS ==========");

        System.out.println("Supermercado: " + supermercado.getNome());

        for (ItemCompra item : lista.getItensCompra()) {

            if (item != null) {

                System.out.println(
                        item.getProduto().getNome() +
                                " | Quantidade: " + item.getQuantidade() +
                                " | Desconto: " + item.getDesconto() + "%"
                );

                System.out.printf(
                        Locale.US,
                        "   Total do item: R$ %.2f%n",
                        item.calcularPreco()
                );
            }
        }


        // 8. Calculando o preço total da compra

        System.out.println("\n========== TOTAL DA COMPRA ==========");

        System.out.printf(
                Locale.US,
                "Total: R$ %.2f%n",
                lista.calcularPreco()
        );


        // 9. Testando o limite da lista

        System.out.println("\n========== TESTE DO LIMITE DA LISTA ==========");

        try {

            ItemCompra item4 = new ItemCompra(produto1, 5);

            lista.incluir(item4);

        } catch (IllegalStateException e) {

            System.out.println(e.getMessage());
        }
    }
}
