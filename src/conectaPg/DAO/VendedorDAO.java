package conectaPg.DAO;

import conectaPg.testConection.Conecta;
import conectaPg.entities.Vendedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAO {
    private Connection con;

    public VendedorDAO() throws SQLException, ClassNotFoundException {
        con = Conecta.criarConexao();
    }
    public void cadastrarVendedor(Vendedor vend) {
        String sql = "INSERT INTO vendedor(matricula, nome) VALUES(?, ?)";

        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, vend.getMatricula());
            preparador.setString(2, vend.getNome());

            preparador.execute();
            preparador.close();

            System.out.println("Inserção Realizada!");
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }
    public void updateVendedor(Vendedor vend) {
        String sql = "UPDATE vendedor SET nome = ? WHERE matricula = ?";
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1, vend.getNome());
            preparador.setInt(2, vend.getMatricula());

            preparador.execute();
            preparador.close();

            System.out.println("Alteração Realizada");
        } catch (SQLException e){
            System.out.println("ERRO - " + e.getMessage());
        }
    }
    public void deleteVendedor(Vendedor vend) {
        String sql = "DELETE FROM vendedor WHERE matricula = ?";
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1,vend.getMatricula());

            preparador.execute();
            preparador.close();
            System.out.println("Deleção realizada!");
        }catch (SQLException e) {
            System.out.println("ERRO - " + e.getMessage());
        }
    }

    public List<Vendedor> selectAll(){
        String sql = "SELECT * FROM vendedor";
        List<Vendedor> lista = new ArrayList<>();
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            ResultSet resultados = preparador.executeQuery();
            while (resultados.next()) {
                Vendedor vendedor2 = new Vendedor();
                vendedor2.setMatricula(resultados.getInt("matricula"));
                vendedor2.setNome(resultados.getString("nome"));
                lista.add(vendedor2);
            }
        } catch (SQLException e) {
            System.out.println("ERRO - " + e.getMessage());
        }
        return lista;
    }
}
