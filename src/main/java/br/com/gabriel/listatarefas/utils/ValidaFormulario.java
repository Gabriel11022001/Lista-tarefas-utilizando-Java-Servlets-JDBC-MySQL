package br.com.gabriel.listatarefas.utils;

public class ValidaFormulario {

	public static Boolean validarFormulario(String titulo) throws Exception {
		if (titulo.isEmpty()) {
			return false;
		}
		return true;
	}
	public static Boolean validarFormularioAtualizarTarefa(String titulo, String status) throws Exception {
		if (titulo.isEmpty() || status.isEmpty()) {
			return false;
		}
		return true;
	}
}
