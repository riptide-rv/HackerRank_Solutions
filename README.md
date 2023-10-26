# Here is my HackerRank Solutions

>The repository contains the solutions to various HackerRank problems.Organize the solutions so they are easy to navigate and understand. Each solution includes a reference to the problem statement and is well-documented to explain the logic and approach.




## 1.Problem

  - [Problem](https://www.hackerrank.com/challenges/apple-and-orange/problem?isFullScreen=true)(navigate to the Problem)
  - [Solution](Apple_and_Orange/appleandorange.py) (navigate to the Solution file)
  - Explanation:
  > In this problem, we are given the coordinates of a house and the positions of apple and orange trees. We need to count the number of apples and oranges that fall within a certain range of the house.

  ```python
s, t = map(int, input().split())
a, b = map(int, input().split())
m, n = map(int, input().split()) 
apples = list(map(int, input().split()))
oranges = list(map(int, input().split()))

count_Apples = sum(1 for apple in apples if s <= a + apple <= t)
count_Oranges = sum(1 for orange in oranges if s <= b + orange <= t)
print(count_Apples)
print(count_Oranges)
```
  
## Problem 2


  - [Solution](./solution.py)
  - Explanation: (Explain your problem-solving approach in detail)




  
  


