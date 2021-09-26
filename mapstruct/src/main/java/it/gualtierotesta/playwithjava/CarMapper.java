package it.gualtierotesta.playwithjava;

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

	@Mapping(source = "numberOfSeats", target = "seatCount")
	CarDTO carToCarDto(Car source);

	CarTypeDTO type(CarType source);

}
