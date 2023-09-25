package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnectionBanco;
import model.ModelLogin;

public class DAOUsuarioRepository {

	private Connection connection;

	public DAOUsuarioRepository() {
		connection = SingleConnectionBanco.getConnection();
	}

	public ModelLogin gravarUsuario(ModelLogin modelLogin) throws Exception {

		if (modelLogin.isNovo()) {
			String sql = "INSERT INTO model_login(login, senha, nome, email) VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, modelLogin.getLogin());
			preparedStatement.setString(2, modelLogin.getSenha());
			preparedStatement.setString(3, modelLogin.getNome());
			preparedStatement.setString(4, modelLogin.getEmail());

			preparedStatement.execute();

			connection.commit();
		 }else {
				String sql = "UPDATE model_login SET login=?, senha=?, nome=?, email=? WHERE id = "+modelLogin.getId()+"; ";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				preparedStatement.setString(1, modelLogin.getLogin());
				preparedStatement.setString(2, modelLogin.getSenha());
				preparedStatement.setString(3, modelLogin.getNome());
				preparedStatement.setString(4, modelLogin.getEmail());

				preparedStatement.executeUpdate();

				connection.commit();
		}
		
		return this.consultaUsuario(modelLogin.getLogin());
	}

	public ModelLogin consultaUsuario(String login) throws Exception {

		ModelLogin modelLogin = new ModelLogin();

		String sql = "SELECT * FROM model_login where upper(login) = upper('" + login + "')";

		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {
			modelLogin.setId(resultado.getLong("id"));
			modelLogin.setEmail(resultado.getString("email"));
			modelLogin.setLogin(resultado.getString("login"));
			modelLogin.setSenha(resultado.getString("senha"));
			modelLogin.setNome(resultado.getString("nome"));
		}

		return modelLogin;
	}

	public boolean validarLogin(String login) throws Exception {

		String sql = "select count(1) > 0 as existe from model_login where upper(login) = upper('" + login + "')";

		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet resultado = statement.executeQuery();
		resultado.next();// Para entrar nos resultados do sql

		return resultado.getBoolean("existe");
	}

	public void deletarUser(String idUser) throws Exception{
		String sql = "DELETE FROM model_login WHERE id = ?;";
		
		PreparedStatement preparedSql = connection.prepareStatement(sql);
		preparedSql.setLong(1, Long.valueOf(idUser));
		
		preparedSql.executeUpdate();
		
		connection.commit();
	}

}
