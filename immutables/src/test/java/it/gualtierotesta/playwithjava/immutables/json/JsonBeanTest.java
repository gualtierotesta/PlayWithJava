package it.gualtierotesta.playwithjava.immutables.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonBeanTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Test
    @DisplayName("Serialize and deserialize immutable bean via its builder")
    void test01() throws JsonProcessingException {
        // given
        ImmutableJsonBean bean = ImmutableJsonBean.builder()
                .name("name")
                .value(42)
                .props(List.of(ImmutableJsonPropBean.builder().propName("apple").build()))
                .build();
        // when
        String result = OBJECT_MAPPER.writeValueAsString(bean);
        JsonBean bean2 = OBJECT_MAPPER.readValue(result, JsonBean.class);
        // then
        assertEquals(bean, bean2);
    }

    @Test
    @DisplayName("Handle unknown fields in input JSON")
    void test02() throws JsonProcessingException {
        // given
        String json = "{" +
                "\"unknown\":\"unknown\"," +
                "\"name\":\"name\"," +
                "\"value\":42,\"props\":[{\"propName\":\"apple\"}]}";
        // when
        JsonBean bean = OBJECT_MAPPER.readValue(json, JsonBean.class);
        // then
        assertEquals(42, bean.value());
    }


    @Test
    @DisplayName("Handle null values in input JSON")
    void test03() throws JsonProcessingException {
        // given
        String json = "{" +
//                "\"name\": null," +
                "\"value\":42}]}";
        // when
        JsonBean bean = OBJECT_MAPPER.readValue(json, JsonBean.class);
        // then
        assertEquals(42, bean.value());
        assertNull(bean.name());  // name has been marked as nullable in JsonBean
        assertTrue(bean.props().isEmpty());  // Collections are empty when JSON is null
    }
}
