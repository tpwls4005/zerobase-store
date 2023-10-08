package com.example.store.dto;

import lombok.Getter;

@Getter
public class StoreDTO {
    // 게터와 세터
    private String name;
    private String address;

    public StoreDTO() {
    }

    public StoreDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
