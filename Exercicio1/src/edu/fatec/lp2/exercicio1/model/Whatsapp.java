package edu.fatec.lp2.exercicio1.model;

import java.util.Arrays;

public class Whatsapp {

    private Contato[] contatos;
    private Mensagem[] mensagens;

    public Whatsapp(Contato[] contatos, Mensagem[] mensagens) {

        this.contatos = Arrays.copyOf(contatos, contatos.length);
        this.mensagens = Arrays.copyOf(mensagens, mensagens.length);
    }

    public void listarContatos() {

        System.out.println("\n========== CONTATOS ==========");

        for (Contato contato : contatos) {
            System.out.println(contato);
        }
    }

    public void listarMensagens() {

        System.out.println("\n========== MENSAGENS ==========");

        for (Mensagem mensagem : mensagens) {
            System.out.println(mensagem);
        }
    }
}