package test;

import org.junit.runner.*;
import org.junit.runners.*;
import wc.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    FileHandlerTest.class,
    WordCountTest.class,
})
public class AllTest
{

}
