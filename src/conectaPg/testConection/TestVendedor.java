package conectaPg.testConection;

import conectaPg.DAO.VendedorDAO;
import conectaPg.entities.Vendedor;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TestVendedor {
    public static void main(String[] args) {
        int opcao = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\n1. Insere Vendedor\n2. Atualiza Vendedor\n" +
                    "3. Deleta Vendedor\n4. Exibe Vendedores\nOpção: ");
            opcao = Integer.parseInt(scanner.nextLine());
            if (opcao == 1) {
                System.out.print("Inserir Matricula do Vendedor: ");
                int matricula = Integer.parseInt(scanner.nextLine());
                System.out.print("Inserir Nome do Vendedor: ");
                String nome = scanner.nextLine();

                vendedorInsert(matricula, nome);
            } else if (opcao == 2) {
                System.out.print("Inserir Matricula do Vendedor: ");
                int matricula = Integer.parseInt(scanner.nextLine());
                System.out.print("Inserir Nome do Vendedor: ");
                String nome = scanner.nextLine();

                vendedorUpdate(matricula, nome);
            } else if (opcao == 3) {
                System.out.print("Inserir Matricula do Vendedor: ");
                int matricula = Integer.parseInt(scanner.nextLine());

                vendedorDelete(matricula);
            } else if (opcao == 4) {
                vendedorShow();
            }
        } while (opcao >= 1 && opcao < 5);
    }

    public static void vendedorInsert(int matricula, String nome) {
        Vendedor vendedor = new Vendedor();
        vendedor.setMatricula(matricula);
        vendedor.setNome(nome);
        VendedorDAO vendedorDAO = null;
        try {
            vendedorDAO = new VendedorDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        vendedorDAO.cadastrarVendedor(vendedor);
    }
    public static void vendedorUpdate(int matricula, String nome) {
        Vendedor vendedor = new Vendedor();
        vendedor.setMatricula(matricula);
        vendedor.setNome(nome);
        VendedorDAO vendedorDAO = null;
        try {
            vendedorDAO = new VendedorDAO();
        } catch (SQLException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        vendedorDAO.updateVendedor(vendedor);
    }

    public static void vendedorDelete(int matricula) {
        Vendedor vendedor = new Vendedor();
        vendedor.setMatricula(matricula);
        VendedorDAO vendedorDAO = null;
        try {
            vendedorDAO = new VendedorDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        vendedorDAO.deleteVendedor(vendedor);
    }
    public static void  vendedorShow() {
        VendedorDAO vendedorDAO =null;
        try {
            vendedorDAO = new VendedorDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<Vendedor> listaShowAll = vendedorDAO.selectAll();
        for(Vendedor e:listaShowAll) {
            System.out.println("---------------------------------------------");
            System.out.print("MATRICULA: " + e.getMatricula());
            System.out.println("NOME: " + e.getNome());
        }
    }
}
