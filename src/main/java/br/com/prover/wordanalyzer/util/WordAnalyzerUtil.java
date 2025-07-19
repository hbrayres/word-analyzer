package br.com.prover.wordanalyzer.util;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A classe WordAnalyzerUtil fornece métodos utilitários para a análise de palavras em
 * uma determinada frase.
 *
 * Ela é responsável por tokenizar a frase, contar a ocorrência de cada palavra e
 * retornar um mapa com as palavras e suas respectivas contagens.
 */
public class WordAnalyzerUtil {

  /**
   * Analisa a frase fornecida e retorna um mapa contendo as palavras como chaves
   * e suas contagens como valores.
   *
   * @param phrase A frase a ser analisada.
   * @return Um mapa com as palavras e seus contadores.
   */
  public static Map<String, Long> analyzePhrase(final String phrase) {

    return Arrays.stream(phrase.toLowerCase().split("\\s+"))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

}
