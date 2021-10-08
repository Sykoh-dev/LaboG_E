package MedicalAppointment.demo.metier.service;

import MedicalAppointment.demo.dto.PatientDTO;
import MedicalAppointment.demo.metier.service.CrudService;
import MedicalAppointment.demo.modelsform.PatientCreateForm;

public interface PatientService extends CrudService<PatientDTO, PatientCreateForm,  Long> {

}
