/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.aptek.pojo;

/**
 *
 * @author Fuad
 */
public class Item {
    private Long id;
    private String value;

    public Item(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    

    @Override
    public String toString() {
        return value ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
