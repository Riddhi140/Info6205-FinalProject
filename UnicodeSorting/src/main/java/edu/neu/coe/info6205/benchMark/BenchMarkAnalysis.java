package edu.neu.coe.info6205.benchMark;

import edu.neu.coe.info6205.huskySortUtils.HuskyCoderFactory;
import edu.neu.coe.info6205.sort.*;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.FileUtil;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BenchMarkAnalysis {
    static NumberFormat formatter = new DecimalFormat("#0.00000");

    public static void main(String[] args) throws IOException {
        msdSortAnalysis();
        lsdSortAnalysis();
        huskySortAnalysis();
        dualQuickSortAnalysis();
        timSortAnalysis();
    }

    private static void msdSortAnalysis() throws FileNotFoundException {
        List<String> words = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            long start1 = System.currentTimeMillis();
            words = hindiWordsList("4MHindiWords.csv");
            if (i > 1) {
                words.addAll(Collections.unmodifiableList(words));
            }
            System.out.println("Sorting for array length" + words.size());
            long end1 = System.currentTimeMillis();
            System.out.println("Execution time for creating list from file is " + formatter.format((end1 - start1) / 1000d) + " seconds");

            long start2 = System.currentTimeMillis();

            Supplier<List<String>> supplier = getListSupplier(words);
            long end2 = System.currentTimeMillis();

            System.out.println("Execution time for shuffling list from file is " + formatter.format((end2 - start2) / 1000d) + " seconds");

            long start = System.currentTimeMillis();
            exeMSDStringSort(supplier, supplier.get().toArray(new String[0]));
            long end = System.currentTimeMillis();

            NumberFormat formatter = new DecimalFormat("#0.00000");
            System.out.println("Execution time for msd sort is " + formatter.format((end - start) / 1000d) + " seconds");
        }
        words.clear();
    }

    private static void dualQuickSortAnalysis() throws FileNotFoundException {
        List<String> words = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            long start1 = System.currentTimeMillis();
            words = hindiWordsList("4MHindiWords.csv");
            if (i > 1) {
                words.addAll(Collections.unmodifiableList(words));
            }
            System.out.println("Sorting for array length" + words.size());
            long end1 = System.currentTimeMillis();
            System.out.println("Execution time for creating list from file is " + formatter.format((end1 - start1) / 1000d) + " seconds");

            long start2 = System.currentTimeMillis();

            Supplier<List<String>> supplier = getListSupplier(words);
            long end2 = System.currentTimeMillis();

            System.out.println("Execution time for shuffling list from file is " + formatter.format((end2 - start2) / 1000d) + " seconds");

            long start = System.currentTimeMillis();
            exeDualPivotQuickSort(getListSupplier(words), supplier.get().toArray(new String[0]));
            long end = System.currentTimeMillis();

            NumberFormat formatter = new DecimalFormat("#0.00000");
            System.out.println("Execution time for dualQuick sort is " + formatter.format((end - start) / 1000d) + " seconds");
        }
        words.clear();
    }

    private static void timSortAnalysis() throws FileNotFoundException {
        List<String> words = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            long start1 = System.currentTimeMillis();
            words = hindiWordsList("4MHindiWords.csv");
            if (i > 1) {
                words.addAll(Collections.unmodifiableList(words));
            }
            System.out.println("Sorting for array length" + words.size());
            long end1 = System.currentTimeMillis();
            System.out.println("Execution time for creating list from file is " + formatter.format((end1 - start1) / 1000d) + " seconds");

            long start2 = System.currentTimeMillis();

            Supplier<List<String>> supplier = getListSupplier(words);
            long end2 = System.currentTimeMillis();

            System.out.println("Execution time for shuffling list from file is " + formatter.format((end2 - start2) / 1000d) + " seconds");

            long start = System.currentTimeMillis();
            exeTimSort(getListSupplier(words), supplier.get().toArray(new String[0]));
            long end = System.currentTimeMillis();

            NumberFormat formatter = new DecimalFormat("#0.00000");
            System.out.println("Execution time for tim sort is " + formatter.format((end - start) / 1000d) + " seconds");
        }
        words.clear();
    }


    private static void lsdSortAnalysis() throws FileNotFoundException {
        List<String> words = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            long start1 = System.currentTimeMillis();
            words = hindiWordsList("4MHindiWords.csv");
            if (i > 1) {
                words.addAll(Collections.unmodifiableList(words));
            }
            System.out.println("Sorting for array length" + words.size());
            long end1 = System.currentTimeMillis();
            System.out.println("Execution time for creating list from file is " + formatter.format((end1 - start1) / 1000d) + " seconds");

            long start2 = System.currentTimeMillis();

            Supplier<List<String>> supplier = getListSupplier(words);
            long end2 = System.currentTimeMillis();

            System.out.println("Execution time for shuffling list from file is " + formatter.format((end2 - start2) / 1000d) + " seconds");

            long start = System.currentTimeMillis();
            exeLSDStringSort(getListSupplier(words), supplier.get().toArray(new String[0]));
            long end = System.currentTimeMillis();

            NumberFormat formatter = new DecimalFormat("#0.00000");
            System.out.println("Execution time for lsd sort is " + formatter.format((end - start) / 1000d) + " seconds");
        }
        words.clear();
    }


    private static void huskySortAnalysis() throws FileNotFoundException {
        List<String> words = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            long start1 = System.currentTimeMillis();
            words = hindiWordsList("4MHindiWords.csv");
            if (i > 1) {
                words.addAll(Collections.unmodifiableList(words));
            }
            System.out.println("Sorting for array length" + words.size());
            long end1 = System.currentTimeMillis();
            System.out.println("Execution time for creating list from file is " + formatter.format((end1 - start1) / 1000d) + " seconds");

            long start2 = System.currentTimeMillis();

            Supplier<List<String>> supplier = getListSupplier(words);
            long end2 = System.currentTimeMillis();

            System.out.println("Execution time for shuffling list from file is " + formatter.format((end2 - start2) / 1000d) + " seconds");

            long start = System.currentTimeMillis();
            exeMergeHuskySort(getListSupplier(words), supplier.get().toArray(new String[0]));
            long end = System.currentTimeMillis();

            NumberFormat formatter = new DecimalFormat("#0.00000");
            System.out.println("Execution time for husky sort is " + formatter.format((end - start) / 1000d) + " seconds");
        }
        words.clear();
    }

    private static void exeMSDStringSort(Supplier<List<String>> supplier, String[] sortInput) {
        try {
            //MSDStringSort Benchmark
            Consumer<List<String>> msdSort = (x) -> MSD.sort(sortInput);
            computeBenchMark(supplier, sortInput, msdSort, "MSDStringSort" + "- Randomly Ordered");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void exeDualPivotQuickSort(Supplier<List<String>> supplier, String[] sortInput) {
        try {
            //Dual Pivot Quick Sort Benchmark
            Consumer<List<String>> quickDualPivotConsumer = (x) -> QuickDualPivot.sort(sortInput);
            computeBenchMark(supplier, sortInput, quickDualPivotConsumer, "QuickDualPivot" + "- Randomly Ordered");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    private static void exeLSDStringSort(Supplier<List<String>> supplier, String[] sortInput) {
        try {
            Consumer<List<String>> lsdTimer = (x) -> LSDStringSort.sort(sortInput);
            computeBenchMark(supplier, sortInput, lsdTimer, "LSDStringSort" + "- Randomly Ordered");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void exeMergeHuskySort(Supplier<List<String>> supplier, String[] sortInput) {
        try {
            MergeHuskySort huskySort = new MergeHuskySort<>(HuskyCoderFactory.asciiCoder);
            Consumer<List<String>> huskySortConsumer = (x) -> huskySort.sort(sortInput);
            computeBenchMark(supplier, sortInput, huskySortConsumer, "Husky Sort" + "- Randomly Ordered");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Supplier<List<String>> getListSupplier(List<String> words) {
        Supplier<List<String>> supplier = () -> {
            Collections.shuffle(words);
            return words;
        };
        return supplier;
    }

    private static void computeBenchMark(Supplier<List<String>> supplier, String[] sortInput, Consumer listConsumer, String description) {
        Benchmark_Timer<List<String>> benchmarkTimer = new Benchmark_Timer<>("Benchmark Test", null, listConsumer, null);
        double sortTime = benchmarkTimer.runFromSupplier(supplier, 20);
        //   show(sortInput, description);
        System.out.println(description + " Time Taken: " + sortTime + "ms");
    }

    public static List<String> hindiWordsList(String fileName) {
        ClassLoader classLoader = FileUtil.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream(fileName);

        List<String> hindiWords = new ArrayList<>();

        if(!Objects.isNull(resourceAsStream)) {
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
