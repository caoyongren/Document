## java - 基础语言
#### 初入掘金 多多关照！
##### 从头开始 寻找初心！
**题目:**
  - 输入五个整数，排序
 
```
import java.util.Scanner;

public class BubbleSort {
    public static void main(String args[]) {
        System.out.print(">>输入三个数<<");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int array[] = new int[5];
        int temp;
        for (int i = 0; i < 5; i++) {
            array[i] = scanner.nextInt();
        }

        /**
         * 冒泡排序 
         * 空间复杂度:O(1)
         * 时间复杂度:O(n^2)
         * 具有稳定性
         * */
        for (int i = 0; i < array.length; i++) { //排序的次数
            for (int j = 0; j < array.length - i - 1; j++) { //比较的次数
                if (array[j] > array[j + 1]) { //交换
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        
                /**
         * 插入排序:
         *   选出一个排头，然后逐个向前面的数字进行比较。
         * 空间复杂度: O(1)
         * 时间复杂度: O(n^2)
         * 具有稳定性
         * */
        int j;
        for (int i = 1; i < array.length; i++) { 
            temp = array[i]; //需要插入的数字
            j = i - 1;
            while(j >= 0 && temp < array[j]) {//对前面的数字进行后退式便利比较找到自己的位置；--j
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = temp;
        }

        for (int i = 0; i < 5; i++) {
            System.out.print(">>" + array[i]);
        }
    }
}
```

