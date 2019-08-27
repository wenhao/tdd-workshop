### 需求分析

### Tasks

1. 不大于2公里时只收起步价6元。
2. 超过2公里时每公里0.8元。
3. 超过8公里则每公里加收50%长途费。
4. 停车等待时加收每分钟0.25元。
5. 最后计价的时候司机会四舍五入只收到元。

### Task 1

1. 不大于2公里时只收起步价6元。

对象分析：
1. 类名：Trip(行程)，属性：公里数(Distance).
2. 类名：TaxiCalculator， 行为：calculate.

测试分析：

测试名称：should_only_charge_basic_fee_if_trip_less_than_base_miles.

### Task 2

2. 超过2公里时每公里0.8元。

测试分析：

测试名称：should_charge_additional_fee_if_trip_has_extra_miles.

### Task 3

3. 超过8公里则每公里加收50%长途费。

测试分析：

测试名称：should_charge_long_distance_fee_if_trip_has_extra_eight_miles.

### Task 4

发现Bad Small, 多重If语句。需要重构。

重构之后实现后面的需求就简单了。

### Task 5

4. 停车等待时加收每分钟0.25元。

测试分析：

测试名称：should_charge_waiting_fee_if_trip_has_waiting_time.

### Task 6

5. 最后计价的时候司机会四舍五入只收到元。

对象分析：
1. 类名：Driver，行为：charge.

测试分析：

测试名称：should_driver_charge_fee_with_round_up.

### Task 7

最后一次重构，内容包括：

1. 相关数字抽象为配置。
2. 引入DI的概念，或者引入对象工厂。