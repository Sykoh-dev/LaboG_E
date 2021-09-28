package MedicalAppointment.demo.dataAccess.repository;

import MedicalAppointment.demo.dataAccess.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository  extends JpaRepository<Appointment, Long> {
}
