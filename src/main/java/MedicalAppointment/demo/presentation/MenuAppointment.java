package MedicalAppointment.demo.presentation;

import MedicalAppointment.demo.dataAccess.entity.Doctor;
import MedicalAppointment.demo.dataAccess.entity.Patient;
import MedicalAppointment.demo.dto.AppointmentDTO;
import MedicalAppointment.demo.exception.ElementAlreadyPresentException;
import MedicalAppointment.demo.exception.ElementNotFoundException;
import MedicalAppointment.demo.metier.service.AppointmentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.Scanner;

@Component
public class MenuAppointment {
    private final AppointmentService service;
    private final Scanner sc;

    public MenuAppointment(AppointmentService service, @Qualifier("sc2") Scanner sc) {
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
                --- MENU RENDEZ-VOUS ---
                1 - Afficher un RDV
                2 - Afficher tous les RDV
                3 - Ajouter un RDV
                4 - Supprimer un RDV
                5 - Modifier un RDV
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
            default -> System.out.println("Choix invalide");
        }
    }

    private void displayAll(){
        service.getAll()
                .forEach( System.out::println );
    }
    private void displayOne(){

        System.out.println("ID du rendez-vous");
        Long id = Long.parseLong(sc.nextLine());

        try {
            System.out.println( service.getOne(id) );
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void insert(){
        try {
            service.insert(new AppointmentDTO());
        } catch (ElementAlreadyPresentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void delete(){
        System.out.println("ID du RDV : ");
        Long id = Long.parseLong(sc.nextLine());

        try {
            service.delete(id);
            System.out.println("Le rendez-vous associé à l'ID" + id + " a été supprimé avec succès.");
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void update(){
        System.out.println("à implémenter");
    }

    private void quit(){
        System.out.println("Au revoir!");
    }
}
