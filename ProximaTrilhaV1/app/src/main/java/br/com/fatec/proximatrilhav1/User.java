package br.com.fatec.proximatrilhav1;

/**
 * Created by MEGAS on 02/10/2017.
 */

public class User {

    private String name;
    private String email;
    private Integer uuid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }
}