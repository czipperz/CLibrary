package com.czipperz.cLibrary.util.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class CArrayHelper {
    private CArrayHelper() {}

    /**
     * Condenses the array by if any members .equals() or == (depending on the parameter equals that is inputed) the parameter equals.
     * @param t - the array to condense.
     * @param delete - the object to delete all from the array.  IF NULL WILL THROW AN EXCEPTION!
     * @param equals - true means use .equals() to test, false means use ==
     * @return the condensed array (will == t, not literally, if no objects to delete.)
     */
    public static <T extends Object> T[] condense(T[] t, T delete, boolean equals) {
        Objects.requireNonNull(t);
        Objects.requireNonNull(delete);
        List<T> result = toArrayList(t);
        for(int i = 0; i < t.length; i++) {
            if(equals)
                if(!(t[i].equals(delete)))
                    result.remove(i);
                else
                if(!(t[i] == delete))
                    result.remove(i);
        }
        return toArray(result);
    }

    /**
     * Condenses the array by if any members are null.
     * @param t - the array to condense.
     * @return the condensed array (will == t, literally, if no objects to delete.)
     */
    public static <T extends Object> T[] condense(T[] t) {
        Objects.requireNonNull(t);
        List<T> result = toArrayList(t);
        for(int i = 0; i < t.length; i++)
            if(!(t[i] == null))
                result.remove(i);
        return toArray(result);
    }

    public static <T extends Object> List<T> addAll(List<T> a, List<T> t) {
        for(T i : t)
            a.add(i);
        return a;
    }

    public static <T extends Object> List<T> addAll(List<T> a, T[] t) {
        for(T i : t)
            a.add(i);
        return a;
    }

    public static <T extends Object> ArrayList<T> toArrayList(T[] t) {
        ArrayList<T> r = new ArrayList<T>();
        for(int i = 0; i < t.length; i++)
            r.add(t[i]);
        return r;
    }

    public static <T extends Object> T[] toArray(List<T> t) {
        return (T[]) t.toArray();
    }

    public static <E extends Object> E[] snip(List<E> a, int x, int width) {
        E[] result = (E[]) new Object[width];
        for(int i = 0; i < result.length; i++)
            result[i] = a.get(x);
        return result;
    }

    public static <E extends Object> E[] snip(E[] a, int x, int width) {
        E[] result = (E[]) new Object[width];
        for(int i = x; i < x + width; i++)
            result[i] = a[x];
        return result;
    }

    public static <E extends Object> E[][] snip(E[][] a, int x, int width) {
        E[][] result = (E[][]) new Object[width][a[0].length];
        for(int i = x; i < x + width; i++)
            result[i] = a[x];
        return result;
    }

    public static Object[] snipTo(List<? extends Object> a, int x, int endX) {
        Object[] result = new Object[endX - x];
        for(int i = 0; i < result.length; i++)
            result[i] = a.indexOf(i + x);
        return result;
    }

    public static boolean[] snip(boolean[] a, int x, int width) {
        boolean[] result = new boolean[width];
        for(int i = x; i < x + width; i++)
            result[i] = a[x];
        return result;
    }

    public static boolean[][] snip(boolean[][] a, int x, int width) {
        boolean[][] result = new boolean[width][a[0].length];
        for(int i = x; i < x + width; i++)
            result[i] = a[x];
        return result;
    }

    public static char[] snip(char[] a, int x, int width) {
        char[] result = new char[width];
        for(int i = x; i < x + width; i++)
            result[i] = a[x];
        return result;
    }

    public static char[][] snip(char[][] a, int x, int width) {
        char[][] result = new char[width][a[0].length];
        for(int i = x; i < x + width; i++)
            result[i] = a[x];
        return result;
    }

    public static double[] snip(double[] a, int x, int width) {
        double[] result = new double[width];
        for(int i = x; i < x + width; i++)
            result[i] = a[x];
        return result;
    }

    public static double[][] snip(double[][] a, int x, int width) {
        double[][] result = new double[width][a[0].length];
        for(int i = x; i < x + width; i++)
            result[i] = a[x];
        return result;
    }

    public static float[] snip(float[] a, int x, int width) {
        float[] result = new float[width];
        for(int i = x; i < x + width; i++)
            result[i] = a[x];
        return result;
    }

    public static float[][] snip(float[][] a, int x, int width) {
        float[][] result = new float[width][a[0].length];
        for(int i = x; i < x + width; i++)
            result[i] = a[x];
        return result;
    }

    public static int[] snip(int[] a, int x, int width) {
        int[] result = new int[width];
        for(int i = x; i < x + width; i++)
            result[i] = a[x];
        return result;
    }

    public static int[][] snip(int[][] a, int x, int width) {
        int[][] result = new int[width][a[0].length];
        for(int i = x; i < x + width; i++)
            result[i] = a[x];
        return result;
    }

    public static long[] snip(long[] a, int x, int width) {
        long[] result = new long[width];
        for(int i = x; i < x + width; i++)
            result[i] = a[x];
        return result;
    }

    public static long[][] snip(long[][] a, int x, int width) {
        long[][] result = new long[width][a[0].length];
        for(int i = x; i < x + width; i++)
            result[i] = a[x];
        return result;
    }

    public static <T extends Object> ArrayList<T> createArrayList(T object) {
        ArrayList<T> a = new ArrayList<T>();
        a.add(object);
        return a;
    }

    public static <T extends Object> T[] createArray(T object) {
        T[] t = (T[]) new Object[1];
        t[0] = object;
        return t;
    }

    /**
     * Tests if there is overlap BETWEEN the lists.  Doesn't check for list duplicity.  Uses <code>.equals()</code>
     * @param items - The lists to compare
     * @return Returns true if an object is measured as equivalent between the lists.
     */
    public static <T extends Object> boolean isOverlap(List<T>[] items) {
        for (int i = 0; i < items.length - 1; i++)
            for (int j = 0; j < items[i].size(); j++)
                for (int k = i+1; k < items.length; k++)
                    for (int l = 0; l < items[k].size(); l++)
                        if(items[i].get(j).equals(items[k].get(l)))
                            return true;
        return false;
    }

    /**
     * Tests if there is overlap in any of the arrays or between the arrays.  Doesn't check for array duplicity.  Uses <code>.equals()</code>
     * <b>NOTE VERY INEFFICIENT</b>
     * @param items - The arrays to compare
     * @return Returns true if an object is measured as equivalent between the lists.
     */
    public static <T extends Object> boolean isOverlap(T[][] items) {
        for (int i = 0; i < items.length - 1; i++)
            for (int j = 0; j < items[i].length; j++)
                for (int k = i+1; k < items.length; k++)
                    for (int l = 0; l < items[k].length; l++)
                        if(items[i][j].equals(items[k][l]))
                            return true;
        for (int i = 0; i < items.length; i++)
            for(int o = 0; o < items.length - 1; i++)
                for(int p = o + 1; p < items.length; p++)
                    if(items[i][o].equals(items[i][p]))
                        return true;
        return false;
    }
}
