package com.scalepoint.ecc.education.guava.strings;

import com.google.common.base.Splitter;
import org.testng.annotations.Test;

import java.util.List;

import static com.google.common.base.CharMatcher.anyOf;
import static com.google.common.collect.Lists.newArrayList;
import static org.testng.Assert.assertEquals;

/**
 * @author rgo
 */
@Test
public class SplitterTest {

    public void testSplitter() {
        String jsonString = "" +
                "{\n" +
                "  \"key1\" : \"value1\",\n" +
                "  \"key2\" : \"value2\"\n" +
                "}";

        Iterable<String> result = Splitter.on(anyOf(":,")).trimResults(anyOf("{}\"\n "))
                        .omitEmptyStrings().split(jsonString);
        List<String> parsedJson = newArrayList(result);
        assertEquals(parsedJson.size(), 4);
        assertEquals(parsedJson.get(0), "key1");
        assertEquals(parsedJson.get(1), "value1");
        assertEquals(parsedJson.get(2), "key2");
        assertEquals(parsedJson.get(3), "value2");
    }
}
