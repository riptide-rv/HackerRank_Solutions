# Here is my HackerRank Solutions

>The repository contains the solutions to various HackerRank problems.Organize the solutions so they are easy to navigate and understand. Each solution includes a reference to the problem statement and is well-documented to explain the logic and approach.




## 1.Queens Attack 2

  - [Problem](https://www.hackerrank.com/challenges/queens-attack-2/problem?isFullScreen=true)(navigate to the Problem)
  - [Solution](Queens_Attack_2/queens_attack_2.java) (navigate to the Solution file)
  - Explanation:
  > In this problem, we are given a square chess board with one queen and a number of obstacles placed on it. we need to determine how many squares the queen can attack.

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
  
## Problem 2


  - [Solution](./solution.py)
  - Explanation: (Explain your problem-solving approach in detail)




  
  


