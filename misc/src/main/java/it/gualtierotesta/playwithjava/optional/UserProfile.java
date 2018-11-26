package it.gualtierotesta.playwithjava.optional;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class UserProfile {

    private boolean valid;
    private String firstName;
    private String lastName;
    private String email;
    private BigDecimal amount;
}
