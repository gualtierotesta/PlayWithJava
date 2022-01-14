package it.gualtierotesta.playwithjava.immutables.valueobject;

import org.immutables.value.Value;

public abstract class AbstractValueObject<T> {

    @Value.Parameter
    public abstract T value();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + value() + ")";
    }

}
