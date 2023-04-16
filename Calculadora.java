
import java.util.Scanner;
public class Calculadora {
    static Scanner scanner = new Scanner(System.in);    // creacion del scanner para captura de datos
    static boolean banderaOperacion = true;
    public static void main(String[] args) {    // codigo principal
        double numero1 = capturaNumero();          // se captura primer numero
        do {
          char operacion = capturarOperacion();   // se captura la operacion
          double numero2 = capturaNumero();          // se captura segundo numero
          double resultado = calcular(numero1,numero2,operacion);    // se llama a la funcion calcular para retornor resultado
          numero1 = resultado;
          System.out.println("El resultado de la operación: "+resultado);     // se imprime el resultado en consola
        }while(true);
    }

    public static double capturaNumero(){
        System.out.print("Introduzca un número: ");
        double numero;
        if(scanner.hasNextDouble()){
            numero = scanner.nextDouble();
        } else {
            System.out.println("Te has equivocado al introducir el número. Inténtalo de nuevo.");
            scanner.next(); //recursividad
            numero = capturaNumero();
        }
        return numero;
    }

    public static char capturarOperacion(){
        System.out.print("Introduzca la operación: ");
        char operacion;
        if(scanner.hasNext()){
            operacion = scanner.next().charAt(0);
        } else {
            System.out.println("Ha cometido un error al entrar en la operación. Inténtalo de nuevo.");
            scanner.next();//recursividad
            operacion = capturarOperacion();
        }

        do {
            if (operacion == '+') {
                banderaOperacion = false;
            } else if (operacion == '-') {
                banderaOperacion = false;
            } else if (operacion == '*') {
                banderaOperacion = false;
            } else if (operacion == '/') {
                banderaOperacion = false;
            } else if (operacion == '%') {
                banderaOperacion = false;
            }else{
                System.out.println("La operación no se reconoce. Repite la entrada.");
                operacion = capturarOperacion();
            }
        }while(banderaOperacion);
        return operacion;
    }

    public static double calcular(double num1, double num2, char operacion){
        double resultado;
        while(num2 == 0 & operacion == '/'){
            System.out.println("No se puede dividir por 0, ya que esta operacion no existe. Inténtalo de nuevo.");
            num2 = capturaNumero();
        }

        switch (operacion) {
            case '+' -> resultado = num1 + num2;    // sumar
            case '-' -> resultado = num1 - num2;    // restar
            case '*' -> resultado = num1 * num2;    // multiplicar
            case '/' -> resultado = num1 / num2;    // dividir
            case '%' -> resultado = num1 % num2;    // modulo
            default -> {
                System.out.println("La operación no se reconoce. Repite la entrada.");
                resultado = calcular(num1, num2, capturarOperacion());//recursividad
            }
        }
        return resultado;
    }
}