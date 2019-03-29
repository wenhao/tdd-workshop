length
============

#需求

### 需求一

```
实现一个库: 通过这个库，用户可以以Mile为单位表一个长度，精度为1 Mile。

并且，可以对比两个长度的相等性。
```

### 需求二

```
用户除了可以使用Mile为单位表示长度外，还可以使Yard为单位表示长度，其中:

* 以Mile为单位表示长度时，精度为1Mile。 
* 以Yard为单位表示长度时，精度为1Yard。 
* 能够对比任意两个长度的相等性。
* 1 Mile == 1760 Yard 
* 3 Yard = 3 Yard
* 1 Mile != 1761 Yard 
* 3 Yard != 4 Yard
```

### 需求三

```
增加两个新的厂度单位，Feet和Inch，用户可以以它们为单位表示长度，其中:

* 1 Yard == 3 Feet
* 1 Feet == 12 Inch
* 当用Feet为单位表示长度时，精度为1 Feet
* 当用Inch为单位表示长度时，精度为1 Inch
```

### 需求四

```
这套库发布后，用户只能使用既有单位 (Mile、Yard、Feet和Inch)，

不应该创建新的单位，以避免用户由于某种原因创建出一些现实中不存

在的单位，从而让系统变得不可理解。
```

### 需求五

```
任意两个长度对象可以进行加法运算
```

### 需求六

```
基于调试等原因，需要将Length对象输出到屏幕上。格式规则如下:

* 如果一个对象的“基准单位数量”在一个更大的单位上的倍数非0，则显示对象在此单
位上的倍数，以及此单位的名字
* 如果一个对象的“基准单位数量”在一个更大的单位上的倍数为0，则无需显示对象在
此单位上的倍数，以及此单位的名字
* 如果余数在一个较小的单位上倍数非0，则显示对象在此单位上的倍数，以及此单
位的名字
* 如果余数在一个较小的单位上倍数为0，则无需显示对象在此单位上的倍数，以及
此单位的名字
* 如果一个对象的“基准单位数量”为0， 则显 0，以及基准单位的名字
* 如果存在多个“数量 + 单位”组合，则按照单位  ，从左向右排列
* 数量和单位之间，由一个空格分开
* “数量 + 单位”之间由一个空格分开
```

### 需求七

```
增加一种新的Length对象输出格式：

* 以Inch为单位输出任何Length对象 
* 数量和单位之间以一个空格分隔

例如:

* Length(2, FEET) => 24 INCH
* Length(2, YARD) => 72 INCH 输出 个Length对象时， 户可以在两种输出格式中自由选择任何一种
```