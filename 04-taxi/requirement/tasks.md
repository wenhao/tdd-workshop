### 创建项目
1. 使用github托管项目
2. 使用maven或者gradle构建项目
3. 添加junit、mockito、guava依赖
4. 能够执行测试并build成功通过

### 任务分解

起步价11元，含3公里。

起步价之后，每公里1.6元。

行车里程不为整数的情况下，向上取整。

1. 根据历程计算价格，3公里以内。
   * 需求
      * 3公里以内，价格为起步价11元。
   * 意图
      * 计算价格为主要业务，3公里以内最简单。
   * 测试名称
      * should_charge_starting_fare_when_travel_distance_less_than_base_distance
   * 类名及行为名
      * Taxi, chargeFee(), 使用伪实现让测试快速通过。
2. 根据历程计算价格，刚好3公里。
   * 需求
      * 刚好3公里，价格为起步价11元。
   * 意图
      * 计算价格为主要业务。
   * 测试名称
      * should_charge_starting_fare_when_travel_distance_equals_to_base_distance
   * 类名及行为名
      * Taxi, chargeFee(), 直接实现。      