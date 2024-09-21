package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Ініціалізація бази даних
        DatabaseInitService.main(args);

        // Наповнення бази даних
        DatabasePopulateService.main(args);

        // Приклад використання запитів
        DatabaseQueryService queryService = new DatabaseQueryService();

        // Виклик методів для отримання даних
        List<MaxProjectCountClient> maxProjectsClients = queryService.findMaxProjectsClient();

        // Вивід результатів
        for (MaxProjectCountClient client : maxProjectsClients) {
            System.out.println("Client Name: " + client.getName() + ", Project Count: " + client.getProjectCount());
        }
    }
}


