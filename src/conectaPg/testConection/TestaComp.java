package conectaPg.testConection;

import conectaPg.DAO.ComputadorDAO;
import conectaPg.entities.Computador;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TestaComp {
    public static void main(String[] args) {
        int opcao = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\n1. Insere Computador\n2. Atualiza Computador\n" +
                    "3. Deleta Computador\n4. Exibe Computadores\nOpção: ");
            opcao = Integer.parseInt(scanner.nextLine());
            if (opcao == 1) {
                System.out.print("Inserir Codigo do Computador: ");
                int codComputador = Integer.parseInt(scanner.nextLine());
                System.out.print("Inserir Descrição do Computador: ");
                String descricao = scanner.nextLine();
                System.out.print("Inserir Quantidade de Computadores: ");
                int qtd = Integer.parseInt(scanner.nextLine());

                computadorInsert(codComputador, descricao, qtd);
            } else if (opcao == 2) {
                System.out.print("Inserir Codigo do Computador: ");
                int codComputador = Integer.parseInt(scanner.nextLine());
                System.out.print("Inserir Quantidade de Computadores: ");
                int qtd = Integer.parseInt(scanner.nextLine());

                computadorUpdate(codComputador, qtd);
            } else if (opcao == 3) {
                System.out.print("Inserir Codigo do Computador: ");
                int codComputador = Integer.parseInt(scanner.nextLine());

                computadorDelete(codComputador);
            } else if (opcao == 4) {
                computadorShow();
            }
        } while (opcao >= 1 && opcao < 5);
    }
    public static void computadorInsert(int codComputador, String descricao, int qtd) {
        Computador computador = new Computador();
        computador.setCodComputador(codComputador);
        computador.setQtd(qtd);
        computador.setDescricao(descricao);

        ComputadorDAO computadorDAO = null;
        try {
            computadorDAO = new ComputadorDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        computadorDAO.cadastrarComputador(computador);
    }
    public static void computadorUpdate(int codComputador, int qtd) {
        Computador computador = new Computador();
        computador.setQtd(qtd);
        computador.setCodComputador(codComputador);
        ComputadorDAO computadorDAO = null;
        try {
            computadorDAO = new ComputadorDAO();

        }catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        computadorDAO.updateComputador(computador);
    }
    public static void computadorDelete(int codComputador) {
        Computador computador = new Computador();
        computador.setCodComputador(codComputador);
        ComputadorDAO computadorDAO = null;
        try {
            computadorDAO = new ComputadorDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        computadorDAO.deleteComputador(computador);
    }

    public static void  computadorShow() {
        ComputadorDAO computadorDAO =null;
        try {
            computadorDAO = new ComputadorDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<Computador> listaShowAll = computadorDAO.selectAllcomputers();
        for(Computador e:listaShowAll) {
            System.out.println("---------------------------------------------");
            System.out.println("COD_COMPUTADOR: " + e.getCodComputador());
            System.out.println("QTD: " + e.getQtd());
            System.out.println("DESCRICAO: " + e.getDescricao());
        }
    }
}
