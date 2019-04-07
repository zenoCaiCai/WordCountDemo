package test;

import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    FileHandler.class,
    WordCount.class,
})
public class AllTest
{

}
