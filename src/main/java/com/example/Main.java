package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Ініціалізація бази даних через Flyway
        Database.getInstance(); // Запускає Flyway, який виконає міграції

        ClientService clientService = new ClientService();

        try {
            long clientId = clientService.create("New Client");
            System.out.println("Client created with ID: " + clientId);

            String clientName = clientService.getById(clientId);
            System.out.println("Client name: " + clientName);

            clientService.setName(clientId, "Updated Client");
            System.out.println("Client name updated.");

            List<Client> clients = clientService.listAll();
            for (Client client : clients) {
                System.out.println("Client ID: " + client.getId() + ", Name: " + client.getName());
            }

            clientService.deleteById(clientId);
            System.out.println("Client deleted.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
