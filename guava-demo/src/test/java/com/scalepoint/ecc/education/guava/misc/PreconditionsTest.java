package com.scalepoint.ecc.education.guava.misc;

import com.google.common.base.Preconditions;
import org.testng.annotations.Test;

/**
 * @author rgo
 */
@Test
public class PreconditionsTest {
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCheckArgument() {
        Preconditions.checkArgument("tooLongString".length() < 10);
    }

    @Test(expectedExceptions = NullPointerException.class, expectedExceptionsMessageRegExp = "Mustn't be null")
    public void testCheckNotNull() {
        String str = null;
        Preconditions.checkNotNull(str, "Mustn't be null");
    }
}
