package com.example.statlib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CentralTendency {

    public static Number arithmeticMean(Collection<? extends Number> numbers) {
        //check type of values
        Iterator<? extends Number> iterator = numbers.iterator();
        Number firstNumberInCollection = iterator.next();

        if (firstNumberInCollection instanceof Integer) {
            return computeMeanInt(numbers);
        } else if (firstNumberInCollection instanceof Long) {
            return computeMeanLong(numbers);
        }

        return computeMeanDouble(numbers);
    }


    public static Double median(Collection<Integer> numbers) {
        Integer integers[] = new Integer[numbers.size()];
        numbers.toArray(integers);

        Arrays.sort(integers);

        if (integers.length%2 == 0) {
            double mid1 = Double.parseDouble(String.valueOf(integers[integers.length/2 - 1]));
            double mid2 = Double.parseDouble(String.valueOf(integers[integers.length/2]));

            return (mid1+mid2)/2.0;
        } else {
            return Double.parseDouble(String.valueOf(integers[integers.length/2]));
        }
    }


    public static ArrayList<Integer> mode(Collection<Integer> numbers) {
        Map<Integer, Integer> counter = new HashMap<>();
        int max = 0;

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            int next = iterator.next();

            if (counter.containsKey(next)) {
                counter.put(next, counter.get(next)+1);
            } else {
                counter.put(next, 1);
            }

            max = counter.get(next) > max ? counter.get(next) : max;
        }

        ArrayList<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == max) {
                modes.add(entry.getKey());
            }
        }

        return modes;
    }


    private static Number computeMeanInt(Collection<? extends Number> numbers) {
        double result = 0;
        Iterator<? extends  Number> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            result += iterator.next().intValue();
        }
        return result/numbers.size();
    }

    private static Number computeMeanLong(Collection<? extends Number> numbers) {
        double result = 0;
        Iterator<? extends  Number> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            result += iterator.next().longValue();
        }
        return result/numbers.size();
    }


    private static Number computeMeanDouble(Collection<? extends Number> numbers) {
        double result = 0;
        Iterator<? extends  Number> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            result += iterator.next().doubleValue();
        }
        return result/numbers.size();
    }
}

