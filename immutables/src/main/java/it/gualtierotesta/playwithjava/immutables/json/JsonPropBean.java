package it.gualtierotesta.playwithjava.immutables.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.List;

/**
 * An immutable bean that can be used for JSON serialization/deserialization
 */
@Value.Immutable
@JsonSerialize(as = ImmutableJsonPropBean.class)
@JsonDeserialize(as = ImmutableJsonPropBean.class)
public interface JsonPropBean {

        String propName();
}
