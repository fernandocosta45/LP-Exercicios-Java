package edu.fatec.lp2.exercicio1.model;

public abstract class Mensagem {

    private Contato destinatario;
    private String horaEnvio;
    private String conteudo;

    public Mensagem(Contato destinatario,
                    String horaEnvio,
                    String conteudo) {

        this.destinatario = destinatario;
        this.horaEnvio = horaEnvio;
        this.conteudo = conteudo;
    }

    public Contato getDestinatario() {
        return destinatario;
    }

    public String getHoraEnvio() {
        return horaEnvio;
    }

    public String getConteudo() {
        return conteudo;
    }

    protected void atualizarConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public abstract Mensagem sendMessage(String conteudo);

    @Override
    public String toString() {
        return "Destinatário: " + destinatario.getNome() +
                " | Horário: " + horaEnvio +
                " | Conteúdo: " + conteudo;
    }
}