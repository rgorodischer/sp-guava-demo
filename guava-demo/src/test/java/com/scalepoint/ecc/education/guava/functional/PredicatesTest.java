package com.scalepoint.ecc.education.guava.functional;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import org.testng.annotations.Test;

import javax.annotation.Nullable;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author rgo
 */
@Test
public class PredicatesTest {

    public void testPredicatesOnCollections() {
        List<String> strings = newArrayList("_first", "second", null, "THIRD"); 
        boolean hasItemsWithLeadingUnderline = Iterables.any(strings, startsWithUnderline);
        assertTrue(hasItemsWithLeadingUnderline);
        assertFalse(Iterables.all(strings, Predicates.notNull()));
        String itemWithLeadingUnderline = Iterables.find(strings, startsWithUnderline);
        assertEquals(itemWithLeadingUnderline, "_first");
    }

    private static final Predicate<String> startsWithUnderline = new Predicate<String>() {
        @Override
        public boolean apply(String input) {
            return input.startsWith("_");
        }
    };
}
