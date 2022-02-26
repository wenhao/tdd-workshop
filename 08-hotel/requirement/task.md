### tasks

1. 当普通客户只预定工作日的房间，并先假设只有一种Lakewood酒店，得到一个预定的酒店结果。
   * 对象
    * Reservation：预定包含客户等级 REGULAR和REWARDS，预定时间周期。
    * HotelChainManager：行为offer。
    * Hotel：类型Lakewood，平时的价格weekday rates和周末的价格weekend rates。
   * 测试
    * 当客户只预定工作日的房间 
    * should_offer_hotel_when_regular_customer_reserve_weekday_days
    * 输入Reservation：REGULAR，16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)
2. 当普通客户预定有周末时，并假设有两种酒店Lakewood和Bridgewood。
   * 对象
    * 每个酒店有两种收费模式Regular和Rewards，抽象为两种不同的收费策略，酒店有一系列的收费策略。
    * Hotel: 属性name和List<PriceStrategy>, RegularPriceStrategy, RewardsPriceStrategy，接口PriceStrategy,行为getFee(Reservation)。 
   * 测试
    * should_offer_hotel_when_regular_customer_reserve_weekend_days
    * 输入Reservation：REGULAR, 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)
3. 当荣誉客户预定时，有三种酒店Lakewood、Bridgewood和Ridgewood
   * 对象
    * 由于Lakewood和Ridgewood算出来的价格一样，需要按照rating排序，故Hotel新增属性rating。
   * 测试
    * should_off_hotel_when_rewards_customer_reserve_weekdays_and_weekend
    * 输入Reservation：REWARDS, 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)
4. 输入信息从文件读取
   * 对象
    * ReservationProvider,行为get
   * 测试
    * should_provider_reservation_from_file
5. 加启动程序ApplicationRunner
6. 调整包结构
