package com.example.s24740Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S24740BankApplication {

	private final BankService bankService;

	public S24740BankApplication(BankService bankService) {
		this.bankService = bankService;

		//Register klienta o swoim saldzie i o danym id
		System.out.println(bankService.registerUser(new Client("Kamil", "Powierza"), 2000.00, "ACCEPTED", 1));

		//Przelew danego klienta o danym id z poprawna iloscia pieniedzy
		System.out.println(bankService.removeSaldoOfId(1, 229.99));

		//Przelew danego klienta o danym id jezeli nie mamy wystarczajaco pieniedzy na koncie
		System.out.println(bankService.removeSaldoOfId(1, 2290.99));

		//Wplacamy pieniadze do danego klienta o danym id
		System.out.println(bankService.addToSaldoOfId(1, 200.99));

		//Odczytanie klienta o danym id
		System.out.println(bankService.getBankerOfId(1));
	}

	public static void main(String[] args) {
		SpringApplication.run(S24740BankApplication.class, args);
	}

}
