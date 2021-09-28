package MedicalAppointment.demo.metier.service.impl;

import MedicalAppointment.demo.dataAccess.entity.Patient;
import MedicalAppointment.demo.dataAccess.repository.PatientRepository;
import MedicalAppointment.demo.dto.PatientDTO;
import MedicalAppointment.demo.exception.ElementAlreadyPresentException;
import MedicalAppointment.demo.exception.ElementNotFoundException;
import MedicalAppointment.demo.metier.mapper.Mapper;
import MedicalAppointment.demo.metier.mapper.PatientMapper;
import MedicalAppointment.demo.metier.service.PatientService;

import java.util.List;

public class PatientServiceImpl implements PatientService {

    private final PatientMapper mapper;
    private final PatientRepository repository;

    public PatientServiceImpl(PatientMapper mapper, PatientRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public PatientDTO getOne(Long aLong) throws ElementNotFoundException {
        return null;
    }

    @Override
    public List<PatientDTO> getAll() {
        return null;
    }

    @Override
    public void insert(PatientDTO toInsert) throws ElementAlreadyPresentException {

    }

    @Override
    public void delete(Long aLong) throws ElementNotFoundException {

    }

    @Override
    public void update(PatientDTO toUpdate) throws ElementNotFoundException {

    }
}

