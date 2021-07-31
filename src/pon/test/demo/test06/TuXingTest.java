/*
输出下面的图形。
******
*****
****
***
**
*
方法：
外层循环控制行数；内层循环控制列数。
 */

package pon.test.demo.test06;

public class TuXingTest {
    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {    //外层循环控制行数
            for (int j = 1; j <= 7 - i; j++) {    //内层循环控制列数
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }
}
