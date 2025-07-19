package br.com.prover.wordanalyzer.bean;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.prover.wordanalyzer.service.WordAnalyzerService;

/**
 * O AnalyzerBean é um managed bean CDI, com escopo de requisição, responsável por
 * gerenciar a interação do usuário com a funcionalidade de análise de frases.
 *
 * Ele injeta o serviço WordAnalyzerService, que é responsável pela lógica de negócios
 * da análise de frases, e expõe métodos e propriedades para permitir que a interface
 * do usuário interaja com essa funcionalidade.
 */
@Named
@RequestScoped
public class AnalyzerBean implements Serializable {

  private static final long serialVersionUID = 1L;

  @Inject
  private WordAnalyzerService analyzerService;

  private String inputPhrase;
  private Map<String, Long> analysisResult;
  private int distinctWordCount;

  /**
   * Action analisa a frase fornecida pelo usuário e atualiza as propriedades
   * 'analysisResult' e 'distinctWordCount' com os resultados.
   */
  public void analyzePhraseAction() {
    if (inputPhrase != null && !inputPhrase.trim().isEmpty()) {
      analysisResult = new LinkedHashMap<>(analyzerService.analyzePhrase(inputPhrase));
      distinctWordCount = analysisResult.size();
    } else {
      analysisResult = new LinkedHashMap<>();
      distinctWordCount = 0;
    }
  }       

  // Getters and Setters
  public String getInputPhrase() {
    return inputPhrase;
  }

  public void setInputPhrase(String inputPhrase) {
    this.inputPhrase = inputPhrase;
  }

  public Map<String, Long> getAnalysisResult() {
    return analysisResult;
  }

  public int getDistinctWordCount() {
    return distinctWordCount;
  }

  public boolean hasResult() {
    return analysisResult != null && !analysisResult.isEmpty();
  }

}
