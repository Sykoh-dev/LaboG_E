package MedicalAppointment.demo.dataAccess.repository;


import MedicalAppointment.demo.dataAccess.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
