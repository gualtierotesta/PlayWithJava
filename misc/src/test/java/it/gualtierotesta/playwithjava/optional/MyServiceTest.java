package it.gualtierotesta.playwithjava.optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

class MyServiceTest {

    private MyService service = new MyService();

    @Test
    void testCheckDatoNonNullo() {
        // Voglio sapere se il campo nome è non nullo.

//        MyDataClass dataClass = service.doSomething();
//        boolean hasName = false;
//        if (dataClass != null) {
//            if (dataClass.getName() != null) {
//                hasName = true;
//            }
//        }

        boolean hasName = Optional.ofNullable(service.doSomething())
                .map(d -> d.getName())
                .isPresent();
        Assertions.assertTrue(hasName);
    }

    @Test
    void testCheckDatoHaLunghezza5() {
        // Voglio sapere se il campo nome è non nullo e ha lunghezza  (esempio di test sul suo valore)

//        MyDataClass dataClass = service.doSomething();
//        boolean hasLength5 = false;
//        if (dataClass != null) {
//            if (dataClass.getName() != null && dataClass.getName().length()==5) {
//                hasLength5 = true;
//            }
//        }

        boolean hasLength5 = Optional.ofNullable(service.doSomething())
                .map(d -> d.getName())
                .filter(s -> s.length() == 5)
                .isPresent();
        Assertions.assertFalse(hasLength5);
    }

    @Test
    void testLeggoDato() {
        // Voglio leggere un dato e, se è senza valore (=null), usare un valore in alternativa

//        MyDataClass dataClass = service.doSomething();
//        BigDecimal amount = BigDecimal.TEN;
//        if (dataClass != null) {
//            UserProfile userProfile = dataClass.getUserProfile();
//            if (userProfile != null) {
//                amount = userProfile.getAmount();
//            }
//        }

        BigDecimal amount = Optional.ofNullable(service.doSomething())
                .map(MyDataClass::getUserProfile)
                .map(UserProfile::getAmount)
                .orElse(BigDecimal.TEN);
        Assertions.assertEquals(10, amount.intValue());
    }

    @Test
    void testLeggoConfigurazioneDaDiversiPunti() {
//
//        long parameter = Optional.ofNullable(System.getenv("MyVar"))
//                .orElseGet(() -> Optional.ofNullable(System.getProperty("my-prop")))
//                .map(Long::parseLong)
//                .orElse(15L);

    }

    private String readConfigurationFromWebSphere() {
        return null;
    }
}