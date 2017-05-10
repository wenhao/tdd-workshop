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
     * should_charge_additional_fare_when_travel_distance_more_than_base_distance
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
     * (重要)重构将上车时间和里程封装成类Ride，重构步骤：1. 现将LocalTime加到新的测试chargeFee方法中，使用Intellij快捷键之前的测试都会添加这个参数。 2. 在Taxi的chargeFee的参数使用Refactor->Extract->Parameter Object。
     * 重构
        * NIGHT_BASE_FEE = BigDecimal.valueOf(13).setScale(2, ROUND_UP)
        * 重命名BASE_FEE为DAY_BASE_FEE
        * 依恋情结，将里程取整的逻辑放到暂时放到Ride类。
                                                        