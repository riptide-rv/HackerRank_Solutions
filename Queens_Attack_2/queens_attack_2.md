# Queens Attack 2

  - [Problem](https://www.hackerrank.com/challenges/queens-attack-2/problem?isFullScreen=true)(navigate to the Problem)
  - [Solution](queens_attack_2.java) (navigate to the Solution file)
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