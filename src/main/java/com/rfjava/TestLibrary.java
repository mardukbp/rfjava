package com.rfjava;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestLibrary extends KeywordLibrary {
    public String getInit() {
        return "com.rfjava.TestLibrary Init";
    }

    public String getIntro() {
        return "com.rfjava.TestLibrary Intro";
    }


    @Keyword(name="Sum list")
    @Doc(doc="Sum the integer numbers in a list")
    public RobotResult sumList(int[] nums) {
        int result = Arrays.stream(nums).sum();

        return RobotResult.Pass(result, "The sum is " + result);
    }

    @Keyword(name="Double list")
    @Doc(doc="Double each integer number in a list")
    public RobotResult doubleList(int[] nums) {
        List<Integer> result =
                Arrays.stream(nums)
                .map(i -> 2*i)
                .boxed().collect(Collectors.toList());

        return RobotResult.Pass(result, "The doubled list is " + result);
    }

    @Keyword(name="Add histograms")
    @Doc(doc="Add two histograms")
    public RobotResult addHistograms(Map<String, Integer> hist1, Map<String, Integer> hist2) {
        Map<String, Integer> result = Stream.of(hist1, hist2).flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum));

        return RobotResult.Pass(result, "The resulting histogram is " + result);
    }

    @Keyword(name="Sum ints")
    @Doc(doc="Sum two integer numbers")
    public RobotResult sumInts(int a, int b) {
        int result = a + b;

        return RobotResult.Pass(result, "The sum is " + result);
    }

    @Keyword(name="Concat strings")
    @Doc(doc="Concatenate two strings")
    public RobotResult concat(String a, String b) {
        String result = a + b;

        return RobotResult.Pass(result, "The resulting string is " + result);
    }

    @Keyword(name="Concat list")
    @Doc(doc="Concatenate a list of strings using the given delimiter")
    public RobotResult concatList(String delimiter, String[] strings) {
        String result = String.join(delimiter, strings);

        return RobotResult.Pass(result, "The resulting string is " + result);
    }
}
