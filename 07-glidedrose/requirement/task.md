### 任务分解

#### Task 1: 对于正常的商品每天价值减1。

**对象分析**

1. 商品Product
    * sellIn 保质期
    * quality 价值
2. 库存系统GlidedRose
   行为：passOneDay
   
**测试分析**    

1. should_decrease_product_sellin_and_decrease_quality_for_normal_product

#### Task 2: 一旦过了保质期，"Quality"就以双倍的速度下滑。

**测试分析**

1. should_decrease_product_sellin_and_double_decrease_quality_for_expired_product

#### Task 3: 商品的价值不能小于0。

**测试分析**

1. should_decrease_product_sellin_and_double_decrease_quality_but_quality_must_large_than_zero

#### Task 4: 陈年干酪（Aged Brie）是一种特殊的商品，放得越久，价值反而越高。

**测试分析**

1. should_decrease_product_sellin_and_increase_quality_for_aged_brie_product

#### Task 5: 商品的品质值永远不会超过50。

**测试分析**

1. should_decrease_product_sellin_and_quality_not_larger_than_fifty

#### Task 6: 萨弗拉斯（Sulfuras）是一种传奇商品，没有保质期的概念，质量也不会下滑

**测试分析**

1. should_not_decrease_product_sellin_and_quality_for_sulfuras_product

#### Task 7: 后台通行证（Backstage pass）和陈年干酪有相似之处：越是接近演出日，随着"SellIn"值的减少，商品价值"Quality"值反而上升。
                 
**测试分析**

1. should_decrease_sellin_and_increase_quality_if_product_is_backstage_pass_when_update                 
