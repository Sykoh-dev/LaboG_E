package MedicalAppointment.demo.metier.service.impl;

import MedicalAppointment.demo.dataAccess.repository.AppointmentRepository;
import MedicalAppointment.demo.dto.AppointmentDTO;
import MedicalAppointment.demo.exception.ElementAlreadyPresentException;
import MedicalAppointment.demo.exception.ElementNotFoundException;
import MedicalAppointment.demo.metier.mapper.AppointmentMapper;
import MedicalAppointment.demo.metier.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentMapper mapper;
    private final AppointmentRepository repository;

    public AppointmentServiceImpl(AppointmentMapper mapper, AppointmentRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public AppointmentDTO getOne(Long id) throws ElementNotFoundException {
        return repository.findById(id)
                .map(mapper::entityToDto)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public List<AppointmentDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void insert(AppointmentDTO toInsert) throws ElementAlreadyPresentException {
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
    public void update(AppointmentDTO toUpdate) throws ElementNotFoundException {
        if( !repository.existsById(toUpdate.getId()) )
            throw new ElementNotFoundException();

        repository.save( mapper.dtoToEntity(toUpdate) );
    }
}
