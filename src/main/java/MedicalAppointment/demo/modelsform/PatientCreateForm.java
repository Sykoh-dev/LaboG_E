package MedicalAppointment.demo.modelsform;

import MedicalAppointment.demo.dataAccess.entity.Patient;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;


@Validated @Data


public class PatientCreateForm {


    @Length(min = 2, max = 25)
    private String name;

    @Length(min = 2, max = 25)
    private String surname;

    @Length(min = 2, max = 25)
    private String adress;

    @Length(min = 2, max = 25)
    private String mail;

    @Length(min = 2, max = 25)
    private String dateOfBirth;

    public Patient mapToPatient() {
        Patient patient = new Patient();
        patient.setId(0L);
        patient.setName(name);
        patient.setSurname(surname);
        patient.setAdress(adress);
        patient.setMail(mail);
        patient.setDateOfBirth(dateOfBirth);

        return patient;
    }


}

