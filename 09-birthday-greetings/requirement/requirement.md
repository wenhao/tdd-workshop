### Problem The birthday greetings kata

Write a program that Loads a set of employee records from a flat file(employee_records.txt)
Sends a greetings email to all employees whose birthday is today
The flat file is a sequence of records, separated by newlines; this are the first few lines:

last_name, first_name, date_of_birth, email

Doe, John, 1982/10/08, john.doe@foobar.com

Ann, Mary, 1975/09/11, mary.ann@foobar.com

The greetings email contains the following text:

Subject: **Happy birthday!**

**Happy birthday, dear John!**

with the first name of the employee substituted for “John”

#### 要求

代码标准至少达到下列三项以上：

* 代码github托管
* 使用构建工具Maven或者Gradle
* 使用Intellij Idea，无明显的Intellij Idea代码优化提示(灰色标记的代码)
* 合理的项目代码脚手架
* 命名规范，尽量少的实体，比如类、方法、函数等
* 尽可能符合OO设计原则
* 有测试，没有重复代码，保持代码整洁，易懂