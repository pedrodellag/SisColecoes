/**
 *
 */
package br.ufsc.ine5605.SisColecoes.Telas;

import br.ufsc.ine5605.SisColecoes.Controladores.ControladorItem;
import br.ufsc.ine5605.SisColecoes.ITela;
import br.ufsc.ine5605.SisColecoes.Modelos.Colecionador;
import br.ufsc.ine5605.SisColecoes.Modelos.Item;
import br.ufsc.ine5605.SisColecoes.TipoRaridade;
import java.util.Scanner;

public class TelaItem implements ITela {

    /**
     *
     * @author Guilherme
     * @author Pedro
     */
    private final Scanner teclado;
    private final ControladorItem controladorItem;

    public TelaItem(ControladorItem controladorItem) {
        this.controladorItem = controladorItem;
        this.teclado = new Scanner(System.in);
    }

    @Override
    public void menu() {
        menuItens();
    }

    public void menuItens() {
        int opcao;
        do {
            System.out.println("------ ITENS ------");
            System.out.println("1 - CADASTRAR ITEM");
            System.out.println("2 - BUSCAR ITENS");
            System.out.println("3 - VOLTAR");
            System.out.println("DIGITE SUA OPCAO");
            System.out.println("--------------------");
            opcao = teclado.nextInt();
            controladorItem.opcaoDoMenuItem(opcao);
        } while (opcao != 0);

    }

    public void cadastrarItem() {
        System.out.println("------ CADASTRO DE ITEM ------");
        System.out.println("NOME DO ITEM: " + teclado.nextLine());
        String nome = teclado.nextLine();
        System.out.println("DESCRICAO DO ITEM: ");
        String descricao = teclado.nextLine();
        System.out.println("VALOR DO ITEM: ");
        double valor = teclado.nextDouble();
        System.out.println("CPF DO DONO: ");
        long cpfDoDono = teclado.nextLong();
        System.out.println("RARIDADE: ");

        System.out.println(" Defina a raridade do item: ");
        System.out.println("Digite:" + "\n" + "(1) - Comum" + "\n"
                + "(2) - Incomum" + "\n" + "(3) - Raro ");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        TipoRaridade tipoRaridade = null;
        switch (opcao) {
            case 1:
                tipoRaridade = TipoRaridade.COMUM;
                break;
            case 2:
                tipoRaridade = TipoRaridade.INCOMUM;
                break;
            case 3:
                tipoRaridade = TipoRaridade.RARO;
                break;
            default:
                System.out.println("Insira apenas uma das opções: (1), (2) ou (3)");
        }

        //Item.getRaridade().mensagem;
        //ENUM
        System.out.println("------ ITEM CADASTRADO ------");
        Colecionador dono = controladorItem.itemGetColecionadorByCpf(cpfDoDono);
        Item item = new Item(nome, descricao, valor, tipoRaridade, dono);
        controladorItem.addItem(item);
    }

    public void buscarItens() {
        System.out.println("------ BUSCAR ITEM ------");
        System.out.println("POR FAVOR DIGITE O NOME DO ITEM: " + teclado.nextLine());
        String nome = teclado.nextLine();
        controladorItem.getItensByNome(nome);
        System.out.println(controladorItem.listaItensBuscados());

        controladorItem.menuItens();
    }

}
