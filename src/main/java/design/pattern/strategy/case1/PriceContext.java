package design.pattern.strategy.case1;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/7/21 5:14 PM
 */
public class PriceContext {

    private MemberStrategy memberStrategy;


    public PriceContext(MemberStrategy memberStrategy) {
        this.memberStrategy = memberStrategy;
    }

    public void setMemberStrategy(MemberStrategy memberStrategy) {
        this.memberStrategy = memberStrategy;
    }


    public double getPrice(double price) {
        return memberStrategy.calculatePrice(price);
    }

}
