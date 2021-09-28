package MedicalAppointment.demo.dataAccess.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String adress;
    @Column
    private String mail;
    @Column
    private Date bateOfBirth;

    @ManyToOne
    @JoinColumn(name = "appointment")
    private Appointment appointment;
}
