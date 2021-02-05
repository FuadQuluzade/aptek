package az.orient.aptek.pojo;

public class Maash extends AbstractPojo{
	private Ishciler ishciler;
        private Vezifeler vezifeler;
        private Double salary;

    @Override
    public String toString() {
        return "Maash{" + "ishciler=" + ishciler + ", vezifeler=" + vezifeler + ", salary=" + salary + '}';
    }

    public Ishciler getIshciler() {
        return ishciler;
    }

    public void setIshciler(Ishciler ishciler) {
        this.ishciler = ishciler;
    }

    public Vezifeler getVezifeler() {
        return vezifeler;
    }

    public void setVezifeler(Vezifeler vezifeler) {
        this.vezifeler = vezifeler;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
