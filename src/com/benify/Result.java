/*
 * Copyright (c) 2024. Hashan Silva
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 */

package com.benify;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Result {
    private static final Logger logger = Logger.getLogger(Result.class.getSimpleName());
    private static final int LIMIT_ORDERS = 5;
    private static final String AVERAGE_FILE_PREFIX = "0_";
    private static final String POPULAR_FILE_PREFIX = "1_";
    private static int totalOrders = 0;

    /**
     * Generate two files based on the given file name
     * 1. Average product per order
     * 2. Most popular product based on the frequency of the product
     *
     * @param inputFileName
     */
    public static void generateFiles(String inputFileName) {
        HashMap<String, ProductCount> productDataMap = new HashMap<>();
        File file = new File(inputFileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.lines().forEach(line -> {
                String[] orderDetails = line.split(",");
                if (orderDetails.length == LIMIT_ORDERS) {
                    ProductCount productCount = productDataMap.computeIfAbsent(orderDetails[2], key -> new ProductCount());
                    productCount.addQuantity(Integer.parseInt(orderDetails[3]));
                    productCount.addBrand(orderDetails[4]);
                    totalOrders++;
                }

            });
            generateResultFiles(productDataMap, inputFileName);
        } catch (IOException exception) {
            logger.log(Level.SEVERE, String.format("Error: %s", exception.getMessage()), exception);
        }

    }

    /**
     * Generate Result Files
     * 1, Average product category for a order list
     * 2, Popular brand, category wise
     *
     * @param productDataMap
     * @param inputFileName
     */
    private static void generateResultFiles(HashMap<String, ProductCount> productDataMap, String inputFileName) {
        try (PrintWriter file0 = new PrintWriter(getFileName(AVERAGE_FILE_PREFIX, inputFileName));
             PrintWriter file1 = new PrintWriter(getFileName(POPULAR_FILE_PREFIX, inputFileName))) {
            for (Map.Entry<String, ProductCount> entry : productDataMap.entrySet()) {
                file0.printf("%s,%.4f%n", entry.getKey(), entry.getValue().getAveragePerOrder(totalOrders));
                file1.printf("%s,%s%n", entry.getKey(), entry.getValue().getPopularBrand());
            }
        } catch (IOException exception) {
            logger.log(Level.SEVERE, String.format("Error: %s", exception.getMessage()), exception);
        }
    }

    /**
     * Get file name
     *
     * @param prefix
     * @param inputFileName
     * @return
     */
    private static String getFileName(String prefix, String inputFileName) {
        return prefix + inputFileName;
    }


    /**
     * Inner class to keep product and the count
     */
    private static class ProductCount {
        private final HashMap<String, Integer> brandPopularity = new HashMap<>();
        private int totalQuantity = 0;

        /**
         * Add Quantity for a product
         *
         * @param quantity
         */
        private void addQuantity(int quantity) {
            this.totalQuantity = this.totalQuantity + quantity;
        }

        /**
         * Add brand to Brand Popularity Map
         *
         * @param brand
         */
        private void addBrand(String brand) {
            if (brandPopularity.containsKey(brand)) {
                brandPopularity.put(brand, brandPopularity.get(brand) + 1);
            } else {
                brandPopularity.put(brand, 1);
            }
        }

        /**
         * Get Popular Brand from the occurrences in orders
         *
         * @return
         */
        private String getPopularBrand() {
            String popularBrand = "";
            int noOrders = 0;
            for (Map.Entry<String, Integer> entry : brandPopularity.entrySet()) {
                if (noOrders < entry.getValue()) {
                    noOrders = entry.getValue();
                    popularBrand = entry.getKey();
                }
            }
            return popularBrand;
        }

        /**
         * Get average per order
         *
         * @param totalOrders
         * @return
         */
        private double getAveragePerOrder(double totalOrders) {
            return totalQuantity / totalOrders;
        }
    }
}
