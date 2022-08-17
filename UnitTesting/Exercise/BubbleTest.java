package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

    @Test
    public void test_BubbleSortArray() {
        int[] numbers = {88, 23, 34, 18, 8, 1};
        Bubble.sort(numbers);
        int[] actual = {1, 8, 18, 23, 34, 88};

        Assert.assertArrayEquals(actual, numbers);
    }
}