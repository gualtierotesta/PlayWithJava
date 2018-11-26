package it.gualtierotesta.playwithjava.optional;

public class MyService {

    MyDataClass doSomething() {
        return new MyDataClass();
    }

    UserProfile identifyLoggedUser() {
        return UserProfile.builder()
                .valid(true)
                .firstName("Gualtiero")
                .lastName("Testa")
                .build();
    }
}
