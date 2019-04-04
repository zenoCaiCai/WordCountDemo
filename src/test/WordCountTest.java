import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import wc.*;

public class WordCountTest
{
    
    @Before
    public void before() throws Exception
    {
    }
    
    @After
    public void after() throws Exception
    {
    }
    
    @Test
    public void testIteratorPath() throws Exception
    {
        WordCount x = new WordCount();
        x.iteratorPath("./target/", "txt");
    }
    
    
    @Test
    public void testOutput() throws Exception
    {
    
    }
    
    
    @Test
    public void testMain() throws Exception
    {
    
    }
    
    
} 
