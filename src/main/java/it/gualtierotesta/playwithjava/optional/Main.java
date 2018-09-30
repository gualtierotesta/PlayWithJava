package it.gualtierotesta.playwithjava.optional;

import java.math.BigDecimal;
import java.util.Optional;

public class Main {


    public void gestionePresenzaAssenza() {
        MyService service = new MyService();

        Optional<UserProfile> optional = Optional.ofNullable(service.identifyLoggedUser());

        // -----------------------------------------------------------------
        // 1 Eseguo qualcosa solo se esiste
        if (optional.isPresent()) {
            createView(optional.get());
        }

        optional.ifPresent(Main::createView);
        optional.ifPresent(up -> createView(up));

        // -----------------------------------------------------------------
        // 2 Eseguo qualcosa dipendente dal risultato
        if (optional.isPresent()) {
            createView(optional.get());
        } else {
            createErrorView();
        }

        optional.ifPresentOrElse(  // Java 9
                Main::createView,
                Main::createErrorView);

        // -----------------------------------------------------------------
        // 3 Eseguo qualcosa se esiste o lancio eccezione
        if (optional.isPresent()) {
            createView(optional.get());
        } else {
            throw new IllegalStateException("Profilo non esistente");
        }

        UserProfile userProfile = optional
                .orElseThrow(() -> new IllegalStateException("Profilo non esistente"));
        createView(userProfile);

    }

    public void gestioneDatoDefault() {

        MyService service = new MyService();

        Optional<MyDataClass> optional = Optional.ofNullable(service.doSomething());

        MyDataClass dataClass;
        if (optional.isPresent()) {
            dataClass = optional.get();
        } else {
            dataClass = defaultDataClass();
        }

        MyDataClass dataClass2 = optional
                .orElse(defaultDataClass());
    }

    public void elaborazioneDati() {
        MyService service = new MyService();
        MyDataClass dataClass = service.doSomething();

        // 1 Controllo esistenza dati gestendo i null
        boolean hasName = false;
        if (dataClass != null) {
            if (dataClass.getName() != null) {
                hasName = true;
            }
        }

        hasName = Optional.ofNullable(service.doSomething())
                .map(d -> d.getName())
                .isPresent();

        // 2 Leggo un dato
        BigDecimal amount1 = BigDecimal.TEN;
        if (dataClass != null) {
            UserProfile userProfile = dataClass.getUserProfile();
            if (userProfile != null) {
                amount1 = userProfile.getAmount();
            }
        }

        BigDecimal amount2 = Optional.ofNullable(service.doSomething())
                .map(MyDataClass::getUserProfile)
                .map(UserProfile::getAmount)
                .orElse(BigDecimal.TEN);


    }

    private MyDataClass defaultDataClass() {
        return new MyDataClass();
    }

    private static void createErrorView() {
    }

    private static void createView(UserProfile userProfile) {

    }
}
