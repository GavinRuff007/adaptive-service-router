package com.rahand.rip.government.infrastructure.api.common;

import com.rahand.rip.government.infrastructure.api.common.date.CalendarUtil;
import com.rahand.rip.government.infrastructure.api.common.date.DateTime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class CommandUtil {

    public static String convertToPersianDate(LocalDateTime dateTime) {
        String persianDate = "";

        DateTime jalaliDateTime = CalendarUtil.gregorianToJalali(Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant()));
        persianDate = String.format("%s/%s/%s", jalaliDateTime.getYear(),
                jalaliDateTime.getMonth() <= 9 ? "0" + jalaliDateTime.getMonth() : jalaliDateTime.getMonth(),
                jalaliDateTime.getDay() <= 9 ? "0" + jalaliDateTime.getDay() : jalaliDateTime.getDay());

        return persianDate;
    }
}
