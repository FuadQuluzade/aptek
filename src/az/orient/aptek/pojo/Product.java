package az.orient.aptek.pojo;

public class Product extends AbstractPojo {

    private MedicineQroup medicineQroup;
    private Refler refler;
    private String name;
    private Integer barkod;

    public Integer getBarkod() {
        return barkod;
    }

    public void setBarkod(Integer barkod) {
        this.barkod = barkod;
    }

    @Override
    public String toString() {
        return "Product{" + "medicineQroup=" + medicineQroup + ", refler=" + refler + ", name=" + name + ", barkod=" + barkod + '}';
    }

  

    public MedicineQroup getMedicineQroup() {
        return medicineQroup;
    }

    public void setMedicineQroup(MedicineQroup medicineQroup) {
        this.medicineQroup = medicineQroup;
    }

    public Refler getRefler() {
        return refler;
    }

    public void setRefler(Refler refler) {
        this.refler = refler;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
