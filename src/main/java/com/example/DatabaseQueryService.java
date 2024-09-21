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


}
