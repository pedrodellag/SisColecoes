/**
 *
 */
package br.ufsc.ine5605.SisColecoes;

public enum TipoRaridade {

    /**
     *
     * @author Guilherme
     * @author Pedro
     */
    COMUM("raridade Comum"),
    INCOMUM("raridade Incomum"),
    RARO("raridade Rara");

    public String tipoDaRaridade;

    TipoRaridade(String tipoRaridade) {
        tipoDaRaridade = tipoRaridade;
    }
}
