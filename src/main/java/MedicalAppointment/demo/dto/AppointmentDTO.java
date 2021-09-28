package MedicalAppointment.demo.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AppointmentDTO {

    private Long id;
    private Date dateAppointement;

    private List<PatientDTO> patients;
    private List<DoctorDTO> doctors;

}
