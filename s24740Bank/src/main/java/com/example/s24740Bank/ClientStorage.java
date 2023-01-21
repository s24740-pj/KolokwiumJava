package com.example.s24740Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientStorage {
    private List<Client> clientList = new ArrayList<>();

    public List<Client> getClientList() {
        return clientList;
    }

    public void addClient(Client client){
        clientList.add(client);
    }
}
