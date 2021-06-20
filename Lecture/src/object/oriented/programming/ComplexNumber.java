package object.oriented.programming;

public class ComplexNumber {
    private int real;
    private int imaginary;
    public ComplexNumber(int a,int b){
        this.real = a;
        this.imaginary = b;
    }
    public int setReal(int a){
        return this.real = a;
    }
    public int setImaginary(int b){
        return this.imaginary = b;
    }
    public void print(){
        System.out.println(real + " + " + imaginary + "i");
    }
    public void add(ComplexNumber c2){
        this.real = this.real + c2.real;
        this.imaginary = this.imaginary + c2.imaginary;
    }
    //3 6
    //7 9
    public void multiply(ComplexNumber a){
        int r = this.real*a.real - this.imaginary*a.imaginary;
        int i = this.real*a.imaginary + a.real*this.imaginary;
        this.real = r;
        this.imaginary = i;
    }

    public static ComplexNumber add(ComplexNumber a,ComplexNumber b){
        int e = a.real + b.real;
        int f = a.imaginary + b.imaginary;
        ComplexNumber c = new ComplexNumber(e,f);
        return c;
    }
}
