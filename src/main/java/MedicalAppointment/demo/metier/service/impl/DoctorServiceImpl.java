package MedicalAppointment.demo.metier.service.impl;

import MedicalAppointment.demo.dataAccess.repository.DoctorRepository;
import MedicalAppointment.demo.dto.DoctorDTO;
import MedicalAppointment.demo.exception.ElementAlreadyPresentException;
import MedicalAppointment.demo.exception.ElementNotFoundException;
import MedicalAppointment.demo.metier.mapper.DoctorMapper;
import MedicalAppointment.demo.metier.service.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {

    private final DoctorMapper mapper;
    private final DoctorRepository repository;

    public DoctorServiceImpl(DoctorMapper mapper, DoctorRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public DoctorDTO getOne(Long aLong) throws ElementNotFoundException {
        return null;
    }

    @Override
    public List<DoctorDTO> getAll() {
        return null;
    }

    @Override
    public void insert(DoctorDTO toInsert) throws ElementAlreadyPresentException {

    }

    @Override
    public void delete(Long aLong) throws ElementNotFoundException {

    }

    @Override
    public void update(DoctorDTO toUpdate) throws ElementNotFoundException {

    }
}
