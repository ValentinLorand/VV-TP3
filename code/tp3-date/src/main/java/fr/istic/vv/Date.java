package fr.istic.vv;

import java.util.LinkedList;
import java.util.List;

class Date implements Comparable<Date> {
    int day;
    int month;
    int year;

    public Date(int day, int month, int year) throws Exception {
        if (!isValidDate(day, month, year)) {
            throw new Exception("Date non valide !");
        }
        this.day = day;
        this.month = month;
        this.year = year;
     }

    public static boolean isValidDate(int day, int month, int year) {
        if(month > 0 && month <=12 && day > 0) {
           return day <= numberOfDay(month,year);
            }
        return false;
    }

    public static boolean isLeapYear(int year) { 
        return year % 4 == 0;
    }

    private static int numberOfDay(int month, int year) {
        List<Integer> trentre = new LinkedList<Integer>();
        int[] co = {4,6,9,11,8,11};
        for(int i=0;i<co.length;i++){
            trentre.add(co[i]);
        }
        if(month == 02 && isLeapYear(year)) {
            return 29;
        }else if(month == 02 && !isLeapYear(year)) {
                return 28;
            }
        else if(trentre.contains(month)) {
            return 30;
        }else {
            return 31;
        }
    }

    public Date nextDate() throws Exception { 
        if(this.month == 12 && this.day == 31) {
            return new Date(1,1,this.year +1);
        }
        int maxDay = numberOfDay(this.month, this.year);
        if(this.day == maxDay) {
            return new Date(1,this.month+1,this.year);
        }
        return new Date(this.day+1,this.month,this.year);
     }

    public Date previousDate() throws Exception { 
        if(this.month == 01 && this.day == 01) {
            return new Date(31,12,this.year-1);
        }

        if(this.day == 01) {
            int previousDay = numberOfDay(this.month-1, this.year);
            return new Date(previousDay,this.month-1,this.year);
        }
        return new Date(this.day-1,this.month,this.year);
     }

    @Override
    public int compareTo(Date other) {
        int diffY = (this.year - other.year) * 365; //Pas parfait mais pas important
        int diffM = (this.month - other.month) * 30;
        int diffD = (this.day - other.day);
        return diffY + diffM + diffD;
     }

    @Override
    public boolean equals(Object other) {
        if(this == other) return true;
        else if(!(this instanceof Date)) return false;
        Date date = (Date) other;
        boolean diffY = this.year == date.year;
        boolean diffM = this.month == date.month;
        boolean diffD = this.day == date.day;

        return diffY && diffM && diffD;
     }
}