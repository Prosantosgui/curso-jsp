package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBanco {

	private static String urlBanco = "jdbc:postgresql://localhost:5432/curso-jsp?autoReconnect=true";
	private static String user = "postgres";
	private static String password = "admin";
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	public SingleConnectionBanco() {//Quando tiver uma instancia vai conectar
		conectar();
	}
	
	private static void conectar() {
		try {
			
			if (connection == null) {
				Class.forName("org.postgresql.Driver");//Carrega o drive de conexão do banco
				connection = DriverManager.getConnection(urlBanco, user, password);
				connection.setAutoCommit(false);//Para não efetuar alterações no banco sem nosso comando
				System.out.println("Conectou com sucesso!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
