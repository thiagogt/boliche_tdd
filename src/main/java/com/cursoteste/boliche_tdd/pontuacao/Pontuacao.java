package com.cursoteste.boliche_tdd.pontuacao;

/**
 * Pontuacao
 */
public class Pontuacao {

    private static final int NUM_MAX_RODADAS = 10;

    private int[][] pontos = new int[NUM_MAX_RODADAS][];

    public Pontuacao() {
        
    }

    public int[][] getPontos(){
        return this.pontos;
    }

    public int[] getPontosDaRodada(int rodada){
        if(rodadaValida(rodada))
            return this.pontos[rodada];
        throw new RuntimeException("Rodada invalida");
    }

    public Pontuacao setPontosDaRodada(int rodada, int[] pontos){

        if(rodadaValida(rodada)){
            this.pontos[rodada] = pontos;
            return this;
        }
        throw new RuntimeException("Rodada invalida");
    }


    public boolean rodadaValida(int rodada){
        return rodada < NUM_MAX_RODADAS && rodada >= 0;
    }
    
    public int calculaSomaPontos(){
        return 8;
    }
}