package com.example.trabalhocontroleremedio.banco;

import java.sql.*;

public class Banco {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/";
        String user = "postgres";
        String senha = "84627913";
        //String database = "teste"; //Utilizado para testes
        String database = "trabalhoidosoremedio";

        Connection con = null;
        Statement stat = null;
        try{
            con = DriverManager.getConnection(url+database,user,senha);
            stat = con.createStatement();
        }catch(SQLException SQLe){
            try{
                con = DriverManager.getConnection(url,user,senha);
                stat = con.createStatement();
                stat.executeUpdate("CREATE DATABASE " + database);
                con = DriverManager.getConnection(url+database,user,senha);
                stat = con.createStatement();
            }catch(SQLException SQLe2){
                System.out.println(SQLe2);
            }
        }

        try{ 
            // stat.executeUpdate("<SQL>"); // Funcionamento do comando
            /* Criação do banco */
            stat.executeUpdate("CREATE TABLE Idoso (idIdoso integer NOT NULL, nome character varying(255), nascimento character varying(255), " +
                                "sexo character varying(255), CONSTRAINT Idoso_pkey PRIMARY KEY (idIdoso))");

            stat.executeUpdate("CREATE TABLE Remedio (idRemedio integer NOT NULL, nome character varying(255), nome_generico character varying(255), " +
                                "categoria character varying(255), forma_dosagem character varying(255), CONSTRAINT Remedio_pkey PRIMARY KEY (idRemedio))");

            stat.executeUpdate("CREATE TABLE Horario (idhorario integer NOT NULL, h1 boolean, h2 boolean, h3 boolean, h4 boolean, " +
                                "h5 boolean, h6 boolean, h7 boolean, h8 boolean, h9 boolean, h10 boolean, h11 boolean, h12 boolean, " +
                                "h13 boolean, h14 boolean, h15 boolean, h16 boolean, h17 boolean, h18 boolean, h19 boolean, h20 boolean, " +
                                "h21 boolean, h22 boolean, h23 boolean, h24 boolean, CONSTRAINT Horario_pkey PRIMARY KEY (idhorario))");
                    
            stat.executeUpdate("CREATE TABLE Usuario (matricula integer NOT NULL, login character varying(255), " +
                                "senha character varying(255), tipo character varying(255), nome character varying(255), telefone character varying(255), " +
                                "CONSTRAINT usuario_pkey PRIMARY KEY (matricula))");

            stat.executeUpdate("CREATE TABLE Remedio_Idoso (idRemedio_Idoso integer NOT NULL, dosagem real, quantidade_dias integer, " +
                                "fk_horario integer, fk_idoso integer, fk_remedio integer, CONSTRAINT Remedio_Idoso_pkey PRIMARY KEY (idRemedio_Idoso), " +
                                "CONSTRAINT horario FOREIGN KEY (fk_horario) REFERENCES horario (idhorario), CONSTRAINT idoso FOREIGN KEY (fk_idoso) REFERENCES Idoso (idIdoso), " +
                                "CONSTRAINT remedio FOREIGN KEY (fk_remedio) REFERENCES Remedio (idRemedio))");

            stat.executeUpdate("INSERT INTO Usuario VALUES (0,'admin','admin','Administrador',null,null);");

            /* Testes realizados no banco */
            //stat.executeUpdate("INSERT INTO Idoso VALUES (0,'admin','admin');");
            //stat.executeUpdate("INSERT INTO Remedio VALUES (0,'admin','admin','Administrador';");
            //ResultSet result = stat.executeQuery("<SQL>"); // Pesquisas no banco
            //ResultSet result = stat.executeQuery("SELECT * FROM Idoso");
            //System.out.println(result.getInt("idIdoso") + " | " + result.getString("nascimento"));

            System.out.println("Banco criado com sucesso!");
        }catch(SQLException SQLe3){
            System.out.println(SQLe3);
        }
    }
}
