package edu.fatec.lp2.exercicio1.app;

import edu.fatec.lp2.exercicio1.model.*;

public class Main {

    public static void main(String[] args) {

        // 1. Criando os contatos

        Contato contato1 = new Contato(
                "João Silva",
                "12999990001"
        );

        Contato contato2 = new Contato(
                "Maria Oliveira",
                "12999990002"
        );

        Contato contato3 = new Contato(
                "Carlos Souza",
                "12999990003"
        );


        // 2. Criando as mensagens

        MsgTexto mensagemTexto = new MsgTexto(
                contato1,
                "09:00",
                "Olá, tudo bem?"
        );

        MsgAudio mensagemAudio = new MsgAudio(
                contato2,
                "09:15",
                "audio_reuniao.mp3",
                45
        );

        MsgFoto mensagemFoto = new MsgFoto(
                contato3,
                "09:30",
                "foto_viagem.jpg",
                2048
        );


        // 3. Enviando as mensagens

        mensagemTexto.sendMessage(
                "Olá João! Como você está?"
        );

        mensagemAudio.sendMessage(
                "audio_reuniao.mp3"
        );

        mensagemFoto.sendMessage(
                "foto_viagem.jpg"
        );


        // 4. Verificando o retorno da própria instância

        System.out.println("========== TESTE SENDMESSAGE ==========");

        System.out.println(
                "Texto retorna a própria instância: " +
                        (mensagemTexto.sendMessage(
                                "Olá João! Como você está?"
                        ) == mensagemTexto)
        );

        System.out.println(
                "Áudio retorna a própria instância: " +
                        (mensagemAudio.sendMessage(
                                "audio_reuniao.mp3"
                        ) == mensagemAudio)
        );

        System.out.println(
                "Foto retorna a própria instância: " +
                        (mensagemFoto.sendMessage(
                                "foto_viagem.jpg"
                        ) == mensagemFoto)
        );


        // 5. Criando os arrays

        Contato[] contatos = {
                contato1,
                contato2,
                contato3
        };

        Mensagem[] mensagens = {
                mensagemTexto,
                mensagemAudio,
                mensagemFoto
        };


        // 6. Inicializando o Whatsapp pelo construtor

        Whatsapp whatsapp = new Whatsapp(
                contatos,
                mensagens
        );


        // 7. Listando os contatos e as mensagens

        whatsapp.listarContatos();

        whatsapp.listarMensagens();
    }
}
