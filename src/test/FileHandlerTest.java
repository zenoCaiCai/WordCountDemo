package test;

import org.junit.*;

import wc.*;

public class FileHandlerTest
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
    public void testFileHandle() throws Exception
    {
        FileHandler f = new FileHandler();
        f.FileHandle("./targets/target1.txt", 0, new String[]{""});
    }
    
    
} 
