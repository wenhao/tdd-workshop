###创建项目
1. 使用github托管项目:white_check_mark:
2. 使用maven或者gradle构建项目:white_check_mark:
3. 添加junit、mockito、guava依赖:white_check_mark:
4. 能够执行测试并build成功通过:white_check_mark:

###任务分解
TDD 的一个重要步骤是在分析需求之后, 对其进行任务分解。每个任务相当于一个功能点,它们都是可以验证的。
在进行TDD时, 可以根据具体情况, 对任务再进行分解, 或者增加一些我们之前未曾发现的任务。

###任务分解
1. 计算单个Item的价格：一件商品，数量2，不打折。
```
驱动出ShoppingItem, 构造方法接受商品名称、价格及数量。
驱动出cost方法来计算单个item的价格。
```
2. 在打折的情况下计算单个Item的价格： 一件商品，数量2，打折。
```
因为是针对ShoppingItem打折，所以打折方法在ShoppingItem里。
驱动出discount方法，Discount类作为参数。
重构discount数额为构造方法参数。
```