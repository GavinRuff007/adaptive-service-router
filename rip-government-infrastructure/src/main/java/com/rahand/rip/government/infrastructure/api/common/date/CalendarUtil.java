package com.rahand.rip.government.infrastructure.api.common.date;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarUtil {
    private static final String JALALI_DATE_PATTERN = "yyyy/MM/dd";
    private static int[] months = new int[] {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };
    private static int[] khayyamTable = new int[] {
            5, 9, 13, 17, 21, 25, 29, 34, 38, 42, 46, 50, 54, 58, 62, 67, 71, 75,
            79, 83, 87, 91, 95, 100, 104, 108, 112, 116, 120, 124
        };

    public CalendarUtil() {
    }

    public static DateTime currentJalaliDateTime() {
        return getDateTime(new JalaliCalendar());
    }

    public static Date currentMiladiDate() {
        JalaliCalendar jalaliCalendar = new JalaliCalendar();

        return jalaliCalendar.getTime();

    }

    public static DateTime currentMiladiDateTime() {
        JalaliCalendar jalaliCalendar = new JalaliCalendar();
        Date date = jalaliCalendar.getTime();

        return toDateTime(date);
    }

    public static String formatToJalaliDate(Date date, String pattern) {
        JalaliCalendar p = new JalaliCalendar(date);
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        format.setCalendar(p);

        return format.format(date);
    }

    public static JalaliCalendar parseGregorian(String date, String format) {
        try {
            if ((date != null) && !date.trim().equals("") && (format != null) &&
                    !format.equals("")) {
                if ((format != null) && !format.trim().equals("")) {
                    GregorianCalendar calendar = new GregorianCalendar();
                    SimpleDateFormat dateFormat = new SimpleDateFormat(format);
                    dateFormat.setCalendar(calendar);
                    dateFormat.parse(date);

                    DateFormatSymbols symbols = new DateFormatSymbols();
                    dateFormat.setDateFormatSymbols(symbols);

                    JalaliCalendar jalaliCalendar = new JalaliCalendar();
                    jalaliCalendar.setTime(dateFormat.getCalendar().getTime());

                    return jalaliCalendar;
                } else {
                    throw new Exception(
                        "the given 'format' either is null or with no value.");
                }
            } else {
                throw new Exception(
                    "the given 'date' either is null or with no value.");
            }
        } catch (Exception var6) {
            return null;
        }
    }

    public static JalaliCalendar parseJalali(String jalaliDate) {
        try {
            if ((jalaliDate != null) && !jalaliDate.trim().equals("")) {
                String[] dateparam = jalaliDate.split("/");
                if ((dateparam != null) || (dateparam.length != 3)) {
                    DateTime dateTime = new DateTime(Integer.valueOf(
                                dateparam[0]), Integer.valueOf(dateparam[1]),
                            Integer.valueOf(dateparam[2]));
                    JalaliCalendar jalaliCalendar = new JalaliCalendar(dateTime);
                    return jalaliCalendar;
                } else {
                    throw new Exception(
                        "the given 'date' is not in correct format use 'YYYY/MM/DD'.");
                }
            } else {
                throw new Exception(
                    "the given 'date' either is null or with no value.");
            }
        } catch (Exception var6) {
            return null;
        }
    }
    public static DateTime toDateTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return getDateTime(calendar);
    }

    public static Date toDate(DateTime dateTime) {
        JalaliCalendar jalaliCalendar = new JalaliCalendar(dateTime);

        return jalaliCalendar.getTime();
    }

    public static DateTime getDateTime(JalaliCalendar jalaliCalendar) {
        int year = jalaliCalendar.get(1);
        int month = jalaliCalendar.get(2) + 1;
        int day = jalaliCalendar.get(5);
        int hour = jalaliCalendar.get(11);
        int minute = jalaliCalendar.get(12);
        int second = jalaliCalendar.get(13);
        int millisecond = jalaliCalendar.get(14);

        return new DateTime(year, month, day, hour, minute, second, millisecond);
    }

    public static DateTime getDateTime(Calendar calendar) {
        int year = calendar.get(1);
        int month = calendar.get(2) + 1;
        int day = calendar.get(5);
        int hour = calendar.get(11);
        int minute = calendar.get(12);
        int second = calendar.get(13);
        int millisecond = calendar.get(14);

        return new DateTime(year, month, day, hour, minute, second, millisecond);
    }

    public static DateTime gregorianToJalali(Date date) {
        return getDateTime(new JalaliCalendar(date));
    }

    public static Date jalaliToGregorianDate(DateTime jalali) {
        JalaliCalendar jalaliCalendar = new JalaliCalendar(jalali);

        return jalaliCalendar.getTime();
    }

    public static DateTime jalaliToGregorianDateTime(DateTime jalali) {
        JalaliCalendar jalaliCalendar = new JalaliCalendar(jalali);

        return toDateTime(jalaliCalendar.getTime());
    }

    public static Date jalaliToGregorianDate(String jalali) {
        return jalaliToGregorianDate(parseDateTime(jalali));
    }

    public static DateTime jalaliToGregorianDateTime(String jalali) {
        return jalaliToGregorianDateTime(parseDateTime(jalali));
    }

    public static DateTime addDaysToJalaliDate(DateTime date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(jalaliToGregorianDate(date));
        calendar.add(5, days);

        Date gregorian = calendar.getTime();

        return gregorianToJalali(gregorian);
    }

    public static DateTime addDaysToJalaliDate(String date, int days) {
        DateTime dateTime = parseDateTime(date);

        return addDaysToJalaliDate(dateTime, days);
    }

    public static DateTime addMonthsToJalaliDate(DateTime date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(jalaliToGregorianDate(date));
        calendar.add(2, months);

        Date gregorian = calendar.getTime();

        return gregorianToJalali(gregorian);
    }

    public static DateTime addMonthsToJalaliDate(String date, int months) {
        DateTime dateTime = parseDateTime(date);

        return addMonthsToJalaliDate(dateTime, months);
    }

    public static Date addDaysToGregorianDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, days);

        return calendar.getTime();
    }

    public static Date addMonthsToGregorianDate(Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(2, months);

        return calendar.getTime();
    }

    public static DateTime parseDateTime(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        try {
            JalaliCalendar jalaliCalendar = new JalaliCalendar();
            format.setCalendar(jalaliCalendar);
            format.parse(date);

            return new DateTime((String.valueOf(jalaliCalendar.get(1)).length() == 2)
                ? (1300 + jalaliCalendar.get(1)) : jalaliCalendar.get(1),
                jalaliCalendar.get(2) + 1, jalaliCalendar.get(5),
                jalaliCalendar.get(11), jalaliCalendar.get(12),
                jalaliCalendar.get(13));
        } catch (ParseException var3) {
            throw new RuntimeException(
                "date format not valid. valid jalali date format is yyyy/MM/dd");
        }
    }

    public static String currentJalaliDate() {
        JalaliCalendar jalaliCalendar = new JalaliCalendar();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        simpleDateFormat.setCalendar(jalaliCalendar);

        return simpleDateFormat.format(jalaliCalendar.getTime());
    }

    private static String calculateSpecificDate(JalaliCalendar jalaliDate,
                                                int day_of_month) {
        jalaliDate.add(5, day_of_month);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        simpleDateFormat.setCalendar(jalaliDate);

        return simpleDateFormat.format(jalaliDate.getTime());
    }

    public static String getSpecificDate(Date specificDate, int day_of_month) {
        JalaliCalendar jalaliDate = new JalaliCalendar(specificDate);

        return calculateSpecificDate(jalaliDate, day_of_month);
    }

    public static String getSpecificJDate(String specificDate, int day_of_month) {
        JalaliCalendar jalaliDate = new JalaliCalendar(parseDateTime(
                    specificDate));

        return calculateSpecificDate(jalaliDate, day_of_month);
    }

    public static boolean isBefore(String firstDate, String secondDate) {
        JalaliCalendar firstJalaliCalendar = new JalaliCalendar(parseDateTime(
                    firstDate));
        JalaliCalendar secondJalaliCalendar = new JalaliCalendar(parseDateTime(
                    secondDate));

        return firstJalaliCalendar.before(secondJalaliCalendar);
    }

    public static boolean isBefore(DateTime firstDate, DateTime secondDate) {
        JalaliCalendar firstJalaliCalendar = new JalaliCalendar(firstDate);
        JalaliCalendar secondJalaliCalendar = new JalaliCalendar(secondDate);

        return firstJalaliCalendar.before(secondJalaliCalendar);
    }

    public static Date convertShamsiToMiladi(String date) {
        JalaliCalendar jalaliCalendar = new JalaliCalendar(parseDateTime(date));

        return jalaliCalendar.getTime();
    }

    public static Date convertJalaliToMiladi(Date date) {
        JalaliCalendar jalaliCalendar = new JalaliCalendar(date);

        return jalaliCalendar.getTime();
    }

    public static String includeSlash(String date) {
        return date.substring(0, 4) + "/" + date.substring(4, 6) + "/" +
        date.substring(6, 8);
    }

    public static boolean isKabiseYear(int year) {
        int dd;

        if (year >= 474) {
            dd = (year - 474) % 128;

            if (dd == 0) {
                return true;
            }
        } else {
            dd = (year >= 342) ? (year - 342) : (128 - ((374 - year) % 128));
        }

        for (int i = 0; i < 30; ++i) {
            if (khayyamTable[i] == dd) {
                return true;
            }
        }

        return false;
    }
}
