#include "second.c"
#include <stdio.h>

int main()
{
    int a = 4, b = 5;

    int ans = sum(a, b);
    printf("Sum: %d", ans);

    ans = sub(a, b);
    printf("Subtraction: %d", ans);

    ans = multiply(a, b);
    printf("Multiply: %d", ans);

    my_struct *obj = (my_struct *)calloc(1, sizeof(my_struct));
    obj->dval = 1.2;
    obj->struct_string = "hello";
    obj->val = 69;

    print_struct(obj);

    return 0;
}