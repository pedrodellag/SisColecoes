/**
 *
 */
package br.ufsc.ine5605.SisColecoes.Modelos;

public abstract class Pessoa {

    /**
     *
     * @author Guilherme
     * @author Pedro
     */
    private String nome;
    private long cpf;
    private double saldo;

    public Pessoa() {

    }

    public Pessoa(String nome, long cpf, double saldo) {
        this.nome = nome;
        this.cpf = cpf;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void mudarSaldo(double saldo) {
        this.saldo += saldo;
    }

}
