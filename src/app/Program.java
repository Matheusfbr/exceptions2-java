package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Account> list = new ArrayList<>();
		int i = 1;
		do {
			StringBuilder sb = new StringBuilder();
			sb.append("Escolha uma opção: \n");
			sb.append("0 - SAIR\n");
			sb.append("1 - CADASTRAR\n");
			sb.append("2 - SAQUE\n");
			sb.append("3 - Deposito\n");
			System.out.println(sb.toString());
			i = sc.nextInt();
			
			Account ac = new Account();
			
			switch (i) {
			case (1):
				try {
				System.out.println("Entre com os dados da conta: ");
				System.out.print("Número: ");
				Integer number = sc.nextInt();
				System.out.print("Proprietário: ");
				sc.nextLine();
				String holder = sc.nextLine();
				System.out.print("Saldo inicial: ");
				Double balance = sc.nextDouble();
				System.out.print("Limite de saque: ");
				Double withdrawLimit = sc.nextDouble();
				list.add(new Account(number, holder, balance, withdrawLimit));
				} catch(NullPointerException e) {
					System.out.println("Saldo insuficiente!");
				}
			case (2):
				System.out.print("Entre com o valor de saque: ");
				Double amount = sc.nextDouble();
				try {
					ac.withDraw(amount);
					System.out.println("Novo saldo: " + String.format("%.2f", ac.getBalance()));
				} catch (DomainException e) {
					System.out.println("Erro de saque: " + e.getMessage());
				}
			case (3):
				System.out.print("Entre com o valor de deposito: ");
				amount = sc.nextDouble();
				ac.deposit(amount);
			default:
				break;
			}
		} while (i != 0);
		
		System.out.println("Fim");

		sc.close();
	}

}
