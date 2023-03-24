package hello.core.order;

public class Order {
    private Long memberId;
    private String itemName;
    private int itmePrice;
    private int discontPrice;


    public Order(Long memberId, String itemName, int itmePrice, int discontPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itmePrice = itmePrice;
        this.discontPrice = discontPrice;
    }

    public int calculatePrice(){
        return itmePrice - discontPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItmePrice() {
        return itmePrice;
    }

    public void setItmePrice(int itmePrice) {
        this.itmePrice = itmePrice;
    }

    public int getDiscontPrice() {
        return discontPrice;
    }

    public void setDiscontPrice(int discontPrice) {
        this.discontPrice = discontPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itmePrice=" + itmePrice +
                ", discontPrice=" + discontPrice +
                '}';
    }
}
