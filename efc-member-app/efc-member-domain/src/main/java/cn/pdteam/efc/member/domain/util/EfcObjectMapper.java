package cn.pdteam.efc.member.domain.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EfcObjectMapper {

    private EfcObjectMapper() {
        throw new IllegalStateException("Utility class");
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> String writeJsonStringCacheToString(T object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            log.warn("writeJsonStringCacheToString error", e);
            return object.toString();
        }
    }

    public static <T> String writeJsonStringCacheNull(T object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            log.warn("writeJsonStringCacheToString error", e);
            return null;
        }
    }

    public static <T> T readValue(String content, Class<T> valueType) {
        try {
            return objectMapper.readValue(content, valueType);
        } catch (Exception e) {
            log.warn("readValue error", e);
            return null;
        }
    }

}
