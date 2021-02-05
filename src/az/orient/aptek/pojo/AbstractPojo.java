package az.orient.aptek.pojo;

import java.util.Date;

public class AbstractPojo {

    private Long id;
    private Integer active;
    private Date dataDate;
    private Long r;

    public Long getR() {
        return r;
    }

    public void setR(Long r) {
        this.r = r;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Date getDataDate() {
        return dataDate;
    }

    public void setDataDate(Date dataDate) {
        this.dataDate = dataDate;
    }

    @Override
    public String toString() {
        return "AbstractPojo{" + "id=" + id + ", active=" + active + ", dataDate=" + dataDate + ", r=" + r + '}';
    }
 
}
