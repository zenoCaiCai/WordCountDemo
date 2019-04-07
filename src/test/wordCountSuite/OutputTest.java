package test.wordCountSuite;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.*;
import org.junit.runners.*;
import wc.*;
import java.util.*;

@RunWith(Parameterized.class)
public class OutputTest {
    FileHandler fHandler;
    String[] args;
    String buffer = "";
    String expected;

    public OutputTest(
            String args,
            String expected
    ){
        this.args = args.split(",");
        this.expected = expected;

        fHandler = new FileHandler();
        fHandler.fileName = "fileName";
        fHandler.countword = 1;
        fHandler.countChar = 2;
        fHandler.countline = 3;
        fHandler.countCodeLine = 4;
        fHandler.countNoteLine = 5;
        fHandler.countSpaceLine = 6;
    }

    @Parameterized.Parameters
    public static Collection parameters()
    {
        return Arrays.asList(new Object[][]
                {
                        {

                                "-a",
                                "fileName, 代码行/空行/注释行: 4/6/5\n"
                        },
                        {

                                "-w,-c,-l",
                                "fileName, 字符数: 2\n" +
                                        "fileName, 单词数: 1\n" +
                                        "fileName, 行数: 3\n"
                        },
                        {

                                "-w,-c",
                                "fileName, 字符数: 2\n" +
                                        "fileName, 单词数: 1\n"
                        },
                        {

                                "-w,-c,-l,-a",
                                "fileName, 字符数: 2\n" +
                                        "fileName, 单词数: 1\n" +
                                        "fileName, 行数: 3\n" +
                                        "fileName, 代码行/空行/注释行: 4/6/5\n"
                        }
                });
    }

    @Test
    public void testOutput() throws Exception
    {
        buffer = WordCount.Output(args,fHandler,buffer);
        System.out.printf(buffer);

        Assert.assertEquals(expected,buffer);
    }
}
