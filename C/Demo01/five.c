/*************************************************************************
	> File Name: five.c
	> Author: 
	> Mail: 
	> Created Time: 2018年01月24日 星期三 22时27分20秒
 ************************************************************************/

#include<stdio.h>
void interchange(int * u, int * v);//提前声明

int main(void) {
    int x = 5 , y = 10;
    printf("Originally x = %d and y = %d. \n", x,y);

    interchange(&x, &y); //地址
    printf("Now x = %d and y = %d .\n", x, y);

    return 0;
}

void interchange(int * u, int * v) {
    int temp;
    temp = *u;
    *u = *v;
    *v = temp;
}

/*
 *解释: char *pc
   pc指向的值(*pc) 是char 类型。
   pc 本身是指向char类型的指针。
   pc的值是一个地址。

 *
 *故: int * u；　需要传递的是地址　ｕ;
 *
 *
 *
 * */
