package sorter;

public class BubbleSort {
	public static PerformanceResult sort(int[] array) {
		long startTime = System.nanoTime();
        int stepCount = 0; 
		
		int n = array.length;
		boolean swapped;
		
		for (int i=0; i<n-1; i++) {
			swapped = false;
			
			for (int j=0; j < n - i - 1; j++) {
				stepCount++;
				if (array[j] > array[j+1]) {
					
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					
					swapped = true;
							
					
				}
			}
			if (!swapped) {
				break;
			}
		}
		
		long endTime = System.nanoTime();
		double timeMs = (endTime - startTime) / 1_000_000.0;
		
		return new PerformanceResult("Bubble Sort", timeMs, stepCount);
	}

}
