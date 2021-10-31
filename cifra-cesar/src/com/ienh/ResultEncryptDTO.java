package com.ienh;

public class ResultEncryptDTO {

    private String result;
    private Integer key;

    public ResultEncryptDTO(String result, Integer key) {
        this.result = result;
        this.key = key;
    }

    public String getResult() {
        return result;
    }

    public Integer getKey() {
        return key;
    }

}
