package it.gualtierotesta.playwithjava.vavr;

import io.vavr.control.Either;

import java.util.List;

public class Main2 {

    enum MyError2 { ERR1, ERR2 }

    static Either<MyError2, String> m1 () { return Either.right("ok");}
    static Either<MyError2, Integer> m2 (String str) { return Either.right(str.length());}


    public static void main(String[] args) {

        Either<Integer, String> e1 = Either.right("ok1");
        Either<Integer, String> e2 = Either.right("ok2");
        Either<Integer, String> e3 = Either.left(3);
        Either<Integer, String> e4 = Either.left(4);


        Either<List<Integer>, List<String>> e10 = Either.sequence(List.of(e1, e2, e3, e4))
                .bimap(ls -> ls.toJavaList(), lr -> lr.toJavaList());
        System.out.println("e10 = " + e10);

    }
}
