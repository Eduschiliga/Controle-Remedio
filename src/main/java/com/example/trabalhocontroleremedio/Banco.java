package com.example.trabalhocontroleremedio;

import java.sql.*;

public class Banco {
    public static void main(String[] args) {
        //String url = "jdbc:sqlite:teste.db"; // Utilizar para testes
        String url = "jdbc:sqlite:trabalhoControleRemedio.db"; // Banco padrão para o trabalho
        try{
            Connection con = DriverManager.getConnection(url);
            Statement stat = con.createStatement();
            // stat.executeUpdate("<SQL>"); // Funcionamento do comando
            stat.executeUpdate("create table person (id integer, name string)");

            // ResultSet result = stat.executeQuery("<SQL>"); // Pesquisas no banco

            //System.out.println(result.getInt("id") + " | " + result.getString("name"));
        }catch(SQLException SQLe){
            System.out.println("Impossível conectar!");
        }
    }
}
