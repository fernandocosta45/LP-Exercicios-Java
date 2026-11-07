package edu.fatec.lp2.exercicio1.model;

public class MsgTexto extends Mensagem {

    private int numChar;

    public MsgTexto(Contato destinatario,
                    String horaEnvio,
                    String conteudo) {

        super(destinatario, horaEnvio, conteudo);
        this.numChar = conteudo.length();
    }

    public int getNumChar() {
        return numChar;
    }

    @Override
    public Mensagem sendMessage(String conteudo) {

        atualizarConteudo(conteudo);
        this.numChar = conteudo.length();

        return this;
    }

    @Override
    public String toString() {
        return "[MENSAGEM DE TEXTO] " +
               super.toString() +
               " | Caracteres: " + numChar;
    }
}