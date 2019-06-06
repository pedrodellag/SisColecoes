/**
 *
 */
package br.ufsc.ine5605.SisColecoes.Controladores;

import br.ufsc.ine5605.SisColecoes.Controladores.ControladorPrincipal;
import br.ufsc.ine5605.SisColecoes.Modelos.Colecionador;
import br.ufsc.ine5605.SisColecoes.Modelos.Item;
import br.ufsc.ine5605.SisColecoes.Modelos.Leilao;
import br.ufsc.ine5605.SisColecoes.Telas.TelaLeilao;
import java.util.ArrayList;

public class ControladorLeilao {

    /**
     *
     * @author Guilherme
     * @author Pedro
     */
    private ArrayList<Leilao> leiloes = new ArrayList<>();
    private ControladorPrincipal controladorPrincipal;
    private TelaLeilao telaLeilao;

    public ControladorLeilao(ControladorPrincipal controladorPrincipal) {
        this.telaLeilao = new TelaLeilao(this);
        this.controladorPrincipal = controladorPrincipal;
    }

    public void opcaoDoMenuLeilao(int opcao) {
        switch (opcao) {
            case 1:
                telaLeilao.cadastrarLeilao();
                break;
            case 2:
                telaLeilao.listarLeiloes();
                break;
            case 3:
                controladorPrincipal.iniciaTelaPrincipal();
                break;

        }
    }

    public void menuLeilao() {
        telaLeilao.menuLeilao();
    }

    public String getLeiloes() {

        String resultado = "";
        for (Leilao l : leiloes) {
            resultado += "VENDEDOR: " + l.getVendedor().getNome() + "\n" + "COMPRADOR: " + l.getComprador().getNome()
                    + "\n" + "ITEM LEILOADO: " + l.getItemLeiloado().getNome() + "\n" + "VALOR DO ITEM: "
                    + l.getValorDoItem() + "\n\n";
        }
        return resultado;
    }

    public void setLeiloes(ArrayList<Leilao> leiloes) {
        this.leiloes = leiloes;
    }

    public void addLeilao(Leilao leilao) {
        if (leiloes != null) {
            leiloes.add(leilao);
        }
    }

    public void removeLeilao(Leilao leilao) {
        if (leiloes != null) {
            leiloes.remove(leilao);
        }
    }

    public ArrayList<Item> leilaoGetItemByNome(String nome) {
        return controladorPrincipal.getItensByNome(nome);
    }

    public Colecionador leilaoGetColecionadorByCpf(long cpf) {
        return controladorPrincipal.getColecionadorByCpf(cpf);
    }

    public Item leilaoGetItemByNomeECpfDoDono(String nome, long cpfDoDono) {
        return controladorPrincipal.getItemByNomeECpfDoDono(nome, cpfDoDono);
    }

}
