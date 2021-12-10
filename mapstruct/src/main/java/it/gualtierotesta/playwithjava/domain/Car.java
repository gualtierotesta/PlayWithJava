package it.gualtierotesta.playwithjava.domain;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Car {
    private CarMaker maker;
    private int numberOfSeats;
    private CarType type;
    private LocalDate mftDate;
}
