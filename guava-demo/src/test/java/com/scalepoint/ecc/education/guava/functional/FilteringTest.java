package com.scalepoint.ecc.education.guava.functional;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.*;
import org.testng.annotations.Test;

import javax.annotation.Nullable;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.testng.Assert.assertEquals;

/**
 * @author rgo
 */
@Test
public class FilteringTest {
    
    public void testFilterNulls() {
        List<String> strings = newArrayList("first", "second", null, null, "third");
        List<String> noNulls = newArrayList(Iterables.filter(strings, Predicates.notNull()));
        assertEquals(noNulls, ImmutableList.of("first", "second", "third"));
    }
    
    public void testRemoveByPredicate() {
        List<Integer> numbers = newArrayList(1, 2, 3, 4, 5, 7, 9, 10, 15, 20);
        Predicate<Integer> evenNumber = new Predicate<Integer>() {
            @Override
            public boolean apply(Integer number) {
                return number % 2 == 0;
            }
        }; 
        Collections2.filter(numbers, evenNumber).clear(); //removes values from the backed collection 'numbers'
        assertEquals(numbers, ImmutableList.of(1, 3, 5, 7, 9, 15));
    }
}
