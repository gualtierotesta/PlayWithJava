package it.gualtierotesta.playwithjava.immutables;

import java.util.List;

import org.immutables.value.Value;

@Value.Modifiable
public interface MyJavaBean {

    String name();

    List<String> props();

}
