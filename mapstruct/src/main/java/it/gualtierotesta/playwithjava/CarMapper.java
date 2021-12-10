package it.gualtierotesta.playwithjava;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import it.gualtierotesta.playwithjava.domain.Car;
import it.gualtierotesta.playwithjava.domain.CarType;
import it.gualtierotesta.playwithjava.dto.CarDTO;
import it.gualtierotesta.playwithjava.dto.CarTypeDTO;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    /*
     * Mapper from Car to CarDTO
     */
    @Mapping(source = "numberOfSeats", target = "seatCount") // cambio nome attributo
    @Mapping(target = "defVal", constant = "default") // attributo dest costante
    CarDTO carToCarDto(Car source);

    /*
     * Mapper from CarDTO to mapper
     */
    @Mapping(target = "numberOfSeats", source = "seatCount") // cambio nome attributo
    Car carDTOToCar(CarDTO source);

    /*
     * Custom Mapper from CarType to CarTypeDTO
     */
    default CarTypeDTO type(final CarType source) {
        CarTypeDTO dto = new CarTypeDTO();
        dto.setType(source.getType());
        return dto;
    }

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLL yyyy");

    default String fromLocalDateToString(final LocalDate pDate) {
        return pDate != null ? pDate.format(formatter) : "";

    }

    default LocalDate fromLocalDateToString(final String pDate) {
        return pDate != null ? LocalDate.parse(pDate, formatter) : null;
    }
}
