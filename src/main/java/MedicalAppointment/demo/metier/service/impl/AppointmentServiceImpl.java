package MedicalAppointment.demo.metier.service.impl;

import MedicalAppointment.demo.dataAccess.repository.AppointmentRepository;
import MedicalAppointment.demo.dto.AppointmentDTO;
import MedicalAppointment.demo.exception.ElementAlreadyPresentException;
import MedicalAppointment.demo.exception.ElementNotFoundException;
import MedicalAppointment.demo.metier.mapper.AppointmentMapper;
import MedicalAppointment.demo.metier.service.AppointmentService;

import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentMapper mapper;
    private final AppointmentRepository repository;

    public AppointmentServiceImpl(AppointmentMapper mapper, AppointmentRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public AppointmentDTO getOne(Long aLong) throws ElementNotFoundException {
        return null;
    }

    @Override
    public List<AppointmentDTO> getAll() {
        return null;
    }

    @Override
    public void insert(AppointmentDTO toInsert) throws ElementAlreadyPresentException {

    }

    @Override
    public void delete(Long aLong) throws ElementNotFoundException {

    }

    @Override
    public void update(AppointmentDTO toUpdate) throws ElementNotFoundException {

    }
}
