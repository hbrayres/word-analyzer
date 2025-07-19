package br.com.prover.wordanalyzer.service;

import br.com.prover.wordanalyzer.util.WordAnalyzerUtil;

import javax.ejb.Singleton;
import java.util.Map;

/**
 * A classe WordAnalyzerService é um EJB Singleton que fornece
 * um método sincronizado para analisar uma frase fornecida e retornar a contagem de
 * cada palavra.
 *
 * O Singleton garante que apenas uma instância deste serviço seja criada e
 * gerenciada pelo contêiner EJB, que faz o motor de análise ser capaz de processar 
 * apenas uma solicitação por vez de forma sincronizada.
 */
@Singleton
public class WordAnalyzerService {

  /**
   * Analisa a frase fornecida e retorna um Map contendo as palavras como chaves
   * e suas respectivas contagens como valores.
   *
   * O método synchronized é para garantir que apenas uma thread
   * possa executá-lo por vez, processando de modo sincronizado as solicitações 
   * conforme necessário.
   *
   * @param phrase A frase a ser analisada.
   * @return Map com as contagens de palavras analisadas.
   */
  public synchronized Map<String, Long> analyzePhrase(String phrase) {
    return WordAnalyzerUtil.analyzePhrase(phrase);
  }
}
