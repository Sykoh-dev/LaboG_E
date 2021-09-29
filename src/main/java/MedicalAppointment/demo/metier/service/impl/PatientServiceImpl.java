package MedicalAppointment.demo.metier.service.impl;

import MedicalAppointment.demo.dataAccess.entity.Patient;
import MedicalAppointment.demo.dataAccess.repository.PatientRepository;
import MedicalAppointment.demo.dto.PatientDTO;
import MedicalAppointment.demo.exception.ElementAlreadyPresentException;
import MedicalAppointment.demo.exception.ElementNotFoundException;
import MedicalAppointment.demo.metier.mapper.Mapper;
import MedicalAppointment.demo.metier.mapper.PatientMapper;
import MedicalAppointment.demo.metier.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientMapper mapper;
    private final PatientRepository repository;

    public PatientServiceImpl(PatientMapper mapper, PatientRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public PatientDTO getOne(Long id) throws ElementNotFoundException {
        return repository.findById(id)
                .map(mapper::entityToDto)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public List<PatientDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void insert(PatientDTO toInsert) throws ElementAlreadyPresentException {
        if( repository.existsById(toInsert.getId()) )
            throw new ElementAlreadyPresentException();

        repository.save( mapper.dtoToEntity(toInsert) );
    }

    @Override
    public void delete(Long id) throws ElementNotFoundException {
        if( !repository.existsById(id) )
            throw new ElementNotFoundException();

        repository.deleteById(id);
    }

    @Override
    public void update(PatientDTO toUpdate) throws ElementNotFoundException {
        if( !repository.existsById(toUpdate.getId()) )
            throw new ElementNotFoundException();

        repository.save( mapper.dtoToEntity(toUpdate) );
    }
}

