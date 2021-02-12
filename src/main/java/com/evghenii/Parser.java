package com.evghenii;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.StringTokenizer;

public class Parser {

    // old version
    public void parseAndDisplayAlt(String s) {
        StringTokenizer toki = new StringTokenizer(s, "/");

        String t1 = toki.nextToken();
        String t2 = toki.nextToken();
        String t3 = toki.nextToken();
        String t4 = toki.nextToken();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, convert(t1));
        calendar.set(Calendar.MINUTE, convert(t2));
        calendar.set(Calendar.SECOND, convert(t3));
        calendar.set(Calendar.MILLISECOND, convert(t4));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        System.out.println(simpleDateFormat.format(calendar.getTime()));
    }

    public int convert(String valueToConvert) {
        Integer returnValue = null;
        try {
            returnValue = Integer.valueOf(valueToConvert);
        } catch (NumberFormatException e) {
        }
        return returnValue;
    }

    /**
     * @param dateString - Eingabe Daten (String-Parameter), die aus 4 getrennten Elementen durch "/" besteht
     *                   - Der erste Parameter ist Stunden
     *                   - Der zweite Parameter ist Minuten
     *                   - Der dritte Parameter ist Sekunden
     *                   - Der vierte Parameter ist Millisekunden
     */
    // a new version
    public void parseAndDisplayNew(String dateString) {
        String[] split = dateString.split("/");

        LocalDateTime now = LocalDateTime.of(
                getRightNow(), LocalTime.of(0, 0))
                .plusHours(Integer.parseInt(split[0]))
                .plusMinutes(Integer.parseInt(split[1]))
                .plusSeconds(Integer.parseInt(split[2]))
                .plusNanos(Integer.parseInt(split[3]) * 1_000_000L);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        System.out.print(now.format(formatter));
    }

    /**
     * @return return the current time
     */
    public LocalDate getRightNow() {
        return LocalDate.now();
    }

}
