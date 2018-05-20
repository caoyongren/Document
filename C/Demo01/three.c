/*************************************************************************
	> File Name: three.c
	> Author: 
	> Mail: 
	> Created Time: 2018年01月22日 星期一 22时58分18秒
 ************************************************************************/

#include<stdio.h>
int main() {
    enum {
        sun,
        mon,
        tue,
        wed,
        thu,
        fri,
        sat
    } date;

    date = mon;
    printf("%d\n", date);
}
