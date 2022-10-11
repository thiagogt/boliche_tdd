package com.cursoteste.boliche_tdd.pontuacao;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


/**
 * PontuacaoTest
 */
public class PontuacaoTest {

    @Test
    public void Deve_RetornarAPontuacaoTotal_Quando_QuadrosApenasComPontosNumericos()
    {
        String[][] partida = new String[][]{
                {"8","1"},
                {"4","3"},
                {"3","3"},
                {"2","3"},
                {"4","3"},
                {"7","3"},
                {"4","3"},
                {"4","3"},
                {"3","3"},
                {"3","3"},
                {"1","3"}};
        


        Pontuacao pontuacao = new Pontuacao()
            .setPontosPartida(partida);
        assertEquals( pontuacao.calculaSomaPontos(), 70 );
    }
    
}