package MedicalAppointment.demo.metier.mapper;

public interface Mapper<DTO, FORM, ENTITY> {

    DTO entityToDto(ENTITY entity);
    ENTITY dtoToEntity(DTO dto);
    ENTITY formToEntity(FORM form);

}
