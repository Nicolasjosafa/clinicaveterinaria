package com.VetClinic.clinicaveterinaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class databasesetup {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/clinica_veterinaria";
        String user = "postgres";
        String password = "postgres";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            String[] commands = {
                "CREATE TABLE IF NOT EXISTS donos ("
                + "id SERIAL PRIMARY KEY, "
                + "nome VARCHAR(100) NOT NULL, "
                + "endereco VARCHAR(255), "
                + "telefone VARCHAR(20), "
                + "email VARCHAR(100))",

                "CREATE TABLE IF NOT EXISTS animais ("
                + "id SERIAL PRIMARY KEY, "
                + "nome VARCHAR(100) NOT NULL, "
                + "especie VARCHAR(50), "
                + "raca VARCHAR(50), "
                + "idade INTEGER, "
                + "historico_medico TEXT, "
                + "dono_id INTEGER, "
                + "FOREIGN KEY (dono_id) REFERENCES donos (id))",

                "CREATE TABLE IF NOT EXISTS funcionarios ("
                + "id SERIAL PRIMARY KEY, "
                + "nome VARCHAR(100) NOT NULL, "
                + "cargo VARCHAR(50), "
                + "contato VARCHAR(100), "
                + "horario_trabalho VARCHAR(50))",

                "CREATE TABLE IF NOT EXISTS consultas ("
                + "id SERIAL PRIMARY KEY, "
                + "data DATE NOT NULL, "
                + "horario TIME NOT NULL, "
                + "animal_id INTEGER, "
                + "dono_id INTEGER, "
                + "veterinario_id INTEGER, "
                + "status VARCHAR(20), "
                + "FOREIGN KEY (animal_id) REFERENCES animais (id), "
                + "FOREIGN KEY (dono_id) REFERENCES donos (id), "
                + "FOREIGN KEY (veterinario_id) REFERENCES funcionarios (id))",

                "CREATE TABLE IF NOT EXISTS servicos ("
                + "id SERIAL PRIMARY KEY, "
                + "tipo_servico VARCHAR(100), "
                + "descricao TEXT, "
                + "preco DECIMAL(10, 2))"
            };

            for (String command : commands) {
                stmt.execute(command);
            }

            System.out.println("Tables created successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
