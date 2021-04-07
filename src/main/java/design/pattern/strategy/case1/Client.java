package design.pattern.strategy.case1;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/7/21 5:16 PM
 */
public class Client {

    public static void main(String[] args) {
        MemberStrategy normalMemberStrategy = new NormalMemberStrategy();
        MemberStrategy advancedMemberStrategy = new AdvancedMemberStrategy();

        PriceContext context = new PriceContext(normalMemberStrategy);
        double price = 500.0;

        context.getPrice(price);

        context.setMemberStrategy(advancedMemberStrategy);
        context.getPrice(price);

    }

}
