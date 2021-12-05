package edu.neu.coe.info6205.sort;


import edu.neu.coe.info6205.util.Benchmark_Timer;

import edu.neu.coe.info6205.huskySortUtils.HuskyCoderFactory;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import edu.neu.coe.info6205.util.FileUtil;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static edu.neu.coe.info6205.util.Utilities.show;

public class Unicode {

    public static void sort(List<String> words, Consumer<List<String>> algoSort, String description){
        Benchmark_Timer<List<String>> benchmarkTimer = new Benchmark_Timer<>("Benchmark Test", null, algoSort, null);
        for(int x = 5000; x < words.size(); x *= 2){
            int y = x;
            Supplier<List<String>> supplier = () -> {
                Random random = new Random();
                String[] arr = new String[y];

                for(int z = 0; z < y; z++){
                    arr[z] = words.get(random.nextInt(y));
                }
//                System.out.println("Array Size: " + arr.length);
                return Arrays.asList(arr);
            };
//            computeBenchMark(supplier, algoSort, description);
            double sortTime = benchmarkTimer.runFromSupplier(supplier, 10);
            System.out.println("Number of words: " + x + " " + description + " Time Taken: " + sortTime + "ms");

        }

    }

    public static void main(String[] args) throws IOException {
        List<String> words = FileUtil.hindiWordsList("UnicodeSorting/src/main/resources/1MHindiWords.csv");
        Supplier<List<String>> supplier = () -> {
            Collections.shuffle(words);
            return words;
        };
        String[] sortInput = words.toArray(new String[0]);

        //MSDStringSort Benchmark
        Consumer<List<String>> msdSort = (x) -> MSD.sort(sortInput);
        Unicode.sort(words, msdSort, "Order Situation - Randomly Ordered - " + "MSDStringSort");
//        computeBenchMark(supplier, msdSort, "MSDStringSort" + "- Randomly Ordered");

        //Dual Pivot Quick Sort Benchmark
//        Consumer<List<String>> quickDualPivotConsumer = (x) -> QuickDualPivot.sort(sortInput);
//        Unicode.sort(words, quickDualPivotConsumer, "Order Situation - Randomly Ordered - " + "QuickSort");
//
////        computeBenchMark(supplier, sortInput, quickDualPivotConsumer, "QuickDualPivot" + "- Randomly Ordered");
////
////        //Tim Sort Benchmark
//        TimSort timSort = new TimSort();
//        Consumer<List<String>> listConsumer = (x) -> timSort.sort(sortInput, 0, sortInput.length);
//        Unicode.sort(words, listConsumer, "Order Situation - Randomly Ordered - " + "TimSort");
////        computeBenchMark(supplier, sortInput, listConsumer, "TimSort" + "- Randomly Ordered");
////
////
////        //LSDStringSort BenchMark
//        Consumer<List<String>> lsdTimer = (x) -> LSDStringSort.sort(sortInput);
//        Unicode.sort(words, lsdTimer, "Order Situation - Randomly Ordered - " + "LSDStringSort");
//
////        computeBenchMark(supplier, sortInput, lsdTimer, "LSDStringSort" + "- Randomly Ordered");
////
////        //HuskySort Benchmark
//        MergeHuskySort huskySort =  new MergeHuskySort<>(HuskyCoderFactory.asciiCoder);
//        Consumer<List<String>> huskySortConsumer = (x) -> huskySort.sort(sortInput);
//        Unicode.sort(words, huskySortConsumer, "Order Situation - Randomly Ordered - " + "HuskySort");

//        computeBenchMark(supplier, sortInput, huskySortConsumer, "Husky Sort" + "- Randomly Ordered");

    }

//    private static void computeBenchMark(Supplier<List<String>> supplier, Consumer listConsumer, String description) {
//        Benchmark_Timer<List<String>> benchmarkTimer = new Benchmark_Timer<>("Benchmark Test", null, listConsumer, null);
//        double sortTime = benchmarkTimer.runFromSupplier(supplier, 20);
////        show(sortInput, description);
//        System.out.println(description + " Time Taken: " + sortTime + "ms");
//    }
}
