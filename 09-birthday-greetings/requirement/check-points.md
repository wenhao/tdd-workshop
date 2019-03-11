### 创建项目
1. 使用github托管项目:white_check_mark:
2. 使用maven或者gradle构建项目:white_check_mark:
3. 添加junit、mockito、guava依赖:white_check_mark:
4. 能够执行测试并build成功通过:white_check_mark:

### 任务分解

1. 从文件读取employee信息。
2. 查询**当天**过生日的employee。
3. 给过生日的employee发邮件。

### 任务一

查询**当天**过生日的employee。

* 对象: Employee, EmployeeFinder
* 行为: findAll
* 测试名称: should_find_all_employees_by_birthday_date

查询的结果中不应该包含非指定日期的employee。

### 任务二

能够找出闰年2.29号生日在平年2.28号的employee。

* 测试名称: should_find_all_employees_include_leap_year_birthday

### 任务三

从文件读取employee信息。目前EmployeeFinder接收的是employees，重构为从文件读取。
