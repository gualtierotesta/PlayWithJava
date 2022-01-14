package it.gualtierotesta.playwithjava.immutables;

import java.util.List;

public class Main {

    public static void main(final String[] args) {

        // Immutable bean

        MyBean bean = ImmutableMyBean.builder()
            .name("name")
            .addProps("one", "two")
            .build();
        System.out.println("bean = " + bean);

        MyBean bean2 = ImmutableMyBean.copyOf(bean).withName("name 2");
        System.out.println("bean2 = " + bean2);

        MyBean bean3 = MyBean.create("name 3", List.of("1"));
        System.out.println("bean3 = " + bean3);

        MyBean bean4 = ImmutableMyBean.builder()
            .name("name")
            .addProps("one", "two")
            .build();
        System.out.println("bean4 = " + bean4);

        // Immutable bean

        ModifiableMyJavaBean jb = ModifiableMyJavaBean.create()
            .setName("name")
            .addProps("one", "two");
        System.out.println("jb = " + jb);
        jb.setName("name 42");
        System.out.println("jb = " + jb);

        // ValueObject
        it.gualtierotesta.playwithjava.immutables.valueobject.MyValueObject vo = it.gualtierotesta.playwithjava.immutables.valueobject.MyValueObject.of("42");
        System.out.println("vo = " + vo);

    }

}
