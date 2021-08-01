package com.comicsm.comicsmanager.service.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Discount {

    public static String TheDiscountDay(String isbn) {
        if (!isbn.equals("")) {
            char lastNumber = isbn.charAt(isbn.length() - 1);
            int checkNumber = Character.getNumericValue(lastNumber);

            switch (checkNumber) {
                case 0:
                case 1:
                    return "Monday";
                case 2:
                case 3:
                    return "Tuesday";
                case 4:
                case 5:
                    return "Wednesday";
                case 6:
                case 7:
                    return "Thursday";
                case 8:
                case 9:
                    return "Friday";
            }
        }
        return null;
    }

    public static boolean checkActiveDiscount(String discountDay) {
        if (discountDay != null) {
            LocalDate today = LocalDate.now();
            DayOfWeek day = today.getDayOfWeek();
            String dia = day.getDisplayName(TextStyle.FULL, new Locale("pt"));

            if (discountDay.equals(dia)) {
                return true;
            }
        }
        return false;
    }
}
