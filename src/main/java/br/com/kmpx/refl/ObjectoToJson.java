package br.com.kmpx.refl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ObjectoToJson {

    public String transform(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper =  new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        Map<String, Object> mapper =  new HashMap<>();
        Class<?> classToBeTransform =  object.getClass();

        Arrays.stream(classToBeTransform.getDeclaredFields()).collect(Collectors.toList()).forEach(
                field -> {
                    field.setAccessible(true);
                    String key = field.getName();
                    Object value = null;
                    try {
                        value = field.get(object);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    mapper.put(key, value);
                }
        );
        return objectMapper.writeValueAsString(mapper);
    }
}
