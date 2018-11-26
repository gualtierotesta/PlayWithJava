package it.gualtierotesta.playwithjava;

import java.io.Serializable;
import java.util.Objects;

/**
 * Service results class. It can be success or failure
 *
 * @param <E>
 */
public abstract class Result<E extends Serializable> implements Serializable {

    public abstract boolean isSuccess();

    public abstract E successValue();

    public abstract String errorMessage();

    public static <E extends Serializable> Result<E> success(final E pValue) {
        return new Success<>(Objects.requireNonNull(pValue));
    }

    public static <E extends Serializable> Result<E> failure(final String pMessage) {
        return new Failure<>(Objects.requireNonNull(pMessage));
    }

    private static final class Success<E extends Serializable> extends Result<E> {

        private static final long serialVersionUID = 8786008382136811523L;
        private final E value;

        private Success(final E pValue) {
            value = pValue;
        }

        @Override
        public boolean isSuccess() {
            return true;
        }

        @Override
        public E successValue() {
            return value;
        }

        @Override
        public String errorMessage() {
            throw new IllegalStateException("No error message when result is success");
        }

        @Override
        public String toString() {
            return String.format("Success(%s)", successValue());
        }
    }

    private static final class Failure<E extends Serializable> extends Result<E> {

        private static final long serialVersionUID = -856744644884077066L;
        private final String message;

        private Failure(final String pErrorMessage) {
            message = pErrorMessage;
        }

        @Override
        public boolean isSuccess() {
            return false;
        }

        @Override
        public E successValue() {
            throw new IllegalStateException("No value when result is failure");
        }

        @Override
        public String errorMessage() {
            return message;
        }

        @Override
        public String toString() {
            return String.format("Failure(%s)", errorMessage());
        }
    }
}
