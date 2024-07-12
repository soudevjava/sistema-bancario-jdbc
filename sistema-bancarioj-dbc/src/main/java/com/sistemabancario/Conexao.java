package com.sistemabancario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/sistemabancario";
        String user = "root";
        String password = "2302843";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conexao = DriverManager.getConnection(url, user, password);
                 Statement stmt = conexao.createStatement();
                 ResultSet rsCliente = stmt.executeQuery("SELECT * FROM CLIENTE")) {
                
                while (rsCliente.next()) {
                    System.out.println("Nome: " + rsCliente.getString("nome"));
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver do banco de dados não localizado.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + e.getMessage());
        }
    }
    
}
