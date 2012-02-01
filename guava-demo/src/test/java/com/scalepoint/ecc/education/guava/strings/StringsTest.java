package com.scalepoint.ecc.education.guava.strings;

import com.google.common.base.Strings;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author rgo
 */
@Test
public class StringsTest {
    
    public void testStringsUtils() {
        assertNull(Strings.emptyToNull(""));
        assertNotNull(Strings.nullToEmpty(null));
        assertTrue(Strings.isNullOrEmpty("") && Strings.isNullOrEmpty(null));
    }
    
    public void testStringRepeat() {
        String i18nX10 = Strings.repeat("internationalization", 10);
        assertEquals(i18nX10.length(), 200);
    }
}
