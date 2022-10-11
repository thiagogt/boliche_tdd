package com.cursoteste.boliche_tdd.pontuacao;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void Deve_RetornarErro_Quando_QuadrosComCaracateresInvalidos()
    {
        String[][] partida = new String[][]{
                {"8","A"},
                {"4","2"},
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
        try {pontuacao.calculaSomaPontos(); assertFalse(true);}
        catch(Exception e){
            assertEquals(e.getClass(),NumberFormatException.class);
            assertEquals(e.getMessage(),"For input string: \"A\"");
        }
        
    }

    @Test
    public void Deve_RetornarErro_Quando_QuadrosComCaracateresNumericosNegativos()
    {
        String[][] partida = new String[][]{
                {"8","-1"},
                {"4","2"},
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
        try {pontuacao.calculaSomaPontos(); assertFalse(true);}
        catch(Exception e){
            assertEquals(e.getClass(),RuntimeException.class);
            assertEquals(e.getMessage(),"Ponto invalido: -1 Rodada: 0");
        }
        
    }

    @Test
    public void Deve_RetornarErro_Quando_QuadrosComCaracateresNumericosMaioresQueLimitePossivel()
    {
        String[][] partida = new String[][]{
                {"8","3"},
                {"4","2"},
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
        try {pontuacao.calculaSomaPontos(); assertFalse(true);}
        catch(Exception e){
            assertEquals(e.getClass(),RuntimeException.class);
            assertEquals(e.getMessage(),"Somatoria de pontos por rodada invalida: 11 Rodada: 0");
        }
        
    }
    
}