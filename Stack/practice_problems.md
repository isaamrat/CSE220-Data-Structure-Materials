 # Stack Practice Problems

 ## Problem Overview Table

 | Problem # | Problem Name | Description | Constraints |
 |-----------|---------------|-------------|-------------|
 | 1 | [`sub_stack`](#problem-1-sub_stack) | Calculate difference between corresponding elements from top and bottom | Even number of elements, Stack operations only |
 | 2 | [`sum_stack`](#problem-2-sum_stack) | Calculate sum of corresponding elements from top and bottom | Even number of elements, Stack operations only |
 | 3 | [`conditional_reverse` (bottom-up)](#problem-3-conditional_reverse-bottom-up) | Reverse stack from bottom to n-th element | Stack operations only |
 | 4 | [`conditional_reverse` (top-down)](#problem-4-conditional_reverse-top-down) | Reverse stack from top to n-th element | Stack operations only |
 | 5 | [`rotate_stack` (upward)](#problem-5-rotate_stack-upward) | Rotate stack upward by k positions | Stack operations only, k ≤ 1,000,000,000 |
 | 6 | [`rotate_stack` (downward)](#problem-6-rotate_stack-downward) | Rotate stack downward by k positions | Stack operations only, k ≤ 1,000,000,000 |
 | 7 | [`filter_and_sort_stack`](#problem-7-filter_and_sort_stack) | Remove elements > k and sort remaining in ascending order | Stack operations only |
 | 8 | [`retain_and_reverse_stack`](#problem-8-retain_and_reverse_stack) | Retain top m elements and reverse them | Stack operations only |
 | 9 | [Odd/Even Rearrangement (Sum-based)](#problem-9-oddeven-rearrangement-sum-based) | Rearrange based on sum comparison of odd vs even numbers | Stack operations only |
 | 10 | [Odd/Even Alternating Pattern](#problem-10-oddeven-alternating-pattern) | Arrange in alternating odd-even pattern starting with odd | Stack operations only |

 ## Detailed Problem Specifications

 ### Problem 1: sub_stack
 **Description:** Takes a stack and modifies it such that the resulting stack contains the difference of corresponding elements from the top and bottom. The 0th element (bottom) is subtracted from the last element (top), and so on.

 | Input | Output | Explanation |
 |-------|--------|-------------|
 | Stack: [10, 20, 30, 40, 50, 60] | Stack: [10, 30, 50] | Pair 1: 60 - 10 = 50<br>Pair 2: 50 - 20 = 30<br>Pair 3: 40 - 30 = 10 |

 ### Problem 2: sum_stack
 **Description:** Takes a stack and modifies it such that the resulting stack contains the sum of corresponding elements from the top and bottom. The last element (top) is summed with the 0th element (bottom), and so on.

 | Input | Output | Explanation |
 |-------|--------|-------------|
 | Stack: [10, 15, 20, 50, 25, 35] | Stack: [70, 40, 45] | Pair 1: 35 + 10 = 45<br>Pair 2: 25 + 15 = 40<br>Pair 3: 50 + 20 = 70 |

 ### Problem 3: conditional_reverse (bottom-up)
 **Description:** Takes a stack and integer n, then reverses the stack from the bottom to n-th element.

 | Input | Output | Explanation |
 |-------|--------|-------------|
 | Stack: [10, 20, 30, 40, 50, 60]<br>n = 4 | Stack: [40, 30, 20, 10, 50, 60] | Reverse 4 elements from bottom: [10,20,30,40] becomes [40,30,20,10] |

 ### Problem 4: conditional_reverse (top-down)
 **Description:** Takes a stack and integer n, then reverses the stack from the top to n-th element.

 | Input | Output | Explanation |
 |-------|--------|-------------|
 | Stack: [10, 20, 30, 40, 50, 60]<br>n = 4 | Stack: [10, 20, 60, 50, 40, 30] | Reverse 4 elements from top: [60,50,40,30] becomes [30,40,50,60] |

 ### Problem 5: rotate_stack (upward)
 **Description:** Takes a stack and integer k, then rotates the stack upward by k positions.

 | Input | Output | Explanation |
 |-------|--------|-------------|
 | Stack: [10, 20, 30, 40, 50] (10 is top)<br>k = 2 | Stack: [30, 40, 50, 10, 20] | Move top 2 elements to bottom |
 | Stack: [10, 20, 30, 40, 50] (10 is top)<br>k = 6 | Stack: [20, 30, 40, 50, 10] | k=6 is equivalent to k=1 for size 5 |

 ### Problem 6: rotate_stack (downward)
 **Description:** Takes a stack and integer k, then rotates the stack downward by k positions.

 | Input | Output | Explanation |
 |-------|--------|-------------|
 | Stack: [10, 20, 30, 40, 50] (10 is top)<br>k = 2 | Stack: [40, 50, 10, 20, 30] | Move bottom 2 elements to top |
 | Stack: [10, 20, 30, 40, 50] (10 is top)<br>k = 6 | Stack: [50, 10, 20, 30, 40] | k=6 is equivalent to k=1 for size 5 |

 ### Problem 7: filter_and_sort_stack
 **Description:** Takes a stack and integer k, removes all elements greater than k, and sorts the remaining elements in ascending order.

 | Input | Output | Explanation |
 |-------|--------|-------------|
 | Stack: [50, 40, 70, 20, 10, 80, 30]<br>k = 40 | Stack: [10, 20, 30, 40] | Remove 50, 70, 80. Sort remaining: 40,20,10,30 → 10,20,30,40 |

 ### Problem 8: retain_and_reverse_stack
 **Description:** Takes a stack and integer m, retains only the top m elements and reverses them.

 | Input | Output | Explanation |
 |-------|--------|-------------|
 | Stack: [10, 20, 30, 40, 50, 60]<br>m = 4 | Stack: [40, 30, 20, 10] | Retain top 4: [10,20,30,40], then reverse to [40,30,20,10] |

 ### Problem 9: Odd/Even Rearrangement (Sum-based)
 **Description:** Calculate sum of odd and even integers. If even sum > odd sum, place odd integers at bottom and even at top. Otherwise, place odd at top and even at bottom. Maintain relative sequence.

 | Input | Output | Explanation |
 |-------|--------|-------------|
 | Stack: [11, 22, 24, 35, 41] | Stack: [11, 35, 41, 22, 24] | Odd sum: 11+35+41=87 > Even sum: 22+24=46<br>So odd numbers go on top |
 | Stack: [8, 10, 7, 5, 12, 3] | Stack: [8, 10, 12, 7, 5, 3] | Even sum: 8+10+12=30 > Odd sum: 7+5+3=15<br>So even numbers go on top |

 ### Problem 10: Odd/Even Alternating Pattern
 **Description:** Arrange stack so that odd integers are on top and even integers come after odd integers in alternating pattern. Maintain relative sequence of odd and even numbers.

 | Input | Output | Explanation |
 |-------|--------|-------------|
 | Stack: [11, 22, 24, 35, 41] | Stack: [11, 22, 35, 24, 41] | Start with odd (11), then even (22), then odd (35), then even (24), then odd (41) |
 | Stack: [8, 10, 7, 5, 12, 3] | Stack: [7, 8, 5, 10, 3, 12] | Start with odd, alternate with even |

 ## Common Constraints for All Problems
 - Only Stack class instances can be used
 - Available methods: `push()`, `pop()`, `peek()`, `isEmpty()`
 - No other data structures allowed
 - Multiple Stack instances can be created for assistance
 - Stack class is pre-defined and provides standard functionality
