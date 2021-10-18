package com.investment.exception;

public class InvestmentException extends Exception{

    public InvestmentException(){
        super();
    }

    public  InvestmentException(final String message){
        super(message);
    }
}
