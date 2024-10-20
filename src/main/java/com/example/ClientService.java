package com.example;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientService {

    public long create(String name) throws Exception {
        validateName(name);
        String sql = "INSERT INTO clients (name) VALUES (?)";
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                } else {
                    throw new Exception("Creating client failed, no ID obtained.");
                }
            }
        }
    }

    public String getById(long id) throws Exception {
        String sql = "SELECT name FROM clients WHERE id = ?";
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("name");
                } else {
                    throw new Exception("Client not found.");
                }
            }
        }
    }

    public void setName(long id, String name) throws Exception {
        validateName(name);
        String sql = "UPDATE clients SET name = ? WHERE id = ?";
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setLong(2, id);
            stmt.executeUpdate();
        }
    }

    public void deleteById(long id) throws Exception {
        String sql = "DELETE FROM clients WHERE id = ?";
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Client> listAll() throws Exception {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT id, name FROM clients";
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Client client = new Client(rs.getLong("id"), rs.getString("name"));
                clients.add(client);
            }
        }
        return clients;
    }

    private void validateName(String name) throws Exception {
        if (name == null || name.length() < 3 || name.length() > 100) {
            throw new Exception("Client name must be between 3 and 100 characters.");
        }
    }
}

