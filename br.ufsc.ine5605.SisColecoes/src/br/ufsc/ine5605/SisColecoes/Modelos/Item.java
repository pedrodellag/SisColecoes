package br.ufsc.ine5605.SisColecoes.Modelos;

import br.ufsc.ine5605.SisColecoes.Modelos.Colecionador;
import br.ufsc.ine5605.SisColecoes.TipoRaridade;

public class Item {

    /**
     *
     * @author Guilherme
     * @author Pedro
     */
    private String nome;
    private String descricao;
    private double valor;
    private TipoRaridade raridade;
    private Colecionador dono;

    public Item() {

    }

    public Item(String nome, String descricao, double valor, TipoRaridade raridade,
            Colecionador dono) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.dono = dono;
        this.raridade = raridade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Enum getRaridade() {
        return raridade;
    }

    public void setRaridade(TipoRaridade raridade) {
        this.raridade = raridade;
    }

    public Colecionador getDono() {
        return dono;
    }

    public void setDono(Colecionador dono) {
        this.dono = dono;
    }

}
