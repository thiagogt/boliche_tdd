package com.cursoteste.boliche_tdd.pontuacao;

import java.util.ArrayDeque;

/**
 * Pontuacao
 */
public class Pontuacao {

    private static final int NUM_MAX_RODADAS = 10;
    private static final int PINOS_MAX_RODADA = 10;

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

    public Pontuacao setPontosPartida(String [][]partida){
        this.pontos = partida;
        return this;
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
        int spare = 0;
        int strike = 0;

        int primeiroPontoFinal = 0;
            int segundoPontoFinal = 0;
            int terceiroPontoFinal = 0;

        for (int i=0; i < NUM_MAX_RODADAS; i++) {
            
            String[] rodada = this.pontos[i];
            int pontosPorRodada = 0;

            
            
            for (int j = 0; j < rodada.length; j++) {
                String pontoDescrito =  rodada[j];
                int ponto = 0;

                if(pontoDescrito.equals("X")){pontoDescrito = "10"; }
                if(pontoDescrito.equals("/")){pontoDescrito = "0"; }
                if(pontoDescrito.equals("-")){pontoDescrito = "0"; }
                    
                ponto = Integer.parseInt(pontoDescrito);
                
                if(ponto < 0  || ponto > PINOS_MAX_RODADA)
                    throw new RuntimeException("Ponto invalido: "+ponto+" Rodada: "+ i);
                soma += ponto;
                
                pontosPorRodada +=ponto;
                if(i == (NUM_MAX_RODADAS-1)){
                    switch (j){
                        case 0:
                            primeiroPontoFinal = ponto;
                            break;
                        case 1:
                            segundoPontoFinal = ponto;
                            if(primeiroPontoFinal != 10)
                                if(pontosPorRodada > PINOS_MAX_RODADA && segundoPontoFinal != 10)
                                 throw new RuntimeException("Somatoria de pontos por rodada invalida: "+pontosPorRodada+" Rodada: "+ i+" na seguda jogada");
                            break;
                        case 2:
                            terceiroPontoFinal = ponto;
                            if(primeiroPontoFinal == 10)
                                if(segundoPontoFinal + terceiroPontoFinal > PINOS_MAX_RODADA )
                                throw new RuntimeException("Somatoria de pontos por rodada invalida: "+segundoPontoFinal + terceiroPontoFinal+" Rodada: "+ i+" entre a segunda e terceira jogada");
                            break;
                    }
                } else{
                    if(pontosPorRodada >  PINOS_MAX_RODADA)
                        throw new RuntimeException("Somatoria de pontos por rodada invalida: "+pontosPorRodada+" Rodada: "+ i);
                
                }

                
            }
            
        }

        return soma;
    }
}