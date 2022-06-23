package br.com.gabriel.listatarefas.utils;

public class ValidaFormulario {

	public static Boolean validarFormulario(String titulo) throws Exception {
		if (titulo.isEmpty()) {
			return false;
		}
		return true;
	}
}
