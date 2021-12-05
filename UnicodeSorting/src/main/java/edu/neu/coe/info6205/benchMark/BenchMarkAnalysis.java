package edu.neu.coe.info6205.benchMark;

import edu.neu.coe.info6205.huskySortUtils.HuskyCoderFactory;
import edu.neu.coe.info6205.sort.*;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.FileUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BenchMarkAnalysis {

    public static void main(String[] args) {
        huskySortAnalysis();
        dualQuickSortAnalysis();
        timSortAnalysis();
        msdSortAnalysis();
        lsdSortAnalysis();
    }

    /**
     * To
     */
    private static void msdSortAnalysis() {
        List<String> words = hindiWordsList("4MHindiWords.csv");
        for (int i = 1; i < 4; i++) {
            if (i > 1) {
                words.addAll(Collections.unmodifiableList(words));
            }
            Supplier<List<String>> supplier = getListSupplier(words);
            exeMSDStringSort(supplier, supplier.get().toArray(new String[0]));
        }
        words.clear();
    }

    /**
     *
     */
    private static void dualQuickSortAnalysis() {
        List<String> words = hindiWordsList("4MHindiWords.csv");
        for (int i = 1; i < 4; i++) {
            if (i > 1) {
                words.addAll(Collections.unmodifiableList(words));
            }
            Supplier<List<String>> supplier = getListSupplier(words);
            exeDualPivotQuickSort(supplier, supplier.get().toArray(new String[0]));
        }
        words.clear();
    }

    /*

     */
    private static void timSortAnalysis() {
        List<String> words = hindiWordsList("4MHindiWords.csv");
        for (int i = 1; i < 4; i++) {
            if (i > 1) {
                words.addAll(Collections.unmodifiableList(words));
            }
            Supplier<List<String>> supplier = getListSupplier(words);
            exeTimSort(supplier, supplier.get().toArray(new String[0]));
        }
        words.clear();
    }

    /**
     * To Analyse LSD Sort for different Bulk inputs
     */
    private static void lsdSortAnalysis() {
        List<String> words = hindiWordsList("4MHindiWords.csv");
        for (int i = 1; i < 4; i++) {
            if (i > 1) {
                words.addAll(Collections.unmodifiableList(words));
            }
            Supplier<List<String>> supplier = getListSupplier(words);
            exeLSDStringSort(supplier, supplier.get().toArray(new String[0]));
        }
        words.clear();
    }

    /**
     * To compute benchmark for Husky Sort for 1-4M input
     */
    private static void huskySortAnalysis() {
        List<String> words = hindiWordsList("4MHindiWords.csv");
        for (int i = 1; i < 4; i++) {
            if (i > 1) {
                words.addAll(Collections.unmodifiableList(words));
            }
            Supplier<List<String>> supplier = getListSupplier(words);
            exeMergeHuskySort(supplier, supplier.get().toArray(new String[0]));
        }
        words.clear();
    }

    /**
     * To compute benchmark for MSD Sort for 1-4M input
     *
     * @param supplier
     * @param sortInput
     */
    private static void exeMSDStringSort(Supplier<List<String>> supplier, String[] sortInput) {
        try {
            Consumer<List<String>> msdSort = (x) -> MSD.sort(sortInput);
            computeBenchMark(supplier, sortInput, msdSort, "MSDStringSort" + "- Randomly Ordered");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * To compute benchmark for Dual Pivot Quick Sort for 1-4M input
     *
     * @param supplier
     * @param sortInput
     */
    private static void exeDualPivotQuickSort(Supplier<List<String>> supplier, String[] sortInput) {
        try {
            Consumer<List<String>> quickDualPivotConsumer = (x) -> QuickDualPivot.sort(sortInput);
            computeBenchMark(supplier, sortInput, quickDualPivotConsumer, "QuickDualPivot" + "- Randomly Ordered");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param supplier
     * @param sortInput
     */
    private static void exeTimSort(Supplier<List<String>> supplier, String[] sortInput) {
        try {
            //Tim Sort Benchmark
            TimSort timSort = new TimSort();
            Consumer<List<String>> listConsumer = (x) -> timSort.sort(sortInput, 0, sortInput.length);
            computeBenchMark(supplier, sortInput, listConsumer, "TimSort" + "- Randomly Ordered");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param supplier
     * @param sortInput
     */
    private static void exeLSDStringSort(Supplier<List<String>> supplier, String[] sortInput) {
        try {
            Consumer<List<String>> lsdTimer = (x) -> LSDStringSort.sort(sortInput);
            computeBenchMark(supplier, sortInput, lsdTimer, "LSDStringSort" + "- Randomly Ordered");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param supplier
     * @param sortInput
     */
    private static void exeMergeHuskySort(Supplier<List<String>> supplier, String[] sortInput) {
        try {
            MergeHuskySort huskySort = new MergeHuskySort<>(HuskyCoderFactory.asciiCoder);
            Consumer<List<String>> huskySortConsumer = (x) -> huskySort.sort(sortInput);
            computeBenchMark(supplier, sortInput, huskySortConsumer, "Husky Sort" + "- Randomly Ordered");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param words
     * @return
     */
    private static Supplier<List<String>> getListSupplier(List<String> words) {
        Supplier<List<String>> supplier = () -> {
            Collections.shuffle(words);
            return words;
        };
        return supplier;
    }

    /**
     * @param supplier
     * @param sortInput
     * @param listConsumer
     * @param description
     */
    private static void computeBenchMark(Supplier<List<String>> supplier, String[] sortInput, Consumer listConsumer, String description) {
        Benchmark_Timer<List<String>> benchmarkTimer = new Benchmark_Timer<>("Benchmark Test", null, listConsumer, null);
        double sortTime = benchmarkTimer.runFromSupplier(supplier, 20);
        //   show(sortInput, description);
        System.out.println(description + " Time Taken: " + sortTime + "ms" + " for Array length: " + sortInput.length);
    }

    /**
     * @param fileName
     * @return
     */
    public static List<String> hindiWordsList(String fileName) {
        ClassLoader classLoader = FileUtil.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream(fileName);

        List<String> hindiWords = new ArrayList<>();

        if (!Objects.isNull(resourceAsStream)) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream))) {

                String line = br.readLine();

                while (line != null) {
                    hindiWords.add(line);
                    line = br.readLine();
                }

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return hindiWords;
    }
}
