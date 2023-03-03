package sort;

public class Sort {
    public void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 1; j < arr.length - i; j++){
                if(arr[j-1] > arr[j]){
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public void quickSort(int[] arr, int start, int end){
        if(start >= end)
            return;

        int pivot = start;
        int low = start + 1;
        int high = end;

        while(low <= high) {
            while (low <= end && arr[low] <= arr[pivot]) // 피벗보다 큰 값을 만날 때 까지
                low++;
            while (high > start && arr[high] >= arr[pivot]) // 피벗보다 작은 값을 만날 떄 까지
                high--;
            if (low > high) // 엇갈리면 피벗과 교체
                swap(arr, high, pivot);
            else
                swap(arr, low, high); // 엇갈리지 않으면 low, high 값 교체
        }

        quickSort(arr, start, high - 1);
        quickSort(arr, high + 1, end);
    }

    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
