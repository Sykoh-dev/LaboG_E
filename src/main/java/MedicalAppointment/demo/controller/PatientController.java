package MedicalAppointment.demo.controller;

import MedicalAppointment.demo.dataAccess.entity.Patient;
import MedicalAppointment.demo.dto.PatientDTO;
import MedicalAppointment.demo.metier.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping(path = {"/create"}, name = "create-patient")
    public String createAction() {
        return "patient/create";
    }

    @PostMapping(path = {"/create"}, name = "patient_create_post")
    public String createAction(@ModelAttribute Patient patient, Model model) {
        // model.addAttribute("patient", patient);
        return "redirect:/patient/list";
    }

    @GetMapping(path = {"/edit"}, name = "edit-patient")
    public String editAction() {
        return "patient/edit";
    }
}
