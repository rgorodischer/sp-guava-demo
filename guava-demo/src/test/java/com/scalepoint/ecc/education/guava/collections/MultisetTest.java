package com.scalepoint.ecc.education.guava.collections;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @author rgo
 */
@Test
public class MultisetTest {
    
    private static final String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
            "Donec cursus faucibus ipsum, quis pretium nibh adipiscing eu. " +
            "Proin facilisis cursus sem, quis suscipit ipsum mattis eu. " +
            "In hendrerit suscipit sapien eget vehicula. Nulla vehicula blandit magna eu mollis. " +
            "Morbi iaculis posuere ipsum in venenatis. Vestibulum ante ipsum primis in faucibus.";

    public void testMultipleItems() {
        Multiset<String> words = HashMultiset.create();
        for (String token : text.toLowerCase().split(" |,|\\.")) {
            words.add(token);    
        }
        assertTrue(words.contains("lorem"));
        assertTrue(words.contains("ipsum"));
        assertEquals(words.count("ipsum"), 5);
    }
}
