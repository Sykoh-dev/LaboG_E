package MedicalAppointment.demo.presentation;

import MedicalAppointment.demo.dto.DoctorDTO;
import MedicalAppointment.demo.exception.ElementAlreadyPresentException;
import MedicalAppointment.demo.exception.ElementNotFoundException;
import MedicalAppointment.demo.metier.service.DoctorService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuDoctor {

    private final DoctorService service;
    private final Scanner sc;

    public MenuDoctor(DoctorService service, @Qualifier("sc2") Scanner sc) {
        this.service = service;
        this.sc = sc;
    }

    public void start(){
        int choix = 0;
        do{
            displayMenu();
            choix = Integer.parseInt(sc.nextLine());
            mapChoix(choix);
        }while (choix != 6);
    }

    private void displayMenu(){
        System.out.println("""
                --- MENU DOCTEUR ---
                1 - Afficher un docteur
                2 - Afficher la liste des docteurs
                3 - Ajouter
                4 - Supprimer
                5 - Modifier
                6 - Quitter
                """);
    }

    private void mapChoix(int choix){
        switch (choix){
            case 1 -> displayOne();
            case 2 -> displayAll();
            case 3 -> insert();
            case 4 -> delete();
            case 5 -> update();
            case 6 -> quit();
            default -> System.out.println("choix invalide");
        }
    }

    private void displayAll(){
        service.getAll()
                .forEach( System.out::println );
    }
    private void displayOne(){

        System.out.println("ID du docteur: ");
        long id = Long.parseLong(sc.nextLine());

        try {
            System.out.println( service.getOne(id) );
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
    private void insert(){

        DoctorDTO.DoctorDTOBuilder builder = DoctorDTO.builder();

        System.out.println("ID : ");
        builder.id(Long.parseLong(sc.nextLine()));
        System.out.println("Nom : ");
        builder.name(sc.nextLine());
        System.out.println("Prénom : ");
        builder.surname(sc.nextLine());
        System.out.println("E-Mail : ");
        builder.mail(sc.nextLine());
        System.out.println("Spécialisation : ");
        builder.specialization(sc.nextLine());

        try {
            service.insert( builder.build() );
            System.out.println("Succès");
        } catch (ElementAlreadyPresentException e) {
            System.out.println(e.getMessage());
        }

    }
    private void delete(){

        System.out.println("ID du docteur ");
        long id = Long.parseLong(sc.nextLine());

        try {
            service.delete(id);
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void update(){

        DoctorDTO.DoctorDTOBuilder builder = DoctorDTO.builder();

        System.out.println("ID : ");
        builder.id(Long.parseLong(sc.nextLine()));
        System.out.println("Nom : ");
        builder.name(sc.nextLine());
        System.out.println("Prénom : ");
        builder.surname(sc.nextLine());
        System.out.println("E-Mail : ");
        builder.mail(sc.nextLine());
        System.out.println("Spécialisation : ");
        builder.specialization(sc.nextLine());

        try {
            service.update( builder.build() );
            System.out.println("Succès");
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    private void quit(){
        System.out.println("Au revoir!");
    }
}
