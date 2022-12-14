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
    public void Deve_RetornarAPontuacaoTotal_Quando_QuadrosApenasComPontosNumericos() {
        String[][] partida = new String[][] { { "8", "1" }, { "4", "3" }, { "3", "3" }, { "2", "3" }, { "4", "3" },
                { "7", "3" }, { "4", "3" }, { "4", "3" }, { "3", "3" }, { "3", "3" } };

        Pontuacao pontuacao = new Pontuacao().setPontosPartida(partida);
        assertEquals(pontuacao.calculaSomaPontos(), 70);
    }

    @Test
    public void Deve_RetornarErro_Quando_QuadrosComCaracateresInvalidos() {
        String[][] partida = new String[][] { { "8", "A" }, { "4", "2" }, { "3", "3" }, { "2", "3" }, { "4", "3" },
                { "7", "3" }, { "4", "3" }, { "4", "3" }, { "3", "3" }, { "3", "3" } };

        Pontuacao pontuacao = new Pontuacao().setPontosPartida(partida);
        try {
            pontuacao.calculaSomaPontos();
            assertFalse(true);
        } catch (Exception e) {
            assertEquals(e.getClass(), NumberFormatException.class);
            assertEquals(e.getMessage(), "For input string: \"A\"");
        }

    }

    @Test
    public void Deve_RetornarErro_Quando_QuadrosComCaracateresNumericosNegativos() {
        String[][] partida = new String[][] { { "8", "-1" }, { "4", "2" }, { "3", "3" }, { "2", "3" }, { "4", "3" },
                { "7", "3" }, { "4", "3" }, { "4", "3" }, { "3", "3" }, { "3", "3" } };

        Pontuacao pontuacao = new Pontuacao().setPontosPartida(partida);
        try {
            pontuacao.calculaSomaPontos();
            assertFalse(true);
        } catch (Exception e) {
            assertEquals(e.getClass(), RuntimeException.class);
            assertEquals(e.getMessage(), "Ponto invalido: -1 Rodada: 0");
        }

    }

    @Test
    public void Deve_RetornarErro_Quando_QuadrosComCaracateresNumericosMaioresQueLimitePossivel() {
        String[][] partida = new String[][] { { "8", "3" }, { "4", "2" }, { "3", "3" }, { "2", "3" }, { "4", "3" },
                { "7", "3" }, { "4", "3" }, { "4", "3" }, { "3", "3" }, { "3", "3" } };

        Pontuacao pontuacao = new Pontuacao().setPontosPartida(partida);
        try {
            pontuacao.calculaSomaPontos();
            assertFalse(true);
        } catch (Exception e) {
            assertEquals(e.getClass(), RuntimeException.class);
            assertEquals(e.getMessage(), "Somatoria de pontos por rodada invalida: 11 Rodada: 0");
        }

    }

    @Test
    public void Deve_RetornarErro_Quando_QuadrosComCaracateresNumericosMaioresQueLimitePossivelNaUltimaRodada() {
        String[][] partida = new String[][] { { "8", "1" }, { "4", "2" }, { "3", "3" }, { "2", "3" }, { "4", "3" },
                { "7", "3" }, { "4", "3" }, { "4", "3" }, { "3", "3" }, { "3", "X", "11" } };

        Pontuacao pontuacao = new Pontuacao().setPontosPartida(partida);
        try {
            pontuacao.calculaSomaPontos();
            assertFalse(true);
        } catch (Exception e) {
            assertEquals(e.getClass(), RuntimeException.class);
            assertEquals(e.getMessage(), "Ponto invalido: 11 Rodada: 9");
        }
        partida = new String[][] { { "8", "1" }, { "4", "2" }, { "3", "3" }, { "2", "3" }, { "4", "3" }, { "7", "3" },
                { "4", "3" }, { "4", "3" }, { "3", "3" }, { "11", "X", "2" } };

        pontuacao = new Pontuacao().setPontosPartida(partida);
        try {
            pontuacao.calculaSomaPontos();
            assertFalse(true);
        } catch (Exception e) {
            assertEquals(e.getClass(), RuntimeException.class);
            assertEquals(e.getMessage(), "Ponto invalido: 11 Rodada: 9");
        }
        partida = new String[][] { { "8", "1" }, { "4", "2" }, { "3", "3" }, { "2", "3" }, { "4", "3" }, { "7", "3" },
                { "4", "3" }, { "4", "3" }, { "3", "3" }, { "X", "11", "2" } };

        pontuacao = new Pontuacao().setPontosPartida(partida);
        try {
            pontuacao.calculaSomaPontos();
            assertFalse(true);
        } catch (Exception e) {
            assertEquals(e.getClass(), RuntimeException.class);
            assertEquals(e.getMessage(), "Ponto invalido: 11 Rodada: 9");
        }

    }

    @Test
    public void Deve_RetornarErro_Quando_QuadrosComCaracateresSomatoriaMaiorsQueLimitePossivelNaUltimaRodadaSegundaJogada() {
        String[][] partida = new String[][] { { "8", "1" }, { "4", "2" }, { "3", "3" }, { "2", "3" }, { "4", "3" },
                { "7", "3" }, { "4", "3" }, { "4", "3" }, { "3", "3" }, { "7", "7", "1" } };

        Pontuacao pontuacao = new Pontuacao().setPontosPartida(partida);
        try {
            pontuacao.calculaSomaPontos();
            assertFalse(true);
        } catch (Exception e) {
            assertEquals(e.getClass(), RuntimeException.class);
            assertEquals(e.getMessage(), "Somatoria de pontos por rodada invalida: 14 Rodada: 9 na seguda jogada");
        }
    }

    @Test
    public void Deve_RetornarErro_Quando_QuadrosComCaracateresSomatoriaMaiorsQueLimitePossivelNaUltimaRodadaterceiraJogada() {
        String[][] partida = new String[][] { { "8", "1" }, { "4", "2" }, { "3", "3" }, { "2", "3" }, { "4", "3" },
                { "7", "3" }, { "4", "3" }, { "4", "3" }, { "3", "3" }, { "X", "7", "7" } };

        Pontuacao pontuacao = new Pontuacao().setPontosPartida(partida);
        try {
            pontuacao.calculaSomaPontos();
            assertFalse(true);
        } catch (Exception e) {
            assertEquals(e.getClass(), RuntimeException.class);
            assertEquals(e.getMessage(),
                    "Somatoria de pontos por rodada invalida: 14 Rodada: 9 entre a segunda e terceira jogada");
        }
    }

    @Test
    public void Deve_RetornarErro_Quando_RodadasAntesDaUltimaTiveremMaisQueDoisQuadros() {
        String[][] partida = new String[][] { { "8", "1" }, { "4", "2", "3" }, { "3", "3" }, { "2", "3" }, { "4", "3" },
                { "7", "3" }, { "4", "3" }, { "4", "3" }, { "3", "3" }, { "X", "1", "7" } };

        Pontuacao pontuacao = new Pontuacao().setPontosPartida(partida);
        try {
            pontuacao.calculaSomaPontos();
            assertFalse(true);
        } catch (Exception e) {
            assertEquals(e.getClass(), RuntimeException.class);
            assertEquals(e.getMessage(), "Total de 3 quadros incompativel para rodada: 1");
        }
    }

    @Test
    public void Deve_RetornarErro_Quando_UltimaRodadasTiveremMaisQueQuadrosPermitidos() {
        String[][] partida = new String[][] { { "8", "1" }, { "4", "2" }, { "3", "3" }, { "2", "3" }, { "4", "3" },
                { "7", "3" }, { "4", "3" }, { "4", "3" }, { "3", "3" }, { "1", "1", "7" } };

        Pontuacao pontuacao = new Pontuacao().setPontosPartida(partida);
        try {
            pontuacao.calculaSomaPontos();
            assertFalse(true);
        } catch (Exception e) {
            assertEquals(e.getClass(), RuntimeException.class);
            assertEquals(e.getMessage(), "Total de 3 quadros incompativel para rodada: 9");
        }

        partida = new String[][] { { "8", "1" }, { "4", "2" }, { "3", "3" }, { "2", "3" }, { "4", "3" }, { "7", "3" },
                { "4", "3" }, { "4", "3" }, { "3", "3" }, { "X", "1", "7", "3" } };

        pontuacao = new Pontuacao().setPontosPartida(partida);
        try {
            pontuacao.calculaSomaPontos();
            assertFalse(true);
        } catch (Exception e) {
            assertEquals(e.getClass(), RuntimeException.class);
            assertEquals(e.getMessage(), "Total de 4 quadros incompativel para ultima rodada");
        }
    }

    @Test
    public void Deve_RetornarAPontuacaoTotal_Quando_QuadrosComPontosETra??os() {
        String[][] partida = new String[][] { { "8", "1" }, { "4", "3" }, { "3", "3" }, { "2", "3" }, { "4", "-" },
                { "7", "3" }, { "4", "3" }, { "4", "3" }, { "3", "-" }, { "3", "3" } };

        Pontuacao pontuacao = new Pontuacao().setPontosPartida(partida);
        assertEquals(pontuacao.calculaSomaPontos(), 64);
    }

    @Test
    public void Deve_RetornarAPontuacaoTotal_Quando_QuadrosComPontosTra??osESpare() {
        String[][] partida = new String[][] { { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" },
                { "0", "1" }, { "0", "1" }, { "0", "1" }, // 8
                { "0", "/" }, // 18 + 3 = 21
                { "3", "3" } }; // 27

        Pontuacao pontuacao = new Pontuacao().setPontosPartida(partida);
        assertEquals(pontuacao.calculaSomaPontos(), 27);

        partida = new String[][] { { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" },
                { "0", "1" }, { "0", "/" }, // 17
                { "0", "/" }, // 27 + 3 = 30
                { "3", "3" } }; // 36

        pontuacao = new Pontuacao().setPontosPartida(partida);
        assertEquals(pontuacao.calculaSomaPontos(), 36);

        partida = new String[][] { { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" },
                { "0", "1" }, { "0", "/" }, // 17
                { "0", "/" }, // 27 + 3 = 30
                { "3", "/", "7" } }; // 47

        pontuacao = new Pontuacao().setPontosPartida(partida);
        assertEquals(pontuacao.calculaSomaPontos(), 47);
    }

    @Test
    public void Deve_RetornarErro_Quando_QuadrosComSpareNaPrimeiraJogada() {
        String[][] partida = new String[][] { { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" },
                { "0", "1" }, { "0", "1" }, { "0", "1" }, { "/", "/" }, { "3", "3" } };

        Pontuacao pontuacao = new Pontuacao().setPontosPartida(partida);

        try {
            pontuacao.calculaSomaPontos();
            assertFalse(true);
        } catch (Exception e) {
            assertEquals(e.getClass(), RuntimeException.class);
            assertEquals(e.getMessage(),
                    "Ponto Spare invalido! Nao existe spare na primeira jogada. N??o seria Strike? (X):  Rodada: 8");
        }
    }

    @Test
    public void Deve_RetornarErro_Quando_QuadrosComSpareSeguidos() {
        String[][] partida = new String[][] { { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" },
                { "0", "1" }, { "0", "1" }, { "0", "/" }, { "0", "/" }, { "3", "/", "/" } };

        Pontuacao pontuacao = new Pontuacao().setPontosPartida(partida);

        try {
            pontuacao.calculaSomaPontos();
            assertFalse(true);
        } catch (Exception e) {
            assertEquals(e.getClass(), RuntimeException.class);
            assertEquals(e.getMessage(), "Ponto Spare invalido! N??o seria Strike? (X):  Rodada: 9");
        }
    }

    @Test
    public void Deve_RetornarAPontuacaoTotal_Quando_QuadrosComPontosEStrikes() {
        String[][] partida = new String[][] { { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" },
                { "0", "1" }, { "0", "1" }, { "0", "1" }, // 8
                { "0", "X" }, // 18 + 3 + 3 = 24
                { "3", "3" } }; // 30

        Pontuacao pontuacao = new Pontuacao().setPontosPartida(partida);
        assertEquals(pontuacao.calculaSomaPontos(), 30);

        partida = new String[][] { { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" },
                { "0", "1" }, { "0", "X" }, // 17 +10 = 27
                { "0", "X" }, // 27 + 10 + 3 + 3 = 43
                { "3", "3" } }; // 49

        pontuacao = new Pontuacao().setPontosPartida(partida);
        assertEquals(pontuacao.calculaSomaPontos(), 49);

        partida = new String[][] { { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" }, { "0", "1" },
                { "0", "1" }, { "0", "X" }, // 17 +10 = 27
                { "0", "X" }, // 27 + 10 =37+ 10+10 = 57
                { "X", "X", "X" } }; // 57 + 10 = 67 + 10 +10 = 87

        pontuacao = new Pontuacao().setPontosPartida(partida);
        assertEquals(pontuacao.calculaSomaPontos(), 87);
    }

    @Test
    public void Deve_RetornarAPontuacaoTotal_Quando_QuadrosComPontosTracosSpareEStrikes() {
        String[][] partida = new String[][] { { "-", "1" }, { "-", "1" }, { "-", "1" }, { "-", "1" }, { "-", "1" },
                { "-", "1" }, { "-", "/" }, // 6+10 = 16 + 0 = 16
                { "-", "1" }, // 16+1 = 17
                { "-", "X" }, // 17 +10 + 3 + 0 = 30
                { "3", "-" } }; // 30+3 = 33

        Pontuacao pontuacao = new Pontuacao().setPontosPartida(partida);
        assertEquals(pontuacao.calculaSomaPontos(), 33);

        partida = new String[][] { { "8", "-" }, { "7", "-" }, { "5", "3" }, { "9", "/" }, { "9", "/" }, { "X" },
                { "8", "-" }, { "5", "1" }, { "3", "/" }, { "9", "-" } };

        pontuacao = new Pontuacao().setPontosPartida(partida);
        assertEquals(pontuacao.calculaSomaPontos(), 122);

        partida = new String[][] { { "8", "/" }, { "9", "-" }, { "4", "4" }, { "7", "2" }, { "9", "-" }, { "X" },
                { "X" }, { "8", "-" }, { "3", "5" }, { "9", "/", "7" } };

        pontuacao = new Pontuacao().setPontosPartida(partida);
        assertEquals(pontuacao.calculaSomaPontos(), 133);

    }

}