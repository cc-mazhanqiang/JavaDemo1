package pon.test.demo.test10;

/*
    数组的查找（搜索）
    > 线性查找
    > 二分法查找
 */

public class ArrayTest {
    public static void main(String[] args) {

        String[] arr = new String[]{"AA","BB","CC","DD","EE"};
        // 数组的查找（线性查找）
        String dest = "CC";
        boolean isFlag = true;
        for (int i = 0;i < arr.length;i++){
            if(dest.equals(arr[i])){
                System.out.println("查到了数组的元素，当前位置为：" + i);
                isFlag = false;
                break;
            }
        }
        if (isFlag){
            System.out.println("没有查到数组的元素！");
        }


        //数组的反转
        // 法一、
     /*   for (int i = 0;i < arr.length / 2;i++){
            String temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        // 遍历
        for (int i = 0;i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }*/

        // 法二、
        for (int i = 0,j = arr.length - 1;i < j;i++,j--){
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // 遍历
        for (int i = 0;i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();


        // 数组的查找（二分法查找，折半查找）
        // 前提：该数组必须是有序的

        int[] arr1 = new int[]{-89,-78,-56,-45,10,45,68,98,130,650,4536};

        int target = 45;
        int first = 0;
        int end = arr1.length - 1;
        boolean flag = true;
        while(first <= end){

            int middle = (first + end) / 2;

            if (target == arr1[middle]){
                System.out.println("查到了数组的元素，当前位置为：" + middle);
                flag = false;
                break;

            }else if(target < arr1[middle]){

                end = middle - 1;

            }else{//target > arr1[middle]
                first = middle + 1;
            }
        }
        if (flag) {
            System.out.println("没有查到数组的元素！");
        }
    }
}
