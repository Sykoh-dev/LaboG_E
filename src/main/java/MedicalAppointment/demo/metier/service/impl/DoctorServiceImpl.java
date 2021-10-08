package MedicalAppointment.demo.metier.service.impl;

import MedicalAppointment.demo.dataAccess.repository.DoctorRepository;
import MedicalAppointment.demo.dto.DoctorDTO;
import MedicalAppointment.demo.exception.ElementAlreadyPresentException;
import MedicalAppointment.demo.exception.ElementNotFoundException;
import MedicalAppointment.demo.metier.mapper.DoctorMapper;
import MedicalAppointment.demo.metier.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorMapper mapper;
    private final DoctorRepository repository;

    public DoctorServiceImpl(DoctorMapper mapper, DoctorRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public DoctorDTO getOne(Long id) throws ElementNotFoundException {
        return repository.findById(id)
                .map(mapper::entityToDto)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public List<DoctorDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void insert(Object toInsert) throws ElementAlreadyPresentException {

    }

    @Override
    public void delete(Long id) throws ElementNotFoundException {
        if( !repository.existsById(id) )
            throw new ElementNotFoundException();

        repository.deleteById(id);
    }

    @Override
    public void update(Object toUpdate) throws ElementNotFoundException {

}
    }
