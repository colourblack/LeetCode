package design.pattern.strategy.case1;

/**
 * 抽象折扣类(抽象策略(Strategy)角色)
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/7/21 5:07 PM
 */
public interface MemberStrategy {

    /**
     * 计算图书价格
     * @param price 图书的原始价格
     * @return 计算后的优惠价格
     */
    double calculatePrice(double price);


}
