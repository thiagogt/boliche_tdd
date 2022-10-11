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
        pontuacao.setPontosDaRodada(0, rodadaInicial);
        assertEquals( pontuacao.calculaSomaPontos(), 8 );
    }
    
}