package conectaPg.DAO;

import conectaPg.testConection.Conecta;
import conectaPg.entities.Venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {
    private Connection con;

    public VendaDAO() throws SQLException, ClassNotFoundException {
        con = Conecta.criarConexao();
    }
    public void cadastrarVenda(Venda venda) {
        String sql = "INSERT INTO venda(idVenda, qtdVendida, codComp, matVend) VALUES(?, ?, ?, ?)";
        System.out.println(sql);
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, venda.getIdVenda());
            preparador.setInt(2, venda.getQtdVendida());
            preparador.setInt(3,venda.getCodComp());
            preparador.setInt(4,venda.getMatVende());
            System.out.println(preparador);

            preparador.execute();
            preparador.close();

            System.out.println("Inserção Realizada!");
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }

    public void updateVenda(Venda venda) {
        String sql = "UPDATE venda SET qtdVendida = ? WHERE idVenda = ?";

        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, venda.getQtdVendida());
            preparador.setInt(2, venda.getIdVenda());

            preparador.execute();
            preparador.close();

            System.out.println("Alteração realizada!");
        }catch (SQLException e) {
            System.out.println("ERRO - " + e.getMessage());
        }
    }

    public void deleteVenda(Venda venda) {
        String sql = "DELETE FROM venda WHERE idVenda = ?";
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, venda.getIdVenda());

            preparador.execute();
            preparador.close();
            System.out.println("Deleção realizada!");
        }catch (SQLException e) {
            System.out.println("ERROR - " + e.getMessage());
        }
    }
    public List<Venda> selectAllVendas(){
        String sql = "SELECT * FROM venda";
        List<Venda> listaA = new ArrayList<Venda>();
        try {
            PreparedStatement preaparador = con.prepareStatement(sql);
            ResultSet resultados = preaparador.executeQuery();
            while (resultados.next()) {
                Venda venda2 = new Venda();
                venda2.setIdVenda(resultados.getInt("idVenda"));
                venda2.setQtdVendida(resultados.getInt("QtdVendida"));
                venda2.setCodComp(resultados.getInt("CodComp"));
                venda2.setMatVende(resultados.getInt("MatVend"));
                listaA.add(venda2);
            }
        }catch (SQLException e) {
            System.out.println("ERRO - " + e.getMessage());
        }
        return listaA;
    }
}
