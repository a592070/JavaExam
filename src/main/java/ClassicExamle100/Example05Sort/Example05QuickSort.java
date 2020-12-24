package ClassicExamle100.Example05Sort;

/**題目：輸入三個整數x,y,z，請把這三個數由小到大輸出。
 * Quick sort:
 *
 * First: method Partition
 * 目的:  返回一個元素 作為劃分為兩個list的基底
 * int i = lowest index of list
 * int j = highest index of list
 * int pivot = chosen basis (list[0])
 *
 * while(i<j){
 *      //從最右邊開始比較 找比pivot小的
 *     while(i<j && list[j]>pivot){
 *          j--}
 *     //找到比pivot小的元素就進行交換 交換後i++ 此時pivot在list[j]處
 *     if(i<j){
 *          exchange(list[i],list[j])
 *          i++
 *     }
 *     //在從左邊開始比較 找比pivot大的
 *     while(i<j && list[i]<=pivot){
 *          i++}
 *     //找到比pivot大的元素就進行交換 交換後j-- 此時pivot在list[i]處
 *     if(i<j){
 *          exchange(list[i],list[j])
 *          j--
 *     }
 * }
 * return i
 *
 * Second: method quick sort(list, lower, high)
 * 目的:  用第一個method找的基底mid 劃分為兩個list    list[lower,mid-1] list[mid+1,high]   在用遞迴重複
 * mid = Partition(list , lower , high)
 * quickSort(list, lower, mid-1)
 * quickSort(list, mid+1, high)
 *
 * */
public class Example05QuickSort {
    /**low is start index of list
     * high is end index of list*/
    private static int Partition(int[] list, int low ,int high){
        int pivot = list[low];        //choose first elements as pivot
        int i = low;
        int j = high;
        int tmp;
        while(i<j){
            while(i<j && list[j]>pivot){
                j--;}
            if(i<j){
                tmp = list[i];
                list[i] = list[j];
                list[j] = tmp;
                i++;
            }
            while(i<j && list[i]<=pivot){
                i++;
            }
            if(i<j){
                tmp = list[j];
                list[j] = list[i];
                list[i] = tmp;
                j--;
            }
        }
        return i;
    }
    private static void quickSort(int[] list, int low ,int high){
        int mid;
        if (low<high){
            mid = Partition(list, low, high);
            quickSort(list, low, mid-1);
            quickSort(list, mid+1, high);
        }
    }

    public static void main(String[] args) {
        int[] list = new int[]{30,24,5,58,18,36,12,42,39};
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]+"\t");
        }
        System.out.println();
        quickSort(list, 0, list.length-1);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]+"\t");
        }
    }
}
