package com.example.s24740Bank;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankService {

    private final ClientStorage clientStorage;
    private final BankStorage bankStorage;

    public BankService(ClientStorage clientStorage, BankStorage bankStorage) {
        this.clientStorage = clientStorage;
        this.bankStorage = bankStorage;
    }

    public Banker registerUser(Client client, double saldo, String status, int id){
        //Dodajemy client do Storage
        clientStorage.addClient(client);
        //Dodajemy wszystko do BankStorage
        bankStorage.addBanker(new Banker(client, saldo, status, id));
        //Zwracamy ten register
        return bankStorage.getBankerById(id);
    }

    public Banker removeSaldoOfId(int id, double removeSaldo){
        return bankStorage.removeSaldoOfId(id, removeSaldo);
    }

    public Banker addToSaldoOfId(int id, double addSaldo){
        return bankStorage.addToSaldoOfId(id, addSaldo);
    }

    public Banker getBankerOfId(int id){
        return bankStorage.getBankerOfId(id);
    }

    public List<Client> getAllClients(){
        return clientStorage.getClientList();
    }

    public List<Banker> getAllBankers(){
        return bankStorage.getBankerList();
    }

    public String getBankerStatusOfId(int id){
        return bankStorage.getBankerStatusOfId(id);
    }

    public String setBankerStatusOfId(int id, String status){
        return bankStorage.setBankerStatusOfId(id, status);
    }

    public double getBankerSaldoOfId(int id){
        return bankStorage.getBankerSaldoOfId(id);
    }

}
