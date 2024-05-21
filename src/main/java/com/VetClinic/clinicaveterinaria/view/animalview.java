package com.VetClinic.clinicaveterinaria.view;

import com.VetClinic.clinicaveterinaria.controller.AnimalController;
import com.VetClinic.clinicaveterinaria.model.animal;

import java.util.Scanner;

public class animalview {
    private AnimalController controller;
    private Scanner scanner;

    public animalview(AnimalController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("1. Adicionar Animal");
            System.out.println("2. Atualizar Animal");
            System.out.println("3. Deletar Animal");
            System.out.println("4. Buscar Animal");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (option) {
                case 1:
                    addAnimal();
                    break;
                case 2:
                    updateAnimal();
                    break;
                case 3:
                    deleteAnimal();
                    break;
                case 4:
                    getAnimalById();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void addAnimal() {
        animal animal = new animal();

        System.out.print("Nome: ");
        animal.setNome(scanner.nextLine());
        System.out.print("Espécie: ");
        animal.setEspecie(scanner.nextLine());
        System.out.print("Raça: ");
        animal.setRaca(scanner.nextLine());
        System.out.print("Idade: ");
        animal.setIdade(scanner.nextInt());
        scanner.nextLine(); // Consome a nova linha
        System.out.print("Histórico Médico: ");
        animal.setHistoricoMedico(scanner.nextLine());
        System.out.print("ID do Dono: ");
        animal.setDonoId(scanner.nextInt());
        scanner.nextLine(); // Consome a nova linha

        controller.addAnimal(animal);
        System.out.println("Animal adicionado com sucesso!");
    }

    private void updateAnimal() {
        System.out.print("ID do Animal a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha

        animal animal = controller.getAnimalById(id);
        if (animal == null) {
            System.out.println("Animal não encontrado.");
            return;
        }

        System.out.print("Nome (" + animal.getNome() + "): ");
        animal.setNome(scanner.nextLine());
        System.out.print("Espécie (" + animal.getEspecie() + "): ");
        animal.setEspecie(scanner.nextLine());
        System.out.print("Raça (" + animal.getRaca() + "): ");
        animal.setRaca(scanner.nextLine());
        System.out.print("Idade (" + animal.getIdade() + "): ");
        animal.setIdade(scanner.nextInt());
        scanner.nextLine(); // Consome a nova linha
        System.out.print("Histórico Médico (" + animal.getHistoricoMedico() + "): ");
        animal.setHistoricoMedico(scanner.nextLine());
        System.out.print("ID do Dono (" + animal.getDonoId() + "): ");
        animal.setDonoId(scanner.nextInt());
        scanner.nextLine(); // Consome a nova linha

        controller.updateAnimal(animal);
        System.out.println("Animal atualizado com sucesso!");
    }

    private void deleteAnimal() {
        System.out.print("ID do Animal a ser deletado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha

        controller.deleteAnimal(id);
        System.out.println("Animal deletado com sucesso!");
    }

    private void getAnimalById() {
        System.out.print("ID do Animal: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha

        animal animal = controller.getAnimalById(id);
        if (animal == null) {
            System.out.println("Animal não encontrado.");
            return;
        }

        System.out.println("ID: " + animal.getId());
        System.out.println("Nome: " + animal.getNome());
        System.out.println("Espécie: " + animal.getEspecie());
        System.out.println("Raça: " + animal.getRaca());
        System.out.println("Idade: " + animal.getIdade());
        System.out.println("Histórico Médico: " + animal.getHistoricoMedico());
        System.out.println("ID do Dono: " + animal.getDonoId());
    }
}

