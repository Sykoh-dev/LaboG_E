package MedicalAppointment.demo;

import MedicalAppointment.demo.presentation.MenuAppointment;
import MedicalAppointment.demo.presentation.MenuDoctor;
import MedicalAppointment.demo.presentation.MenuPatient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MedicalAppointementApplication {
	// Accès pour Gedev : autorisé
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MedicalAppointementApplication.class, args);
//
//		MenuPatient menuPatient = ctx.getBean(MenuPatient.class);
//		menuPatient.start();
//
//		MenuDoctor menuDoctor = ctx.getBean(MenuDoctor.class);
//		menuDoctor.start();
//
//		MenuAppointment menuAppointment = ctx.getBean(MenuAppointment.class);
//		menuAppointment.start();
	}

}
