package entidade;

import java.util.Scanner;

public class Conta {
	
	Scanner tc = new Scanner(System.in);
	private double saldo;
	private String titular;

	public Conta(String titular) {
		System.out.println("Conta criada com sucesso...");
		this.titular = titular;
	}

	public Conta(double saldoInicial, String titular) {
		System.out.println("Conta criada com sucesso...");
		depositar(saldoInicial);
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void depositar(double valor) {
		this.saldo += valor;
	}

	public void sacar(double valor) {
		while (verificaSaldo(valor) == true) {
			System.out.print("Digite novamente o valor desejado: R$ ");
			valor = tc.nextDouble();
		}
		this.saldo -= valor;
	}

	private boolean verificaSaldo(double valor) {

		if (this.saldo < valor) {
			System.out.print("Você nao possui saldo suficiente para realizar essa transação...");
			return true;
		} else {
			return false;
		}
	}

	public void transfereConta(Conta destino, double valor) {
		while (true) {

			if (verificaSaldo(valor) == false) {
				this.saldo -= valor;
				destino.saldo += valor;
				System.out.println("Transferencia realizada com sucesso...");
				System.out.println("Saldo: R$ " + getSaldo());
				System.out.println("Digite outro valor para transferencia: R$ ");
				valor = tc.nextDouble();

			} else {
				System.out.println("Saldo negativo.... Transferencia não realizada!");
				break;
			}
		}
	}

	@Override
	public String toString() {
		return "Conta saldo: R$" + saldo + ", Titular:" + titular;
	}

}
