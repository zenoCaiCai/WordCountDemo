package test;

import org.junit.runner.*;
import org.junit.runners.*;
import test.wordCountSuite.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        IteratorPathTest.class,
        OutputTest.class,
        MainTest.class
})
public class WordCountTest
{
} 
