package com.example.s24740Bank;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BankTests {

    private BankService bankService = new BankService(new ClientStorage(), new BankStorage());

    @Test
    void ifThereIsChangesInStatus() {
        //Test na to czy zmienia sie status
        Client client = new Client("Piotr","Wawrzyniak");
        double saldo = 1000.00;
        String status = "ACCEPTED";
        int id = 1;

        bankService.registerUser(client, saldo, status, id);

        String status1 = bankService.getBankerStatusOfId(id);

        bankService.setBankerStatusOfId(id, "DECLINED");

        String status2 = bankService.getBankerStatusOfId(id);

        assertThat(status1).isNotEqualTo(status2);
    }

    @Test
    void ifThereIsChangesInSaldoAfterValidCashout() {
        //Test na to czy poprawnie wyplacamy pieniadze
        Client client = new Client("Piotr","Wawrzyniak");
        double saldo = 1000.00;
        String status = "ACCEPTED";
        int id = 2;
        bankService.registerUser(client, saldo, status, id);

        double saldo1 = bankService.getBankerSaldoOfId(id);

        bankService.removeSaldoOfId(id, 200);

        double saldo2 = bankService.getBankerSaldoOfId(id);

        assertThat(saldo1).isNotEqualTo(saldo2);
    }

    @Test
    void ifThereIsChangesInSaldoAfterNotValidCashout() {
        //Test na to czy status sie zmieni na declined w trakcie gdy nie posiadamy danej ilosci srodkow na koncie
        Client client = new Client("Piotr","Wawrzyniak");
        double saldo = 1000.00;
        String status = "ACCEPTED";
        int id = 3;
        bankService.registerUser(client, saldo, status, id);

        String status1 = bankService.getBankerStatusOfId(id);

        bankService.removeSaldoOfId(id, 1200);

        String status2 = bankService.getBankerStatusOfId(id);

        assertThat(status1).isNotEqualTo(status2);
    }



}
