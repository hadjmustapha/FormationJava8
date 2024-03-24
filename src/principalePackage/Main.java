package principalePackage;

import principalePackage.utils.CustomException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.function.IntPredicate;

public class Main {
    public static void main(String[] args) throws Exception {
        //-------------------------------Exercie 1 --------------------------------------
        // Validez un mot de passe en respectant les conditions suivantes :
        // * minimum de taille 8
        // * contient des lettres minuscules et majuscules
        // * contient au minimum 2 nombres
        // pour chaque condition non respectée, lancez l'exception qui lui correspond
        // => gérez les exceptions

        //Scanner scanner = new Scanner(System.in);
        //while (true) {
        //    System.out.println("enter a password : ");
        //    String password = scanner.nextLine();
        //    try{
        //       validatePassword(password);
        //        System.out.println("valid password");
        //    }catch (Exception e){
        //        System.out.println(e.getMessage());
        //    }
        //}
        //------------------------------Fin Exercice 1 ----------------------------------
        /**
         *
         */

        //---------------------------------Exercice 2 ------------------------------------
           IGenericSet<Double> myGenericSet = new GenericSet<>(5);
           myGenericSet.print();
           System.out.println(myGenericSet.getSize());
           myGenericSet.add(1.0);myGenericSet.add(1.1);myGenericSet.add(1.2);
           myGenericSet.add(1.3);myGenericSet.add(1.3);myGenericSet.add(1.4);
           myGenericSet.add(1.5);
           myGenericSet.print();

           myGenericSet.remove(1.2);

           myGenericSet.print();
        //-------------------------------Fin Exercice 2 ----------------------------------
    }

    public static void validatePassword(String password) throws Exception {
          if(password.length()<8){
              throw new CustomException("   Taille inférieur à 8         !");
          }
          if(!containsLowerCase(password) || (!containsUpperCase(password)) ){
              throw new CustomException("   doit contenir miniscule et majiscule !");
          }
          if (password.replaceAll("\\D","").length()<2)
            throw new Exception("password should contain at least 2 digits");

    }
    private static boolean containsLowerCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isLowerCase(i));
    }
    private static boolean containsUpperCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isUpperCase(i));
    }
    private static boolean containsNumber(String value) {
        return contains(value, Character::isDigit);
    }
    private static boolean contains(String value, IntPredicate predicate) {
        return value.chars().anyMatch(predicate);
    }


    }


