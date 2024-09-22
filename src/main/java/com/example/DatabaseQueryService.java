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

    public List<String[]> findLongestProject() {
        List<String[]> result = new ArrayList<>();
        try {
            String sql = new String(Files.readAllBytes(Paths.get("sql/find_longest_project.sql")));
            Connection conn = Database.getInstance().getConnection();
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    String[] project = new String[2];
                    project[0] = String.valueOf(rs.getInt("ID"));
                    project[1] = String.valueOf(rs.getInt("MONTH_COUNT"));
                    result.add(project);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<String[]> findMaxSalaryWorker() {
        List<String[]> result = new ArrayList<>();
        try {
            String sql = new String(Files.readAllBytes(Paths.get("sql/find_max_salary_worker.sql")));
            Connection conn = Database.getInstance().getConnection();
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    String[] worker = new String[2];
                    worker[0] = rs.getString("NAME");
                    worker[1] = String.valueOf(rs.getInt("SALARY"));
                    result.add(worker);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<String[]> findYoungestEldestWorkers() {
        List<String[]> result = new ArrayList<>();
        try {
            String sql = new String(Files.readAllBytes(Paths.get("sql/find_youngest_eldest_workers.sql")));
            Connection conn = Database.getInstance().getConnection();
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    String[] worker = new String[3];
                    worker[0] = rs.getString("TYPE");
                    worker[1] = rs.getString("NAME");
                    worker[2] = rs.getString("BIRTHDAY");
                    result.add(worker);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
