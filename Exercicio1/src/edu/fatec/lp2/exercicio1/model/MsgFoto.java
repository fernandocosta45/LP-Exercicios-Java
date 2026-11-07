package edu.fatec.lp2.exercicio1.model;

public class MsgFoto extends Mensagem {

    private int tamanho;

    public MsgFoto(Contato destinatario,
                   String horaEnvio,
                   String conteudo,
                   int tamanho) {

        super(destinatario, horaEnvio, conteudo);
        this.tamanho = tamanho;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public Mensagem sendMessage(String conteudo) {

        atualizarConteudo(conteudo);

        return this;
    }

    @Override
    public String toString() {
        return "[MENSAGEM DE FOTO] " +
                super.toString() +
                " | Tamanho: " + tamanho + " KB";
    }
}
