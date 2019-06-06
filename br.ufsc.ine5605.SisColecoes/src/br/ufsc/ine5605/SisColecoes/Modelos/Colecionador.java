/**
 *
 */
package br.ufsc.ine5605.SisColecoes.Modelos;

import br.ufsc.ine5605.SisColecoes.Modelos.Pessoa;

public class Colecionador extends Pessoa {

    /**
     *
     * @author Guilherme
     * @author Pedro
     */
    private long numeroDeCadastro;

    public Colecionador(String nome, long cpf, double saldo, long numeroDeCadastro) {
        super(nome, cpf, saldo);
        this.numeroDeCadastro = numeroDeCadastro;
    }

    public long getNumeroDeCadastro() {
        return numeroDeCadastro;
    }

    public void setNumeroDeCadastro(long numeroDeCadastro) {
        this.numeroDeCadastro = numeroDeCadastro;
    }

}
