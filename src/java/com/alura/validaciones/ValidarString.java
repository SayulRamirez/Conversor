package com.alura.validaciones;

public class ValidarString {

    /**
     * EL MÉTODO INTENTA CONVERTIR EL STRING INGRESADO A DOUBLE SI NO ES UN DOUBLE REGRESA TRUE INDICANDO QUE ES UN STRING
     * Y SI LOGRA CONVERTIRLO A UN DATO TIPO DOUBLE REGRESA FALSE INDICANDO QUE NO ES STRING
     * @param str {@link String} valor a evaluar.
     * @return TRUE SI ES STRING Y FALSE SI ES DOUBLE
     */
    public static boolean isString(String str){
        try{
            Double.parseDouble(str);
        } catch(NumberFormatException nfe){
            return true;
        }
        return false;
    }
}
