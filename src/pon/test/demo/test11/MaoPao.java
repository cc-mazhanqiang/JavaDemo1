package pon.test.demo.test11;

/*
    数组的冒泡排序
 */

public class MaoPao {
    public static void main(String[] args) {
        int[] arr = new int[]{98,56,78,100,-89,-99,20,50,60,2,0};

        // 需要比的轮数
        for (int i = 0;i < arr.length - 1;i++){

            // 每轮需要比的次数
            for (int j = 0;j < arr.length - 1 - i;j++){

              /*  // 从小到大进行排序
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;*/

                 // 从大到小进行排序
                if (arr[j] < arr[j + 1]){
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }


        for (int i = 0;i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
