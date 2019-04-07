package test.wordCountSuite;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.*;
import org.junit.runners.*;
import wc.WordCount;
import java.util.*;

@RunWith(Parameterized.class)
public class IteratorPathTest {
    String testPath;
    String testFileClass;
    String filePath;

    public IteratorPathTest(
            String testPath,
            String testFileClass,
            String filePath
    ){
        this.testPath = testPath;
        this.testFileClass = testFileClass;
        this.filePath = filePath;
    }

    @Parameterized.Parameters
    public static Collection parameters()
    {
        return Arrays.asList(new Object[][]
                {
                        {
                            //测试目录下多个同类型文件的路径提取
                            "targets/WordCount",".txt",
                            "[targets/WordCount/txt2.txt, targets/WordCount/txt1.txt]"
                        },
                        {
                            //测试在-s参数下单个文件路径的提取
                            "targets/WordCount/txt1.txt",".txt",
                            "[targets/WordCount/txt1.txt]"
                        },
                        {
                            //测试在-s参数下，多个不同后缀的文件的路径提取
                            "targets/WordCount",".txt",
                            "[targets/WordCount/txt2.txt, targets/WordCount/txt1.txt]"
                        }
                });
    }

    @Test
    public void testFileHandle() throws Exception
    {
        WordCount wc = new WordCount();
        wc.iteratorPath(testPath,testFileClass);

        System.out.printf("%s",wc.filePath);

        Assert.assertEquals(filePath,wc.filePath.toString());
    }
}
