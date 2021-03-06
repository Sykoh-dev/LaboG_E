package MedicalAppointment.demo.metier.mapper;

import MedicalAppointment.demo.dataAccess.entity.Doctor;
import MedicalAppointment.demo.dataAccess.entity.Patient;
import MedicalAppointment.demo.dto.DoctorDTO;
import MedicalAppointment.demo.dto.PatientDTO;
import MedicalAppointment.demo.modelsform.DoctorCreateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DoctorMapper implements Mapper<DoctorDTO, DoctorCreateForm, Doctor> {

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Override
    public DoctorDTO entityToDto(Doctor doctor) {
        if (doctor == null)
            return null;

        return DoctorDTO.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .surname(doctor.getSurname())
                .mail(doctor.getMail())
                .specialization(doctor.getSpecialization())
                .AppointmentDoctorList(
                        doctor.getAppointments()
                                .stream()
                                .map(appointmentMapper::entityToDto)
                                .collect(Collectors.toList())
                )
        .build();
    }

    @Override
    public Doctor dtoToEntity(DoctorDTO doctorDTO) {
        if (doctorDTO == null)
            return null;

        return Doctor.builder()
                .id(doctorDTO.getId())
                .name(doctorDTO.getName())
                .surname(doctorDTO.getSurname())
                .mail(doctorDTO.getMail())
                .specialization(doctorDTO.getSpecialization())
                .build();

    }

    @Override
    public Doctor formToEntity(DoctorCreateForm doctorCreateForm) {
        return null;
    }
}
