package com.grupo10.despensa.service;

import com.grupo10.despensa.entity.Client;
import com.grupo10.despensa.entity.Product;
import com.grupo10.despensa.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
public class ClientServiceImpl {

    @Autowired
    private ClientRepository clientRepository;

    @Value("${despensa.max.shoppingCart.size}")
    private int maxCartSize;

    @PersistenceContext
    private EntityManager clientManager;

    public Iterable<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    public void removeClient(Client client) {
        clientRepository.delete(client);
    }

    public Client getById(Integer id) {
        Client client = new Client();
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            client = clientOptional.get();
        }
        return client;
    }
//REVISAR!!!!
    //Si es posible llevar a cabo la compra se devuelve el producto comprado
    public Product buyProduct(Product product, Client client) throws Exception {
        int dailyBuys = dailyBuysOf(client);
        if (client.getShoppingCart().size() > maxCartSize) {
            client.getShoppingCart().add(product);
            persistBuy(client);
            clientRepository.save(client);
        } else {
            throw new Exception("Lo sentimos, ya no podemos venderte más productos por hoy");
        }
        return product;
    }

    private int dailyBuysOf(Client client) {

        //Traer las compras del cliene de las 00:00 en adelante
        //clientManager.createQuery("select count(client) from client where client.buys");
        return 0;
    }

    private int persistBuy(Client client) {
       /* Client clientOptional = clientRepository.findById(client.getIdClient()).get();
        int buys = clientOptional.getBuysOfToday();
        buys += 1;
        client.setBuysOfToday(buys);
        clientRepository.save(client);
        return buys;*/
        return 0;
    }
}
