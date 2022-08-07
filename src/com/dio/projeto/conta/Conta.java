package com.dio.projeto.conta;

import com.dio.projeto.conta.implementacao.ContaGenerica;

public interface Conta {
	void sacar(int valor);
	void depositar(int valor);
	void transferir(int valor, ContaGenerica conta);
	void Extrato();
}
