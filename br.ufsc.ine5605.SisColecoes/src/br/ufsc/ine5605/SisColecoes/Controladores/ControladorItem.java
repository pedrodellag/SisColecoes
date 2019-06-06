/**
 *
 */
package br.ufsc.ine5605.SisColecoes.Controladores;

import br.ufsc.ine5605.SisColecoes.Controladores.ControladorPrincipal;
import br.ufsc.ine5605.SisColecoes.Modelos.Colecionador;
import br.ufsc.ine5605.SisColecoes.Modelos.Item;
import br.ufsc.ine5605.SisColecoes.Telas.TelaItem;
import static br.ufsc.ine5605.SisColecoes.TipoRaridade.COMUM;
import static br.ufsc.ine5605.SisColecoes.TipoRaridade.INCOMUM;
import static br.ufsc.ine5605.SisColecoes.TipoRaridade.RARO;
import java.util.ArrayList;

public class ControladorItem {

    /**
     *
     * @author Guilherme
     * @author Pedro
     */
    private ArrayList<Item> itens;
    private TelaItem telaItem;
    private ControladorPrincipal controladorPrincipal;
    private ArrayList<Item> itensBuscados = new ArrayList<>();

    public ControladorItem(ControladorPrincipal controladorPrincipal) {
        this.telaItem = new TelaItem(this);
        this.controladorPrincipal = controladorPrincipal;
        itens = new ArrayList<>();
    }

    public void menuItens() {
        telaItem.menuItens();
    }

    public void opcaoDoMenuItem(int opcao) {
        switch (opcao) {
            case 1:
                telaItem.cadastrarItem();
                break;
            case 2:
                telaItem.buscarItens();
                break;
            case 3:
                controladorPrincipal.iniciaTelaPrincipal();
                break;
        }
    }

    public ArrayList<Item> getItensByNome(String nome) {
        Item item = null;
        itensBuscados.clear();
        for (Item it : itens) {
            if (it.getNome().equals(nome));
            item = it;
            itensBuscados.add(item);
        }
        return itensBuscados;

    }

    public Item getItemByNomeECpfDoDono(String nome, long cpfDoDono) {
        Item item = null;
        for (Item it : itens) {
            if (it.getNome().equals(nome));
            {
                if (it.getDono().equals(controladorPrincipal.getColecionadorByCpf(cpfDoDono))) {
                    item = it;
                }

            }
        }

        return item;

    }

    public ArrayList<Item> getItensByDono(Colecionador dono) {
        Item item = null;
        itensBuscados.clear();
        for (Item it : itens) {
            if (it.getDono().equals(dono));
            item = it;
            itensBuscados.add(item);
        }
        return itensBuscados;

    }

    public String listaItensBuscados() {
        String resultado = "";
        for (Item i : itensBuscados) {
            resultado += "NOME: " + i.getNome() + "\n" + "DESCRICAO: "
                    + i.getDescricao() + "\n" + "VALOR: " + i.getValor() + "\n"
                    + "RARIDADE: " + i.getRaridade() + "\n\n";
        }
        return resultado;
    }

    public void removeItem(Item item) {
        itens.remove(item);
    }

    public Colecionador itemGetColecionadorByCpf(long cpf) {
        return controladorPrincipal.getColecionadorByCpf(cpf);
    }

    public void addItem(Item item) {
        if (item != null) {
            itens.add(item);
        }
    }

    public void itensTeste() {
        Item um = new Item("Dragao Branco De Olhos Azuis", "Carta famosa de Yugioh", 30.0, INCOMUM, itemGetColecionadorByCpf(11832332993L));
        Item dois = new Item("Quadro Monalisa", "Quadro renascentista pintado por Leonardo da Vinci", 200.0, RARO, itemGetColecionadorByCpf(11832332993L));
        Item tres = new Item("Nota de 1 real", "Nota que esta fora de circulacao", 5.0, COMUM, itemGetColecionadorByCpf(11932433094L));
        Item quatro = new Item("Disco “Double Fantasy” do John Lennon", "Disco de vinil", 5.0, RARO, itemGetColecionadorByCpf(73925225900L));

        itens.add(um);
        itens.add(dois);
        itens.add(tres);
        itens.add(quatro);
    }
}
