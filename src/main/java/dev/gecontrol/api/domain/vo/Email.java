package dev.gecontrol.api.domain.vo;

public class Email {
    private final String address;

    public Email(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
