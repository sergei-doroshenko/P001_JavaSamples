package main.java.core._12_hash_code_equals;

/**
 * Created by Sergei on 13.05.2016.
 */
public class DateMO {
    private int year;
    private int month;
    private int date;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof DateMO)) return false;

        DateMO dateMO = (DateMO) o;

        if (year != dateMO.year) return false;
        if (month != dateMO.month) return false;
        return date == dateMO.date;

    }

    @Override
    public int hashCode()
    {
        int result = year;
        result = 31 * result + month;
        result = 31 * result + date;
        return result;
    }

    public static void main(String[] args) {
        DateMO d1 = new DateMO();
        System.out.println(d1 instanceof DateMO);
        DateMO d2 = null;
        System.out.println(d2 instanceof DateMO);

    }
}
