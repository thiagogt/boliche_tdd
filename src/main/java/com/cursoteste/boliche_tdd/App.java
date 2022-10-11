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

        if (args.length < 1) 
            defaultCase();

        else{
            printInicioMensagem();
            System.out.println("Logo mais vira uma funcionalidade que pega os valores de um csv...aguarde =)");
            printFinalMensagem();

        }

       
    }

    public static void defaultCase(){
        String[][] partida_1 = new String[][]{
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
        String[][] partida_2 = new String[][]{
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

        casoExemplo(partida_1);
        casoExemplo(partida_2);
        }
    

    public static void casoExemplo(String[][] partida){
        printInicioMensagem();
        System.out.println("Dada a entrada: ");
        

         Pontuacao pontuacao = new Pontuacao();
         pontuacao.setPontosPartida(partida);

         pontuacao.print();

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
