package com.VetClinic.clinicaveterinaria.controller;

import com.VetClinic.clinicaveterinaria.model.animal;
import com.VetClinic.clinicaveterinaria.model.database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.RestController;



@RestController

public class AnimalController{
    
    public void addAnimal(animal animal) {
        String query = "INSERT INTO animais (nome, especie, raca, idade, historico_medico, dono_id) VALUES (?, ?, ?, ?, ?, ?)";
      
        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getEspecie());
            stmt.setString(3, animal.getRaca());
            stmt.setInt(4, animal.getIdade());
            stmt.setString(5, animal.getHistoricoMedico());
            stmt.setInt(6, animal.getDonoId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     public void deleteAnimal(int id) {
        String query = "DELETE FROM animais WHERE id = ?";

        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public animal getAnimalById(int id) {
        String query = "SELECT * FROM animais WHERE id = ?";
        animal animal = null;

        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                animal = new animal();
                animal.setId(rs.getInt("id"));
                animal.setNome(rs.getString("nome"));
                animal.setEspecie(rs.getString("especie"));
                animal.setRaca(rs.getString("raca"));
                animal.setIdade(rs.getInt("idade"));
                animal.setHistoricoMedico(rs.getString("historico_medico"));
                animal.setDonoId(rs.getInt("dono_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return animal;
    }

    public void updateAnimal(animal animal) {
        String query = "UPDATE animais SET nome = ?, especie = ?, raca = ?, idade = ?, historico_medico = ?, dono_id = ? WHERE id = ?";

        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getEspecie());
            stmt.setString(3, animal.getRaca());
            stmt.setInt(4, animal.getIdade());
            stmt.setString(5, animal.getHistoricoMedico());
            stmt.setInt(6, animal.getDonoId());
            stmt.setInt(7, animal.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



