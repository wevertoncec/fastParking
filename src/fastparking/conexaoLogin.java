package fastparking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexaoLogin {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/entrar";
    Connection con = null;
    Statement stat = null;
    ResultSet rs;

    public void conectar(){
        try{
            //Carrega classe de driver do Banco de Dados
            Class.forName(JDBC_DRIVER);
            //Estabelece conexão com o banco de dados
            con = DriverManager.getConnection(DATABASE_URL,"root","102030");
            //Criar Stament para consultar banco de dados
            stat = con.createStatement();
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        catch(ClassNotFoundException classNotFound){
            classNotFound.printStackTrace();
        }
    }

    public ResultSet Consulta(String texto) throws SQLException{
        ResultSet rs = null;
        //Consulta o banco de dados
        rs = stat.executeQuery(texto);
        return rs;
    }

    public void Atualiza(String texto) throws SQLException{
        //Inserir no banco de dados
        stat.executeUpdate(texto);
    }

    public void Exit() throws SQLException{
         stat.close();
         con.close();
    }
}
