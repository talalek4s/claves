/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.talalek.claves;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Talalek
 */
public class KeyGenerator {

    public static void main(String[] args) {
               
        String clave = "";
        char[] mayusculas = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] minusculas = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] signo = {'!','"','#','$','%','&', '(',')','*','+', ',','-','.','/', ':',';','<','=','>','?','@', '[',']','^','_', '{','|','}','~'};
        char[] numero = {'0','1','2','3','4','5','6','7','8','9'};
        
        int longitudClave;
        int grupo; 
        int numeroCaracter;
        String letra;
        int respuesta = 0;
        
        do{
           
           Scanner reader = new Scanner(System.in);
           System.out.println("Ingrese un entero mayor que 8 y menor que 50");
           longitudClave = reader.nextInt();
           
           if(longitudClave >= 8 && longitudClave <= 50) respuesta = 1;
           else System.out.println("Longitud erronea, vuelva a intentar ");
           
        }while(respuesta != 1);
        
        for(int i = 1; i<= longitudClave; i++){
        
           grupo = fSemilla(4);
           switch(grupo){
               case 0 -> {
                   numeroCaracter = fSemilla(26);
                   letra = String.valueOf((mayusculas[numeroCaracter]));
                   clave = clave.concat(letra);
                }
               case 1 -> {
                   numeroCaracter = fSemilla(26);
                   letra = String.valueOf((minusculas[numeroCaracter]));
                   clave = clave.concat(letra);
                }
               case 2 -> {
                   numeroCaracter = fSemilla(29);
                   letra = String.valueOf((signo[numeroCaracter]));
                   clave = clave.concat(letra);
                }
               case 3 -> {
                   numeroCaracter = fSemilla(10);
                   letra = String.valueOf((numero[numeroCaracter]));
                   clave = clave.concat(letra);
                }
               default -> {
                }
           }//switch

        }//for
        
        System.out.println(clave);

    }//main
    
    static int fSemilla(int dato){
        
        Calendar calendario = new GregorianCalendar();
        int minuto = calendario.get(Calendar.MINUTE);
        int segundo = calendario.get(Calendar.SECOND);
        
        int semilla = minuto + segundo+ (int) Math.floor(Math.random()*dato);
        semilla = semilla %dato;

        return semilla;
    }
    
}
