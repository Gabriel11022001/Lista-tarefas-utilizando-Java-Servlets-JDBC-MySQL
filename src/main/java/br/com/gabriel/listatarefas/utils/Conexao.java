package br.com.gabriel.listatarefas.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public static Connection getConexao() throws Exception {
		String usuarioBancoDados = "root";
		String senhaUsuarioBancoDados = "Gabriel@11022001";
		String bancoDados = "db_lista_tarefas";
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + bancoDados, usuarioBancoDados, senhaUsuarioBancoDados);
	}
}
