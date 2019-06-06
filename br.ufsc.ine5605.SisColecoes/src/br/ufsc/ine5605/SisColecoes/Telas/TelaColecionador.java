/**
 *
 */
package br.ufsc.ine5605.SisColecoes.Telas;

import br.ufsc.ine5605.SisColecoes.Controladores.ControladorColecionador;
import br.ufsc.ine5605.SisColecoes.ITela;
import br.ufsc.ine5605.SisColecoes.Modelos.Colecionador;

import java.util.Scanner;

public class TelaColecionador implements ITela {

    /**
     *
     * @author Guilherme
     * @author Pedro
     */
    private Scanner teclado;
    private ControladorColecionador controladorColecionador;
    long cpfDados;

    public TelaColecionador(ControladorColecionador controladorColecionador) {
        this.teclado = new Scanner(System.in);
        this.controladorColecionador = controladorColecionador;
    }

    @Override
    public void menu() {
        menuColecionadores();
    }

    public void menuColecionadores() {
        int opcao;
        do {
            System.out.println("------ COLECIONADORES ------");
            System.out.println("1 - CADASTRAR COLECIONADOR");
            System.out.println("2 - EXCLUIR COLECIONADOR" + "\n");
            System.out.println("LISTAR");
            System.out.println("3 - LISTAR COLECAO DO COLECIONADOR");
            System.out.println("4 - LISTAR DADOS DO COLECIONADOR");
            System.out.println("5 - LISTAR TODOS COLECIONADORES" + "\n");
            System.out.println("6 - VOLTAR");
            System.out.println("DIGITE SUA OPCAO:");
            System.out.println("----------------------------");
            opcao = teclado.nextInt();
            controladorColecionador.opcaoDoMenuColecionadores(opcao);
        } while (opcao != 0);
    }

    public void cadastrarColecionador() {
        System.out.println("------ CADASTRO DE COLECIONADOR ------");
        System.out.println("DIGITE SEU NOME: " + teclado.nextLine());
        String nome = teclado.nextLine();
        System.out.println("DIGITE SEU SALDO: ");
        double saldo = teclado.nextDouble();
        System.out.println("DIGITE SEU CPF: ");
        long cpf = teclado.nextLong();
        System.out.println("------ COLECIONADOR CADASTRADO ------");
        long numeroDeCadastro = (cpf);
        System.out.println("SEU NUMERO DE CADASTRO É: ");
        System.out.println(numeroDeCadastro);
        Colecionador colecionador = new Colecionador(nome, cpf, saldo, numeroDeCadastro);
        controladorColecionador.addColecionador(colecionador);
    }

    public void excluirColecionador() {
        System.out.println("CPF DO COLECIONADOR: ");
        long cpfExcluido = teclado.nextLong();
        controladorColecionador.removeColecionador(cpfExcluido);
        System.out.println("COLECIONADOR EXCLUIDO COM SUCESSO");

        controladorColecionador.menuColecionadores();
    }

    public void listarColecao() {
        int opcao;
        do {
            System.out.println("POR FAVOR IMFORME O CPF DO COLECIONADOR: ");
            long cpf = teclado.nextLong();
            System.out.println("LISTA DE ITENS: ");
            controladorColecionador.colGetItensByDono(controladorColecionador.getColecionadorByCpf(cpf));
            System.out.println(controladorColecionador.colListaItensBuscados());
            System.out.println("DIGITE 0 PARA RETORNAR");
            opcao = teclado.nextInt();
        } while (opcao != 0);
        controladorColecionador.retornarMenu(opcao);
    }

    public void listarDados() {
        System.out.println("CPF DO COLECIONADOR: ");
        cpfDados = teclado.nextLong();
        System.out.println("------ DADOS DO COLECIONADOR ------");
        System.out.println(controladorColecionador.listarDados(cpfDados));
        System.out.println("DIGITE 1 PARA ALTERAR OS DADOS");
        System.out.println("DIGITE 2 PARA VOLTAR");
        int opcao = teclado.nextInt();
        controladorColecionador.buscarDados(opcao);
    }

    public void alterarDados() {
        System.out.println("------ ALTERACAO DE DADOS ------");
        System.out.println("DIGITE TODOS OS DADOS PARA ALTERAR:");
        System.out.println("NOME: ");
        String nomeNovo = teclado.next();
        System.out.println("CPF: ");
        long cpfNovo = teclado.nextLong();
        controladorColecionador.alterarDados(cpfDados, nomeNovo, cpfNovo);
    }

    public void listarColecionadores() {
        System.out.println("------ LISTA DE COLECIONADORES ------");
        System.out.println(controladorColecionador.getColecionadores());
    }

}
