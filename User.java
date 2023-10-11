// Importacao da API de SQL (Banco de Dados)
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;

/**
 * A classe User representa um usuário e fornece métodos para conectar a um banco de dados MySQL
 * e verificar um usuário com base em login e senha.
 */
public class User {
    /**
    Metodo de realizar a conexao com o Banco De Dados 
    **/
    public Connection conectarBD(){
        /** 
        Instancia uma classe puxada da API inicialmente como nula 
        **/
        Connection conn = null;
        /** 
        Realiza a tentativa de fazer a conexao com o banco de dados e assim retornar uma conexao real 
        **/
        try {
            Class.forName("com.mysql.Driver.Manager").newInstance(); // Seta o nome da classe e tenta instanciar
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123"; // Seta uma variavel de nome url com o parametro a frente dela
            conn = DriverManager.getConnection(url); // Tenta realizar a conexao com a variavel setada acima
        } catch (Exception e) { 
            /** 
            Lanca a excecao caso nao consiga fazer a conexao 
            **/ 
            }
        return conn; // Retorna a conexao com o url setado na variavel "url" caso nao consiga continua sendo nula
    }
    public String nome =""; /** Variavel nome setada vazia incialmente **/
    public boolean result = false; /** Variavel result setada falsa incialmente **/
    /** 
    Metodo para verificar se o usuario for valido 
    **/
    public boolean verificarUsuario(String login, String senha){ 
        String sql = ""; // Seta uma variavel de nome sql para vazio incialmente
        Connection conn = conectarBD(); // Instancia a classe conn e tenta fazer a conexao com o metodo criado acima
        /** 
        Faz a linha de comando que vai ser enviada no sql para verificar se existe um usuario com login e senha iguais
        **/
        sql += "select nome from usuarios "; 
        sql += "where login = " + "'" + login + "'";
        sql += "and senha = " + "'" + senha + "'";
        /** 
        Realiza a tentativa de criar uma conexao com o Banco de Dados (Statement) e executar uma linha de comando em SQL para achar um usuario (Query)
        **/
        try {
            Statement st = conn.createStatement(); // Faz a conexao com o Banco de Dados
            ResultSet rs = st.executeQuery(sql); // Executa a Query salva na variavel "sql" feita anteriormente
            /** 
            Faz uma verificacao se ele conseguiu executar a Query dentro da conexao com o Banco de Dados e retornou algo
            **/
            if(rs.next()){ // Se ResultSet tiver algo na proxima fase ele cai dentro do IF
                result = true; // Seta o result que anteriormente era "false" para "true"
                nome = rs.getString("nome");} // Retorna o nome que foi localizado apos rodar a Query dentro do Banco De Dados
            } catch (Exception e) { 
            /** 
            Lanca a excecao caso rode a Query no Banco de Dados e nao retorne nada no nome 
            **/
            }   
        return result; // Por fim retorna o result sendo "true" caso de certo a conexao com o banco de dados e rode a Query e ache o nome e "false" se nao achar nada ou a conexao nao funcionar
    }
}