#ifndef TYPES_H
#define TYPES_H

/* Type definitions */
typedef int my_type;

typedef struct struct_type {
  my_type val1;
  int val2;
} struct_type;

typedef struct union_type {
  my_type n;
  char c;
} union_type;

#endif