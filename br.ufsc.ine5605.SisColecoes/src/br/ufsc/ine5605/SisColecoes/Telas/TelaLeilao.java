/**
 *
 */
package br.ufsc.ine5605.SisColecoes.Telas;

import br.ufsc.ine5605.SisColecoes.Controladores.ControladorLeilao;
import br.ufsc.ine5605.SisColecoes.ITela;
import br.ufsc.ine5605.SisColecoes.Modelos.Colecionador;
import br.ufsc.ine5605.SisColecoes.Modelos.Item;
import br.ufsc.ine5605.SisColecoes.Modelos.Leilao;
import java.util.Scanner;

public class TelaLeilao implements ITela {

    /**
     *
     * @author Guilherme
     * @author Pedro
     */
    private Scanner teclado;
    private ControladorLeilao controladorLeilao;

    public TelaLeilao(ControladorLeilao controladorLeilao) {
        this.teclado = new Scanner(System.in);
        this.controladorLeilao = controladorLeilao;
    }

    @Override
    public void menu() {
        menuLeilao();
    }

    public void menuLeilao() {
        int opcao;
        do {
            System.out.println("------ LEILAO ------");
            System.out.println("1 - NOVO LEILAO");
            System.out.println("2 - LISTAR LEILOES");
            System.out.println("3 - VOLTAR");
            opcao = teclado.nextInt();
            controladorLeilao.opcaoDoMenuLeilao(opcao);
        } while (opcao != 0);
    }

    public void cadastrarLeilao() {
        System.out.println("CPF DO VENDEDOR: ");
        long cpfVendedor = teclado.nextLong();
        System.out.println("CPF DO COMPRADOR: ");
        long cpfComprador = teclado.nextLong();
        System.out.println("NOME DO ITEM: " + teclado.nextLine());
        String nomeDoItem = teclado.nextLine();
        System.out.println("VALOR DO ITEM: ");
        double valorDoItem = teclado.nextDouble();
        Colecionador vendedor = controladorLeilao.leilaoGetColecionadorByCpf(cpfVendedor);
        Colecionador comprador = controladorLeilao.leilaoGetColecionadorByCpf(cpfComprador);
        Item itemLeiloado = controladorLeilao.leilaoGetItemByNomeECpfDoDono(nomeDoItem, cpfVendedor);
        Leilao leilao = new Leilao(vendedor, comprador, itemLeiloado, valorDoItem);
        controladorLeilao.addLeilao(leilao);
        vendedor.mudarSaldo(valorDoItem);
        comprador.mudarSaldo(-valorDoItem);
        itemLeiloado.setDono(comprador);

    }

    public void listarLeiloes() {
        System.out.println("------ LISTA DE LEILOES REALIZADOS ------");
        System.out.println(controladorLeilao.getLeiloes());
    }
}
