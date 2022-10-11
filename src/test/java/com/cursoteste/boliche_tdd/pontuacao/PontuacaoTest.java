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
        String[] rodadaInicial = new String[]{"8","/"};
        String[] rodadaFinal = new String[]{"X","-","1"};


        Pontuacao pontuacao = new Pontuacao()
            .setPontosDaRodada(0, rodadaInicial)
            .setPontosDaRodada(1, rodadaFinal);

        assertEquals( pontuacao.calculaSomaPontos(), 17 );
    }
    
}