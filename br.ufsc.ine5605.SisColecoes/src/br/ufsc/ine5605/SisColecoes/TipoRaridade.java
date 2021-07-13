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
    COMUM("Raridade Comum"),
    INCOMUM("Raridade Incomum"),
    RARO("Raridade Rara");

    public String tipoDaRaridade;

    TipoRaridade(String tipoRaridade) {
        tipoDaRaridade = tipoRaridade;
    }
}
