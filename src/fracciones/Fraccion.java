package fracciones;

public class Fraccion {

    private int num;
    private int denom; // Fraccion num/denom

    public int getNum() {//get
        return num;
    }

    public int getDenom() {//get
        return denom;
    }

    public Fraccion(int num, int denom) {//constructor
        this.num = num;
        this.denom = denom;
    }

    Fraccion multiplicacion(Fraccion f) {  //(a/b)*(c/d)  = 
        Fraccion result = new Fraccion(this.num * f.getNum(), this.denom * f.getDenom());
        return result;
    }

    Fraccion multiplicacion(int n) {
        Fraccion result = new Fraccion(this.num * n, this.denom);
        return result;
    }

    Fraccion division(Fraccion f) {
        Fraccion result = new Fraccion(this.num * f.getDenom(), this.denom * f.getNum());
        return result;
    }

    Fraccion suma(Fraccion f) {
        Fraccion result = new Fraccion(this.num * f.getDenom() + this.denom * f.getNum(), this.denom * f.getDenom());
        return result;
    }

    Fraccion resta(Fraccion f) {
        Fraccion result = new Fraccion(this.num * f.getDenom() - this.denom * f.getNum(), this.denom * f.getDenom());
        return result;
    }

    Fraccion inversa() {
        Fraccion result = new Fraccion(this.denom, this.num);
        return result;
    }

    public boolean igualQue(Fraccion f) {
        return this.num * f.getDenom() == this.denom * f.getNum();
    }

    void multiplicarPor(Fraccion f) {
        this.num = this.num * f.getNum();
        this.denom = this.denom * f.getDenom();
    }

    Fraccion simplificar() {

        int a = Math.min(this.num, this.denom);
        int b = Math.max(this.num, this.denom);
        
        int resultado = 0;
        while (b != 0) {
            resultado = b;
            b = a % b;
            a = resultado;
        }
        
        Fraccion result = new Fraccion(this.num / resultado, this.denom / resultado);

        return result;

    }
    
    Fraccion cambiarSigno(){
    
         if (this.denom < 0) {
            this.num = -(this.num);
            this.denom = -(this.denom);
        }

         Fraccion result = new Fraccion(this.num, this.denom);
         
         return result;
    
    }

    @Override
    public String toString() {
        return "(" + num + "/" + denom + ")";
    }

    public static void main(String[] args) {

        Fraccion f1 = new Fraccion(5, 3);
        Fraccion f2 = new Fraccion(3, 2);

        // System.out.printf("f1*f2= %s\n", f1.multiplicacion(f2));
        System.out.printf("f1: %s\n", f1.toString());
        System.out.printf("f2: %s\n", f2.toString());

        //f1.multiplicarPor(f2);
        // System.out.printf("f1 tras multiplicarse por f2: %s\n",f1.toString());
        // System.out.printf("f2: %s\n",f2.toString());
        System.out.printf("%s*%s= %s\n", f1, f2, f1.multiplicacion(f2));

        System.out.printf("%s*%s= %s\n", f1, f2, f1.multiplicacion(5));

        Fraccion suma = f1.suma(f2);
        System.out.printf("%s+%s=%s\n", f1, f2, suma);

        System.out.printf("%s-%s=%s\n", f1, f2, f1.resta(f2));

        System.out.printf("%s/%s=%s\n", f1, f2, f1.division(f2));

        System.out.printf("La fracion inversa de %s es %s\n", f1, f1.inversa());

        Fraccion f3 = new Fraccion(6, 4);
        Fraccion f4 = new Fraccion(3, 2);
        Fraccion f5 = new Fraccion(2, 5);

        if (f3.igualQue(f4)) {
            System.out.printf("%s y %s son iguales \n", f3, f4);
        } else {
            System.out.printf("%s y %s son distintas \n ", f3, f4);
        }

        // @Ejercicio:
        // Dividir dos fracciones sin utilizar el mÃ©todo dividir, 
        // valiÃ©ndose del mÃ©todo inversa:  f1*inversa(f2)
        System.out.printf("%s/%s = %s\n", f1, f2, f1.multiplicacion(f2.inversa()));
        
        //simplificar la fraccion
         Fraccion f6 = new Fraccion(40, -24);
         
        System.out.printf("la fraccion %s simplificada es: %s",f6,(f6.simplificar()).cambiarSigno());
                
    }

}
