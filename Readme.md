# WordCount Demo
https://github.com/zenoCaiCai/WordCountDemo

## 介绍 Description
1. 本程序是进行“软件质量与测试”课程的测试目标，测试使用文件请放在/targets/目录下。测试用例文档请放到/doc/目录下。
1. 课程相关文档存储在/doc/目录下。
1. 本程序的需求是黑盒测试中曾经讨论过的WordCount问题，关于WordCount问题的需求描述详见课程学习平台中，专题讨论区中“WC问题的测试”。

### 如何 Run Tests
1. 使用 IntelliJ IDEA 打开文件夹.
1. 设置 Project Structure -> Project Settings -> Project 下的所有项.
1. 设置 Project Structure -> Project Settings -> Modules -> Paths, 选取 Inheritance project compile output path.
1. 在工程目录下新建一个文件夹 lib.
1. 将 hamcrest-core-1.3.jar 和 junit-4.12.jar 放入 lib 文件夹.
1. 在 IntelliJ IDEA 的 Project 选项卡中可以看到两个 lib. 分别右键点击 jar 文件, 选择 Add as library.
1. 右键单击任意测试文件, 点击 Run '...'.
注意:
1. project settings 作为个人配置文件使用, 不commit.
