package it.gualtierotesta.playwithjava.immutables;

import java.io.Serializable;
import java.util.List;

import org.immutables.value.Value;

@Value.Immutable
public abstract class MyBean implements Serializable {

    private static final long serialVersionUID = 1L;

    abstract String name();

    abstract List<String> props();

    static MyBean create(final String pName, final List<String> pProps) {
        return ImmutableMyBean.builder().name(pName).addAllProps(pProps).build();
    }

    @Value.Check
    protected void check() {
        if (name().isBlank()) {
            throw new IllegalArgumentException("name cannot be empty");
        }
        if (props().isEmpty()) {
            throw new IllegalArgumentException("props list cannot be empty");
        }
    }

}
