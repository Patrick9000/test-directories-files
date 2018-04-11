package ru.test.directories.other;

public class SizeFormatUtil {
    public static String getSizeReadable(long size)
    {
        int unit = 1024;
        if (size < unit) return size + " B";
        int exp = (int) (Math.log(size) / Math.log(unit));
        char pre = ("kMGTPE").charAt(exp-1);
        return String.format("%.1f %sB", size / Math.pow(unit, exp), pre);
    }
}
