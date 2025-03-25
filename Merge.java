import java.util.Scanner;

public class MergeSort 
{
    public static void merge(int[] a, int low, int mid, int high) 
    {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        // Create temporary arrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++)
            left[i] = a[low + i];
        for (int j = 0; j < n2; j++)
            right[j] = a[mid + 1 + j];

        // Merge the temp arrays
        int i = 0, j = 0;
        int k = low;

        while (i < n1 && j < n2) 
        {
            if (left[i] <= right[j]) 
            {
                a[k] = left[i];
                i++;
            } 
            else 
            {
                a[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left[] if any
        while (i < n1) 
        {
            a[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining elements of right[] if any
        while (j < n2) 
        {
            a[k] = right[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] a, int low, int high) 
    {
        if (low < high) 
        {
            int mid = low + (high - low) / 2;

            // Sort first and second halves
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);

            // Merge the sorted halves
            merge(a, low, mid, high);
        }
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) 
        {
            array[i] = scanner.nextInt();
        }

        mergeSort(array, 0, array.length - 1);

        System.out.println("Sorted Array:");
        for (int num : array) 
        {
            System.out.print(num + " ");
        }
        scanner.close();
    }
}
output:
Enter the number of elements in the array:
6 
Enter the elements of the array:
8
3
6
5
1
9
Sorted Array:
1 3 5 6 8 9
