package it.gualtierotesta.playwithjava;

import it.gualtierotesta.playwithjava.domain.Car;
import it.gualtierotesta.playwithjava.domain.CarMaker;
import it.gualtierotesta.playwithjava.domain.CarType;
import it.gualtierotesta.playwithjava.dto.CarDTO;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(final String[] args) {
        Car car = Car.builder().maker(CarMaker.TOYOTA).numberOfSeats(5).type(CarType.builder().type("SUV").build())
                .mftDate(LocalDate.now()).build();
        System.out.println(car);

        // when
        CarDTO carDto = CarMapper.INSTANCE.carToCarDto(car);
        System.out.println(carDto);

        // when
        Car car2 = CarMapper.INSTANCE.carDTOToCar(carDto);
        System.out.println(car2);
    }
}
