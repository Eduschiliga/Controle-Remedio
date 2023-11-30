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
            /* Criação do banco */
            stat.executeUpdate("CREATE TABLE Idoso(idIdoso INTEGER PRIMARY KEY AUTOINCREMENT, nascimento STRING, sexo STRING);");
            stat.executeUpdate("CREATE TABLE Usuario(matricula INTEGER PRIMARY KEY, login STRING, senha STRING, tipo STRING, nome STRING, telefone STRING);");
            stat.executeUpdate("CREATE TABLE Remedio(idRemedio INTEGER PRIMARY KEY AUTOINCREMENT, nome STRING, nome_generico STRING, categoria STRING);");
            stat.executeUpdate("CREATE TABLE Horario(idHorario INTEGER PRIMARY KEY AUTOINCREMENT, h1 BOOLEAN, h2 BOOLEAN, h3 BOOLEAN, h4 BOOLEAN, h5 BOOLEAN," +
                            " h6 BOOLEAN, h7 BOOLEAN, h8 BOOLEAN, h9 BOOLEAN, h10 BOOLEAN, h11 BOOLEAN, h12 BOOLEAN, h13 BOOLEAN, h14 BOOLEAN, h15 BOOLEAN, h16" + 
                            " BOOLEAN, h17 BOOLEAN, h18 BOOLEAN, h19 BOOLEAN, h20 BOOLEAN, h21 BOOLEAN, h22 BOOLEAN, h23 BOOLEAN, h24 BOOLEAN);");
            stat.executeUpdate("CREATE TABLE Remedio_Idoso(idRemedio_Idoso INTEGER PRIMARY KEY AUTOINCREMENT, dosagem REAL, forma_dosagem STRING, fk_horario" +
                            " INTEGER, fk_idoso INTEGER, fk_remedio INTEGER, FOREIGN KEY(fk_horario) REFERENCES Horario(idHorario), FOREIGN KEY(fk_idoso)" +
                            " REFERENCES Idoso(idIdoso), FOREIGN KEY(fk_remedio) REFERENCES Remedio(idRemedio));");

            stat.executeUpdate("INSERT INTO Usuario VALUES (0,'admin','admin','Administrador',null,null);");

            /* Testes realizados no banco */
            //stat.executeUpdate("INSERT INTO Idoso VALUES (0,'admin','admin');");
            //stat.executeUpdate("INSERT INTO Remedio VALUES (0,'admin','admin','Administrador';");
            //ResultSet result = stat.executeQuery("<SQL>"); // Pesquisas no banco
            //ResultSet result = stat.executeQuery("SELECT * FROM Idoso");
            //System.out.println(result.getInt("idIdoso") + " | " + result.getString("nascimento"));

        }catch(SQLException SQLe){
            System.out.println(SQLe);
        }
    }
}
