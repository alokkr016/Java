package object.oriented.programming;

public class Polynomial {
    DynamicArray coefficients;
    public Polynomial(){
        coefficients = new DynamicArray();
    }
    public void setCoefficient(int degree, int coeff){
            this.coefficients.set(degree,coeff);
    }
    // Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree.

    public void print() {
        for (int i = 0; i < this.coefficients.size(); i++) {
            if (this.coefficients.get(i) != 0) {
                System.out.print(this.coefficients.get(i) + "x" + i + " ");
            }
        }
    }
//     Adds two polynomials and returns a new polynomial which has result

    public Polynomial add(Polynomial p){
       Polynomial ans = new Polynomial();
       int size = p.coefficients.arr.length + 3;
       ans.coefficients.arr = new int[size];
       for (int i = 0;i < p.coefficients.arr.length;i++){
           ans.coefficients.set(i,(this.coefficients.get(i) + p.coefficients.get(i)));

       }
       return ans;
    }
//
    // Subtracts two polynomials and returns a new polynomial which has result
    public Polynomial subtract(Polynomial p) {
        Polynomial ans = new Polynomial();
        int size = p.coefficients.arr.length + 2;
        ans.coefficients.arr = new int[size];
        for (int i = 0; i < ans.coefficients.arr.length; i++) {
            ans.coefficients.arr[i] = this.coefficients.arr[i] - p.coefficients.arr[i];
        }
        return ans;
    }

    // Multiply two polynomials and returns a new polynomial which has result
    public Polynomial multiply(Polynomial p) {
        Polynomial p1 = new Polynomial();
        int size = this.coefficients.arr.length * p.coefficients.arr.length;
        p1.coefficients.arr = new int[size];
        for (int j = 0; j < p.coefficients.arr.length; j++)
            for (int i = 0; i < p.coefficients.arr.length; i++) {
                p1.coefficients.arr[i + j] += this.coefficients.arr[j] * p.coefficients.arr[i];
            }
        return p1;
    }

}
