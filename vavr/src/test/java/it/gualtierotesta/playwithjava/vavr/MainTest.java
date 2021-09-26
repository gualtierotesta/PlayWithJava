package it.gualtierotesta.playwithjava.vavr;

import io.vavr.CheckedFunction0;
import io.vavr.control.Option;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {


    @Test
    void creation() {
        assertTrue(Option.of("ciao").isDefined());
        assertFalse(Option.of(null).isDefined());
    }

    @Test
    void operations() {
        Option<String> option = Option.of("ciao");

        // get()
        // some: return the value, none: NoSuchElementException
        String result1 = option.get();


        // getOrElse(T)
        // some: return the value, none: return the specified value
        String result2 = option.getOrElse("hello");


        // getOrElse(supplier)
        // some: return the value, none: invoke the supplier to have a value
        String result3a = option.getOrElse(() -> "hello");
        String result3b = option.getOrElse(MainTest::result3Supplier);
        String result3c = option.getOrElse(new Supplier<String>() {
            @Override
            public String get() {
                return "hello";
            }
        });


        // getOrElse(supplier)
        // some: return the value, none: invoke the supplier to throw an exception
        String result4a = option.getOrElseThrow(() -> {
            throw new IllegalArgumentException("Failed");
        });
        String result4b = option.getOrElseThrow(MainTest::result4Supplier);
        String result4c = option.getOrElseThrow(new Supplier<RuntimeException>() {
            @Override
            public RuntimeException get() {
                throw new IllegalArgumentException("Failed");
            }
        });


        // getOrNull();
        // some: return the value, none: return null
        String result5 = option.getOrNull();

        // option.getOrElseTry( checked-function)
        // some: return the value, none: invoke the function to get the value
        String result6a = option.getOrElseTry(() -> aMethod());
        String result6b = option.getOrElseTry(this::aMethod);
        String result6c = option.getOrElseTry(new CheckedFunction0<String>() {
            @Override
            public String apply() throws Throwable {
                return aMethod();
            }
        });

    }

    private String aMethod() {
        return "hi";
    }

    private static String result3Supplier() {
        return "hello";
    }


    private static RuntimeException result4Supplier() {
        throw new IllegalArgumentException("Failed");
    }
}
