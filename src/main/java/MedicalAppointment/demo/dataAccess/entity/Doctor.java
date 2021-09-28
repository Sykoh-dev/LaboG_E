package MedicalAppointment.demo.dataAccess.entity;

import lombok.*;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "appointment")
    private Appointment appointment;
}
