###创建项目
1. 使用github托管项目:white_check_mark:
2. 使用maven或者gradle构建项目:white_check_mark:
3. 添加junit、mockito、guava依赖:white_check_mark:
4. 能够执行测试并build成功通过:white_check_mark:

```
任务分解
TDD 的一个重要步骤是在分析需求之后, 对其进行任务分解。每个任务相当于一个功能点,它们都是可以验证的。
在进行TDD时, 可以根据具体情况, 对任务再进行分解, 或者增加一些我们之前未曾发现的任务。
```

###任务分解
1. 随机生成6位不重复的数字:white_check_mark:
2. 判断每次猜测的结果:white_check_mark:
3. 判断输入是否合法:white_check_mark:
4. 记录并显示历史猜测记录:white_check_mark:
5. 判断游戏结果。判断猜测次数，如果满6次但是未猜对判断负；如果在6次内猜测的4个数字值与位置都正确，则判胜。:white_check_mark:

```
讨论：选择开始的任务
在分解好任务开始测试驱动开发时， 我们应该优先选择哪一个任务 ？
选择的标准包括:
    1. 任务的依赖性
    2. 任务的重要性
```
