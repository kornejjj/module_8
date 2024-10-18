package com.example;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();
        try {
            String sql = new String(Files.readAllBytes(Paths.get("sql/find_max_projects_client.sql")));
            Connection conn = Database.getInstance().getConnection();
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        MaxProjectCountClient client = new MaxProjectCountClient();
                        client.setName(rs.getString("NAME"));
                        client.setProjectCount(rs.getInt("PROJECT_COUNT"));
                        result.add(client);
                    }
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
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        LongestProject project = new LongestProject();
                        project.setId(rs.getInt("ID"));
                        project.setMonthCount(rs.getInt("MONTH_COUNT"));
                        result.add(project);
                    }
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
            try (Connection conn = Database.getInstance().getConnection()) {
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    try (ResultSet rs = stmt.executeQuery()) {
                        while (rs.next()) {
                            MaxSalaryWorker worker = new MaxSalaryWorker();
                            worker.setName(rs.getString("NAME"));
                            worker.setSalary(rs.getInt("SALARY"));
                            result.add(worker);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorkers() {
        List<YoungestEldestWorker> result = new ArrayList<>();
        try {
            String sql = new String(Files.readAllBytes(Paths.get("sql/find_youngest_eldest_workers.sql")));
            Connection conn = Database.getInstance().getConnection();
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        YoungestEldestWorker worker = new YoungestEldestWorker();
                        worker.setType(rs.getString("TYPE"));
                        worker.setName(rs.getString("NAME"));
                        worker.setBirthday(rs.getString("BIRTHDAY"));
                        result.add(worker);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
