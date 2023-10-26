package org.utm.labtwo.services;

public class CommandService {

    public static void greetingMessage() {
        System.out.println("Welcome to the university management system! \n Choose an option:");
        System.out.println("g - general Operations");
        System.out.println("f - faculty Operations");
        System.out.println("q - exit the program");
    }

    public static void getFacultyOperations() {
        System.out.println("cf/<faculty name>/<faculty abbreviation>/<field> - create new faculty");
        System.out.println("df - display faculties");
        System.out.println("ss/<email> - search what faculty student belongs");
        System.out.println("dfef/<field> - display all faculties of a field");
        System.out.println();
        System.out.println("b - back");
        System.out.println("q - exit the program");
    }

    public static void getGeneralOperations() {
        System.out.println("cs/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year> - create new student");
        System.out.println("gs/<email> - (g)raduate (s)tudent");
        System.out.println("des/<faculty abbreviation> - (d)isplay (e)nrolled students");
        System.out.println("dgs/<faculty abbreviation> - (d)isplay (g)raduated students");
        System.out.println("bf/<faculty abbreviation>/<email> - check if student (b)elongs to (f)aculty");
        System.out.println();
        System.out.println("b - back");
        System.out.println("q - exit the program");
    }

}
