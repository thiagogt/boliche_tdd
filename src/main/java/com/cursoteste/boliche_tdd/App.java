package com.cursoteste.boliche_tdd;

import com.cursoteste.boliche_tdd.pontuacao.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        if (args.length < 1)
            defaultCase();

        else {
            if (args[0].equals("-e"))
                errorCases();
            else {
                printInicioMensagem();
                System.out.println("Logo mais vira uma funcionalidade que pega os valores de um csv...aguarde =)");
                printFinalMensagem();
            }

        }

    }

    public static void defaultCase() {
        String[][] partida_1 = new String[][] { { "8", "-" }, { "7", "-" }, { "5", "3" }, { "9", "/" }, { "9", "/" },
                { "X" }, { "8", "-" }, { "5", "1" }, { "3", "/" }, { "9", "-" } };
        String[][] partida_2 = new String[][] { { "8", "/" }, { "9", "-" }, { "4", "4" }, { "7", "2" }, { "9", "-" },
                { "X" }, { "X" }, { "8", "-" }, { "3", "5" }, { "9", "/", "7" } };

        casoExemplo(partida_1);
        casoExemplo(partida_2);
    }

    public static void errorCases() {
        String[][] partida_1 = new String[][] { { "8", "A" }, { "4", "2" }, { "3", "3" }, { "2", "3" }, { "4", "3" },
                { "7", "3" }, { "4", "3" }, { "4", "3" }, { "3", "3" }, { "3", "3" } };
        String[][] partida_2 = new String[][] { { "8", "-1" }, { "4", "2" }, { "3", "3" }, { "2", "3" }, { "4", "3" },
                { "7", "3" }, { "4", "3" }, { "4", "3" }, { "3", "3" }, { "3", "3" } };
        String[][] partida_3 = new String[][] { { "8", "3" }, { "4", "2" }, { "3", "3" }, { "2", "3" }, { "4", "3" },
                { "7", "3" }, { "4", "3" }, { "4", "3" }, { "3", "3" }, { "3", "3" } };
        String[][] partida_4 = new String[][] { { "8", "1" }, { "4", "2" }, { "3", "3" }, { "2", "3" }, { "4", "3" },
                { "7", "3" }, { "4", "3" }, { "4", "3" }, { "3", "3" }, { "3", "X", "11" } };
        String[][] partida_5 = new String[][] { { "8", "1" }, { "4", "2" }, { "3", "3" }, { "2", "3" }, { "4", "3" },
                { "7", "3" }, { "4", "3" }, { "4", "3" }, { "3", "3" }, { "11", "X", "2" } };
        String[][] partida_6 = new String[][] { { "8", "1" }, { "4", "2" }, { "3", "3" }, { "2", "3" }, { "4", "3" },
                { "7", "3" }, { "4", "3" }, { "4", "3" }, { "3", "3" }, { "X", "11", "2" } };
        String[][] partida_7 = new String[][] { { "8", "1" }, { "4", "2" }, { "3", "3" }, { "2", "3" }, { "4", "3" },
                { "7", "3" }, { "4", "3" }, { "4", "3" }, { "3", "3" }, { "7", "7", "1" } };
        String[][] partida_8 = new String[][] { { "8", "1" }, { "4", "2" }, { "3", "3" }, { "2", "3" }, { "4", "3" },
                { "7", "3" }, { "4", "3" }, { "4", "3" }, { "3", "3" }, { "X", "7", "7" } };
        String[][] partida_9 = new String[][] { { "8", "1" }, { "4", "2", "3" }, { "3", "3" }, { "2", "3" },
                { "4", "3" }, { "7", "3" }, { "4", "3" }, { "4", "3" }, { "3", "3" }, { "X", "1", "7" } };
        String[][] partida_10 = new String[][] { { "8", "1" }, { "4", "2" }, { "3", "3" }, { "2", "3" }, { "4", "3" },
                { "7", "3" }, { "4", "3" }, { "4", "3" }, { "3", "3" }, { "1", "1", "7" } };
        String[][] partida_11 = new String[][] { { "8", "1" }, { "4", "2" }, { "3", "3" }, { "2", "3" }, { "4", "3" },
                { "7", "3" }, { "4", "3" }, { "4", "3" }, { "3", "3" }, { "X", "1", "7", "3" } };
        String[][] partida_12 = new String[][] { { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" },
                { "0", "1" }, { "0", "1" }, { "0", "1" }, { "/", "/" }, { "3", "3" } };
        String[][] partida_13 = new String[][] { { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" },
                { "0", "1" }, { "0", "1" }, { "0", "/" }, { "0", "/" }, { "3", "/", "/" } };

        System.out.println();
        System.out.println("Quadros Com Caracateres Invalidos");
        casoExemplo(partida_1);

        System.out.println();
        System.out.println("Quadros Com Caracateres Numericos Negativos");
        casoExemplo(partida_2);

        System.out.println();
        System.out.println("Quadros Com Caracateres Numericos Maiores Que Limite Possivel");
        casoExemplo(partida_3);

        System.out.println();
        System.out.println("Quadros Com Caracateres Numericos Maiores Que Limite Possivel Na Ultima Rodada");
        casoExemplo(partida_4);
        casoExemplo(partida_5);
        casoExemplo(partida_6);

        System.out.println();
        System.out.println(
                "Quadros Com Caracateres Somatoria Maior Que Limite Possivel Na Ultima Rodada, Segunda Jogada");
        casoExemplo(partida_7);

        System.out.println();
        System.out.println(
                "Quadros Com Caracateres Somatoria Maior Que Limite Possivel Na Ultima Rodada, Terceira Jogada");
        casoExemplo(partida_8);

        System.out.println();
        System.out.println("Rodadas Antes Da Ultima Tiverem Mais Que Dois Quadros");
        casoExemplo(partida_9);

        System.out.println();
        System.out.println("Ultima Rodada Tiver Mais Quadros Que o Permitido");
        casoExemplo(partida_10);
        casoExemplo(partida_11);

        System.out.println();
        System.out.println("Quadros Com Spare Na Primeira Jogada");
        casoExemplo(partida_12);

        System.out.println();
        System.out.println("Quadros Com Spare Repetidos");
        casoExemplo(partida_13);

    }

    public static void casoExemplo(String[][] partida) {
        printInicioMensagem();
        System.out.println("Dada a entrada: ");

        Pontuacao pontuacao = new Pontuacao();
        pontuacao.setPontosPartida(partida);

        pontuacao.print();

        System.out.println();

        try {
            System.out.println("Pontos totais: " + pontuacao.calculaSomaPontos());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        printFinalMensagem();
    }

    public static void printInicioMensagem() {
        System.out.println();
        System.out.println();
        System.out.println("=================================================================");
    }

    public static void printFinalMensagem() {
        System.out.println();
        System.out.println("=================================================================");
        System.out.println();

    }

}
