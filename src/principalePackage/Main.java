package principalePackage;

import principalePackage.utils.CustomException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.function.IntPredicate;

public class Main {
    public static void main(String[] args) throws Exception {
        // Validez un mot de passe en respectant les conditions suivantes :
        // * minimum de taille 8
        // * contient des lettres minuscules et majuscules
        // * contient au minimum 2 nombres
        // pour chaque condition non respectée, lancez l'exception qui lui correspond
        // => gérez les exceptions

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("enter a password : ");
            String password = scanner.nextLine();
            try{
                validatePassword(password);
                System.out.println("valid password");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }


        }

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


