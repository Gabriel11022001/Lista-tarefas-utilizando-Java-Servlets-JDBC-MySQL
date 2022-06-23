package br.com.gabriel.listatarefas.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.gabriel.listatarefas.entidades.Tarefa;
import br.com.gabriel.listatarefas.utils.Conexao;

public class TarefaService implements IService {

	@Override
	public void salvar(Tarefa tarefa) throws Exception {
		String query = "INSERT INTO tbl_tarefas(tarefa_titulo, tarefa_data_cadastro, tarefa_status)"
				+ "VALUES(?, ?, ?);";
		Connection conexao = Conexao.getConexao();
		PreparedStatement stmt = conexao.prepareStatement(query);
		stmt.setString(1, tarefa.getTitulo());
		stmt.setString(2, tarefa.getDataCadastro().toString());
		stmt.setString(3, tarefa.getStatus());
		stmt.execute();
		conexao.close();
	}
	@Override
	public void remover(Integer id) throws Exception {
		String query = "DELETE FROM tbl_tarefas WHERE tarefa_id = ?;";
		Connection conexao = Conexao.getConexao();
		PreparedStatement stmt = conexao.prepareStatement(query);
		stmt.setInt(1, id);
		stmt.execute();
		conexao.close();
	}
	@Override
	public Tarefa buscarPeloId(Integer id) throws Exception {
		Tarefa tarefa = null;
		String query = "SELECT * FROM tbl_tarefas WHERE tarefa_id = ?;";
		Connection conexao = Conexao.getConexao();
		PreparedStatement stmt = conexao.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			tarefa = new Tarefa();
			tarefa.setId(rs.getInt("tarefa_id"));
			tarefa.setTitulo(rs.getString("tarefa_titulo"));
			tarefa.setStatus(rs.getString("tarefa_status"));
			LocalDate dataCadastro = LocalDate.parse(rs.getString("tarefa_data_cadastro"));
			tarefa.setDataCadastro(dataCadastro);
		}
		if (tarefa == null) {
			throw new Exception("Não existe uma tarefa com o id " + id + " cadastrada no banco de dados!");
		}
		return tarefa;
	}
	@Override
	public List<Tarefa> buscarTodas() throws Exception {
		List<Tarefa> tarefas = new ArrayList<>();
		String query = "SELECT * FROM tbl_tarefas;";
		Connection conexao = Conexao.getConexao();
		PreparedStatement stmt = conexao.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Tarefa tarefa = new Tarefa();
			tarefa.setId(rs.getInt("tarefa_id"));
			tarefa.setTitulo(rs.getString("tarefa_titulo"));
			tarefa.setStatus(rs.getString("tarefa_status"));
			String dataCadastroFormatoTexto = rs.getString("tarefa_data_cadastro");
			LocalDate dataCadastro = LocalDate.parse(dataCadastroFormatoTexto);
			tarefa.setDataCadastro(dataCadastro);
			tarefas.add(tarefa);
		}
		conexao.close();
		if (tarefas.size() == 0) {
			throw new Exception("Não existem tarefas cadastradas no banco de dados!");
		}
		return tarefas;
	}
	@Override
	public void atualizar(Tarefa tarefa) throws Exception {
		
	}
}
