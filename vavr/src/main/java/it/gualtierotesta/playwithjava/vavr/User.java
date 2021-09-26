package it.gualtierotesta.playwithjava.vavr;

import java.util.StringJoiner;

public class User {

    private final String name;

    public User(final String pName) {
        this.name = pName;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
