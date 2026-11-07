package edu.fatec.lp2.exercicio1.model;

public class MsgAudio extends Mensagem {

    private int duracao;

    public MsgAudio(Contato destinatario,
                    String horaEnvio,
                    String conteudo,
                    int duracao) {

        super(destinatario, horaEnvio, conteudo);
        this.duracao = duracao;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public Mensagem sendMessage(String conteudo) {

        atualizarConteudo(conteudo);

        return this;
    }

    @Override
    public String toString() {
        return "[MENSAGEM DE ÁUDIO] " +
                super.toString() +
                " | Duração: " + duracao + " segundos";
    }
}
