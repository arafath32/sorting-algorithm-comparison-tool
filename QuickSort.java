package sorter;

public class QuickSort {

    public static PerformanceResult sort(int[] array) {
    	long startTime = System.nanoTime();
        int stepCount = 0;
        
        quicksort(array, 0, array.length - 1);
        
        long endTime = System.nanoTime();
        double timeMs = (endTime - startTime) / 1_000_000.0;

        return new PerformanceResult("Quick Sort", timeMs, stepCount);

       
    }

    private static void quicksort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quicksort(array, low, pivotIndex - 1);
            quicksort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; 
        int i = low - 1; 

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
               
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

       
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
