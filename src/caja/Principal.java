package caja;

//Importamos caja.Caja.Material, para introducir la lista de materiales
import caja.Caja.Material;
import utilidades.ES;

/**
 * Crea una clase Principal, que será la que usará las clases Caja y ES. Se
 * pedira por teclado el carácter con el que se dibujará la caja,se pedira el
 * número de columnas y de filas, así como el material de la misma.
 * Seguidamente, mostrará los datos del objeto caja recién creado y la dibujará,
 * con el método que tenemos para ello. Posteriormente, se pedirá un valor para
 * aumentar la anchura de la caja caja en el tamaño que se lea por teclado y se
 * invocará el método correspondiente con el valor leído, para después mostrar
 * los datos de la caja y volverla a pintar. A continuación, se invocará el
 * método que hemos creado para girar, y de forma similar a lo anterior,
 * mostraremos los datos y dibujaremos una vez más la caja. Por último
 * preguntará si se quiere continuar iterando en el programa, para hacer lo
 * mismo con otra caja, y así sucesivamente.
 *
 * @author Alejandro Acuña Martín
 * @version 1.0
 * @since 17/11/2017
 */
public class Principal {

    /**
     * Pide inicialmente el caracter con el que se dibujara la caja y a
     * continuación el número de filas y columnas del que se compondrá la caja.
     * Tras la introducción de los valores, se dibujara la caja y luego se
     * elegira el material de la que esta hecha.Se podra aumentar el ancho de la
     * caja segun el dato introducido y despues mostrara la caja de nuevo. A
     * continuación se girara la caja, monstrando el resultado del mismo,
     * cambiando el dato de columnas por filas y vicerversa. Por último nos
     * pedira si quereremos realizar otra caja.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Inicialización de la variable caja nueva para usarla en el bucle do-while.
        int cajaNueva = 0;

        //Mensaje incial
        System.out.println("Creación de la Caja");
        //Bucle para repetir el proceso si se elige la opción de crear otra caja
        do {
            //Petición de datos inciales para la creación de la caja
            //Petición del caracter que rellenara la caja.
            char caracter = ES.leeCaracter("Introduce el caracter que dibujara la caja");
            
            //Petitción del número de filas de la caja.
            int fila = ES.leeEntero("Introduce el número de filas de la caja");
            
            //Petición del número de columas de la caja.
            int columna = ES.leeEntero("Introduce el número de columnas de la caja");
            
            //Petición del material de la caja, opción del 1 al 4, madera por defecto.
            int material = ES.leeEntero("Introduce el material que tendra la caja "
                    + "(1-> MADERA 2-CORCHO, 3->PLASTICO, 4-> CARTON)");
            
            //Si se introduce un número diferentes de las opciones, se escogera madera por defecto.
            if(material<1 || material>4){
                System.out.println("Al no elegir una de las 4 opciones, se usara madera por defecto para la caja");
            }
            
            //Se obtiene el material de la caja dependiendo de la opción elegida en la línea 48.
            Material materialCaja = Caja.enteroMaterial(material);
            
            //Inciamos la instancia de la clase Caja con la petición de parametros 
            Caja datosCaja = new Caja(columna, fila, caracter, materialCaja);

            //Imprimos la información de la caja con los datos introducidos
            ES.msg(datosCaja.toString());
            
            //Imprimimos la caja
            datosCaja.dibujar();
            
            //Ejecutamos el metodo para rellenar la caja
            datosCaja.rellenarCaja(columna);
            
            //Imprimimos de nuevo la caja con los nuevos datos dado en rellenarCaja.
            ES.msg(datosCaja.toString());
            
            //Dentro del metodo hay un bucle do-while que se repetira hasta que se introduzca 2 o 7.
            datosCaja.dibujar();
            
            //Por último, giramos la caja siendo el número de filas ahora columnas y viceversa
            datosCaja.girar_caja();
            
            //bucle do-while, para determinar que el número introducido para continuar sea 0 o 1.
            //Si no es correcto volvera a pedirlo.
            do {
                cajaNueva = ES.leeEntero("¿Desea continuar con otra caja? (1->para seguir / 0->para terminar)");

            } while (cajaNueva < 0 || cajaNueva > 1);
          //Cuando la opción sea 0, el programa finalizara.  
        } while (cajaNueva != 0);
    }
}

