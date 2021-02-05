package az.orient.aptek.pojo;

public class MedicineQroup extends AbstractPojo {
	private String qroupName;
	private Refler shelfs;
	

	public String getQroupName() {
		return qroupName;
	}

	public void setQroupName(String qroupName) {
		this.qroupName = qroupName;
	}

    public Refler getShelfs() {
        return shelfs;
    }

    public void setShelfs(Refler shelfs) {
        this.shelfs = shelfs;
    }

    @Override
    public String toString() {
        return "MedicineQroup{" + "qroupName=" + qroupName + ", shelfs=" + shelfs + '}';
    }

	

	
}
