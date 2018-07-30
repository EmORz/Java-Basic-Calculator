package com.softuni.entity;

public class Calculator {
    private double leftOperand;
    private String operator;
    private double rightOperand;

    public Calculator() {
    }

    public Calculator(double leftOperand, String operator, double rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
    }

    public double getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(double leftOperand) {
        this.leftOperand = leftOperand;
    }

    public double getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(double rightOperand) {
        this.rightOperand = rightOperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }


    public double calculateResult(){


        switch (this.operator){
            case "+":
                return this.leftOperand+this.rightOperand;
            case "-":
                return this.leftOperand-this.rightOperand;
            case "*":
                return this.leftOperand*this.rightOperand;
            case "/":
                return this.leftOperand/this.rightOperand;
            case "F":
                double[] arr = new double[(int)this.leftOperand+1];
                return fib(this.leftOperand, arr);
        }

        return 0;
    }

    private double fib(double leftOperand, double[] arr) {
        if (leftOperand<3) {
            return 1;
        }
        int index = (int)leftOperand;
        if (arr[index] !=0){
            return arr[index];
        }
        return arr[index] = fib(leftOperand-1, arr)+fib(leftOperand-2, arr);
    }
}
