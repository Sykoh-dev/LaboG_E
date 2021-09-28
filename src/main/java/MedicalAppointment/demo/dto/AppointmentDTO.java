package MedicalAppointment.demo.dto;

import MedicalAppointment.demo.dataAccess.entity.Doctor;
import MedicalAppointment.demo.dataAccess.entity.Patient;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AppointmentDTO {

    private Long id;
    private Date dateAppointment;

    private PatientDTO patients;
    private DoctorDTO doctors;

}
