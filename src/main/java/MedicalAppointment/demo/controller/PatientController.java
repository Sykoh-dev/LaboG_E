package MedicalAppointment.demo.controller;

import MedicalAppointment.demo.metier.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/patient"})
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(path = {"", "/list"}, name = "patient_list")
    public String listAction(Model view) {
        view.addAttribute("patients", patientService.getAll());
        return "patient/list";
    }
}
