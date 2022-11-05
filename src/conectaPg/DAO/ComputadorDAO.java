package conectaPg.DAO;

import conectaPg.entities.Computador;
import conectaPg.testConection.Conecta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputadorDAO {

    private Connection con;

    public ComputadorDAO() throws SQLException, ClassNotFoundException {
        con = Conecta.criarConexao();
    }

    public void cadastrarComputador(Computador comp) {
        String sql = "INSERT INTO computador(codComputador, Descricao, Qtd)VALUES(?,?,?)";
        /*? valor a ser substituido no INSERT*/
        try {
            PreparedStatement preaparador = con.prepareStatement(sql);
            preaparador.setInt(1, comp.getCodComputador());
            preaparador.setString(2, comp.getDescricao());
            preaparador.setInt(3, comp.getQtd());
            preaparador.execute();
            preaparador.close();
            System.out.println("Inserção Realizada!");
        } catch (SQLException e) {
            System.out.println("ERR - " + e.getMessage());
        }
    }
    public void updateComputador(Computador comp) {
        String sql = "UPDATE computador SET qtd = ? WHERE codComputador = ?";

        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, comp.getQtd());
            preparador.setInt(2, comp.getCodComputador());

            preparador.execute();
            preparador.close();

            System.out.println("Alteração Realizada");
       }catch (SQLException e) {
           System.out.println("ERRO - " + e.getMessage());
       }
    }
    public void deleteComputador(Computador comp) {
        String sql = "DELETE FROM computador WHERE codComputador = ?";
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1,comp.getCodComputador());

            preparador.execute();
            preparador.close();
            System.out.println("Deleção realizada!");
        }catch (SQLException e){
            System.out.println("ERRO - " + e.getMessage());
        }
    }
    public List<Computador> selectAllcomputers() {
        String sql = "SELECT * FROM computador";
        List<Computador> listaC = new ArrayList<Computador>();
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            ResultSet resultados = preparador.executeQuery();
            while (resultados.next()) {
                Computador computador2 = new Computador();
                computador2.setCodComputador(resultados.getInt("CodComputador"));
                computador2.setQtd(resultados.getInt("Qtd"));
                computador2.setDescricao(resultados.getString("Descricao"));
                listaC.add(computador2);
            }
        }catch (SQLException e) {
            System.out.println("ERRO - " + e.getMessage());
        }
        return listaC;
    }
}
