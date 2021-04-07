package design.pattern.strategy.case1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/7/21 5:10 PM
 */
@Slf4j
public class NormalMemberStrategy implements MemberStrategy{

    /**
     * 初级会员没有优惠
     * @param price 图书的原始价格
     * @return 原始价格
     */
    @Override
    public double calculatePrice(double price) {
        log.info("初级会员没有优惠");
        return price;
    }
}
