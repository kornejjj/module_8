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

        // Отримання максимальних проектів клієнтів
        List<MaxProjectCountClient> maxProjectsClients = queryService.findMaxProjectsClient();
        for (MaxProjectCountClient client : maxProjectsClients) {
            System.out.println("Client Name: " + client.getName() + ", Project Count: " + client.getProjectCount());
        }

        // Отримання найдовшого проекту
        List<String[]> longestProjects = queryService.findLongestProject();
        for (String[] project : longestProjects) {
            System.out.println("Project ID: " + project[0] + ", Month Count: " + project[1]);
        }

        // Отримання працівника з максимальним заробітком
        List<String[]> maxSalaryWorkers = queryService.findMaxSalaryWorker();
        for (String[] worker : maxSalaryWorkers) {
            System.out.println("Worker Name: " + worker[0] + ", Salary: " + worker[1]);
        }

        // Отримання наймолодших і найстарших працівників
        List<String[]> youngestEldestWorkers = queryService.findYoungestEldestWorkers();
        for (String[] worker : youngestEldestWorkers) {
            System.out.println(worker[0] + " Worker Name: " + worker[1] + ", Birthday: " + worker[2]);
        }
    }
}
