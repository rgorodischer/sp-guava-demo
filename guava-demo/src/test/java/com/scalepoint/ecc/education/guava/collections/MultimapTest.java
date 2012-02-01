package com.scalepoint.ecc.education.guava.collections;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * @author rgo
 */
@Test
public class MultimapTest {

    public void testMultimap() {
        Multimap<String, String> foods = HashMultimap.create();
        foods.put("Fruits", "Banana");
        foods.put("Fruits", "Apple");
        foods.put("Vegetables", "Carrot");
        foods.put("Vegetables", "Potato");

        assertEquals((Set<String>)foods.get("Fruits"), ImmutableSet.of("Banana", "Apple"));    //cast is needed to call assertEquals(Set, Set) but not assertEquals(Collection, Collection)
        assertEquals((Set<String>)foods.get("Vegetables"), ImmutableSet.of("Potato", "Carrot"));

        Map<String, Collection<String>> foodsMap = foods.asMap();
        assertEquals(foodsMap.size(), 2);
        assertEquals(foodsMap.keySet(), ImmutableSet.of("Fruits", "Vegetables"));
    }
}
