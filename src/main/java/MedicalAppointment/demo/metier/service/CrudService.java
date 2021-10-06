package MedicalAppointment.demo.metier.service;

import MedicalAppointment.demo.exception.ElementAlreadyPresentException;
import MedicalAppointment.demo.exception.ElementNotFoundException;

import java.util.List;

public interface CrudService<DTO, ID> {
    DTO getOne(ID Long) throws ElementNotFoundException;

    List<DTO> getAll();

    void insert(DTO toInsert) throws ElementAlreadyPresentException;

    void delete(ID id) throws ElementNotFoundException;

    void update(DTO toUpdate) throws ElementNotFoundException;
}
