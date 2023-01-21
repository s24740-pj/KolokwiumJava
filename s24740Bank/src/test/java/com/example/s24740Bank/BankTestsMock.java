package com.example.s24740Bank;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class BankTestsMock {

    @InjectMocks
    private BankService bankService;
    @Mock
    private BankStorage bankStorage;
    @Mock
    private ClientStorage clientStorage;

    @Test
    void ifThereisClientsMock() {
        //Test czy sa klienci
        Client client = new Client("Marek","Mostowiak");
        when(clientStorage.getClientList()).thenReturn(List.of(client));
        assertThat(bankService.getAllClients()).isNotEmpty();
    }

    @Test
    void ifThereisBankersMock() {
        //Test czy sa Bankery
        Client client = new Client("Jozef","Wybicki");
        Banker banker = new Banker(client, 2000.00, "ACCEPTED", 1);
        when(bankStorage.getBankerList()).thenReturn(List.of(banker));
        assertThat(bankService.getAllBankers()).isNotEmpty();
    }

}
