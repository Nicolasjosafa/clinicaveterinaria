package com.VetClinic.clinicaveterinaria;


import com.VetClinic.clinicaveterinaria.controller.AnimalController;
import com.VetClinic.clinicaveterinaria.view.animalview;

public class app {
    public static void main(String[] args) {
        AnimalController animalController = new AnimalController();
        animalview animalView = new animalview(animalController);

        animalView.showMenu();
    }
}

