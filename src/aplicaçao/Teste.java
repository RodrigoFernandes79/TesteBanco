package aplica�ao;

import java.util.Scanner;

import entidade.Conta;

public class Teste {

	public static void main(String[] args) {
		/*
		 * Altere: O m�todo sacar para testar se existe saldo dispon�vel na conta;
		 * Altere tamb�m o retorno desse m�todo para boolean. Crie duas contas
		 * distintas: ContaPessoaA e ContaPessoaB;Ap�s a cria��o acima, desenvolva
		 * transfer�ncias entre as contas, at� uma das contas ficar sem saldo dispon�vel
		 * e imprima no console uma mensagem de erro, informando a falta de saldo da
		 * conta). OBS: Tudo isso deve ser desenvolvido dentro de um while(true) [loop
		 * infinito] Criar m�todo para mostrar o saldo da conta.
		 */
		Scanner tcInt = new Scanner(System.in);
		Scanner tcStr = new Scanner(System.in);
		Conta c1;
		Conta c2;

		System.out.print("Nome do titular: ");
		String titular = tcStr.nextLine();

		System.out.print("Deseja Fazer um deposito inicial? s/n?");
		char resposta = tcStr.next().charAt(0);
		if (resposta == 's') {
			System.out.print("Digite o valor do deposito: R$ ");
			double saldoInicial = tcInt.nextDouble();
			c1 = new Conta(saldoInicial, titular);
		} else {
			c1 = new Conta(titular);
		}
		System.out.println("Conta 1: "+c1);

		System.out.print("Qual o valor a depositar? R$ ");
		double valor = tcInt.nextDouble();
		c1.depositar(valor);
		System.out.println("Transa��o realizada com sucesso!seu saldo � de R$ " + c1.getSaldo());

		System.out.print("Qual o valor do saque? R$ ");
		valor = tcInt.nextDouble();
		c1.sacar(valor);
		System.out.println("Transa��o realizada com sucesso!seu saldo � de R$ " + c1.getSaldo());

		c2 = new Conta(titular);
		System.out.println("Conta 2: "+c2);
		System.out.print("Qual o valor que deseja realizar a transferencia? R$ ");
		valor = tcInt.nextDouble();
		c1.transfereConta(c2, valor);
		System.out.println("O saldo da conta 1 � de R$ " + c1.getSaldo());
		System.out.println("O saldo da conta 2 � de R$ " + c2.getSaldo());

	}

}
