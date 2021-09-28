package MedicalAppointment.demo.dataAccess.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Date dateAppointement;

    @OneToMany(mappedBy = "appointement",fetch = FetchType.EAGER)
    private List<Patient> patients;

    @OneToMany(mappedBy = "appointement",fetch = FetchType.EAGER)
    private List<Doctor> doctors;
}
