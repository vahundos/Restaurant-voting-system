package com.vahundos;

import com.vahundos.web.json.JsonUtil;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import java.io.UnsupportedEncodingException;

import static com.vahundos.web.json.JsonUtil.writeValue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class TestUtil {
    public static <T> void assertMatch(T actual, T expected, String... ignoredFields) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, ignoredFields);
    }

    public static <T> void assertMatch(Iterable<T> actual, Iterable<T> expected, String... ignoredFields) {
        assertThat(actual).usingElementComparatorIgnoringFields(ignoredFields).isEqualTo(expected);
    }

    public static String getContent(ResultActions action) throws UnsupportedEncodingException {
        return action.andReturn().getResponse().getContentAsString();
    }

    public static ResultActions print(ResultActions action) throws UnsupportedEncodingException {
        System.out.println(getContent(action));
        return action;
    }

    public static <T> T readFromJson(ResultActions action, Class<T> clazz) throws UnsupportedEncodingException {
        return JsonUtil.readValue(getContent(action), clazz);
    }

    public static <T> ResultMatcher contentJson(T expected) {
        return content().json(writeValue(expected), true);
    }

    public static <T> ResultMatcher contentJsonArray(T... expected) {
        return contentJson(expected);
    }
}
