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
        List<LongestProject> longestProjects = queryService.findLongestProject();
        for (LongestProject project : longestProjects) {
            System.out.println(project);
        }

        // Отримання працівника з максимальним заробітком
        List<MaxSalaryWorker> maxSalaryWorkers = queryService.findMaxSalaryWorker();
        for (MaxSalaryWorker worker : maxSalaryWorkers) {
            System.out.println(worker);
        }

        // Отримання наймолодших і найстарших працівників
        List<Worker> youngestEldestWorkers = queryService.findYoungestEldestWorkers();
        for (Worker worker : youngestEldestWorkers) {
            System.out.println(worker);
        }
    }
}
