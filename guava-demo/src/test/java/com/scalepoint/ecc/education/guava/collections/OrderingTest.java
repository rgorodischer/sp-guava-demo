package com.scalepoint.ecc.education.guava.collections;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.inject.internal.ImmutableList;
import org.testng.annotations.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author rgo
 */
@Test
public class OrderingTest {

    public void testNaturalOrdering() {
        List<Integer> unsorted = newArrayList(5, 4, 3, 1, 2);
        Ordering<Integer> naturalOrdering = Ordering.natural();
        
        assertFalse(naturalOrdering.isOrdered(unsorted));
        int max = naturalOrdering.max(unsorted);
        int min = naturalOrdering.min(unsorted);
        assertEquals(max, 5);
        assertEquals(min, 1);
        
        List<Integer> sorted = naturalOrdering.sortedCopy(unsorted);
        assertTrue(naturalOrdering.isOrdered(sorted));
        assertEquals(sorted, newArrayList(1, 2, 3, 4, 5));
        
        List<Integer> reverseSorted = naturalOrdering.reverse().sortedCopy(unsorted);
        assertEquals(reverseSorted, Lists.newArrayList(5, 4, 3, 2, 1));
    }
    
    public void testExplicitOrdering() {
        List<String> daysOfWeek = ImmutableList.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        Ordering<String> daysOrdering = Ordering.explicit(daysOfWeek);
        List<String> unorderedDays = ImmutableList.of("Friday", "Wednesday", "Monday");
        List<String> orderedDays = daysOrdering.sortedCopy(unorderedDays);
        assertEquals(orderedDays, newArrayList("Monday", "Wednesday", "Friday"));
        
        String lastDay = daysOrdering.max(unorderedDays);
        assertEquals(lastDay, "Friday");
    }
}
