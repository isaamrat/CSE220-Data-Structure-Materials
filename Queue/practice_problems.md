 # Queue Problems Collection

 ## Problem Overview Table

 | Problem # | Problem Name | Description | Constraints |
 |-----------|---------------|-------------|-------------|
 | 1 | [`rotate_queue`](#problem-1-rotate_queue) | Rotate queue elements by k positions | Queue operations only |
 | 2 | [`remove_negative`](#problem-2-remove_negative) | Remove all negative numbers from queue | Queue operations only |
 | 3 | [`interleave_queue`](#problem-3-interleave_queue) | Interleave first and second half of queue | Even number of elements, Queue operations only |
 | 4 | [`generate_binary`](#problem-4-generate_binary) | Generate binary representations from 1 to n using queue | Queue operations only |
 | 5 | [`merge_queues`](#problem-5-merge_queues) | Merge two sorted queues into one sorted queue | Queue operations only |
 | 6 | [`rearrange_positive_negative`](#problem-6-rearrange_positive_negative) | Rearrange queue with negatives first, then positives | Queue operations only |
 | 7 | [`find_first_negative_window`](#problem-7-find_first_negative_window) | Find first negative in every window of size k | Queue operations only |
 | 8 | [`circular_queue_simulation`](#problem-8-circular_queue_simulation) | Simulate circular queue operations with linear queue | Queue operations only |
 | 9 | [`check_palindrome`](#problem-9-check_palindrome) | Check if elements in queue form a palindrome | Queue & Stack operations only |

 ## Detailed Problem Specifications

 ### Problem 1: rotate_queue
 **Description:** Takes a queue and integer k, then rotates the queue by k positions. Elements from the front move to the rear.

 | Input | Output | Explanation |
 |-------|--------|-------------|
 | Queue: [1, 2, 3, 4, 5]<br>k = 2 | Queue: [3, 4, 5, 1, 2] | First 2 elements (1,2) move to rear |
 | Queue: [10, 20, 30]<br>k = 1 | Queue: [20, 30, 10] | First element (10) moves to rear |

 ### Problem 2: remove_negative
 **Description:** Takes a queue of integers and removes all negative numbers while maintaining the order of non-negative numbers.

 | Input | Output | Explanation |
 |-------|--------|-------------|
 | Queue: [1, -2, 3, -4, 5, 0] | Queue: [1, 3, 5, 0] | Remove -2 and -4, keep positive numbers and zero |
 | Queue: [-1, -2, -3] | Queue: [] | All elements are negative, result is empty queue |
 | Queue: [5, 10, 15] | Queue: [5, 10, 15] | No negative numbers, queue unchanged |

 ### Problem 3: interleave_queue
 **Description:** Takes a queue with even number of elements and interleaves the first half with the second half. Element from first half, then from second half, alternating.

 | Input | Output | Explanation |
 |-------|--------|-------------|
 | Queue: [1, 2, 3, 4, 5, 6] | Queue: [1, 4, 2, 5, 3, 6] | First half: [1,2,3], Second half: [4,5,6]<br>Interleave: 1,4,2,5,3,6 |
 | Queue: [11, 12, 13, 14] | Queue: [11, 13, 12, 14] | First half: [11,12], Second half: [13,14]<br>Interleave: 11,13,12,14 |

 ### Problem 4: generate_binary
 **Description:** Takes an integer n and generates binary representations of numbers from 1 to n using queue. Returns a queue containing binary strings.

 | Input | Output | Explanation |
 |-------|--------|-------------|
 | n = 5 | Queue: ["1", "10", "11", "100", "101"] | Binary of 1=1, 2=10, 3=11, 4=100, 5=101 |
 | n = 3 | Queue: ["1", "10", "11"] | Binary representations of 1, 2, 3 |

 ### Problem 5: merge_queues
 **Description:** Takes two sorted queues and merges them into one sorted queue maintaining ascending order.

 | Input | Output | Explanation |
 |-------|--------|-------------|
 | Queue1: [1, 3, 5]<br>Queue2: [2, 4, 6] | Queue: [1, 2, 3, 4, 5, 6] | Merge two sorted queues maintaining order |
 | Queue1: [10, 30, 50]<br>Queue2: [20, 40] | Queue: [10, 20, 30, 40, 50] | Combine and sort both queues |

 ### Problem 6: rearrange_positive_negative
 **Description:** Takes a queue of integers and rearranges it so that all negative numbers come first, followed by all non-negative numbers. Maintain relative order within each group.

 | Input | Output | Explanation |
 |-------|--------|-------------|
 | Queue: [1, -2, 3, -4, 5] | Queue: [-2, -4, 1, 3, 5] | Negatives first: [-2, -4], then non-negatives: [1, 3, 5] |
 | Queue: [10, -5, -8, 15, -3] | Queue: [-5, -8, -3, 10, 15] | Maintain relative order within negative and positive groups |

 ### Problem 7: find_first_negative_window
 **Description:** Takes a queue of integers and window size k, then finds the first negative element in every window of size k. Returns a queue containing the first negative values (0 if no negative found).

 | Input | Output | Explanation |
 |-------|--------|-------------|
 | Queue: [1, -2, 3, -1, 4, 5]<br>k = 3 | Queue: [-2, -2, -1, -1] | Window [1,-2,3]=-2, [-2,3,-1]=-2, [3,-1,4]=-1, [-1,4,5]=-1 |
 | Queue: [8, 5, 10, 7, 9]<br>k = 2 | Queue: [0, 0, 0, 0] | No negative numbers in any window |

 ### Problem 8: circular_queue_simulation
 **Description:** Simulate a circular queue using a regular queue. Implement operations where when queue reaches capacity, new elements overwrite old ones from the front.

 | Input | Output | Explanation |
 |-------|--------|-------------|
 | Capacity: 3<br>Operations: enqueue(1,2,3,4) | Queue: [2, 3, 4] | When 4 is added, 1 is overwritten (circular behavior) |
 | Capacity: 2<br>Operations: enqueue(10,20,30,40) | Queue: [30, 40] | Only last 2 elements remain due to circular overwriting |

  ### Problem 9: check_palindrome
 **Description:** Takes a queue of characters/integers and checks if the elements form a palindrome. The function should return True if palindrome, False otherwise. The original queue should remain unchanged. `You can use stack to solve this problem.`

 | Input | Output | Explanation |
 |-------|--------|-------------|
 | Queue: [1, 2, 3, 2, 1] | True | Reading from front to rear: 1,2,3,2,1 is same as rear to front |
 | Queue: [a, b, c, b, a] | True | Characters form palindrome: abcba |
 | Queue: [1, 2, 3, 4, 5] | False | 12345 is not same as 54321 |


 ## Common Constraints for All Problems
 - Only Queue class instances can be used
 - Available methods: `enqueue()`, `dequeue()`, `peek/front()`, `isEmpty()`
 - No other data structures allowed except where specifically mentioned
 - Multiple Queue instances can be created for assistance
 - Queue class is pre-defined and provides standard FIFO functionality
 - For problems requiring additional data structures (like stacks), it will be explicitly mentioned
