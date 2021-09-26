package it.gualtierotesta.playwithjava.vavr;

import io.vavr.control.Either;
import io.vavr.control.Try;

import java.util.Optional;

public class Dao {

    User findUser1() {
        User user = doFind();
        return user;
    }

    Optional<User> findUser2() {
        User user = doFind();
        return Optional.ofNullable(user);
    }

    Try<User> findUser3() {
        return Try.of(() -> doFind());
        //return Try.failure(new IllegalStateException("BOOM"));
    }

    Try<String> updateUser(User user) {
        //return Try.of(() -> "user");
        return Try.failure(new IllegalStateException("BOOM"));
    }

    Either<?, User> findUser4() {
        return Either.right(doFind());
    }

    private User doFind() {
        return new User("Mario");
    }
}
