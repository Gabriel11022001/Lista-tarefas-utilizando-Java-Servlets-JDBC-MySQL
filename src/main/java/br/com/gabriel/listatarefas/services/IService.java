package br.com.gabriel.listatarefas.services;

import java.util.List;

import br.com.gabriel.listatarefas.entidades.Tarefa;

public interface IService {

	void salvar(Tarefa tarefa) throws Exception;
	void remover(Integer id) throws Exception;
	Tarefa buscarPeloId(Integer id) throws Exception;
	List<Tarefa> buscarTodas() throws Exception;
	void atualizar(Tarefa tarefa) throws Exception;
}
