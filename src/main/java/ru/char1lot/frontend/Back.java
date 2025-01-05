package ru.char1lot.frontend;

public class Back {

    static double rev(double arg){
        return -arg;
    }

    static double plus(double arg1, double arg2){
        return arg1 + arg2;
    }

    static double minus(double arg1, double arg2){
        return arg1 - arg2;
    }

    static double mult(double arg1, double arg2){
        return arg1 * arg2;
    }

    static double dec(double arg){
        return 1/arg;
    }

    static double exp(double arg){
        return arg*arg;
    }

    static double sqrt(double arg){
        return Math.sqrt(arg);
    }

    static double div(double arg1, double arg2){
        return arg1/arg2;
    }

    static int mod(double arg1, double arg2){
        return (int)(arg1%arg2);
    }
}
