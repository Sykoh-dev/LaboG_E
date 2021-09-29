package MedicalAppointment.demo.presentation;

import MedicalAppointment.demo.dto.DoctorDTO;
import MedicalAppointment.demo.exception.ElementAlreadyPresentException;
import MedicalAppointment.demo.exception.ElementNotFoundException;
import MedicalAppointment.demo.metier.service.DoctorService;

import java.util.Scanner;

public class MenuDoctor {

    private final DoctorService service;
    private final Scanner sc;

    public MenuDoctor(DoctorService service, Scanner sc) {
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
                1 - afficher un
                2 - afficher tout
                3 - ajouter
                4 - supprimer
                5 - modifier
                6 - quitter
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

        System.out.println("id de du docteur: ");
        long id = Long.parseLong(sc.nextLine());

        try {
            System.out.println( service.getOne(id) );
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
    private void insert(){

        DoctorDTO.DoctorDTOBuilder builder = DoctorDTO.builder();

        System.out.println("id: ");
        builder.id(Long.parseLong(sc.nextLine()));
        System.out.println("nom: ");
        builder.name(sc.nextLine());
        System.out.println("prénom: ");
        builder.surname(sc.nextLine());
        System.out.println("mail: ");
        builder.mail(sc.nextLine());
        System.out.println("specialisation: ");
        builder.specialization(sc.nextLine());

        try {
            service.insert( builder.build() );
            System.out.println("succes");
        } catch (ElementAlreadyPresentException e) {
            System.out.println(e.getMessage());
        }

    }
    private void delete(){

        System.out.println("id du docteur ");
        long id = Long.parseLong(sc.nextLine());

        try {
            service.delete(id);
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    private void update(){

        // TODO : préciser
        System.out.println("à implémenter");

    }
    private void quit(){

        System.out.println("au revoir!");

    }
}
