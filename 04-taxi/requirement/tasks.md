### 创建项目
1. 使用github托管项目
2. 使用maven或者gradle构建项目
3. 添加junit、mockito、guava依赖
4. 能够执行测试并build成功通过

### 任务分解

#### 需求一

起步价11元，含3公里。

起步价之后，每公里1.6元。

行车里程不为整数的情况下，向上取整。

1. 根据里程计算价格，3公里以内。
   * 需求
      * 3公里以内，价格为起步价11元。
   * 意图
      * 计算价格为主要业务，3公里以内最简单。
   * 测试名称
      * should_charge_starting_fare_when_travel_distance_less_than_base_distance
   * 类名及行为名
      * Taxi, chargeFee(), 使用伪实现让测试快速通过。
2. 根据里程计算价格，刚好3公里。
   * 需求
      * 刚好3公里，价格为起步价11元。
   * 意图
      * 计算价格为主要业务。
   * 测试名称
      * should_charge_starting_fare_when_travel_distance_equals_to_base_distance
   * 类名及行为名
      * Taxi, chargeFee(), 直接实现。
3. 超过3公里的，每公里加收1.6元。
   * 需求
     * 超过3公里的，每公里加收1.6元。
   * 意图
     * 计算加收费用。
   * 测试名称
     * should_charge_additional_fee_when_travel_distance_more_than_base_distance
   * 类名及行为名
     * Taxi, chargeFee()。
4. 重构
   * 魔法数字-可读性较低
     * BASE_FEE = BigDecimal.valueOf(11)
     * BASE_DISTANCE = 3
     * PRICE_PER_MILE = BigDecimal.valueOf(1.6D) 
5. 里程向上取整
   * 需求
     * 里程向上取整。
   * 意图
     * 重要程度次之。
   * 测试名称
     * should_charge_fare_when_travel_distance_has_decimal_number
   * 类名及行为名
     * Taxi, chargeFee()。
   * 问题：
     * 在测试的时候会遇到BigDecimal精度的问题，两个选择：1. 统一所有的精度问题， 2. 暂时忽略，在测试中都乘以100。
   * commit: 8625073bd6c8350622957fbd0cddcd18c34014eb
   
#### 需求二

起步价及单价 以 上车时间的价格为准。

晚上11点之后（含），次日6点前（不含）起步价13元，含3公里。

晚上起步价之后，每公里2.4元。
                                       
6. 晚上11点之后（含），次日6点前（不含），根据里程计算价格，3公里以内。
   * 需求
     * 晚上11点之后（含），次日6点前（不含），根据里程计算价格，3公里以内[其实就是6点(含)~23点(不含)]。
   * 意图
     * 计算费用
   * 测试名称
     * should_charge_night_starting_fare_when_travel_at_night_and_distance_less_than_base_distance
   * 类名及行为名
     * Taxi, chargeFee(), Ride。
   * 问题：
     * 上车的时间如何处理，LocalTime。
     * chargeFee需要多传入一个上车时间的参数。
     * (重要)重构将上车时间和里程封装成类Ride，重构步骤：1. 先将小时加到新的测试chargeFee方法中，使用Intellij快捷键之前的测试都会添加这个参数。 2. 在Taxi的chargeFee的参数使用Refactor->Extract->Parameter Object。
     * 重构
       * NIGHT_BASE_FEE = BigDecimal.valueOf(13).setScale(2, ROUND_UP)
       * 重命名BASE_FEE为DAY_BASE_FEE
       * 依恋情结，将里程取整的逻辑放到暂时放到Ride类。
7. 晚上起步价之后，每公里2.4元。
   * 需求
     * 晚上起步价之后，每公里2.4元。
   * 意图
     * 计算费用
   * 测试名称
     * should_charge_night_additional_fee_when_travel_at_night_and_distance_more_than_base_distance
   * 类名及行为名
     * Taxi, chargeFee(), Ride。
8. 整理一下代码，将相关的代码分块。
   * commit: a07880f278dfd320c6db315056441e7c6c16b3a1
9. 给Ride加上测试。         

### 需求三：

以下是上海出租车的需求（可以理解为前面的那些需求是普通的出租车）：起步价14元，含3公里。

起步价之后，每公里2.5元，晚上11点之后(含)，次日6点前(不含)起步价18元，含3公里。

晚上起步价之后，每公里3元。

10公里之后，白天每公里3.5元，晚上每公里4.7元。

外环的出租车10公里之外的价格与10公里之内相同(外环没有10公里差别)(内环外环可以理解为出租车的类型)。

