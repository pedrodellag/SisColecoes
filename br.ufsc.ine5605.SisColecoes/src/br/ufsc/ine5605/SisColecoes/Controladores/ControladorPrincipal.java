/**
 * Controlador principal
 * ----- Controla todos os outros controladores -----
 * Inicia tela principal
 * Recebe opcao da tela principal para iniciar os outros controladores
 *      Inicia controlador de colecionador
 *      Inicia controlador de item
 *      Inicia controlador de leilao
 */
package br.ufsc.ine5605.SisColecoes.Controladores;

import br.ufsc.ine5605.SisColecoes.Controladores.ControladorLeilao;
import br.ufsc.ine5605.SisColecoes.Controladores.ControladorItem;
import br.ufsc.ine5605.SisColecoes.Controladores.ControladorColecionador;
import br.ufsc.ine5605.SisColecoes.Modelos.Colecionador;
import br.ufsc.ine5605.SisColecoes.Modelos.Item;
import br.ufsc.ine5605.SisColecoes.Telas.TelaPrincipal;
import java.util.ArrayList;

public class ControladorPrincipal {

    /**
     *
     * @author Guilherme
     * @author Pedro
     */
    private ControladorColecionador controladorColecionador;
    private ControladorItem controladorItem;
    private ControladorLeilao controladorLeilao;
    private TelaPrincipal telaPrincipal;

    public ControladorPrincipal() {
        this.controladorColecionador = new ControladorColecionador(this);
        this.controladorItem = new ControladorItem(this);
        this.controladorLeilao = new ControladorLeilao(this);
        this.telaPrincipal = new TelaPrincipal(this);
    }

    public void iniciaTelaPrincipal() {
        controladorColecionador.colecionadoresTeste();
        //controladorItem.itensTeste();
        telaPrincipal.menuPrincipal();
    }

    public void opcaoDoMenuPrincipal(int opcao) {

        switch (opcao) {
            case 1:
                controladorColecionador.menuColecionadores();
                break;
            case 2:
                controladorItem.menuItens();
                break;
            case 3:
                controladorLeilao.menuLeilao();
                break;
        }
    }

    public Colecionador getColecionadorByCpf(long cpf) {
        return controladorColecionador.getColecionadorByCpf(cpf);
    }

    public ArrayList<Item> getItensByDono(Colecionador dono) {
        return controladorItem.getItensByDono(dono);
    }

    public String listaItensBuscados() {
        return controladorItem.listaItensBuscados();
    }

    public ArrayList<Item> getItensByNome(String nome) {
        return controladorItem.getItensByNome(nome);
    }

    Item getItemByNomeECpfDoDono(String nome, long cpfDoDono) {
        return controladorItem.getItemByNomeECpfDoDono(nome, cpfDoDono);
    }

}
