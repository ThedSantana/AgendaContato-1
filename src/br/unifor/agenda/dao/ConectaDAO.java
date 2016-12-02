package br.unifor.agenda.dao;
import java.sql.*;

/**
 * @author Maikon Albuquerque
 */

public class ConectaDAO {
    
    //Método responsável por estabelecer conexnao com o banco.
    public static Connection conector(){
        java.sql.Connection conexao = null;
        // linha abaixo chama o driver
        String driver = "org.postgresql.Driver";
        // armazenando informações referentes ao banco.
        String url = "jdbc:postgresql://localhost:5433/agendb";
        String user = "postgres";
        String password = "a"; 
        // Estabelecendo a conexão com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            //esclarecer erro
            //System.out.println(e);
            return null;
        }
    }
    
}
