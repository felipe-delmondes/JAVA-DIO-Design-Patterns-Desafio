package com.dio.projeto.conta.implementacao;

import com.dio.projeto.cliente.Cliente;
import com.dio.projeto.conta.Conta;

//Pensei no sequencial como único independente do tipo de conta.
//A obrigação de assinar o contrato conta faz essa classe se adequar no padrão de projetos Strategy.
public abstract class ContaGenerica implements Conta {
	private static int proximaConta = 1;
	private int agencia;
	private int conta;
	private int saldo;
	private String tipoConta;
	private Cliente cliente;
	
	public int getAgencia() {
		return agencia;
	}

	public int getConta() {
		return conta;
	}

	public int getSaldo() {
		return saldo;
	}
	
	public String getTipoConta() {
		return tipoConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public ContaGenerica(Cliente cliente, int agencia, int saldo, String tipoConta) {
		
		this.agencia = agencia;
		this.conta = proximaConta++;
		this.saldo = saldo;
		this.tipoConta = tipoConta;
		this.cliente = cliente;
		
		System.out.println("======================================");
		System.out.println("Criação de " + this.getTipoConta());
		System.out.println(String.format("Cliente %s %s, Chave PIX %s", cliente.getNome(),cliente.getSobrenome(), cliente.getChavePIX()));
		System.out.println(String.format("Agencia %d, Conta %d", this.getAgencia(), this.getConta()));
		System.out.println(String.format("Saldo Inicial R$%d", this.getSaldo()));
	}
	
	@Override
	public void Extrato() {
		System.out.println("======================================");
		System.out.println("Extrato de " + this.getTipoConta());
		System.out.println(String.format("Cliente %s %s, Chave PIX %s", cliente.getNome(),cliente.getSobrenome(), cliente.getChavePIX()));
		System.out.println(String.format("Agencia %d, Conta %d", this.getAgencia(), this.getConta()));
		System.out.println(String.format("Saldo %d", this.getSaldo()));
	}

	
	private void sacar(int valor, boolean supressMessages) {
		if (valor > 0) {
			this.saldo -= valor;
			if(!supressMessages) {
				System.out.println("======================================");
				System.out.println(this.getCliente().getNome()+" o Saque de R$"+ valor +" foi bem sucedido.");
				System.out.println(this.getCliente().getNome()+" o Saldo na conta é R$" + this.getSaldo());
			}
		}
		else {
			System.out.println("======================================");
			System.out.println(this.getCliente().getNome()+" o Valor informado para Saque deve ser maior que R$0.");
		}
		
	}
	
	@Override
	public void sacar(int valor) {
		if (valor > 0) {
			this.saldo -= valor;
				System.out.println("======================================");
				System.out.println(this.getCliente().getNome()+" o Saque de R$"+ valor +" foi bem sucedido.");
				System.out.println(this.getCliente().getNome()+" o Saldo na conta é R$" + this.getSaldo());
		}
		else {
			System.out.println("======================================");
			System.out.println(this.getCliente().getNome()+" o Valor informado para Saque deve ser maior que R$0.");
		}
		
	}


	
	private void depositar(int valor, boolean supressMessages) {
		
		if (valor > 0) {
			this.saldo += valor;
			if(!supressMessages) {
				System.out.println("======================================");
				System.out.println(this.getCliente().getNome()+ " o Deposito de R$"+ valor +" foi bem sucedido.");
				System.out.println(this.getCliente().getNome()+ " o Saldo na conta é R$" + this.getSaldo());
			}
		}
		else {
			System.out.println("======================================");
			System.out.println(this.getCliente().getNome()+ " o Valor informado para Deposito deve ser maior que R$0.");
		}
		
		
	}
	
	@Override
	public void depositar(int valor) {
		
		if (valor > 0) {
			this.saldo += valor;
				System.out.println("======================================");
				System.out.println(this.getCliente().getNome()+ " o Deposito de R$"+ valor +" foi bem sucedido.");
				System.out.println(this.getCliente().getNome()+ " o Saldo na conta é R$" + this.getSaldo());
		}
		else {
			System.out.println(this.getCliente().getNome()+ " o Valor informado para Deposito deve ser maior que R$0.");
		}
		
		
	}

	@Override
	public void transferir(int valor, ContaGenerica conta) {
		
		if (valor > 0) {
			this.sacar(valor,true);
			conta.depositar(valor,true);
			System.out.println("======================================");
			System.out.println(this.getCliente().getNome()+ " a transferência de R$"+ valor +" para "+conta.getCliente().getNome()+" foi bem sucedida.");
		}
		else {
			System.out.println("======================================");
			System.out.println(this.getCliente().getNome()+ " o Valor informado deve ser maior que R$0.");
		}
	}

	@Override
	public String toString() {
		return "Informações da onta \nAgencia=" + agencia + "\nConta=" + conta + "\nSaldo=" + saldo + "\nTipo de Conta=" + tipoConta
				+ "\nCliente=" + cliente;
	}
	
}
