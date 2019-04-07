package test;

import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    FileHandlerTest.class,
    WordCountTest.class
})
public class AllTest
{

}
