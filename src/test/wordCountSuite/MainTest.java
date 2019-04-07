package test.wordCountSuite;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import wc.WordCount;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

@RunWith(Parameterized.class)
public class MainTest {
    String[] args;
    String expectd;

    public MainTest(
        String args,
        String expectd
    ) {
        this.args = args.split(",");
        this.expectd = expectd;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]
                {
                        {
                                "-s,-w,-c,-l,targets/WordCount/",
                                "targets/WordCount/txt1.txt, 字符数: 1018701\n" +
                                        "targets/WordCount/txt1.txt, 单词数: 205260\n" +
                                        "targets/WordCount/txt1.txt, 行数: 21555\n"
                        },
                        {
                                "-s,-w,-c,-l,targets/WordCount/txt1.txt",
                                "targets/WordCount/txt1.txt, 字符数: 1018701\n" +
                                        "targets/WordCount/txt1.txt, 单词数: 205260\n" +
                                        "targets/WordCount/txt1.txt, 行数: 21555\n"
                        },
                        {
                                "-w,-c,-l,targets/WordCount/txt1.txt",
                                "targets/WordCount/txt1.txt, 字符数: 1018701\n" +
                                        "targets/WordCount/txt1.txt, 单词数: 205260\n" +
                                        "targets/WordCount/txt1.txt, 行数: 21555\n"
                        }
                });
    }


    @Test
    public void testMain() throws Exception {
        PrintStream save_out=System.out;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        WordCount.main(args);

        Assert.assertEquals(expectd, out);
    }
}
