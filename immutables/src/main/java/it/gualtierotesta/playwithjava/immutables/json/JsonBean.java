package it.gualtierotesta.playwithjava.immutables.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import it.gualtierotesta.playwithjava.immutables.Nullable;
import org.immutables.value.Value;

import java.util.List;

/**
 * An immutable bean that can be used for JSON serialization/deserialization
 */
@Value.Immutable
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(as = ImmutableJsonBean.class)
@JsonDeserialize(as = ImmutableJsonBean.class)
public interface JsonBean {

    @Nullable
    String name();
    int value();
    List<JsonPropBean> props();

}
