package br.com.kmpx;

public class Endereco {

    public Endereco(String rua, Integer number) {
        this.rua = rua;
        this.number = number;
    }
    private String rua;
    private Integer number;


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
}
