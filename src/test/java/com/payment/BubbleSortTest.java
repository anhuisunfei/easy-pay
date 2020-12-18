package com.payment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * $BubbleSortTest 冒泡排序 Test
 *
 * @author sunf
 * @version 1.0
 * @date 2020/12/18 16:01
 */
@RunWith(SpringRunner.class)
public class BubbleSortTest {
    @Test
    public void testBubbleSort() {
        int arr[] = new int[]{5, 4, 2, 3, 8};
        IArraySort sort = new SelectionSort();
        int newArr[] = sort.sort(arr);

        System.out.println(Arrays.toString(newArr));
    }

}

interface IArraySort {
    public int[] sort(int[] sourceArray);
}

/**
 * $BubbleSort 冒泡
 */
class BubbleSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }
}

/**
 * $SelectionSort 选择排序
 */
class SelectionSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j; // 记录最小下标
                }
            }
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        return arr;
    }
}


