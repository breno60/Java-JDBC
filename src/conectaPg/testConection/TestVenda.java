package conectaPg.testConection;

import conectaPg.DAO.VendaDAO;
import conectaPg.entities.Venda;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TestVenda {
    public static void main(String[] args) {
        int opcao = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\n1. Insere Venda\n2. Atualiza Venda\n" +
                    "3. Deleta Venda\n4. Exibe Vendas\nOpção: ");
            opcao = Integer.parseInt(scanner.nextLine());
            if (opcao == 1) {
                System.out.print("Inserir Id da Venda: ");
                int idVenda = Integer.parseInt(scanner.nextLine());
                System.out.print("Inserir Quantidade Vendida: ");
                int qtdVendida = Integer.parseInt(scanner.nextLine());
                System.out.print("Inserir Codigo do Computador: ");
                int codComp = Integer.parseInt(scanner.nextLine());
                System.out.print("Inserir Matricula do Vendedor: ");
                int matVende = Integer.parseInt(scanner.nextLine());

                vendaInsert(idVenda, qtdVendida, codComp, matVende);
            } else if (opcao == 2) {
                System.out.print("Inserir Id da Venda: ");
                int idVenda = Integer.parseInt(scanner.nextLine());
                System.out.print("Inserir Quantidade Vendida: ");
                int qtdVendida = Integer.parseInt(scanner.nextLine());

                vendaUpdate(idVenda, qtdVendida);
            } else if (opcao == 3) {
                System.out.print("Inserir Id da Venda: ");
                int idVenda = Integer.parseInt(scanner.nextLine());

                vendaDelete(idVenda);
            } else if (opcao == 4) {
                showAllVendas();
            }
        } while (opcao >= 1 && opcao < 5);
    }

    public static void vendaInsert(int idVenda, int qtdVendida, int codComp, int matVende) {
        Venda venda = new Venda();
        venda.setIdVenda(idVenda);
        venda.setQtdVendida(qtdVendida);
        venda.setCodComp(codComp);
        venda.setMatVende(matVende);

        VendaDAO vendaDAO = null;
        try{
            vendaDAO = new VendaDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        vendaDAO.cadastrarVenda(venda);
    }

    public static void vendaUpdate(int qtdVendida, int idVenda) {
        Venda venda = new Venda();
        venda.setQtdVendida(qtdVendida);
        venda.setIdVenda(idVenda);
        VendaDAO vendaDAO = null;
        try {
            vendaDAO = new VendaDAO();
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        vendaDAO.updateVenda(venda);
    }
    public static void vendaDelete(int idVenda) {
        Venda venda = new Venda();
        venda.setIdVenda(idVenda);
        VendaDAO vendaDAO = null;
        try {
            vendaDAO = new VendaDAO();
        }  catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        vendaDAO.deleteVenda(venda);
    }

    public static void showAllVendas() {
        VendaDAO vendaDAO = null;
        try {
            vendaDAO = new VendaDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<Venda> listaVendas = vendaDAO.selectAllVendas();
        for (Venda e : listaVendas) {
            System.out.println("---------------------------------------------");
            System.out.print(" ID_VENDA: " + e.getIdVenda());
            System.out.print(" QTD_VENDIDA: " + e.getQtdVendida());
            System.out.print(" COD_COMP: " + e.getCodComp());
            System.out.println(" MAT_VENDE: " +e.getMatVende());
        }
    }
}
