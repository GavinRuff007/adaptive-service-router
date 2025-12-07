package com.rahand.rip.government.infrastructure.api.common.date;

import java.io.Serializable;
import java.util.Formatter;
import java.util.TimeZone;

public class DateTime implements Serializable, Cloneable, Comparable {

    public DateTime() {
    }

    public DateTime(int year, int month, int day)
    {
        this(year, month, day, 0, 0, 0, 0, TimeZone.getDefault());
    }

    public DateTime(int year, int month, int day, int hour, int minute, int second)
    {
        this(year, month, day, hour, minute, second, 0, TimeZone.getDefault());
    }

    public DateTime(int year, int month, int day, int hour, int minute, int second, int millisecond)
    {
        this(year, month, day, hour, minute, second, millisecond, TimeZone.getDefault());
    }

    public DateTime(int year, int month, int day, int hour, int minute, int second, int millisecond,
                    TimeZone timeZone)
    {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.millisecond = millisecond;
        if(timeZone == null || timeZone.equals(""))
            this.timeZone = TimeZone.getDefault();
        else
            this.timeZone = timeZone;
    }

    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        DateTime that = (DateTime)o;
        if(year != that.year)
            return false;
        if(month != that.month)
            return false;
        if(day != that.day)
            return false;
        if(hour != that.hour)
            return false;
        if(minute != that.minute)
            return false;
        if(second != that.second)
            return false;
        return timeZone == null || that.timeZone == null || timeZone.getID().equals(that.timeZone.getID());
    }

    public String toString()
    {
        Formatter formatter = new Formatter();
        return formatter.format("%1$04d/%2$02d/%3$02d %4$02d:%5$02d:%6$02d", new Object[] {
                Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day), Integer.valueOf(hour), Integer.valueOf(minute), Integer.valueOf(second)
        }).toString();
    }

    public int hashCode()
    {
        int result = year;
        result = 31 * result + month;
        result = 31 * result + day;
        result = 31 * result + hour;
        result = 31 * result + minute;
        result = 31 * result + second;
        return result;
    }

    public int compareTo(DateTime o)
    {
        if(!isValid(this) || !isValid(o))
            throw new IllegalArgumentException("invalid date argument");
        if(year > o.year)
            return 1;
        if(year < o.year)
            return -1;
        if(month > o.month)
            return 1;
        if(month < o.month)
            return -1;
        if(day > o.day)
            return 1;
        if(day < o.day)
            return -1;
        if(hour > o.hour)
            return 1;
        if(hour < o.hour)
            return -1;
        if(minute > o.minute)
            return 1;
        if(minute < o.minute)
            return -1;
        if(second > o.second)
            return 1;
        if(second < o.second)
            return -1;
        if(millisecond > o.millisecond)
            return 1;
        return millisecond >= o.millisecond ? 0 : -1;
    }

    public boolean isValid()
    {
        return isValid(this);
    }

    private boolean isValid(DateTime o)
    {
        if(0 > o.hour || o.hour >= 24)
            return false;
        if(0 > o.minute || o.minute >= 60)
            return false;
        if(0 > o.second || o.second >= 60)
            return false;
        if(o.year == 0 && o.month == 0 && o.day == 0 && o.hour == 0 && o.minute == 0 && o.second == 0)
            return false;
        if(1 > o.month || o.month > 12)
            return false;
        if(1 > o.day || o.day > 31)
            return false;
        if(o.year < 0)
            return false;
        return o.month <= 6 || o.month < 12 && o.day <= 30 || o.month == 12 && (o.day < 30 || o.day == 30 && shamsi_Kabisse(o.year) == 1);
    }

    private int shamsi_Kabisse(int i_iyear)
    {
        int dd;
        if(i_iyear >= 474)
        {
            dd = (i_iyear - 474) % 128;
            if(dd == 0)
                return 1;
        } else
        {
            dd = i_iyear < 342 ? 128 - (374 - i_iyear) % 128 : i_iyear - 342;
        }
        for(int i = 0; i < 30; i++)
            if(Khayyam_Table[i] == dd)
                return 1;

        return 0;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    public int getHour()
    {
        return hour;
    }

    public void setHour(int hour)
    {
        this.hour = hour;
    }

    public int getMinute()
    {
        return minute;
    }

    public void setMinute(int minute)
    {
        this.minute = minute;
    }

    public int getSecond()
    {
        return second;
    }

    public void setSecond(int second)
    {
        this.second = second;
    }

    public TimeZone getTimeZone()
    {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone)
    {
        this.timeZone = timeZone;
    }

    public int getMillisecond()
    {
        return millisecond;
    }

    public void setMillisecond(int millisecond)
    {
        this.millisecond = millisecond;
    }

    public  int compareTo(Object x0)
    {
        return compareTo((DateTime)x0);
    }

    private static final long serialVersionUID = 0x164276b556118bb5L;
    private static final int TSN_NATURAL = 0;
    private static final int TSN_KABISSE = 1;
    private static final int Khayyam_Table[] = {
            5, 9, 13, 17, 21, 25, 29, 34, 38, 42,
            46, 50, 54, 58, 62, 67, 71, 75, 79, 83,
            87, 91, 95, 100, 104, 108, 112, 116, 120, 124
    };
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;
    private int millisecond;
    private TimeZone timeZone;

}
