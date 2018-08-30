/*************************************************************************
	> File Name: four.c
	> Author: 
	> Mail: 
	> Created Time: 2018年01月23日 星期二 22时02分59秒
 ************************************************************************/

#include<stdio.h>

void butler();/* C函数模型*/
int main() {
    printf("I will summon the butler function .\n");
    butler();
    printf("Yes, Bring me some tea and writeable DVDs. \n");

    return 0;
}

void butler(void) {
    printf("You rang. sir? \n");
}
