package com.dio.projeto;

import com.dio.projeto.banco.Banco;
import com.dio.projeto.banco.Instituicao;
import com.dio.projeto.cliente.Cliente;

public class Main {

	public static void main(String[] args) {
		
		
		int agencias[] = {1,2,3,4,5,6,7,8,9,10};
		
		Banco Bradesco = new Banco("Bradesco",agencias);
		
		//Singleton
		//Tratando a Instituição como Singleton.
		//Só existirá uma, e ela se auto instância.
		//Facade
		//A instituição facilita as operações para o caixa eletrônico.
		Instituicao instituicao = Instituicao.getInstancia();
		instituicao.setBanco(Bradesco);
		
		//Primeira Sessão do caixa eletrônico.
		instituicao.novoCliente("Felipe", "Delmondes Aires de Brito", 6, 500);
		instituicao.depositar(20);
		instituicao.Extrato();
		
		//Segunda Sessão do caixa eletrônico.
		instituicao.novoCliente("Steve", "Jobs", 3, 3000);
		instituicao.Extrato();
				
		//Terceira Sessão do caixa eletrônico.
		instituicao.novoCliente("Stephen", "Hawking", 7, 900);
		//Stephen transfere R$ para Agência 6 conta 1 (Para o Felipe)!
		instituicao.transferir(6,1,50);
		instituicao.Extrato();
		
		//Consulta o extrato do Felipe Novamente.
		instituicao.loginCliente(6, 1);
		instituicao.Extrato();

		//O Super Manager imprime a lista de clientes para uma auditoria Interna
		instituicao.clientes();
		
		

	}

}
