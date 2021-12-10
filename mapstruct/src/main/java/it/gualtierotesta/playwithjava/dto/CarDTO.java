package it.gualtierotesta.playwithjava.dto;

import lombok.Data;

@Data
public class CarDTO {
    private String maker;
    private int seatCount;
    private CarTypeDTO type;
    private String defVal;
    private String mftDate;
}
