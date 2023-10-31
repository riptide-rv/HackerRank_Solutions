# Largest Permutation

  - [Problem](https://www.hackerrank.com/challenges/largest-permutation/problem)
  - [Solution](largest_permutation.java) (navigate to the Solution file)
  - Explanation:
  > In this problem we are given an unordered array of unique integers incrementing from 1. we can swap any two elements a limited number of times. we have to determine the largest lexicographical value array that can be created by executing no more than the limited number of swaps.
  
  1. To make an array as large as possible , we have to have the array values in descending order. So for k swaps the first k elements should be the greatest that is n , n - 1, ... n - k
  2. Initially we pass through array once and store postion of each element in a postion array.
  3. Then for k passes , starting from first element we check whether array element is in postion i.e. proper descending order postion, if not we swap the element with the element in that postion.
  for position i , element will be n - i;


```java
public static List<Integer> largestPermutation(int k, List<Integer> arr) {
        int n = arr.size();
        int[] position = new int[n + 1];
        for (int i = 0; i < n; i++) {
            position[arr.get(i)] = i;
        }
        int a = 0;
        while (k > 0 && a < n) {
            if (arr.get(a) != n - a) {
                int temp = arr.get(a);
                int swapIndex = position[n - a];
                arr.set(a, n - a);
                arr.set(swapIndex, temp);
                position[temp] = swapIndex;
                position[n - a] = a;
                k--;
            }
            a++;
        }
        return arr;
    }



```
#### Sample input & output
input
```
5 1       
4 2 3 5 1
```
output
```
5 2 3 4 1

```
****