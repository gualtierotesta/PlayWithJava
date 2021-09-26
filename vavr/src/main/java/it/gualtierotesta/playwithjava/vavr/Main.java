package it.gualtierotesta.playwithjava.vavr;

import io.vavr.control.Either;
import io.vavr.control.Try;

public class Main {

    Dao dao = new Dao();

    public static void main(String[] args) {
        Main play = new Main();

        play.doSomething();

    }

    enum MyError { ERR1, ERR2 }

    private void doSomething() {

        Try<User> userTry = dao.findUser3();

        Either<Throwable, User> e1 = userTry.toEither();
        System.out.println("e1 = " + e1);

        Either<MyError, User> e2 = e1.mapLeft(ex -> MyError.ERR1);
        System.out.println("e2 = " + e2);

        Either<MyError, String> e3 = e2.map(user -> updateUser(user));
        System.out.println("e3 = " + e3);

        Either<MyError, String> e4 = e2.flatMap(user -> updateUser2(user));
        System.out.println("e4 = " + e4);
    }

    private Either<MyError, String> updateUser2(User pUser) {
        System.out.println("updateUser2");
        return dao.updateUser(pUser).toEither().mapLeft(ex -> MyError.ERR2);
        //return  Either.right("user2");
    }

    private String updateUser(User pUser) {
        System.out.println("updateUser");
        return "user";
    }
}
