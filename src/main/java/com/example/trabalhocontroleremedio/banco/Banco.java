package com.example.trabalhocontroleremedio.banco;

import java.sql.*;

public class Banco {
    public static void main(String[] args) {
        //String url = "jdbc:sqlite:teste.db"; // Utilizar para testes
        String url = "jdbc:sqlite:trabalhoControleRemedio.db"; // Banco padrão para o trabalho
        try{
            Connection con = DriverManager.getConnection(url);
            Statement stat = con.createStatement();
            // stat.executeUpdate("<SQL>"); // Funcionamento do comando
            stat.executeUpdate("CREATE TABLE Idoso(idIdoso INTEGER PRIMARY KEY AUTOINCREMENT, nascimento STRING, sexo STRING);");
            stat.executeUpdate("CREATE TABLE Usuario(matricula INTEGER PRIMARY KEY, login STRING, senha STRING, tipo STRING, nome STRING, telefone STRING);");
            stat.executeUpdate("CREATE TABLE Remedio(idRemedio INTEGER PRIMARY KEY AUTOINCREMENT, nome STRING, nome_generico STRING, categoria STRING);");
            stat.executeUpdate("INSERT INTO Usuario VALUES (0,'admin','admin','Administrador',null,null);");
            // ResultSet result = stat.executeQuery("<SQL>"); // Pesquisas no banco

            //System.out.println(result.getInt("id") + " | " + result.getString("name"));
        }catch(SQLException SQLe){
            System.out.println("Impossível conectar!");
        }
    }
}
