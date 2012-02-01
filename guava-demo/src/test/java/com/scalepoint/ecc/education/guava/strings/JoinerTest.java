package com.scalepoint.ecc.education.guava.strings;

import com.google.common.base.Joiner;
import com.google.inject.internal.ImmutableMap;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static org.testng.Assert.assertEquals;

/**
 * @author rgo
 */
@Test
public class JoinerTest {
    
    public void testTokensJoining() {
        List<String> tokens = newArrayList("first", "second", null, "last");
        String result = Joiner.on(", ").useForNull("[null]").join(tokens);
        assertEquals(result, "first, second, [null], last");
    }
    
    public void testKeyValuePairsJoining() {
        Map<String, Integer> pairs = ImmutableMap.of("one", 1, "two", 2);
        String result = Joiner.on(", and ").withKeyValueSeparator(" corresponds to digit ").join(pairs);
        assertEquals(result, "one corresponds to digit 1, and two corresponds to digit 2");
    }
}