10. 在需求二的代码之上加上需求三有点困难，需要重构(重构第一章：如果你发现为现有的程序添加新特性时，现有的代码结构使你无法方便的添加新特性是，应该先重构)。
11. 计算价格的变化：起步价、每公里的价格还有10公里之后的价格，价格的变化：时间(白天和晚上)、出租车的类型
12. 先重构计算价格。总结等于：起步价+每公里价格+...., 步骤：
    * 将白天和晚上的抽成两个方法：getDayCharge()和getNightCharge()。Refactor->Extract->Method。
    * getDayCharge()抽成两个方法：getBaseFare()和getAdditionalFee()。
    * getNightCharge()同样有这个问题，需要消除重复代码。将变化的BASE_FEE作为getBaseFare()方法的参数，PRICE_PER_MILE作为getAdditionalFee()方法的参数。Change Signature。
13. 第12步重构之后，可以发现getDayCharge()和getNightCharge()极其相似。但先把getBaseFare()和getAdditionalFee()抽离Taxi类。
    * Refactor->Extract->Delegate委托getBaseFare()到类BaseFareTaxiCharge。修改方法名为chargeFee()。
    * 这个地方chargeFee()不应该有第二个参数，第二个参数应该出现在BaseFareTaxiCharge的构造参数内。
    * 同样的Refactor->Extract->Delegate委托getAdditionalFee()到类BaseFareTaxiCharge。修改方法名为chargeFee()。
14. BaseFareTaxiCharge和AdditionalFeeTaxiCharge拥有相同的行为，可以抽象接口。Refactor->Extract->Interface。
15. getDayCharge()方法可以简化List<TaxiCharge> taxiCharges。然后遍历。
16. 价格是多个TaxiCharge的组合。使用组合模式。重构getDayCharge()方法。抽离变化，DAY_BASE_FEE和PRICE_PER_MILE。
17. 给新加的类添加测试。    
    
### 组合模式

#### 定义

将对象组合成树形结构以表示“部分——整体”的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性。

类比理解：复制文件时，可以一个一个单独复制，也可以一次将整个文件夹复制了；再比如文本编辑，可以给单个字进行加粗、变色、改字体，也可以对整段文字进行同样的操作。这个问题实际上就是要求“整体与部分可以被一致对待”。

#### 理论类比（Component-细胞，Leaf-叶子，Composite-树枝）

##### Component-细胞

抽象基类，定义所有组件需要的共有接口，在适当的情况下实现所有类共有接口的默认行为；所有的叶子对象和树枝对象都继承细胞（即由细胞组成）

##### Leaf-叶子
    * 叶节点：其上不能再有分支，即叶子没有子节点
    * 因为叶子没有子节点，所以它的Add和Remove方法没有意义；但是仍然要求叶子对象也继承细胞，这样就可以消除叶子和树枝在抽象层次的区别，使他们具备完全一致的接口，方便操作组合模式下的任意对象

##### Composite-树枝
    * 树枝：定义有枝节点的行为，用来存储子部件；在内部建立一个对象集合，用来存储其下属的子节点
    * 可以有子节点（叶子或者树枝），在细胞接口中实现与子部件有关的操作；
    
客户端：通过Component-细胞的接口来操作组合部件的对象，包括建立、移除节点，执行部件的自有方法

注：树枝和叶子属于基本对象，这些基本对象可以被组合成更复杂的组合对象，这样不断递归下去，客户端的代码中，任何用到基本对象的地方就可以使用组合对象了；用户就不需要再去关心到底是处理一个叶子对象还是一个组合对象，避免了为组合对象专门写一些选择判断语句。一句话：组合模式可以让用户一致的使用单个对象和组合结构。

##### 关于“透明方式”与“安全方式”

    * 来源：上面叶子节点中，由于其不能再有子节点，因此叶子对象的Add和Remove方法是没有意义的，而树枝可以有子节点（叶子或树枝）；但是在一般情况下依然要求叶子和树枝都要继承自Component-细胞
    * 解释：透明方式与安全方式
        * 透明方式：在基类中声明所有用来管理子对象的方法，这样继承该基类的所有子类都具备了相同的接口；这样做就使得叶子和树枝对于外界没有区别，但是也有问题，即叶子对象本身不具备子节点，所以实现Add和Remove方法是没有意义的；
        * 安全方式：在基类中不去声明Add和Remove方法，这时叶子对象就不需要实现这些接口，而在树枝对象中声明用来管理子节点的方法，这样做就避免了‘透明方式’的问题；但是由于叶子和树枝具有不同的接口，客户端的调用就需要单独判断，又带来了不便。
        * 两者各有好处，需要在使用时进行具体判断。

#### 使用时机

当你发现需求中体现部分与整体的层次结构时，以及你希望用户可以忽略组合对象与单个对象的不同，统一的使用所有组合结构中的所有对象时，就应该考虑使用组合模式。
    
18. 目前Taxi类根据时间来判断收费，而且包括了两个类的创建。代理模式(委托)重构。
    * 类的创建和使用需要分开，先抽取连个成员变量dayCharge和nightCharge。
    * 将时间选择委托给另外一个类TimeTaxiCharge。TimeTaxiCharge构造函数接收两个参数dayCharge和nightCharge。
    