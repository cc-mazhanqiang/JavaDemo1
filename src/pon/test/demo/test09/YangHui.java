package pon.test.demo.test09;

/*
 * 使用二维数组打印一个 10 行杨辉三角。

【提示】
 1. 第一行有 1 个元素, 第 n 行有 n 个元素
 2. 每一行的第一个元素和最后一个元素都是 1
 3. 从第三行开始, 对于非第一个元素和最后一个元素的元素。即：
yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j];
 *
 */
public class YangHui {
    public static void main(String[] args) {

        int[][] Yanghui = new int[10][];

        for (int i = 0;i < Yanghui.length;i++){
            /** 对数组进行赋值 */
            Yanghui[i] = new int[ i + 1 ];
            /** 对首列和每一行的最后一列赋值 */
            Yanghui[i][0] = Yanghui[i][i] = 1;
            /** 从第二列开始赋值  赋值的个数要小于Yanghui[i].length - 1 */
            for(int j = 1;j < Yanghui[i].length - 1;j++){
                Yanghui[i][j] = Yanghui[i-1][j-1] + Yanghui[i-1][j];
            }
        }
        for (int i = 0; i < Yanghui.length; i++) {
            for (int j = 0; j < Yanghui[i].length;j++){
                System.out.print(Yanghui[i][j] + " ");
            }
            System.out.println();
        }

    }
}
