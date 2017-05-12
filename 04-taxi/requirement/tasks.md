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
    
    
    
    