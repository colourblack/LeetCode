package design.pattern.strategy.case1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/7/21 5:13 PM
 */
@Slf4j
public class AdvancedMemberStrategy implements MemberStrategy {

    /**
     * 高级会员优惠20%
     * @param price 图书的原始价格
     * @return 优惠价格
     */
    @Override
    public double calculatePrice(double price) {
        price = price * 0.8;
        log.info("高级会员优惠20%， 优惠后的价格为: {}", price);
        return price;
    }
}
