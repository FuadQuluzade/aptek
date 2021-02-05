package az.orient.aptek.pojo;

public class Xerc extends AbstractPojo {

    private OdenishVasiteleri odenishVasiteleri;
    private Double amount;

    public OdenishVasiteleri getOdenishVasiteleri() {
        return odenishVasiteleri;
    }

    public void setOdenishVasiteleri(OdenishVasiteleri odenishVasiteleri) {
        this.odenishVasiteleri = odenishVasiteleri;
    }

    public Double getAmount() {
        return amount;
    }


    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Xerc{" + "odenishVasiteleri=" + odenishVasiteleri + ", amount=" + amount + '}';
    }

    
    
}
