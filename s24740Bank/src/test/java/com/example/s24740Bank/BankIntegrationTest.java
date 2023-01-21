package com.example.s24740Bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class BankIntegrationTest {

    @Autowired
    private BankService bankService;

    @MockBean
    private BankStorage bankStorage;

    @MockBean
    private ClientStorage clientStorage;

    @Test
    void ifThereIsClients() {
        Client client = new Client("Kamil","Powierza");
        when(clientStorage.getClientList()).thenReturn(List.of(client));
        List<Client> clientList = bankService.getAllClients();
        assertThat(clientList).isNotNull();
    }

    @Test
    void ifThereIsClientRegistered() {
        Client client = new Client("Piotr","Wawrzyniak");
        when(bankStorage.getBankerList()).thenReturn(List.of(new Banker(client, 3000.00 , "ACCEPTED", 1)));
        List<Banker> helperList = bankService.getAllBankers();
        assertThat(helperList).isNotNull();
    }

}
