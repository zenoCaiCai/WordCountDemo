import jdk.jshell.*;
import org.junit.*;

import org.junit.runner.*;
import org.junit.runners.*;
import wc.*;

import java.util.*;

@RunWith(Parameterized.class)
public class FileHandlerTest
{
    public int isStop;
    public String path;
    public String[] stopList;
    public int exChar = 0;         //字符计数
    public int exWord = 0;         //单词计数
    public int exLine = 0;         //行数计数
    public int exSpLine = 0;       //空行计数
    public int exCLine = 0;        //代码行计数
    public int exNLine = 0;        //注释行计数
    
    
    public FileHandlerTest(
         int isStop,
         String path,
         String[] stopList,
         int exChar,
         int exWord,
         int exLine,
         int exSpLine,
         int exCLine,
         int exNLine)
    {
        this.isStop = isStop;
        this.path = path;
        this.stopList = stopList;
        this.exChar = exChar;
        this.exWord = exWord;
        this.exLine = exLine;
        this.exSpLine = exSpLine;
        this.exCLine = exCLine;
        this.exNLine = exNLine;
    }
    
    @Parameterized.Parameters
    public static Collection parameters()
    {
        return Arrays.asList(new Object[][]
        {
            
            // ===== 全覆盖测试用例 =====
            
            // 空文件
            {
                0, "./targets/FileHandler/empty.txt", null,
                0, 0, 0, 0, 0, 0
            },
            
            // 非空文件
            // 无停表
            // 无空行
            // 无 // 类型注释
            // 无 /* 类型注释
            {
                0, "./targets/FileHandler/1.txt", null,
                13, 2, 1, 0, 1, 0
            },
    
            // 非空文件
            // 有停表
            //    停表内容有匹配
            // 有空行
            // 有 // 类型注释
            // 有 /* 类型注释
            //   能找到匹配的 */
            //   是一行的开头
            {
                1, "./targets/FileHandler/2.txt", new String[]{ "stop" },
                64, 13, 9, 3, 2, 4
            },
    
    
            // 非空文件
            // 有停表
            //    停表内容无匹配
            // 无空行
            // 无 // 类型注释
            // 有 /*类型注释
            //   不是一行的开头
            // 有 /* 类型注释
            //   不能找到匹配的 */
            {
                1, "./targets/FileHandler/3.txt", new String[]{ "stop" } ,
                50, 12, 9, 3, 4, 2
            },
            
            // ===== 边界值和异常输入用例 =====
            
            // 无后缀名的空文件
            {
                0, "./targets/FileHandler/no-extension", null,
                0, 0, 0, 0, 0, 0
            },
            
            // 无后缀名的非空文件
            {
                0, "./targets/FileHandler/no-extension-with-content", null,
                13, 2, 1, 0, 1, 0
            },
            
            // 全符号字符文件
            {
                0, "./targets/FileHandler/punctuations.txt", null,
                49, 9, 9, 0, 2, 7
            },
            
            // 分词符作停表内容
            {
                1, "./targets/FileHandler/separator-stop.txt", new String[]{ " ", "\n" },
                42, 10, 4, 2, 2, 0
            },
            
            // 注释符号作停表内容
            {
                1, "./targets/FileHandler/comment-stop.txt", new String[]{ "/", "*" },
                42, 10, 4, 2, 2, 0
            },
    
            // 停表的忽略大小写
            {
                1, "./targets/FileHandler/upper-lower.txt", new String[]{ "a", "b" },
                23, 3, 5, 0, 5, 0
            },
    
    
        });
    }
    
    
    @Test
    public void testFileHandle() throws Exception
    {
        FileHandler f = new FileHandler();
        f.FileHandle(path, isStop, stopList);
        
        System.out.printf("%d, %d, %d, %d, %d, %d\n",
            f.countChar,
            f.countword,
            f.countline,
            f.countSpaceLine,
            f.countCodeLine,
            f.countNoteLine
        );
        
//        Assert.assertEquals(f.countChar, exChar);
//        Assert.assertEquals(f.countword, exWord);
//        Assert.assertEquals(f.countline, exLine);
//        Assert.assertEquals(f.countCodeLine, exCLine);
//        Assert.assertEquals(f.countSpaceLine, exSpLine);
//        Assert.assertEquals(f.countNoteLine, exNLine);
    }
    
    
} 
