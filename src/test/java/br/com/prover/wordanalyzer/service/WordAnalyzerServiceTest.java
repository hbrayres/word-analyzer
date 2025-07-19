package br.com.prover.wordanalyzer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WordAnalyzerServiceTest {

    private WordAnalyzerService service;

    @BeforeEach
    public void setup() {
        service = new WordAnalyzerService();
    }

    @Test
    public void testAnalyzePhrase_NormalPhrase() {
        String phrase = "casa bola casa cachorro";
        Map<String, Long> result = service.analyzePhrase(phrase);
        
        assertNotNull(result, "O resultado não deveria ser null");
        assertEquals(3, result.size(), "Deve haver 3 palavras distintas");
        assertEquals(2L, result.get("casa"), "A palavra 'casa' aparece 2 vezes");
        assertEquals(1L, result.get("bola"), "A palavra 'bola' aparece 1 vez");
        assertEquals(1L, result.get("cachorro"), "A palavra 'cachorro' aparece 1 vez");
    }

    @Test
    public void testAnalyzePhrase_EmptyString() {
        String phrase = "";
        Map<String, Long> result = service.analyzePhrase(phrase);
        
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Resultado deve estar vazio para frase vazia");
    }

    @Test
    public void testAnalyzePhrase_PhraseWithPontuation() {
        String phrase = "Olá! Olá, mundo.";
        Map<String, Long> result = service.analyzePhrase(phrase);
        
        assertTrue(result.containsKey("olá"), "Deve conter 'Olá'");
        assertTrue(result.containsKey("mundo"), "Deve conter 'mundo'");
        assertEquals(2L, result.get("olá"), "A palavra 'Olá' aparece duas vezes");
        assertEquals(1L, result.get("mundo"), "A palavra 'mundo' aparece uma vez");
    }

    @Test
    public void testAnalyzePhrase_CaseInsensitive() {
        String phrase = "Casa CASA casa";
        Map<String, Long> result = service.analyzePhrase(phrase);
        
        // Espera-se que trate as palavras como iguais (caso comum na análise de palavras)
        assertEquals(3L, result.get("casa"), "Deve contar todas as variações como uma única palavra");
    }
}
