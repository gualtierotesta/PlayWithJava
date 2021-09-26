package it.gualtierotesta.playwithjava;

import it.gualtierotesta.playwithjava.domain.Car;
import it.gualtierotesta.playwithjava.domain.CarMaker;
import it.gualtierotesta.playwithjava.domain.CarType;
import it.gualtierotesta.playwithjava.dto.CarDTO;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(final String[] args) {
		CarType type = CarType.builder().type("SUV").build();
		Car car = Car.builder().maker(CarMaker.TOYOTA).numberOfSeats(5).type(type).build();

		// when
		CarDTO carDto = CarMapper.INSTANCE.carToCarDto(car);
		System.out.println(carDto);
	}
}
