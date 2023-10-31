# Here is my HackerRank Solutions

>The repository contains the solutions to various HackerRank problems.Organize the solutions so they are easy to navigate and understand. Each solution includes a reference to the problem statement and is well-documented to explain the logic and approach.



## 1. Queens Attack 2

  - [Problem](https://www.hackerrank.com/challenges/queens-attack-2/problem?isFullScreen=true)(navigate to the Problem)
  - [Solution](Queens_Attack_2/queens_attack_2.java) (navigate to the Solution file)
  - Explanation:
  > In this problem, we are given a square chess board with one queen and a number of obstacles placed on it. we need to determine how many squares the queen can attack.
  
  1. Initial thought process is about how many squares the queen can move to if no obstacles are present. Movement in horizontal and vertical directions is straightforward with 2(n-1) total. 
  2. Now we can consider diagonals , each diagonal is a combination of two other sides, vertical and horizontal. example: top-right is combination of top and right, the queen can move minimum of top , right squares in the direction of top-right diagonal.
  3. Next for each obstacle check if the obstacle is in the path of the queen (one of eight paths)
  4. if obstacle is in path reduce the movable boxes in that direction to minimum of current limit and limit due to obstacle


  ```java
public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
    int top = n - r_q;
    int bottom = r_q - 1;
    int left = c_q - 1;
    int right = n - c_q;
    
    int topRight = Math.min(n-c_q,n-r_q);
    int topLeft = Math.min(n-r_q,c_q-1);
    int bottomLeft = Math.min(bottom,left);
    int bottomRight = Math.min(bottom,right);
    
    for(List<Integer> obs :obstacles){

        int r = obs.get(0);
        int c = obs.get(1);
        if(r==r_q && c>c_q)
          right = Math.min(right,c-c_q-1);
        else if(r==r_q && c<c_q) 
          left = Math.min(left,c_q - c -1);
        else if(c==c_q && r>r_q) 
          top = Math.min(top,r-r_q-1);
        else if(c==c_q && r<r_q) 
          bottom = Math.min(bottom,r_q-r-1);
        else if(r_q-c_q==r-c && c>c_q) 
          topRight = Math.min(topRight,Math.min(c-c_q-1,r-r_q-1));
        else if(r_q-c_q==r-c && c<c_q)
          bottomLeft = Math.min(bottomLeft,Math.min(c_q-c-1,r_q-r-1));
        else if(r_q+c_q==r+c && c>c_q)
          bottomRight = Math.min(bottomRight,Math.min(r_q-r-1,c-c_q-1));
        else if(r_q+c_q==r+c && c<c_q)
          topLeft = Math.min(topLeft,Math.min(c_q-c-1,r-r_q-1));        
    }
    
    return top + left + bottom + right + topRight + topLeft + bottomLeft + bottomRight;

    }
```
#### Sample input & output
input
```
5 3
4 3
5 5
4 2
2 3
```
output
```
10
```
****

## 2. Largest Permutation

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




  
  


