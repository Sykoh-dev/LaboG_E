package MedicalAppointment.demo.metier.mapper;


import MedicalAppointment.demo.dataAccess.entity.Patient;
import MedicalAppointment.demo.dto.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper implements Mapper<PatientDTO, Patient> {

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Override
    public PatientDTO entityToDto(Patient patient) {
        if (patient == null)
            return null;

        return PatientDTO.builder()
                .id(patient.getId())
                .name(patient.getName())
                .surname(patient.getSurname())
                .adress(patient.getAdress())
                .mail(patient.getMail())
                .dateOfBirth(patient.getDateOfBirth())
                .build();
    }

    @Override
    public Patient dtoToEntity(PatientDTO patientDTO) {
        if (patientDTO == null)
            return null;

        return Patient.builder()
                .id(patientDTO.getId())
                .name(patientDTO.getName())
                .surname(patientDTO.getSurname())
                .adress(patientDTO.getAdress())
                .mail(patientDTO.getMail())
                .dateOfBirth(patientDTO.getDateOfBirth())
                .build();
    }
}
