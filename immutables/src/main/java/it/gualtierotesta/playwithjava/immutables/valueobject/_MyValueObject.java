package it.gualtierotesta.playwithjava.immutables.valueobject;

import org.immutables.value.Value;

@Value.Immutable
@ValueObject
public abstract class _MyValueObject extends AbstractValueObject<String> {

    @Value.Check
    protected void check() {
        String value = value();
        if (value.isBlank()) {
            throw new IllegalArgumentException("Invalid value: [" + value + "]");
        }
    }

}
