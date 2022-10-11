package com.cursoteste.boliche_tdd.pontuacao;

/**
 * Pontuacao
 */
public class Pontuacao {

    private static final int NUM_MAX_RODADAS = 10;

    private String[][] pontos = new String[NUM_MAX_RODADAS][];

    public Pontuacao() {
        for(int i = 0; i < NUM_MAX_RODADAS; i++){
            this.pontos[i] = new String[]{"0","0","0"};
        }
        
    }

    public String[][] getPontos(){
        return this.pontos;
    }

    public String[] getPontosDaRodada(int rodada){
        if(rodadaValida(rodada))
            return this.pontos[rodada];
        throw new RuntimeException("Rodada invalida");
    }

    public Pontuacao setPontosDaRodada(int rodada, String[] pontos){

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
        int soma = 0;
        for (String[] rodada : this.pontos) {
            for (String ponto : rodada) {

                soma += Integer.parseInt(ponto);
                
            }
            
        }

        return soma;
    }
}