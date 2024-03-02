package org.example;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidatorUsingDateFormat implements DateValidator {
    private final String dateFormat;

    public DateValidatorUsingDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            if(dateStr.length() != 10) {
                throw new RuntimeException("Неверный формат даты, пожалуйста введите корректно dd.mm.yyyy");
            }
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    @Override
    public String okDate(boolean valid) {
        if (valid) return "Введенная дата корректна";
        else throw new RuntimeException("Неверный формат даты, пожалуйста введите корректно dd.mm.yyyy");
    }



}
