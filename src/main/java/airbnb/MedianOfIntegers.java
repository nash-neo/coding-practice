package airbnb;

public class MedianOfIntegers {

    //get n/2 index after sorting
    public static int findMedian(int[] arr) {
        int n = arr.length;
        long left = Integer.MIN_VALUE;
        long right = Integer.MAX_VALUE;
        //compare n/2-1 , (< , <=]
        //0,0,1,1,1,2
        //mid =1, smaller 2, SE = 5 n/2 = 3 (2,5]
        //mid =0, (0, 2],
        //mid =2, (5, 6] n/2 =3
        while (left <= right) {
            long mid = (left+right)/2 ; //to avoid overflow
            int smaller = smallerThan(arr, mid);
            int smallerOrEqual = smallerOrEqual(arr, mid);
            if (n/2 >= smaller &&  n/2 < smallerOrEqual) {
                return (int)mid;
            }
            else if (n/2 < smaller) {
                right = mid -1;
            }
            else { // smallerOrEqual < n/2
                left = mid + 1;
            }
        }
        throw new RuntimeException("Unexpected");
    }

    //find the number of int in arr that < num
    private static int smallerThan(int[] arr, long num) {
        int count = 0;
        for (int i : arr) {
            if (i < num) {
                ++count;
            }
        }
        return count;
    }

    private static int smallerOrEqual(int[] arr, long num) {
        int count = 0;
        for (int i : arr) {
            if (i <= num) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("test");
        int[] arr = {0,0,1,1,1,2};
        int median = findMedian(arr);
        System.out.println(median);

        int[] arr2 = {0,0,0,1,1,1,2}; //n/2 =3
        median = findMedian(arr2);
        System.out.println(median);

        int[] arr3 = {0,1,2,3,3,4,5};
        median = findMedian(arr3);
        System.out.println(median);

        int[] arr4 = {0};
        median = findMedian(arr4);
        System.out.println(median);
    }
}
