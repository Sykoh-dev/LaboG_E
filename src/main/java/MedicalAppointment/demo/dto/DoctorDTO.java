package MedicalAppointment.demo.dto;

import MedicalAppointment.demo.dataAccess.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DoctorDTO {

    private long id;
    private String surname;
    private String name;
    private String specialization;
    private String mail;
    private Doctor doctors;

    private List<AppointmentDTO> AppointmentDoctorList;

}
