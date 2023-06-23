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