package com.cursoteste.boliche_tdd.pontuacao;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


/**
 * PontuacaoTest
 */
public class PontuacaoTest {

    @Test
    public void Deve_RetornarAPontuacaoTotal_Quando_QuadrosValidosForemDados()
    {

        Pontuacao pontuacao = new Pontuacao();
        int[] rodadaInicial = {8,0};
        int[] rodadaFinal = {9,2};
        pontuacao.setPontosDaRodada(0, rodadaInicial);
        pontuacao.setPontosDaRodada(1, rodadaFinal);
        assertEquals( pontuacao.calculaSomaPontos(), 19 );
    }
    
}