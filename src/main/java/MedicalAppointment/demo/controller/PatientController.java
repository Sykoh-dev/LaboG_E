package MedicalAppointment.demo.controller;

import MedicalAppointment.demo.dataAccess.entity.Patient;
import MedicalAppointment.demo.dto.PatientDTO;
import MedicalAppointment.demo.exception.ElementAlreadyPresentException;
import MedicalAppointment.demo.metier.service.CrudService;
import MedicalAppointment.demo.metier.service.PatientService;
import MedicalAppointment.demo.modelsform.PatientCreateForm;
import MedicalAppointment.demo.presentation.MenuPatient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Scanner;

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
    public String createAction(Model view,@Valid() PatientCreateForm patientform, BindingResult result ) throws ElementAlreadyPresentException  {

        if (result.hasErrors()){
            view.addAttribute("errors", result.getFieldError());
            return "user/create";
        }

        patientService.insert(patientform);


        return "redirect:/patient/list";
    }

    @GetMapping(path = {"/edit"}, name = "edit-patient")
    public String editAction() {
        return "patient/edit";
    }
}
