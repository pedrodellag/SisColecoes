/**
 * Controlador de Colecionador
 * ----- Controla acoes relacionada ao colecionadores -----
 * Inicia tela colecionador
 * Recebe opcao da tela colecionador para executar acoes
 *      cadastra novo Colecionador
 *      exclui selecionado pelo cpf Colecionador
 *      lista os itens da colecao do Colecionador
 *      lista todos os Colecionadores
 *      lista dados do Colecionador
 *
 *      Retorna para o controlador principal
 */
package br.ufsc.ine5605.SisColecoes.Controladores;

import br.ufsc.ine5605.SisColecoes.Controladores.ControladorPrincipal;
import br.ufsc.ine5605.SisColecoes.Modelos.Colecionador;
import br.ufsc.ine5605.SisColecoes.Modelos.Item;
import br.ufsc.ine5605.SisColecoes.Telas.TelaColecionador;
import java.util.ArrayList;

public class ControladorColecionador {

    /**
     *
     * @author Guilherme
     * @author Pedro
     */
    private ArrayList<Colecionador> colecionadores;
    private TelaColecionador telaColecionador;
    private ControladorPrincipal controladorPrincipal;

    public ControladorColecionador(ControladorPrincipal controladorPrincipal) {
        this.telaColecionador = new TelaColecionador(this);
        this.controladorPrincipal = controladorPrincipal;
        colecionadores = new ArrayList<>();
    }

    public void menuColecionadores() {
        telaColecionador.menuColecionadores();
    }

    public void opcaoDoMenuColecionadores(int opcao) {
        switch (opcao) {
            case 1:
                telaColecionador.cadastrarColecionador();
                break;
            case 2:
                telaColecionador.excluirColecionador();
                break;
            case 3:
                telaColecionador.listarColecao();
                break;
            case 4:
                telaColecionador.listarDados();
                break;
            case 5:
                telaColecionador.listarColecionadores();
                break;
            case 6:
                controladorPrincipal.iniciaTelaPrincipal();
                break;
            default:
                break;
        }
    }

    public void retornarMenu(int opcao) {
        menuColecionadores();
    }

    public void addColecionador(Colecionador colecionador) {
        if (colecionador != null) {
            colecionadores.add(colecionador);
        }
    }

    public Colecionador getColecionadorByCpf(long cpf) {
        Colecionador colecionador = null;
        for (Colecionador col : colecionadores) {
            if (col.getCpf() == cpf) {
                colecionador = col;
            }
        }
        return colecionador;

    }

    public void removeColecionador(long cpf) {
        colecionadores.remove(getColecionadorByCpf(cpf));
    }

    public String getColecionadores() {
        String resultado = "";
        for (Colecionador c : colecionadores) {
            resultado += "NOME: " + c.getNome() + "\n" + "CPF: " + c.getCpf()
                    + "\n" + "SALDO: " + c.getSaldo() + "\n" + "NUMERO DE CADASTRO: "
                    + c.getNumeroDeCadastro() + "\n\n";
        }
        return resultado;
    }

    public void setColecionador(ArrayList<Colecionador> colecionador) {
        this.colecionadores = colecionador;
    }

    public String listarDados(long cpf) {
        String dados = "";
        dados += "NOME: " + getColecionadorByCpf(cpf).getNome() + "\n" + "CPF: "
                + getColecionadorByCpf(cpf).getCpf() + "\n" + "SALDO: "
                + getColecionadorByCpf(cpf).getSaldo() + "\n" + "NUMERO DE CADASTRO: "
                + getColecionadorByCpf(cpf).getNumeroDeCadastro() + "\n\n";
        return dados;
    }

    public void buscarDados(int opcao) {
        switch (opcao) {
            case 1:
                telaColecionador.alterarDados();
                break;
            case 2:
                controladorPrincipal.iniciaTelaPrincipal();
                break;

        }
    }

    public void alterarDados(long cpfDados, String nomeNovo, long cpfNovo) {
        getColecionadorByCpf(cpfDados).setNome(nomeNovo);
        getColecionadorByCpf(cpfDados).setCpf(cpfNovo);
        getColecionadorByCpf(cpfDados).setNumeroDeCadastro(cpfNovo);
    }

    public TelaColecionador getTelaColecionador() {
        return telaColecionador;
    }

    public void setTelaColecionador(TelaColecionador telaColecionador) {
        this.telaColecionador = telaColecionador;
    }

    public ControladorPrincipal getControladorPrincipal() {
        return controladorPrincipal;
    }

    public void setControladorPrincipal(ControladorPrincipal controladorPrincipal) {
        this.controladorPrincipal = controladorPrincipal;
    }

    public ArrayList<Item> colGetItensByDono(Colecionador dono) {
        return controladorPrincipal.getItensByDono(dono);
    }

    public String colListaItensBuscados() {
        return controladorPrincipal.listaItensBuscados();
    }

    public void colecionadoresTeste() {
        Colecionador um = new Colecionador("Pedro Della", 11832332993L, 1000.0, 11832332993L);
        Colecionador dois = new Colecionador("Guilherme Rocha", 11932433094L, 300.0, 11932433094L);
        Colecionador tres = new Colecionador("Joao Silva", 73925225900L, 999.9, 73925225900L);

        colecionadores.add(um);
        colecionadores.add(dois);
        colecionadores.add(tres);
    }

}
