package cn.test;

import java.util.Scanner;

public class TestNum {
    public void test(){
        int[] nums;
        int index;
        int k;

        int max;

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入数组的个数：\n");

        index = scanner.nextInt();
        nums = new int[index];
        System.out.println("请输入数组的数据：\n");

        for (int i = 0; i < index ; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("请输入每次遍历的个数：\n");

        k = scanner.nextInt();

        for(int i = 0 ; i < index - k + 1 ; i ++){
            max = nums[i];
            for(int j = i ; j < i + k ; j ++){
                if( max < nums[j]){
                    max = nums[j];
                }
            }
            System.out.println("第" + (i+1) + "层：" + max );
        }

    }

    public static void main(String[] args) {
        new TestNum().test();
    }
}
