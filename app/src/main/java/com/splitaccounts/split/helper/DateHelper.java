package com.splitaccounts.split.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gaellecoz on 12.11.2015.
 */
public abstract class DateHelper {

    /**
     * ISO8601 long RFC822 zone
     */
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

    /**
     * @return The current date in text form
     */
    public static final String toText() {
        return toText(new Date());
    }

    /**
     * @param date The date object to convert
     * @return The provided date in text form
     */
    public static final String toText(Date date) {
        return dateFormat.format(date);
    }

    /**
     * Transform a sring into Date object
     * @param date The date in text form to convert
     * @return A Date object corresponding to the provided date in text
     */
    public static final Date toDate(String date) {
        Date res;

        try {
            res = dateFormat.parse(date);
        } catch (ParseException e) {
            res = new Date();
        }

        return res;
    }
}
