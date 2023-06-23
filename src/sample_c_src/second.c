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

void check_if_statements(void) {
    int a = 0;
    if (a > -1) {
        printf("1\n");
    }

    if(a==0){
        printf( "2\n" );
    }

    if (a != 10)
    {
        printf("3\n");
    }
}