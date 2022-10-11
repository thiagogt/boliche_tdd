package com.cursoteste.boliche_tdd;

import com.cursoteste.boliche_tdd.pontuacao.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        casoExemplo_1();
        casoExemplo_2();
    }

    public static void casoExemplo_1(){
        printInicioMensagem();
        System.out.println("Dada a entrada: ");
        String[][] partida = new String[][]{
            {"8","-"}, 
            {"7","-"},
            {"5","3"},
            {"9","/"},
            {"9","/"},
            {"X"},
            {"8","-"}, 
            {"5","1"}, 
            {"3","/"}, 
            {"9","-"}};


         Pontuacao pontuacao = new Pontuacao();
         pontuacao.setPontosPartida(partida);

         System.out.println();

         System.out.println("Pontos totais: "+pontuacao.calculaSomaPontos());

         printFinalMensagem();
    }

    public static void casoExemplo_2(){
        printInicioMensagem();
        System.out.println("Dada a entrada: ");
        String[][] partida = new String[][]{
            {"8","/"}, 
            {"9","-"},
            {"4","4"},
            {"7","2"},
            {"9","-"},
            {"X"},
            {"X"}, 
            {"8","-"}, 
            {"3","5"}, 
            {"9","/","7"}};


         Pontuacao pontuacao = new Pontuacao();
         pontuacao.setPontosPartida(partida);

         System.out.println();

         System.out.println("Pontos totais: "+pontuacao.calculaSomaPontos());

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
