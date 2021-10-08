package MedicalAppointment.demo.metier.mapper;


import MedicalAppointment.demo.dataAccess.entity.Appointment;
import MedicalAppointment.demo.dataAccess.entity.Doctor;
import MedicalAppointment.demo.dataAccess.entity.Patient;
import MedicalAppointment.demo.dto.AppointmentDTO;
import MedicalAppointment.demo.dto.DoctorDTO;
import MedicalAppointment.demo.dto.PatientDTO;
import MedicalAppointment.demo.modelsform.AppointmentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppointmentMapper implements Mapper<AppointmentDTO, AppointmentForm, Appointment> {

    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private PatientMapper patientMapper;

    @Override
    public AppointmentDTO entityToDto(Appointment appointment) {
        if (appointment == null)
            return null;

        return AppointmentDTO.builder()
                .id(appointment.getId())
                .dateAppointment(appointment.getDateAppointment())
                .doctors(doctorMapper.entityToDto(appointment.getDoctor()))
                .patients(patientMapper.entityToDto(appointment.getPatient()))
                .build();
    }
    @Override
    public Appointment dtoToEntity(AppointmentDTO appointmentDTO) {
        if (appointmentDTO == null)
            return null;

        return Appointment.builder()
                .id(appointmentDTO.getId())
                .dateAppointment(appointmentDTO.getDateAppointment())
                .build();
    }

    @Override
    public Appointment formToEntity(AppointmentForm appointmentForm) {
        return null;
    }
}
