package org.example;

import java.io.FileWriter;
import java.io.IOException;

import java.util.Arrays;
import java.util.Scanner;

public class Input {
    String[] text = new String[6];
    public String[] input() throws IOException {
        String mafia = prompt("Введите фамилию: ");
        String name = prompt("Введите имя: ");
        String fathername = prompt("Введите отчество: ");
        String birthday = prompt("Введите дату рождения формата dd.mm.yyyy: ");

        DateValidator validator = new DateValidatorUsingDateFormat("dd.MM.yyyy");
        validator.isValid(birthday);
        String phone = prompt("Введите номер мобильного телефона формата 7хххххххххх: ");
        if(phone.charAt(0) == 7){
            try {
                int i = Integer.parseInt(phone);
            }catch (NumberFormatException e){
                System.out.println("Номер должен содержать только цифры");
                return null;
            }
        }else {
            System.out.println();
        }

        String gender = prompt("укажите ваш пол (f - женский, m -  мужской): ");
        if (gender.charAt(0) != 'f' && gender.charAt(0) != 'm') {
            System.out.println("Пол должен быть указан как f (женский) или m (мужской).");
            return null;
        }
//        String result = "<"+mafia+"> "+"<"+name+"> "+"<"+fathername+"> "+"<"+birthday+"> "+"<"+phone+"> "+"<"+gender+"> ";
        String[] result = {mafia,name,fathername,birthday,phone,gender};

        for (String s : result) {
            if (s.isEmpty()) {
                System.out.println("Неверное колличество данных, пустые значения не принимаются");
                return null;
            }
        }
        System.out.println(Arrays.toString(result));
        String text = "<"+mafia+"> "+"<"+name+"> "+"<"+fathername+"> "+"<"+birthday+"> "+"<"+phone+"> "+"<"+gender+"> ";
        FileWriter fileWriter = new FileWriter(mafia+".txt",true);
        fileWriter.write(text + "\n");
        fileWriter.close();
        return result;

    }



    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

//    public static void isNumber(String str) {
//        try {
//            Integer.parseInt(str);
//        } catch (Exception ignored) {
//        }
//    }
//    void controlInput() throws IOException {
//        try{
//
//        }catch(){
//
//        }final{
//            String[] control = input();
//            FileWriter fileWriter = new FileWriter(control[0] + ".txt", true);
//            String text = "<" + control[0] + "> " + "<" + control[1] + "> " + "<" + control[2] + "> " + "<" + control[3] + "> " + "<" + control[4] + "> " + "<" + control[5] + "> ";
//            fileWriter.write(text + "\n");
//            fileWriter.close();
//        }
//    }

}
