
import java.util.Scanner;
public class Calculadora {
    static Scanner scanner = new Scanner(System.in);    // creacion del scanner para captura de datos
    static boolean banderaOperacion = true;         // bandera por operacion correcta
    public static void main(String[] args) {    // codigo principal
        double numero1 = capturaNumero();          // se captura primer numero
        do {
          char operacion = capturarOperacion();   // se captura la operacion
          double numero2 = capturaNumero();          // se captura segundo numero
          double resultado = calcular(numero1,numero2,operacion);    // se llama a la funcion calcular para retornor resultado
          numero1 = resultado;                          // se establece el valor total al valor numero 1
          System.out.println("El resultado de la operación: "+resultado);     // se imprime el resultado en consola
        }while(true);
    }

    public static double capturaNumero(){
        System.out.print("Introduzca un número: ");     // mensaje de consola
        double numero;                                  // define variable decimal
        if(scanner.hasNextDouble()){                    // verifica si el proximo token puede ser bouble
            numero = scanner.nextDouble();              // habilita el ingreso del valor del numero
        } else {
            System.out.println("Te has equivocado al introducir el número. Inténtalo de nuevo.");
            scanner.next(); //recursividad
            numero = capturaNumero();   // se captura nuevamente el numero
        }
        return numero;  //retorna el valor del numero
    }

    public static char capturarOperacion(){
        System.out.print("Introduzca la operación: ");      // mensaje de consola
        char operacion;                                     // define variable caracter
        if(scanner.hasNext()){                              // verifica la entrada
            operacion = scanner.next().charAt(0);           // toma el primer caracter ingresado
        } else {
            System.out.println("Ha cometido un error al entrar en la operación. Inténtalo de nuevo.");
            scanner.next();//recursividad
            operacion = capturarOperacion();    // se captura nuevamente la operacion
        }

        do {
            if (operacion == '+') {         // se evalua si la operacion es suma
                banderaOperacion = false;   // se habilita el procedimiento
            } else if (operacion == '-') {  // se evalua si la operacion es resta
                banderaOperacion = false;   // se habilita el procedimiento
            } else if (operacion == '*') {  // se evalua si la operacion es multiplicacion
                banderaOperacion = false;   // se habilita el procedimiento
            } else if (operacion == '/') {  // se evalua si la operacion es division
                banderaOperacion = false;   // se habilita el procedimiento
            } else if (operacion == '%') {  // se evalua si la operacion es modulo
                banderaOperacion = false;
            }else{
                System.out.println("La operación no se reconoce. Repite la entrada.");  // mensaje de consola
                operacion = capturarOperacion();    // se captura nuevamente la operacion
            }
        }while(banderaOperacion);   // condicion de parada
        return operacion;           // retorna la operacion
    }

    public static double calcular(double num1, double num2, char operacion){    // funcion calcular
        double resultado;               // define variable decimal
        while(num2 == 0 & operacion == '/'){      // verifica que no se pueda dividir por cero
            System.out.println("No se puede dividir por 0, ya que esta operacion no existe. Inténtalo de nuevo.");
            num2 = capturaNumero();         // pide un nuevo valor para dividir
        }

        switch (operacion) {                        // operacion
            case '+' -> resultado = num1 + num2;    // sumar
            case '-' -> resultado = num1 - num2;    // restar
            case '*' -> resultado = num1 * num2;    // multiplicar
            case '/' -> resultado = num1 / num2;    // dividir
            case '%' -> resultado = num1 % num2;    // modulo
            default -> {
                System.out.println("La operación no se reconoce. Repite la entrada.");  // mensaje de consola
                resultado = calcular(num1, num2, capturarOperacion());  //recursividad
            }
        }
        return resultado;       // retorna el resultado
    }
}