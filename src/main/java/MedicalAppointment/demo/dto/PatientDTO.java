package MedicalAppointment.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PatientDTO {

    private Long id;
    private String name;
    private String surname;
    private String adress;
    private String mail;
    private String dateOfBirth;

    private List<AppointmentDTO> AppointmentPatientList;

}
