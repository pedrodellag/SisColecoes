/**
 *
 */
package br.ufsc.ine5605.SisColecoes.Telas;

import br.ufsc.ine5605.SisColecoes.Controladores.ControladorPrincipal;
import br.ufsc.ine5605.SisColecoes.ITela;
import java.util.Scanner;

public class TelaPrincipal implements ITela {

    /**
     *
     * @author Guilherme
     * @author Pedro
     */
    private Scanner teclado;
    private ControladorPrincipal controladorPrincipal;

    public TelaPrincipal(ControladorPrincipal controladorPrincipal) {
        this.teclado = new Scanner(System.in);
        this.controladorPrincipal = controladorPrincipal;

    }

    @Override
    public void menu() {
        menuPrincipal();
    }

    public void menuPrincipal() {

        int opcao;
        System.out.println("------ MENU PRINCIPAL ------");
        System.out.println("1 - COLECIONADORES");
        System.out.println("2 - ITENS");
        System.out.println("3 - LEILAO");
        System.out.println("DIGITE SUA OPCAO: ");
        System.out.println("----------------------------");

        do {
            opcao = teclado.nextInt();
            controladorPrincipal.opcaoDoMenuPrincipal(opcao);
        } while (opcao != 0);
    }

}
