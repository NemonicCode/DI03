/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caja;

//Importamos utilidades.ES para poder usar metodos de la clase .ES en la clase Caja
import utilidades.ES;

/**
 * En la clase Caja se definen los atributos necesarios tal y como se listan a
 * continuación, sabiendo que una caja tendrá un carácter que dibujado de forma
 * repetida en x filas e y columnas conformará la caja.
 *
 * @author Alejandro
 *
 *
 */
public class Caja {

    private int x;//Número de filas que se repetira el carácter introducido
    private int y;//Número de columnas que se repetira el carácter introducido
    private char caracter;//Caracter que formara la caja
    private Material material;//Material del que estará hecha la caja

    //Enumeramos los valores del atributo Material
    public enum Material {
        MADERA, CORCHO, PLASTICO, CARTON
    }

    /**
     * Creamos un constructor con los valores por defecto de la caja
     * caracter-'*' columnas-5 filas-2 material-CORCHO
     */
    public Caja() {
        //Valores iniciales de las variables
        x = 2;//Variable que indica el número de columnas
        y = 5;//Variable que indica el número de filas
        caracter = '*';//Variable que indica el caracter
        material = Material.CORCHO;//Material inicial de la caja

    }

    /**
     * Constructor con parámetros para la clase Caja que inicialice los
     * atributos el objeto con los valores que se le pasen como parámetros al
     * invocar al constructor para crear un nuevo objeto.
     *
     * @param x columnas que se asignaran a la caja.
     * @param y filas que se asignaran a la caja.
     * @param caracter caracter que formara la caja.
     * @param material material del que estara hecha la caja.
     *
     *
     */
    public Caja(int y, int x, char caracter, Material material) {

        this.x = x;
        this.y = y;
        this.caracter = caracter;
        this.material = material;
    }
   
    /**
     * Devuelve una cadena de caracteres con la información del objeto.
     *
     * @return Cadena con la información de las filas x,columnas y,caracter y el
     * material del que esta hecha la caja.
     */
    @Override
    public String toString() {
        return "La caja se dibuja con el carácter:  " + caracter + " y se dibujará con: "
                + y + " columnas y " + x + " filas.El material de la caja es " + material;
    }
    /**
     * Devuelve una cadena de caracteres con la información del objeto.
     *
     * @return Cadena con la información de las filas x,columnas y,caracter y el
     * material del que esta hecha la caja.
     */
    public String girarString() {
        return "La caja se dibuja con el carácter:  " + caracter + " y se dibujará con: "
                + x + " columnas y " + y + " filas.El material de la caja es " + material;
    }

    /**
     * Dibujar una caja segun los parametros introducidos, x(filas) indica el
     * alto de la caja y y(columas) indica el ancho de la misma. El caracter
     * introducido es el que que rellenara el espacio indicado por x y y.
     *
     * @param x filas de la caja, indicara el alto de la misma.
     * @param y columnas de la caja, indcara el ancho de la misma.
     * @param caracter Caracter que dibujara la caja rellenadolo segun las filas
     * y columnas introducidas.
     */
    public void dibujar() {
        System.out.println("");
        for (int i = 0; i < x; i++) {
            for (int h = 0; h < y; h++) {
                System.out.print(caracter);
            }
            System.out.println("");
        }

    }
    /**
     * Metodo para aumentar el número de columnas de la caja, añadiendo a la misma 
     * un número introducido por teclado.
     * 
     * @param y añade el valor de y a this.y para aumentar el número de columnas de la caja
     * @return devuelve el valor de y.
     */
    public int rellenarCaja(int y) {
        System.out.println("");
        int rellenar = 0;
        do {
            ES.msg("Introduce un valor entre 2 y 7 para aumentar el número de columnas de la caja> ");
            rellenar = ES.leeEntero();
        } while (rellenar < 2 || rellenar > 7);
        this.y = rellenar + y;
        return y;

    }

    /**
     * Cambia el dato recibido al invocar la caja, En este caso, el primer bucle
     * recibe en este caso y(columas) y el segundo bucle recibira x(filas),
     * invirtiendo la impresión de la caja.
     * 
     */
    public void girar_caja() {
        System.out.println("Se procede a girar la caja");
        System.out.println(girarString());
        for (int i = 0; i < y; i++) {
            for (int h = 0; h < x; h++) {
                System.out.print(caracter);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    /**
     * Elección del material de la caja, segun número introducido
     *
     * @param mat_caja Número entero que represeta el material a elegir.
     * @return Devolverá el valor del enumerado MADERA,CORCHO,PLASTICO o CARTON
     * según el número que recibe como parámetro.
     */
    public static Material enteroMaterial(int mat_caja) {
        Material mat = Material.CORCHO;

        switch (mat_caja) {
            case 0:
            case 1:
                mat = Material.MADERA;
                break;
            case 2:
                mat = Material.CORCHO;
                break;
            case 3:
                mat = Material.PLASTICO;
                break;
            case 4:
                mat = Material.CARTON;
                break;
            default:
                mat = Material.MADERA;
        }
        return mat;
    }
 //Get y Set
 //Columnas
    /**
     * Columnas que tendra la caja.
     *
     * @return Devuelve el número de columnas que tendra la caja
     */
    public int getX() {
        return x;
    }
    /**
     * Columnas que se asignara al objeto.
     *
     * @param x columnas que tendra la caja.
     */
    public void setX(int x) {
        this.x = x;
    }
    
    //Filas
    /**
     * Filas que tendra la caja
     *
     * @return Devuelve el número de filas que tendra la caja
     */
    public int getY() {
        return y;
    }
    /**
     * Filas que se asignaran al objeto
     *
     * @param y Filas que tendra la caja.
     */
    public void setY(int y) {
        this.y = y;
    }
    
    //Caracter
    /**
     * Caracter del que se comprondra la caja
     *
     * @return Devuelve el caracter que se ejecutara para formar la caja
     */
    public char getCaracter() {
        return caracter;
    }

    
    /**
     * Caracter que se asignara al objeto
     *
     * @param caracter Caracter que formara la caja.
     */
    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    //Material
    /**
     * Material del que se estara formada la caja
     *
     * @return Devuelve el material del que esta hecho la caja
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Material que se asignaran al objeto
     *
     * @param material Columnas que tendra la caja.
     */
    public void setMaterial(Material material) {
        this.material = material;
    }
}
