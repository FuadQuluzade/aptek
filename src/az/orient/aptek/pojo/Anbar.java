package az.orient.aptek.pojo;

public class Anbar extends AbstractPojo {

    private Product product;
    private Integer amount;
    private Double purchasePrise;
    private String qeyd;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPurchasePrise() {
        return purchasePrise;
    }

    public void setPurchasePrise(Double purchasePrise) {
        this.purchasePrise = purchasePrise;
    }

    public String getQeyd() {
        return qeyd;
    }

    public void setQeyd(String qeyd) {
        this.qeyd = qeyd;
    }

    @Override
    public String toString() {
        return "Anbar{" + "product=" + product + ", amount=" + amount + ", purchasePrise=" + purchasePrise + ", qeyd=" + qeyd + ", active=" + this.getActive() + '}';
    }

}
