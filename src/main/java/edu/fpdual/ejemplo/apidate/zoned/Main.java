package edu.fpdual.ejemplo.apidate.zoned;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class Main {


    public static void main(String[] args) {
        zonedDateTime();

//        ZoneId.getAvailableZoneIds().forEach(System.out::println);

    }

    private static void zonedDateTime() {

        Instant instant = Instant.now();

        ZonedDateTime fechaActualWinipeg = ZonedDateTime.ofInstant(instant, ZoneId.of("America/Winnipeg"));
        ZonedDateTime fechaActualSpain = ZonedDateTime.ofInstant(instant, ZoneId.of("Europe/Madrid"));
        System.out.println(fechaActualWinipeg);
        System.out.println(fechaActualSpain);
        System.out.println(fechaActualWinipeg.isBefore(fechaActualSpain));
        fechaActualWinipeg = fechaActualWinipeg.withZoneSameInstant(ZoneId.of("Asia/Seoul"));
        System.out.println(fechaActualWinipeg);
        System.out.println(fechaActualWinipeg.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
    }

}
