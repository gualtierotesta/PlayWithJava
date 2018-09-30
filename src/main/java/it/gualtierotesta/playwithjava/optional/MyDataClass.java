package it.gualtierotesta.playwithjava.optional;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class MyDataClass {

    private String name ;
    private int value;
    private UserProfile userProfile;

    public MyDataClass () {
        name = "Gualtiero";
        value = 0;
        userProfile = UserProfile.builder().valid(true).build();
    }
}
