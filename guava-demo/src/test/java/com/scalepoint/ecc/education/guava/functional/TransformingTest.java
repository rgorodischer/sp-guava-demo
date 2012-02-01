package com.scalepoint.ecc.education.guava.functional;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * @author rgo
 */
@Test
public class TransformingTest {
    
    public void testValidTransformation() {
        List<Integer> values = ImmutableList.of(1, 2, 3, 4, 5);
        List<Integer> squares = Lists.transform(values, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer value) {
                return value * value;
            }
        });
        assertEquals(squares, ImmutableList.of(1, 4, 9, 16, 25));
    }
    
    public void testInvalidTransformation() throws IOException {
        List<String> fileNames = ImmutableList.of("1.txt", "2.txt", "3.txt");
        List<File> files = Lists.transform(fileNames, new Function<String, File>() {
            @Override
            public File apply(String fileName) {
                //remove if exists
                if (new File(fileName).delete()) {
                    System.out.println(fileName + " deleted.");
                }
                return new File(fileName);
            }
        });
        //THE NEXT CODE IS WRONG!!!
        //A NEW FILE IS CREATED EVERY TIME (AND THE OLD ONE IS DELETED)
        //A CORRECT SOLUTION: MAKE DEFENSIVE COPY OF FILES AND WORK ONLY WITH IT
        for (File file : files) {
            Files.append("single line", file, Charset.defaultCharset());
        }
        for (File file : files) {
            Files.append("single line", file, Charset.defaultCharset());
        }
    }

    
}
