# MergeSortArrayApplication

Задача

Функция сортирующая массив элементов A:

- Sort(A,p,r)

1. if p < r
2. then q := round_half_down((p+r)/2)
3.                       Sort(A,p,q)
4.                       Sort(A,q+1,r)
5.                       Merge(A,p,q,r)

Пример массива:
A = (5,2,4,6,1,3,2,6)

Примера запуска:
Sort(A,1,length[A])