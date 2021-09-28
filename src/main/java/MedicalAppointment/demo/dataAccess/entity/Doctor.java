package MedicalAppointment.demo.dataAccess.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String mail;
    @Column
    private String specialization;

    @OneToMany(mappedBy = "doctor",fetch = FetchType.EAGER)
    private List<Appointment> appointments;
}
