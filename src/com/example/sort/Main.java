package com.example.sort;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] intArray1 = new int []{4,5,10,7,8};
        int[] intArray2 = new int []{1, 2, 4};
        List<Integer> result = new ArrayList<>();
        List<String> strArray = new ArrayList<>();
        strArray.add("88 99 200");
        strArray.add("88 99 300");
        strArray.add("99 32 100");
        strArray.add("12 1215");
        result.add(5);
        result.add(3);
        result.add(2);
        result.add(4);
        result.add(1);
        result.add(2);
        String s = "";
        List<Integer> first = Arrays.asList(1, 1);
        List<Integer> second = Arrays.asList(1, 7);
//        String arr1[] = {"1100", "1110", "0110", "0001"};//2
//        String arr2[] = {"10000", "01000", "00100", "00010", "00001"};//5
//        String arr3[] = {"1100", "1101", "0010", "0010", "0001"};//2
//        String arr4[] = {"1100", "1101", "0010", "0010", "0001"};//2
//        String arr5[] = {"11100", "11001", "10100", "00011", "01011"};//1
//        String arr6[] = {"11100", "11100", "11100", "00011", "00011"};//2
//        String arr7[] = {"10100", "01010", "10100", "01010", "00001"};//3
        // binary search requires sorted list
//        shellSort(intArray);
//        System.out.println(Arrays.toString(intArray));
//        System.out.println(recursiveBinarySearch(intArray, 2, 0, intArray.length));
        List<Integer> decrease = Arrays.asList(4, 3, 5, 4, 3, 2, 1);
        System.out.println(countDecreasingRatings(decrease));
    }

    /*
     *find the median of two sorted arrays in O(log(m +n))/
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> arr = new ArrayList<>();
        Arrays.sort(nums1);

        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int iMin = 0;
        int iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0;
    }


    // Sort Algorithms
    public static int[] bubbleSort(int []array) {
        for (int lastUnsortedIndex = array.length -1; lastUnsortedIndex > 0;lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (array[i] > array[i + 1]) bubbleSwap(array, i, i + 1);
            }
        }
        return array;
    }
    public static void bubbleSwap(int []array, int i, int j) {
        if (i == j) return;
        int temp = array[i];
        array[i] = array[i +1];
        array[i + 1] = temp;
    }
    public static int[] selectionSort(int [] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int max = array[i];
            for (int j = 0; j <= i; j++) {
                if(max < array[j]) {
                    max = array[j];
                    array[j] = array[i];
                    array[i] = max;
                }
            }
        }
        return array;
    }
    public static int[] insertionSort(int [] array) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
            int temp = array[firstUnsortedIndex];
            int j = firstUnsortedIndex;
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
        return array;
    }
    public static int[] shellSort(int [] array) {
        for (int gap = array.length; gap > 0; gap/=2) {

            for (int i = gap; i < array.length; i++) {
                int newElement = array[i];
                int j = i ;
                while (j >= gap && array[j - gap] > newElement) {
                    array[j] = array[j -gap];
                    j -= gap;
                }
                array[j] = newElement;
            }
        }
        return array;
    }

    // Recursion + Search Algorithms
    public static int iterativeFactorial(int num) {
        if (num == 0) return 1;
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }
    public static int recursiveFactorial(int num) {
        if (num == 0) return 1;
        return num * recursiveFactorial(num - 1);
    }

    public static int iterativeBinarySearch(int[] array, int value) {
        int start = 0;
        int end = array.length;

        while (start < end) {
            int midpoint = (start + end) / 2;
            if (array[midpoint] ==  value) return midpoint;
            else if (array[midpoint] < value) start = midpoint + 1;
            else end = midpoint;
        }
        return -1;
    }
    public static int recursiveBinarySearch(int[] array, int value, int start, int end) {
        if (start >= end) {
            return -1;
        }
        int midPoint = (start + end) / 2;
        if (array[midPoint] ==  value) return midPoint;
        else if (array[midPoint] < value) return recursiveBinarySearch(array, value, midPoint + 1, end);
        else return recursiveBinarySearch(array, value, start, midPoint);
    }

    public static void arrayHasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                System.out.println("Duplicate found");
                return;
            }
            set.add(array[i]);
        }
        System.out.println("No duplicates found");
    }

    public static void deleteDuplactedValuesString(String[] array) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                array[i] = "";
            } else {
                set.add(array[i]);
            }
        }
    }
    // remove duplication from array of strings
    public static void removeDuplicatedValues(String[] array) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                array[i] = "";
            } else {
                set.add(array[i]);
            }
        }
    }

    //amazon
    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        // Write your code here
        int sum = 0;
        for (int x : arr) {
            sum += x;
        }
        arr.sort((itemA, itemB) -> itemB - itemA);
        return arr;
    }

    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        if (s.isEmpty()) return  new ArrayList<>();
        List <Integer> result = new ArrayList<>();
        for(int i = 0; i < startIndices.size(); i++) {
            String items = s.substring(startIndices.get(i) - 1, endIndices.get(i) );
            boolean containItems = false;
            while (!containItems) {
                if(startIndices.get(i).equals(endIndices.get(i))) {
                    items = "";
                    containItems = true;
                }
                else if (items.charAt(0) != (int)'|') {
                    items = items.substring(1);
                }
                else if (items.charAt(items.length() -1) != '|') {
                    System.out.println(items);
                    items = items.substring(0, items.length() -1);
                } else containItems = true;
            }
            items = items.replaceAll("\\|", "");
            result.add(items.length());
        }
        return result;
    }

    public static int countGroups(List<String> related) {
        int result = 0;
        boolean[] isReached = new boolean[related.size()];
        for(int i = 0; i < related.size() ; i++) {
            if (!isReached[i]) {
                alignedGroups(related, isReached, i);
                result ++;
            }
        }
        return result;
    }
    public static void alignedGroups(List<String> related, boolean [] isReached, int x) {
        isReached[x] = true;
        for (int i = x + 1; i < related.size(); i++) {
            if (Integer.parseInt(String.valueOf(related.get(i).charAt(x))) == 1 && !isReached[i] ) {
                alignedGroups(related, isReached, i);
            }
        }
    }

    public static int countDecreasingRatings(List<Integer> ratings) {
        int count = 0, result = 0;
        for (int i = 0; i < ratings.size() - 1; i++) {
            count++;
            if (ratings.get(i) < ratings.get(i + 1) || i + 1 == ratings.size() - 1) {
                if (count % 2 == 0){
                    result += (count / 2) * (count + 1);
                }
                else{
                    result += count * (count + 1) / 2;
                }
                count = 1;
            }
        }
        return result;
    }
}
