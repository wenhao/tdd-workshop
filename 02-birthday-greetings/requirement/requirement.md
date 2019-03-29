### Problem: [The birthday greetings kata](http://matteo.vaccari.name/blog/archives/154)

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

The program should be invoked by a main program like this one:

public static void main(String[] args) {
    ...
    BirthdayService birthdayService = new BirthdayService(
        employeeRepository, emailService);
    birthdayService.sendGreetings(today());
}
Note that the collaborators of the birthdayService objects are injected in it. Ideally domain code should never use the new operator. The new operator is called from outside the domain code, to set up an aggregate of objects that collaborate together.

#### Goals
The goal of this exercise is to come up with a solution that is

* Testable; we should be able to test the internal application logic with no need to ever send a real email.
* Flexible: we anticipate that the data source in the future could change from a flat file to a relational database, or perhaps a web service. We also anticipate that the email service could soon be replaced with a service that sends greetings through Facebook or some other social network.
* Well-designed: separate clearly the business logic from the infrastructure. 

#### An optional complication 

If you want to develop further the domain logic, you can take into account the special rule for people born on a 29th of February: they should be sent greetings on the 28th of February, except in leap years, when they will get their greetings on the 29th.

#### Testability
A test is not a unit test if:

* It talks to a database
* It communicates across the network
* It touches the file system
* You have to do things to your environment to run it (eg, change config files, comment line)

Tests that do this are integration tests.

Integration tests have their place; but they should be clearly marked as such, so that we can execute them separately. The reason we draw this sharp distinction is that unit tests should be

* Very fast; we expect to run thousands of tests per second.
* Reliable; we don’t want to see tests failing because of random technical problems in external systems.


One way to make code more testable is to use Dependency Injection. This means that an object should never instantiate its collaborator by calling the new operator. It should be passed its collaborators instead. When we work this way we separate classes in two kinds.

* Application logic classes have their collaborators passed into them in the constructor.
* Configuration classes build a network of objects, setting up their collaborators.
Application logic classes contain a bunch of logic, but no calls to the new operator. Configuration classes contain a bunch of calls to the new operator, but no application logic.

#### 要求

代码标准至少达到下列三项以上：

* 代码github托管
* 使用构建工具Maven或者Gradle
* 使用Intellij Idea，无明显的Intellij Idea代码优化提示(灰色标记的代码)
* 合理的项目代码脚手架
* 命名规范，尽量少的实体，比如类、方法、函数等
* 尽可能符合OO设计原则
* 有测试，没有重复代码，保持代码整洁，易懂