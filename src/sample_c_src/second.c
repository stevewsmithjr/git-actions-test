// C Program second.c
// to be used in first.c
#include "types.h"

int sum(int a, int b)
{
    return a + b;
}

int sub(int a, int b)
{
    return a - b;
}

int multiply(int a, int b)
{
    return a * b;
}

void print_struct(my_struct *sample)
{
    printf("%d\n%s\n%lf\n", sample->val, sample->struct_string, sample->dval);
}

void check_control_blocks(void) { // brace should be on new line
    int a = 0;

    if (a > -1) { // brace should be on new line
        printf("1\n");
    }

    if(a==0) // improper spacing after keyword and in condition
    {
        printf( "2\n" ); // improper spacing
    }

    if (a != 10)
    {
        printf("3\n");
    }

    while(a < 10) // improper spacing after keyword
    {
        a++;
    }

    while (a > 0) { // brace should be on new line
        a--;
    }

    while (a != 10)
    {
        a++;
    }
    
    for(int i = 0; i < 10; i++) // improper spacing after keyword
    {
        printf("%d\n", i);
    }

    for (int i = 0; i < 10; i++) { // brace should be on new line
        printf("%d\n", i);
    }

    for ( int i =0; i< 10;i++) // improper spacing in loop statements
    { 
        printf("%d\n", i);
    }

    for (int i = 0; i < 10; i++) 
    {
        printf("%d\n", i);
    }
}