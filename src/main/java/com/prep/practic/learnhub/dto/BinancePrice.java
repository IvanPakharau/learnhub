package com.prep.practic.learnhub.dto;

public class BinancePrice {
    private String symbol;
    private String price;

    @Override
    public String toString() {
        return "BinancePrice{" +
                "symbol='" + symbol + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
