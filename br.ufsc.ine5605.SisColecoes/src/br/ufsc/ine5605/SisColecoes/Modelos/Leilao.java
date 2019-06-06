/**
 *
 */
package br.ufsc.ine5605.SisColecoes.Modelos;

import br.ufsc.ine5605.SisColecoes.Modelos.Item;
import br.ufsc.ine5605.SisColecoes.Modelos.Colecionador;

public class Leilao {

    /**
     *
     * @author Guilherme
     * @author Pedro
     */
    private Colecionador vendedor;
    private Colecionador comprador;
    private Item itemLeiloado;
    private double valorDoItem;

    public Leilao(Colecionador vendedor, Colecionador comprador,
            Item itemLeiloado, double valorDoItem) {
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.itemLeiloado = itemLeiloado;
        this.valorDoItem = valorDoItem;
    }

    public Colecionador getVendedor() {
        return vendedor;
    }

    public void setVendedor(Colecionador vendedor) {
        this.vendedor = vendedor;
    }

    public Colecionador getComprador() {
        return comprador;
    }

    public void setComprador(Colecionador comprador) {
        this.comprador = comprador;
    }

    public Item getItemLeiloado() {
        return itemLeiloado;
    }

    public void setItemLeiloado(Item itemLeiloado) {
        this.itemLeiloado = itemLeiloado;
    }

    public double getValorDoItem() {
        return valorDoItem;
    }

    public void setValorDoItem(double valorDoItem) {
        this.valorDoItem = valorDoItem;
    }

}
