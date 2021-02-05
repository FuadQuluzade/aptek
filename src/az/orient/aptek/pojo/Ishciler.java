package az.orient.aptek.pojo;

import java.util.Date;

public class Ishciler  extends AbstractPojo{
	private String name;
	private String surname;
	private Date dob;
	private String adress;
	private String phone;
        private String tehsil;
	private String dilBiliyi;

    public String getTehsil() {
        return tehsil;
    }

    public void setTehsil(String tehsil) {
        this.tehsil = tehsil;
    }

    public String getDilBiliyi() {
        return dilBiliyi;
    }

    public void setDilBiliyi(String dilBiliyi) {
        this.dilBiliyi = dilBiliyi;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Ishciler [name=" + name + ", surname=" + surname + ", dob=" + dob + ", adress=" + adress + ", phone="
				+ phone + "]";
	}
	
	
}
