package com.scalepoint.ecc.education.guava.collections;

import com.google.common.collect.*;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

/**
 * @author rgo
 */
@Test
public class CollectionsUtilsTest {
    
    public void testReversList() {
        List<Integer> digits = Lists.newArrayList(0, 1, 2, 3, 4, 5);
        List<Integer> reversed = Lists.reverse(digits);      //makes a reversed 'live-view' 
                                  
        assertEquals(reversed, ImmutableList.of(5, 4, 3, 2, 1, 0));
        digits.add(6);
        digits.add(7);
        assertEquals(reversed, ImmutableList.of(7, 6, 5, 4, 3, 2, 1, 0));
    }
    
    public void testListPartitioning() {
        List<Integer> numbers = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<List<Integer>> partitions = Lists.partition(numbers, 5); //specify desired size; backed by the original list
        assertEquals(partitions.size(), 2);
        assertEquals(partitions.get(0), ImmutableList.of(1, 2, 3, 4, 5));
        assertEquals(partitions.get(1), ImmutableList.of(6, 7, 8, 9, 10));
        numbers.add(11);
        numbers.add(12);
        assertEquals(partitions.size(), 3);
        assertEquals(partitions.get(2), ImmutableList.of(11, 12));
    }
    
    @SuppressWarnings("unchecked")
    public void testSetsOperations() {
        Set<String> allDays = ImmutableSet.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        Set<String> weekDays = ImmutableSet.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");
        Set<String> weekEnd = ImmutableSet.of("Saturday", "Sunday");
        Set<String> evenDays = ImmutableSet.of("Tuesday", "Thursday", "Saturday");
        
        Set<String> dayTimes = ImmutableSet.of("morning", "daytime", "evening");
        
        assertEquals(Sets.union(weekDays, weekEnd), allDays);
        assertEquals(Sets.difference(allDays, weekDays), weekEnd);
        assertEquals(Sets.intersection(weekEnd, evenDays), ImmutableSet.of("Saturday"));
        
        assertEquals(Sets.cartesianProduct(weekEnd, dayTimes), 
                ImmutableSet.of(
                        ImmutableList.of("Saturday", "morning"),
                        ImmutableList.of("Sunday", "morning"),

                        ImmutableList.of("Saturday", "daytime"),
                        ImmutableList.of("Sunday", "daytime"),

                        ImmutableList.of("Saturday", "evening"),
                        ImmutableList.of("Sunday", "evening")
                )
        );
    }
    
    public void testMapsDifference() {
        Map<Integer, String> weekdays = ImmutableMap.of(1, "Monday", 2, "Tuesday", 3, "Wednesday", 4, "Thursday", 5, "Friday");
        Map<Integer, String> allDays = new ImmutableMap.Builder<Integer, String>()
                .put(1, "Monday")
                .put(2, "Tuesday")
                .put(3, "Wednesday")
                .put(4, "Thursday")
                .put(5, "Friday")
                .put(6, "Saturday")
                .put(7, "Sunday")
                .build();
        MapDifference<Integer, String> mapDifference = Maps.difference(weekdays, allDays);
        assertFalse(mapDifference.areEqual());
        assertEquals(mapDifference.entriesInCommon(), weekdays);
        assertEquals(mapDifference.entriesOnlyOnLeft(), Collections.emptyMap());
        assertEquals(mapDifference.entriesOnlyOnRight(), ImmutableMap.of(6, "Saturday", 7, "Sunday"));
    }
    
    public void testMapFromProperties() {
        Map<String, String> systemProperties = Maps.fromProperties(System.getProperties());
        assertEquals(systemProperties.get("file.separator"), System.getProperty("file.separator"));
    }

}
