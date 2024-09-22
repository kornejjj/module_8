package com.example;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();
        try {
            String sql = new String(Files.readAllBytes(Paths.get("sql/find_max_projects_client.sql")));
            Connection conn = Database.getInstance().getConnection();
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    MaxProjectCountClient client = new MaxProjectCountClient();
                    client.setName(rs.getString("NAME"));
                    client.setProjectCount(rs.getInt("PROJECT_COUNT"));
                    result.add(client);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<LongestProject> findLongestProject() {
        List<LongestProject> result = new ArrayList<>();
        try {
            String sql = new String(Files.readAllBytes(Paths.get("sql/find_longest_project.sql")));
            Connection conn = Database.getInstance().getConnection();
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    int monthCount = rs.getInt("MONTH_COUNT");
                    result.add(new LongestProject(id, monthCount));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> result = new ArrayList<>();
        try {
            String sql = new String(Files.readAllBytes(Paths.get("sql/find_max_salary_worker.sql")));
            Connection conn = Database.getInstance().getConnection();
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    String name = rs.getString("NAME");
                    int salary = rs.getInt("SALARY");
                    result.add(new MaxSalaryWorker(name, salary));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Worker> findYoungestEldestWorkers() {
        List<Worker> result = new ArrayList<>();
        try {
            String sql = new String(Files.readAllBytes(Paths.get("sql/find_youngest_eldest_workers.sql")));
            Connection conn = Database.getInstance().getConnection();
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    String type = rs.getString("TYPE");
                    String name = rs.getString("NAME");
                    String birthday = rs.getString("BIRTHDAY");
                    result.add(new Worker(type, name, birthday));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
