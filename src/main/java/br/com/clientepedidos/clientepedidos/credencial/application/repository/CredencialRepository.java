package br.com.clientepedidos.clientepedidos.credencial.application.repository;


import br.com.clientepedidos.clientepedidos.credencial.domain.Credencial;

public interface CredencialRepository {
	Credencial salva(Credencial credencial);
	Credencial buscaCredencialPorUsuario(String usuario);
}
