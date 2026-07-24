# DSA in Java — Solutions Worth Reading

Most DSA repos stop at "accepted." This one doesn't.

Every solution here is documented the way you'd document production code — with honest tradeoff analysis, approach comparisons, and comments that explain _why_ a decision was made, not just _what_ the code does.

---

## What makes this different

- Every problem has multiple approaches documented — brute force through optimal
- The chosen approach is marked (★) with a clear reason why
- Inline comments are written in developer tone — short, direct, non-obvious things only
- Time and space complexity per approach, not just the final one
- No copy-paste from editorials — solutions are built from first principles

---

## 🗂️ Master Index

### 0. Math

#### EASY

| Problem Name              | Topic                     | Difficulty | Time Complexity | Space Complexity | Solution Link                                                      |
| :------------------------ | :------------------------ | :--------- | :-------------- | :--------------- | :----------------------------------------------------------------- |
| [LC3754] Sum and Multiply | Math + Digit Manipulation | Easy       | `O(d)`          | `O(1)`           | [LC3754SumAndMultiply.java](./math/easy/LC3754SumAndMultiply.java) |

<br>

#### Greatest Common Divisor

| Problem Name                                   | Topic                | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                         |
| :--------------------------------------------- | :------------------- | :--------- | :-------------- | :--------------- | :---------------------------------------------------------------------------------------------------- |
| [LC] GCD of Odd and Even Sums                  | Math + Number Theory | Easy       | `O(log n)`      | `O(1)`           | [LC_GCDOfOddEvenSums.java](./math/gcd/LC_GCDOfOddEvenSums.java)                                       |
| [LC3867] GCD Pair Sum                          | Math + GCD           | Medium     | `O(n log n)`    | `O(n)`           | [LC3867GCDPairSum.java](./math/gcd/LC3867GCDPairSum.java)                                             |
| [LC1979] Find Greatest Common Divisor of Array | Math + GCD           | Easy       | `O(n)`          | `O(1)`           | [LC1979FindGreatestCommonDivisorOfArray.java](./math/gcd/LC1979FindGreatestCommonDivisorOfArray.java) |

<br>

#### candidate Generation (Enumeration)

| Problem Name               | Topic              | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                 |
| :------------------------- | :----------------- | :--------- | :-------------- | :--------------- | :---------------------------------------------------------------------------- |
| [LC1291] Sequential Digits | Math + Enumeration | Easy       | `O(1)`          | `O(1)`           | [LC1291SequentialDigits.java](./math/enumeration/LC1291SequentialDigits.java) |

<br>

#### Advanced Math

| Problem Name                                        | Topic                                        | Difficulty | Time Complexity  | Space Complexity         | Solution Link                                                                                                      |
| :-------------------------------------------------- | :------------------------------------------- | :--------- | :--------------- | :----------------------- | :----------------------------------------------------------------------------------------------------------------- |
| [LC2521] Distinct Prime Factors of Product of Array | Math + Number Theory                         | Medium     | `O(n * √m)`      | `O(k)`                   | [LC2521DistinctPrimeFactorsOfProductOfArray.java](./math/advanced/LC2521DistinctPrimeFactorsOfProductOfArray.java) |
| [GFG] All Divisors of a Number                      | Math                                         | Easy       | `O(√n)`          | `O(√n)`                  | [GFG_AllDivisorsOfANumber.java](./math/advanced/GFG_AllDivisorsOfANumber.java)                                     |
| [LC204] Count Primes                                | Math + Advanced Math + Sieve of Eratosthenes | Medium     | `O(n log log n)` | `O(n)`                   | [LC204CountPrimes.java](./math/advanced/LC204CountPrimes.java)                                                     |
| Prime Factorisation of a Number                     | Mathematics + Number Theory                  | Easy       | `O(Q × √N)`      | `O(total prime factors)` | [PrimeFactorisationOfANumber.java](./math/advanced/PrimeFactorisationOfANumber.java)                               |

---

### 1. Sorting Algorithms

| Problem Name   | Topic                      | Difficulty | Time Complexity | Space Complexity | Solution Link                                      |
| :------------- | :------------------------- | :--------- | :-------------- | :--------------- | :------------------------------------------------- |
| Selection Sort | Sorting / Basics           | Easy       | `O(N^2)`        | `O(1)`           | [SelectionSort.java](./sorting/SelectionSort.java) |
| Bubble Sort    | Sorting / Basics           | Easy       | `O(N^2)`        | `O(1)`           | [BubbleSort.java](./sorting/BubbleSort.java)       |
| Insertion Sort | Sorting / Basics           | Easy       | `O(N^2)`        | `O(1)`           | [InsertionSort.java](./sorting/InsertionSort.java) |
| Merge Sort     | Sorting / Divide & Conquer | Medium     | `O(N log N)`    | `O(N)`           | [MergeSort.java](./sorting/MergeSort.java)         |
| Quick Sort     | Sorting / Divide & Conquer | Medium     | `O(N log N)`    | `O(log N)`       | [QuickSort.java](./sorting/QuickSort.java)         |

<br>

#### Medium

| Problem Name                      | Topic            | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                           |
| :-------------------------------- | :--------------- | :--------- | :-------------- | :--------------- | :-------------------------------------------------------------------------------------- |
| [LC1288] Remove Covered Intervals | Greedy + Sorting | Medium     | `O(n log n)`    | `O(1)`           | [LC1288RemoveCoveredIntervals.java](./sorting/medium/LC1288RemoveCoveredIntervals.java) |

---

### 2. Array Challenges

#### Easy

| Problem Name                     | Topic                     | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                            |
| :------------------------------- | :------------------------ | :--------- | :-------------- | :--------------- | :------------------------------------------------------------------------------------------------------- |
| [LC1] Two Sum                    | Arrays / Hashing          | Easy       | `O(N)`          | `O(N)`           | [LC1TwoSum.java](./arrays/easy/LC1TwoSum.java)                                                           |
| [LC26] Remove Duplicates         | Arrays / Two Pointers     | Easy       | `O(N)`          | `O(1)`           | [LC26RemoveDuplicates.java](./arrays/easy/LC26RemoveDuplicates.java)                                     |
| [LC88] Merge Sorted Array        | Arrays / Two Pointers     | Easy       | `O(M+N)`        | `O(1)`           | [LC88MergeSortedArraysInOne.java](./arrays/easy/LC88MergeSortedArray.java)                               |
| [LC118] Pascal's Triangle        | Arrays / Math             | Easy       | `O(N^2)`        | `O(N^2)`         | [LC118PascalsTriangle.java](./arrays/easy/LC118PascalsTriangle.java)                                     |
| [LC136] Single Number            | Arrays / Bit Manipulation | Easy       | `O(N)`          | `O(1)`           | [LC136SingleNumber.java](./arrays/easy/LC136SIngleNumber.java)                                           |
| [LC169] Majority Element         | Arrays / Boyer-Moore      | Easy       | `O(N)`          | `O(1)`           | [LC169MajorityElement.java](./arrays/easy/LC169MajorityElement.java)                                     |
| [LC268] Missing Number           | Arrays / Math             | Easy       | `O(N)`          | `O(1)`           | [LC268MissingNumber.java](./arrays/easy/LC268MissingNumber.java)                                         |
| [LC283] Move Zeroes              | Arrays / Two Pointers     | Easy       | `O(N)`          | `O(1)`           | [LC283MoveZeroes.java](./arrays/easy/LC283MoveZeroes.java)                                               |
| [LC485] Max Consecutive Ones     | Arrays / Traversal        | Easy       | `O(N)`          | `O(1)`           | [LC485MaxConsecutiveOnes.java](./arrays/easy/LC485MaxConsecutiveOnes.java)                               |
| [GFG] Leaders in an Array        | Arrays / Traversal        | Easy       | `O(N)`          | `O(N)`           | [LeadersInArray.java](./arrays/easy/GFG_LeadersInArray.java)                                             |
| [GFG] Union of Two Sorted Arrays | Arrays / Two Pointers     | Easy       | `O(N+M)`        | `O(N+M)`         | [UnionOfTwoSortedArraysWithDuplicates.java](./arrays/easy/GFG_UnionOfTwoSortedArraysWithDuplicates.java) |

<br>

#### Medium

| Problem Name                         | Topic                        | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                |
| :----------------------------------- | :--------------------------- | :--------- | :-------------- | :--------------- | :------------------------------------------------------------------------------------------- |
| [LC15] 3Sum                          | Arrays / Two Pointers        | Medium     | `O(N^2)`        | `O(1)`           | [LC15ThreeSum.java](./arrays/medium/LC15ThreeSum.java)                                       |
| [LC18] 4Sum                          | Arrays / Two Pointers        | Medium     | `O(N^3)`        | `O(1)`           | [LC18FourSum.java](./arrays/medium/LC18FourSum.java)                                         |
| [LC53] Maximum Subarray (Kadane)     | Arrays / DP                  | Medium     | `O(N)`          | `O(1)`           | [LC59MaximumSubarrayKadanesAlgo.java](./arrays/medium/LC53MaximumSubarrayKadanesAlgo.java)   |
| [LC54] Spiral Matrix                 | Arrays / Matrix              | Medium     | `O(M*N)`        | `O(1)`           | [LC54SpriralMatrix.java](./arrays/medium/LC54SpiralMatrix.java)                              |
| [LC56] Merge Intervals               | Arrays / Sorting             | Medium     | `O(N log N)`    | `O(N)`           | [LC56MergeIntervals.java](./arrays/medium/LC56MergeIntervals.java)                           |
| [LC73] Set Matrix Zeroes             | Arrays / Matrix              | Medium     | `O(M*N)`        | `O(1)`           | [LC73SetMatrixZeroes.java](./arrays/medium/LC73SetMatrixZeroes.java)                         |
| [LC75] Sort Colors                   | Arrays / Dutch National Flag | Medium     | `O(N)`          | `O(1)`           | [LC75SortColors.java](./arrays/medium/LC75SortColors.java)                                   |
| [LC128] Longest Consecutive Sequence | Arrays / Hashing             | Medium     | `O(N)`          | `O(N)`           | [LC128LongestConsecutiveSequence.java](./arrays/medium/LC128LongestConsecutiveSequence.java) |
| [LC2149] Rearrange Array by Sign     | Arrays / Two Pointers        | Medium     | `O(N)`          | `O(N)`           | [LC2149RearrangeArrayBySign.java](./arrays/medium/LC2149RearrangeArrayBySign.java)           |

<br>

#### Hard Problems

| Problem Name                       | Topic                     | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                    |
| :--------------------------------- | :------------------------ | :--------- | :-------------- | :--------------- | :----------------------------------------------------------------------------------------------- |
| [LC229] Majority Element II        | Arrays / Boyer-Moore      | Medium     | `O(N)`          | `O(1)`           | [LC229MajorityElements2.java](./arrays/medium/LC229MajorityElements2.java)                       |
| [IB/LC] Count Subarrays with XOR K | Arrays / Prefix XOR       | Medium     | `O(N)`          | `O(N)`           | [CountSubarrayXOREqualsK.java](./arrays/medium/CountSubarrayXOREqualsK.java)                     |
| [GFG] Find Missing & Repeating     | Arrays / Math             | Medium     | `O(N)`          | `O(1)`           | [GFG_FindMissingAndRepeatingNumber.java](./arrays/medium/GFG_FindMissingAndRepeatingNumber.java) |
| [GFG] Longest Subarray with Sum K  | Arrays / Prefix Sum       | Medium     | `O(N)`          | `O(N)`           | [GFG_LongestSubarrayWithSumK.java](./arrays/medium/GFG_LongestSubarrayWithSumK.java)             |
| [LC493] Reverse Pairs              | Arrays / Divide & Conquer | Hard       | `O(N log N)`    | `O(N)`           | [LC493ReversePairs.java](./arrays/hard/LC493ReversePairs.java)                                   |
| [GFG] Count Inversions             | Arrays / Divide & Conquer | Hard       | `O(N log N)`    | `O(N)`           | [GFG_CountInversion.java](./arrays/hard/GFG_CountInversion.java)                                 |

<br>

#### Array Rotation related problems

| Problem Name           | Topic             | Difficulty | Time Complexity | Space Complexity | Solution Link                                                          |
| :--------------------- | :---------------- | :--------- | :-------------- | :--------------- | :--------------------------------------------------------------------- |
| [LC189] Rotate Array   | Arrays / Math     | Medium     | `O(N)`          | `O(1)`           | [LC189RotateArrayByK.java](./arrays/rotation/LC189RotateArrayByK.java) |
| [LC1260] Shift 2D Grid | Arrays + Rotation | Easy       | `O(m × n)`      | `O(1)`           | [LC1260Shift2DGrid.java](./arrays/rotation/LC1260Shift2DGrid.java)     |
| [LC48] Rotate Image    | Arrays / Matrix   | Medium     | `O(N^2)`        | `O(1)`           | [LC48RotateMatrix.java](./arrays/rotation/LC48RotateMatrix.java)       |

---

### 3. Binary Search

#### Binary Search On 1D Arrays

| Problem Name                           | Topic    | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                                |
| :------------------------------------- | :------- | :--------- | :-------------- | :--------------- | :----------------------------------------------------------------------------------------------------------- |
| [Basic] Find Index of Target           | BS on 1D | Easy       | `O(log N)`      | `O(1)`           | [FindIndexOfTarget.java](./binarysearch/on1DArrays/FindIndexOfTarget.java)                                   |
| [LC35] Search Insert Position          | BS on 1D | Easy       | `O(log N)`      | `O(1)`           | [LC35SearchInsertPosition.java](./binarysearch/on1DArrays/LC35SearchInsertPosition.java)                     |
| [GFG] Count Occurrences                | BS on 1D | Easy       | `O(log N)`      | `O(1)`           | [GFG_CountOccurrencesInSortedArray.java](./binarysearch/on1DArrays/GFG_CountOccurrencesInSortedArray.java)   |
| [LC34] Find First & Last Position      | BS on 1D | Medium     | `O(log N)`      | `O(1)`           | [LC34FindFirstAndLastOccurrences.java](./binarysearch/on1DArrays/LC34FindFirstAndLastOccurrences.java)       |
| [LC33] Search in Rotated Array         | BS on 1D | Medium     | `O(log N)`      | `O(1)`           | [LC33RotatedSortedArraySearch.java](./binarysearch/on1DArrays/LC33RotatedSortedArraySearch.java)             |
| [LC81] Search in Rotated Array II      | BS on 1D | Medium     | `O(log N)*`     | `O(1)`           | [LC81RotatedSortedArraySearch2.java](./binarysearch/on1DArrays/LC81RotatedSortedArraySearch2.java)           |
| [LC153] Min in Rotated Array           | BS on 1D | Medium     | `O(log N)`      | `O(1)`           | [LC153MinOfRotatedSortedArray.java](./binarysearch/on1DArrays/LC153MinOfRotatedSortedArray.java)             |
| [GFG] Find Rotation Count              | BS on 1D | Medium     | `O(log N)`      | `O(1)`           | [GFG_FindRotationCountInSortedArray.java](./binarysearch/on1DArrays/GFG_FindRotationCountInSortedArray.java) |
| [LC162] Find Peak Element              | BS on 1D | Medium     | `O(log N)`      | `O(1)`           | [LC162PeakElementInSortedArray.java](./binarysearch/on1DArrays/LC162PeakElementInSortedArray.java)           |
| [LC540] Single Element in Sorted Array | BS on 1D | Medium     | `O(log N)`      | `O(1)`           | [LC540SingleElementInSortedArray.java](./binarysearch/on1DArrays/LC540SingleElementInSortedArray.java)       |

<br>

#### Binary Search On Answers

| Problem Name                    | Topic         | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                             |
| :------------------------------ | :------------ | :--------- | :-------------- | :--------------- | :---------------------------------------------------------------------------------------- |
| [LC69] Sqrt(x)                  | BS on Answers | Easy       | `O(log N)`      | `O(1)`           | [LC69SquareRoot.java](./binarysearch/onAnswers/LC69SquareRoot.java)                       |
| [GFG] Nth Root of M             | BS on Answers | Easy       | `O(log M)`      | `O(1)`           | [GFG_nthRoot.java](./binarysearch/onAnswers/GFG_nthRoot.java)                             |
| [LC875] Koko Eating Bananas     | BS on Answers | Medium     | `O(N log M)`    | `O(1)`           | [LC875BananaEating.java](./binarysearch/onAnswers/LC875BananaEating.java)                 |
| [SPOJ/GFG] Aggressive Cows      | BS on Answers | Medium     | `O(N log M)`    | `O(1)`           | [GFG_AggressiveCows.java](./binarysearch/onAnswers/GFG_AggressiveCows.java)               |
| [GFG] Allocate Minimum Pages    | BS on Answers | Hard       | `O(N log M)`    | `O(1)`           | [GFG_BookAllocation.java](./binarysearch/onAnswers/GFG_BookAllocation.java)               |
| [LC410] Split Array Largest Sum | BS on Answers | Hard       | `O(N log M)`    | `O(1)`           | [LC410SplitArrayLargestSum.java](./binarysearch/onAnswers/LC410SplitArrayLargestSum.java) |

<br>

#### Binary Search On 2D Matrix

| Problem Name                             | Topic    | Difficulty | Time Complexity         | Space Complexity | Solution Link                                                                        |
| :--------------------------------------- | :------- | :--------- | :---------------------- | :--------------- | :----------------------------------------------------------------------------------- |
| [LC74] Search a 2D Matrix                | BS on 2D | Medium     | `O(log(M*N))`           | `O(1)`           | [LC74SortedMatrixSearch.java](./binarysearch/on2DMatrix/LC74SortedMatrixSearch.java) |
| [LC240] Search a 2D Matrix II            | BS on 2D | Medium     | `O(M + N)`              | `O(1)`           | [LC240MatrixSearch2.java](./binarysearch/on2DMatrix/LC240MatrixSearch2.java)         |
| [GFG] Row with Max 1s                    | BS on 2D | Medium     | `O(M + N)`              | `O(1)`           | [GFG_RowWithMaxOne.java](./binarysearch/on2DMatrix/GFG_RowWithMaxOne.java)           |
| [LC1901] Find a Peak Element II          | BS on 2D | Medium     | `O(M log N)`            | `O(1)`           | [LC1901PeakElement2.java](./binarysearch/on2DMatrix/LC1901PeakElement2.java)         |
| [GFG] Median in a Row-Wise Sorted Matrix | BS on 2D | Hard       | `O(M log(MAX) * log N)` | `O(1)`           | [GFG_MatrixMedian.java](./binarysearch/on2DMatrix/GFG_MatrixMedian.java)             |

---

### 4. Strings

#### Character Counter based problems (Frequency)

| Problem Name                             | Topic             | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                 |
| :--------------------------------------- | :---------------- | :--------- | :-------------- | :--------------- | :-------------------------------------------------------------------------------------------- |
| [LC242] Valid Anagram                    | Strings / Hashing | Easy       | `O(N)`          | `O(1)`           | [LC242Anagram.java](./strings/easy/LC242Anagram.java)                                         |
| [LC1021] Remove Outermost Parentheses    | Strings / Stack   | Easy       | `O(N)`          | `O(N)`           | [LC1021RemoveOutermostParenthesis.java](./strings/easy/LC1021RemoveOutermostParenthesis.java) |
| [LC1781] Sum of Beauty of All Substrings | Strings / Hashing | Medium     | `O(N^2)`        | `O(1)`           | [LC1781BeautyOfString.java](./strings/medium/LC1781BeautyOfString.java)                       |

<br>

#### Modiefied Traversal based problems

| Problem Name                          | Topic                | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                       |
| :------------------------------------ | :------------------- | :--------- | :-------------- | :--------------- | :---------------------------------------------------------------------------------- |
| [LC1903] Largest Odd Number in String | Strings / Math       | Easy       | `O(N)`          | `O(1)`           | [LC1903LargestOddNumInString.java](./strings/easy/LC1903LargestOddNumInString.java) |
| [LC796] Rotate String                 | Strings / Matching   | Easy       | `O(N)`          | `O(N)`           | [LC796RotateString.java](./strings/easy/LC796RotateString.java)                     |
| [LC6] Zigzag Conversion               | Strings + Simulation | Medium     | `O(n)`          | `O(n)`           | [LC6ZigzagConversion.java](./strings/medium/LC6ZigzagConversion.java)               |

<br>

#### Two Pointer

| Problem Name                        | Topic                   | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                               |
| :---------------------------------- | :---------------------- | :--------- | :-------------- | :--------------- | :------------------------------------------------------------------------------------------ |
| [LC151] Reverse Words in a String   | Strings / Two Pointers  | Medium\*   | `O(N)`          | `O(N)`           | [LC151ReverseWords.java](./strings/easy/LC151ReverseWords.java)                             |
| [LC5] Longest Palindromic Substring | Strings / Expand Center | Medium     | `O(N^2)`        | `O(1)`           | [LC5LongestPalindromicSubstring.java](./strings/medium/LC5LongestPalindromicSubstring.java) |

<br>

#### Preffix / Suffix

| Problem Name                                 | Topic                             | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                                   |
| :------------------------------------------- | :-------------------------------- | :--------- | :-------------- | :--------------- | :-------------------------------------------------------------------------------------------------------------- |
| [LC3499] Maximize Active Section After Trade | Strings + Prefix/Suffix Traversal | Medium     | `O(n)`          | `O(n)`           | [LC3499MaximizeActiveSectionAfterTrade.java](./strings/prefixsuffix/LC3499MaximizeActiveSectionAfterTrade.java) |

---

### 5. Linked List

#### Singly Linked List (Basics)

| Problem Name                 | Topic                | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                      |
| :--------------------------- | :------------------- | :--------- | :-------------- | :--------------- | :------------------------------------------------------------------------------------------------- |
| Convert Array to Linked List | Linked List / Basics | Easy       | `O(N)`          | `O(N)`           | [ArrayToLinkedList.java](./linkedlist/singlylinkedlist/ArrayToLinkedList.java)                     |
| Print Linked List            | Linked List / Basics | Easy       | `O(N)`          | `O(1)`           | [PrintLinkedList.java](./linkedlist/singlylinkedlist/PrintLinkedList.java)                         |
| Find Length of Linked List   | Linked List / Basics | Easy       | `O(N)`          | `O(1)`           | [LinkedListLength.java](./linkedlist/singlylinkedlist/LinkedListLength.java)                       |
| Search in Linked List        | Linked List / Basics | Easy       | `O(N)`          | `O(1)`           | [CheckIfTargetExistsInLL.java](./linkedlist/singlylinkedlist/CheckIfTargetExistsInLL.java)         |
| Insert Node in Singly LL     | Linked List / Basics | Easy       | `O(N)`\*        | `O(1)`           | [InsertionInSinglyLinkedList.java](./linkedlist/singlylinkedlist/InsertionInSinglyLinkedList.java) |
| Delete Node in Singly LL     | Linked List / Basics | Easy       | `O(N)`\*        | `O(1)`           | [DeleteInSinglyLinkedList.java](./linkedlist/singlylinkedlist/DeleteInSinglyLinkedList.java)       |

<br>

#### Singly Linked List (Medium)

| Problem Name                                            | Topic                      | Difficulty | Time Complexity        | Space Complexity | Solution Link                                                                                                                                    |
| :------------------------------------------------------ | :------------------------- | :--------- | :--------------------- | :--------------- | :----------------------------------------------------------------------------------------------------------------------------------------------- |
| [LC2807] Insert Greatest Common Divisors in Linked List | Linked List + Math         | Medium     | `O(n * log(min(a,b)))` | `O(1)`           | [LC2807InsertGreatestCommonDivisorsInLinkedList.java](./linkedlist/mediumonsinglylinkedlist/LC2807InsertGreatestCommonDivisorsInLinkedList.java) |
| [LC876] Middle of the Linked List                       | Linked List / Fast & Slow  | Easy\*     | `O(N)`                 | `O(1)`           | [LC876MidOfLL.java](./linkedlist/mediumonsinglylinkedlist/LC876MidOfLL.java)                                                                     |
| [LC141] Linked List Cycle                               | Linked List / Fast & Slow  | Easy\*     | `O(N)`                 | `O(1)`           | [LC141CycleInSinglyLL.java](./linkedlist/mediumonsinglylinkedlist/LC141CycleInSinglyLL.java)                                                     |
| [LC142] Linked List Cycle II                            | Linked List / Fast & Slow  | Medium     | `O(N)`                 | `O(1)`           | [LC142StartOfCycleLengthSinglyLinkedList.java](./linkedlist/mediumonsinglylinkedlist/LC142StartOfCycleLengthSinglyLinkedList.java)               |
| [GFG] Length of Loop in LL                              | Linked List / Fast & Slow  | Medium     | `O(N)`                 | `O(1)`           | [GFG_LengthOfLoopOfLinkedList.java](./linkedlist/mediumonsinglylinkedlist/GFG_LengthOfLoopOfLinkedList.java)                                     |
| [LC19] Remove Nth Node From End                         | Linked List / Two Pointers | Medium     | `O(N)`                 | `O(1)`           | [LC19RemoveNthNode.java](./linkedlist/mediumonsinglylinkedlist/LC19RemoveNthNode.java)                                                           |
| [LC160] Intersection of Two LLs                         | Linked List / Two Pointers | Easy\*     | `O(N+M)`               | `O(1)`           | [LC160IntersectionInLinkedList.java](./linkedlist/mediumonsinglylinkedlist/LC160InterSectionInLinkedList.java)                                   |
| [LC234] Palindrome Linked List                          | Linked List / Two Pointers | Easy\*     | `O(N)`                 | `O(1)`           | [LC234PalindromicLinkedList.java](./linkedlist/mediumonsinglylinkedlist/LC234PalindromicLinkedList.java)                                         |
| [LC328] Odd Even Linked List                            | Linked List / Traversal    | Medium     | `O(N)`                 | `O(1)`           | [LC_328OddEvenLinkedList.java](./linkedlist/mediumonsinglylinkedlist/LC_328OddEvenLinkedList.java)                                               |
| [LC148] Sort List                                       | Linked List / Merge Sort   | Medium     | `O(N log N)`           | `O(1)`           | [LC148SortSinglyLinkedList.java](./linkedlist/mediumonsinglylinkedlist/LC148SortSinglyLinkedList.java)                                           |
| [GFG] Add 1 to a Number as LL                           | Linked List / Math         | Medium     | `O(N)`                 | `O(1)`           | [GFG_AddOneToSinglyLinkedList.java](./linkedlist/mediumonsinglylinkedlist/GFG_AddOneToSinglyLinkedList.java)                                     |

<br>

#### Doubly Linked List (Medium)

| Problem Name                            | Topic                    | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                                  |
| :-------------------------------------- | :----------------------- | :--------- | :-------------- | :--------------- | :------------------------------------------------------------------------------------------------------------- |
| [GFG] Find Pairs with Given Sum         | Doubly LL / Two Pointers | Medium     | `O(N)`          | `O(1)`           | [GFG_PairSumDoublyLinkedList.java](./linkedlist/mediumondoublylinkedlist/GFG_PairSumDoublyLinkedList.java)     |
| [GFG] Remove All Occurrences of Key     | Doubly LL / Traversal    | Medium     | `O(N)`          | `O(1)`           | [GFG_RemoveAllOccurrencesOfKey.java](./linkedlist/mediumondoublylinkedlist/GFG_RemoveAllOccurrencesOfKey.java) |
| [GFG] Remove Duplicates from Sorted DLL | Doubly LL / Traversal    | Easy\*     | `O(N)`          | `O(1)`           | [GFG_RemoveDuplicates.java](./linkedlist/mediumondoublylinkedlist/GFG_RemoveDuplicates.java)                   |

<br>

#### Hard Problems

| Problem Name                          | Topic                      | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                |
| :------------------------------------ | :------------------------- | :--------- | :-------------- | :--------------- | :------------------------------------------------------------------------------------------- |
| [LC25] Reverse Nodes in k-Group       | Linked List / Reversal     | Hard       | `O(N)`          | `O(1)`           | [LC25ReverseLinkedListInKGroups.java](./linkedlist/hard/LC25ReverseLinkedListInKGroups.java) |
| [LC61] Rotate List                    | Linked List / Two Pointers | Medium\*   | `O(N)`          | `O(1)`           | [LC61RotateSinglyListToRightByK.java](./linkedlist/hard/LC61RotateSinglyListToRightByK.java) |
| [LC138] Copy List with Random Pointer | Linked List / Deep Copy    | Medium\*   | `O(N)`          | `O(1)`           | [LC138DeepCopyRandomPointers.java](./linkedlist/hard/LC138DeepCopyRandomPointers.java)       |
| [GFG] Flattening a Linked List        | Linked List / Merge        | Hard       | `O(N * M)`      | `O(1)`           | [GFG_FlattenLinkedList.java](./linkedlist/hard/GFG_FlattenLinkedList.java)                   |

---

### 6. Recursion

#### Basics

| Problem Name                   | Topic               | Difficulty | Time Complexity | Space Complexity | Solution Link                                                       |
| :----------------------------- | :------------------ | :--------- | :-------------- | :--------------- | :------------------------------------------------------------------ |
| [LC8] String to Integer (atoi) | Recursion / Strings | Medium     | `O(N)`          | `O(N)`           | [LC8_AtoiRecursion.java](./recursion/basics/LC8_AtoiRecursion.java) |
| [GFG] Sort a Stack             | Recursion / Stack   | Medium     | `O(N^2)`        | `O(N)`           | [GFG_SortStack.java](./recursion/basics/GFG_SortStack.java)         |

<br>

#### Subsequence Patterns

| Problem Name                                 | Topic                    | Difficulty | Time Complexity       | Space Complexity | Solution Link                                                                                                                                |
| :------------------------------------------- | :----------------------- | :--------- | :-------------------- | :--------------- | :------------------------------------------------------------------------------------------------------------------------------------------- |
| [Code360] Binary Strings w/o Consecutive 1s  | Recursion / Backtracking | Medium     | `O(2^N)`              | `O(N)`           | [Code360_GenerateBinaryStringWithoutConsecutive1.java](./recursion/subsequencepatterns/Code360_GenerateBinaryStringWithoutConsecutive1.java) |
| [GFG] Subsequence Sum Target                 | Recursion / Subsequences | Medium     | `O(2^N)`              | `O(N)`           | [GFG_SubsequenceSumTarget.java](./recursion/subsequencepatterns/GFG_SubsequenceSumTarget.java)                                               |
| [GFG] Count Subsequences with Sum K          | Recursion / Subsequences | Medium     | `O(2^N)`              | `O(N)`           | [CountSubsequenceWithSumK.java](./recursion/subsequencepatterns/CountSubsequenceWithSumK.java)                                               |
| [GFG] Subset Sums                            | Recursion / Subsequences | Medium     | `O(2^N)`              | `O(2^N)`         | [GFG_SubsetSums.java](./recursion/subsequencepatterns/GFG_SubSetSums.java)                                                                   |
| [LC90] Subsets II                            | Recursion / Backtracking | Medium     | `O(2^N * N)`          | `O(N)`\*         | [LC90SubSetsSum2.java](./recursion/subsequencepatterns/LC90SubSetsSum2.java)                                                                 |
| [LC39] Combination Sum                       | Recursion / Backtracking | Medium     | `O(2^T)`              | `O(T)`           | [LC39CombinationSum.java](./recursion/subsequencepatterns/LC39CombinationSum.java)                                                           |
| [LC40] Combination Sum II                    | Recursion / Backtracking | Medium     | `O(2^N)`              | `O(N)`\*         | [LC40CombinationSum_2.java](./recursion/subsequencepatterns/LC40CombinationSum_2.java)                                                       |
| [LC216] Combination Sum III                  | Recursion / Backtracking | Medium     | `O(9! / (K!*(9-K)!))` | `O(K)`           | [LC216CombinationSum3.java](./recursion/subsequencepatterns/LC216CombinationSum3.java)                                                       |
| [LC17] Letter Combinations of a Phone Number | Recursion / Backtracking | Medium     | `O(4^N * N)`          | `O(N)`           | [LC17_LetterCombinations.java](./recursion/subsequencepatterns/LC17_LetterCombinations.java)                                                 |
| [LC22] Generate Parentheses                  | Recursion / Backtracking | Medium     | `O(4^N / sqrt(N))`    | `O(N)`           | [LC22GenerateParenthesis.java](./recursion/subsequencepatterns/LC22GenerateParenthesis.java)                                                 |

<br>

#### Hard Backtracking Problems

| Problem Name                    | Topic                  | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                          |
| :------------------------------ | :--------------------- | :--------- | :-------------- | :--------------- | :------------------------------------------------------------------------------------- |
| [LC51] N-Queens                 | Backtracking           | Hard       | `O(N!)`         | `O(N²)`          | [LC51NQueens.java](./recursion/hard/LC51NQueens.java)                                  |
| [LC131] Palindrome Partitioning | Backtracking / Strings | Medium     | `O(N · 2^N)`    | `O(N)`           | [LC131PalindromePartitioning.java](./recursion/hard/LC131PalindromePartiotioning.java) |
| [LC139] Word Break              | Backtracking + DP      | Medium     | `O(N^2 * M)`    | `O(N)`           | [LC139WordBreak.java](./recursion/hard/LC139WordBreak.java)                            |
| [GFG] Rat In A Maze             | Backtracking / Strings | Medium     | `O(3^(N ^ 2))`  | `O(N^2)`         | [GFG_RatInMaze.java](./recursion/hard/GFG_RatInMaze.java)                              |
| [LC37] Sudoku Solver            | Backtracking           | Hard       | `O(9^(N^2))`    | `O(N^2)`         | [LC37SudokuSolver](./recursion/hard/LC37SudokuSolver.java)                             |

---

### 7. Stack and Queue

#### Implementation

| Problem Name      | Topic        | Difficulty | Time Complexity | Space Complexity | Solution Link                                                        |
| :---------------- | :----------- | :--------- | :-------------- | :--------------- | :------------------------------------------------------------------- |
| Stack Using Array | Stack/Array  | Easy       | `O(1)`          | `O(N)`           | [StackUsingArray.java](./stack/implementation/StackUsingArray.java)  |
| Stack Using Queue | Stack /Queue | Easy       | `O(N)`          | `O(N)`           | [StackUsingQueue.java](./stack/implementation/StackUsingQueue.java)  |
| Queue Using Array | Queue /Array | Easy       | `O(1)`          | `O(N)`           | [QueueUsingArray.java](./queue/implementation/QueueUsingArray.class) |

<br>

#### Easy

| Problem Name             | Topic | Difficulty | Time Complexity | Space Complexity | Solution Link                                                  |
| :----------------------- | :---- | :--------- | :-------------- | :--------------- | :------------------------------------------------------------- |
| [LC20] Valid Parentheses | Stack | Easy       | `O(N)`          | `O(N)`           | [LC20ValidParentheses.java](./stack/LC20ValidParentheses.java) |
| [LC155] MinStack         | Stack | Medium     | `O(1)`          | `O(N)`           | [LC155MinStack.java.java](./stack/LC155MinStack.java)          |

<br>

#### Monotonic Stack

| Problem Name                                         | Topic                            | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                                                   |
| :--------------------------------------------------- | :------------------------------- | :--------- | :-------------- | :--------------- | :------------------------------------------------------------------------------------------------------------------------------ |
| [GFG] Next Smaller Element                           | Stack / Monotonic Stack          | Easy       | `O(N)`          | `O(N)`           | [GFG_NextSmallerElement.java](./stack/monotonicstack/GFG_NextSmallerElement.java)                                               |
| [LC42] Trapping Rain Water                           | Stack / Monotonic Stack          | Hard       | `O(N)`          | `O(N)`           | [LC42TrappingRainWater.java](./stack/monotonicstack/LC42TrappingRainWater.java)                                                 |
| [LC496] Next Greater Element I                       | Stack / Monotonic Stack          | Easy       | `O(N + M)`      | `O(M)`           | [LC496NextGreterElement.java](./stack/monotonicstack/LC496NextGreterElement.java)                                               |
| [LC503] Next Greater Element II                      | Stack / Monotonic Stack          | Medium     | `O(N)`          | `O(N)`           | [LC503NextGreterElement2.java](./stack/monotonicstack/LC503NextGreterElement2.java)                                             |
| [LC907] Sum of Subarray Minimums                     | Stack / Monotonic Stack          | Medium     | `O(N)`          | `O(N)`           | [LC907SumOfSubArrayMinimums.java](./stack/monotonicstack/LC907SumOfSubArrayMinimums.java)                                       |
| [LC735] Asteroid Collisions                          | Stack / Monotonic Stack          | Medium     | `O(N)`          | `O(N)`           | [LC735AsteroidCollisions.java](./stack/monotonicstack/LC735AsteroidCollisions.java)                                             |
| [LC2104] Sum of Subarray Ranges                      | Stack / Monotonic Stack          | Medium     | `O(N)`          | `O(N)`           | [LC2104SumOFSubArrayRange.java](./stack/monotonicstack/LC2104SumOFSubArrayRange.java)                                           |
| [LC402] Remove K degits                              | Stack / Monotonic Stack / String | Medium     | `O(N)`          | `O(N)`           | [LC402RemoveKDigits.java](./stack/monotonicstack/LC402RemoveKDigits.java)                                                       |
| [LC84] Largest Area Histogram                        | Stack / Monotonic Stack          | Hard       | `O(N)`          | `O(N)`           | [LC84LargestReactangeAreaHistogram.java](./stack/monotonicstack/LC84LargestReactangleAreaHistogram.java)                        |
| [LC85] Maximal Rectangle Area                        | Stack / Monotonic Stack / Matrix | Hard       | `O(N * M)`      | `O(M)`           | [LC85MaximalAreaRectangle.java](./stack/monotonicstack/LC85MaximalAreaRectangle.java)                                           |
| [LC1081] Smallest Subsequence of Distinct Characters | Stack + Monotonic Stack + Greedy | Medium     | `O(n)`          | `O(1)`           | [LC1081SmallestSubsequenceOfDistinctCharacters.java](./stack/monotonicstack/LC1081SmallestSubsequenceOfDistinctCharacters.java) |

#### Queue hard problem

| Problem Name                   | Topic           | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                 |
| :----------------------------- | :-------------- | :--------- | :-------------- | :--------------- | :---------------------------------------------------------------------------- |
| [LC239] Sliding Window Maximum | Monotonic Deque | Hard       | `O(N)`          | `O(K)`           | [LC239SlidingWindowMaximum.java](./queue/hard/LC239SlidingWindowMaximum.java) |

#### Stack hard problems

| Problem Name                | Topic           | Difficulty | Time Complexity | Space Complexity | Solution Link                                                             |
| :-------------------------- | :-------------- | :--------- | :-------------- | :--------------- | :------------------------------------------------------------------------ |
| [LC901] Online Stock Span   | Monotonic Stack | Medium     | `O(1)` amort.   | `O(N)`           | [LC901StockSpanner.java](./stack/hard/LC901StockSpanner.java)             |
| [GFG] The Celebrity Problem | Monotonic Stack | Medium     | `O(N*N)` amort. | `O(N)`           | [GFG_TheCelebrityProblem.java](./stack/hard/GFG_TheCelebrityProblem.java) |

---

### 8. Design Problems

#### LRU cache

| Problem Name      | Topic         | Difficulty | Time Complexity | Space Complexity | Solution Link                                     |
| :---------------- | :------------ | :--------- | :-------------- | :--------------- | :------------------------------------------------ |
| [LC146] LRU cache | DLL / HashMap | Medium     | `O(1)` amort.   | `O(N)`           | [LC146LRUCache.java](./design/LC146LRUCache.java) |

---

### 9. Sliding Window and Two Pointer

#### Medium Problems

| Problem Name                                                  | Topic          | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                                                                 |
| :------------------------------------------------------------ | :------------- | :--------- | :-------------- | :--------------- | :-------------------------------------------------------------------------------------------------------------------------------------------- |
| [LC3] Longest Substring Without Repeating Characters          | Sliding Window | Medium     | `O(N)`          | `O(1)`           | [LC3LongestSubstringWithoutRepeatingCharacters.java](./slidingwindow/medium/LC3LongestSubstringWithoutRepeatingCharacters.java)               |
| [LC1004] Max Consecutive Ones III                             | Sliding Window | Medium     | `O(N)`          | `O(1)`           | [LC1004MaxConsecutiveOnesIII.java](./slidingwindow/medium/LC1004MaxConsecutiveOnesIII.java)                                                   |
| [LC904] Fruit Into Baskets                                    | Sliding Window | Medium     | `O(N)`          | `O(1)`           | [LC904FruitIntoBaskets.java](./slidingwindow/medium/LC904FruitIntoBaskets.java)                                                               |
| [LC424] Longest Repeating Character Replacement               | Sliding Window | Medium     | `O(N)`          | `O(1)`           | [LC424LongestRepeatingCharacterReplacement.java](./slidingwindow/medium/LC424LongestRepeatingCharacterReplacement.java)                       |
| [LC930] Binary Subarrays With Sum                             | Sliding Window | Medium     | `O(N)`          | `O(1)`           | [LC930BinarySubarraysWithSum.java](./slidingwindow/medium/LC930BinarySubarraysWithSum.java)                                                   |
| [LC1248] Count Number of Nice Subarrays                       | Sliding Window | Medium     | `O(N)`          | `O(1)`           | [LC1248CountNumberOfNiceSubarrays.java](./slidingwindow/medium/LC1248CountNumberOfNiceSubarrays.java)                                         |
| [LC1358] Number of Substrings Containing All Three Characters | Sliding Window | Medium     | `O(N)`          | `O(1)`           | [LC1358NumberOfSubstringsContainingAllThreeCharacters.java](./slidingwindow/medium/LC1358NumberOfSubstringsContainingAllThreeCharacters.java) |
| [LC1423] Maximum Points You Can Obtain From Cards             | Sliding Window | Medium     | `O(N)`          | `O(1)`           | [LC1423MaxPointsFromCards.java](./slidingwindow/medium/LC1423MaxPointsFromCards.java)                                                         |

<br>

#### Hard Problems

| Problem Name                                | Topic          | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                             |
| :------------------------------------------ | :------------- | :--------- | :-------------- | :--------------- | :-------------------------------------------------------------------------------------------------------- |
| [GFG] Longest Substring with K Uniques      | Sliding Window | Medium     | `O(N)`          | `O(1)`           | [GFG_LongestSubstringWithKUniques.java](./slidingwindow/hard/GFG_LongestSubstringWithKUniques.java)       |
| [LC992] Subarrays with K Different Integers | Sliding Window | Hard       | `O(N)`          | `O(N)`           | [LC992SubarraysWithKDistinctIntegers.java](./slidingwindow/hard/LC992SubarraysWithKDistinctIntegers.java) |
| [LC76 ] Minimum Window Substring            | Sliding Window | Hard       | `O(N + M)`      | `O(1)`           | [LC76MinimumWindowSubstring.java](./slidingwindow/hard/LC76MinimumWindowSubstring.java)                   |

---

### 10. Heaps

#### Medium Problems Heaps

| Problem Name                             | Topic | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                |
| ---------------------------------------- | ----- | ---------- | --------------- | ---------------- | ---------------------------------------------------------------------------- |
| [LC215] Kth Smallest Element in an Array | Heap  | Medium     | `O(n log k)`    | ``O(k)`          | [BASIC] [FindKthSmallest.java](./heap/medium/Basic_KthSmallestElement.java)  |
| [LC215] Kth Largest Element in an Array  | Heap  | Medium     | `O(n log k)`    | `O(k)`           | [LC215FindKthLargest.java](./heap/medium/LC215FindKthLargest.java)           |
| [LC215] Merge K Sorted Lists             | Heap  | Medium     | `O(n log k)`    | `O(k)`           | [LC215FindKthLargest.java](./heap/medium/LC23MergeKSortedLists.java)         |
| [LC1331] Array Rank Transform            | Heap  | Medium     | `O(N log N)`    | `O(N)`           | [LC1331ArrayRankTransform.java](./heap/medium/LC1331RankTransformArray.java) |
| [LC846] Hand of Straights                | Heap  | Medium     | `O(N² / k)`     | `O(N)`           | [LC846IsNStraightHand.java](./heap/medium/LC846HandOfStraights.java)         |

<br>

#### Hard Problems Heap

| Problem Name                            | Topic                 | Difficulty | Time Complexity         | Space Complexity | Solution Link                                                                |
| --------------------------------------- | --------------------- | ---------- | ----------------------- | ---------------- | ---------------------------------------------------------------------------- |
| [GFG] Minimum Cost to Connect Ropes     | Greedy / Heap         | Hard       | `O(n log n)`            | `O(n)`           | [GFG_MinCostToConnectRopes.java](./heap/hard/GFG_MinCostToConnectRopes.java) |
| [LC703] Kth Largest Element in a Stream | Heap / Priority Queue | Easy       | `O(n log k) / O(log k)` | `O(k)`           | [LC703KthLargest.java](./heap/hard/LC703KthLargest.java)                     |
| [GFG] Maximum Sum Combination           | Heap / Priority Queue | Medium     | `O(n² log k)`           | `O(k)`           | [GFG_MaximumSumCombination.java](./heap/hard/GFG_MaximumSumCombination.java) |
| [LC658] Find K Closest Elements         | Heap / Priority Queue | Medium     | `O(log n + k log k)`    | `O(k)`           | [LC658FindKClosestElements.java](./heap/hard/LC658FindKClosestElements.java) |
| [LC347] Top K Frequent Elements         | Heap / Priority Queue | Medium     | `O(n log k)`            | `O(n)`           | [LC347TopKFrequentElements.java](./heap/hard/LC347TopKFrequentElements.java) |

---

### 11. Tree

#### Traversal

| Problem Name          | Topic    | Difficulty | Time Complexity | Space Complexity | Solution Link                                                         |
| :-------------------- | :------- | :--------- | :-------------- | :--------------- | :-------------------------------------------------------------------- |
| Level Order Traversal | Tree/BFS | Easy       | `O(N)`          | `O(N)`           | [LevelOrderTraversal.java](./tree/traversal/LevelOrderTraversal.java) |
| Inorder Traversal     | Tree/DFS | Easy       | `O(N)`          | `O(H)`           | [InorderTraversal.java](./tree/traversal/InorderTraversal.java)       |
| Inorder Traversal     | Tree/DFS | Easy       | `O(N)`          | `O(H)`           | [InorderTraversal.java](./tree/traversal/InorderTraversal.java)       |
| Preorder Traversal    | Tree/DFS | Easy       | `O(N)`          | `O(H)`           | [PreorderTraversal.java](./tree/traversal/PreorderTraversal.java)     |

<br>

#### Binary Tree Medium Problems

| Problem Name                                      | Topic | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                          |
| :------------------------------------------------ | :---- | :--------- | :-------------- | :--------------- | :------------------------------------------------------------------------------------- |
| [LC104] MaximumDepthOfBinaryTree                  | Tree  | Easy       | `O(n)`          | `O(h)`           | [LC104MaximumDepthOfBinaryTree](./tree/medium/LC104MaximumDepthOfBinaryTree.java)      |
| [LC110] Balanced Binary Tree                      | Tree  | Easy       | `O(n)`          | `O(h)`           | [LC110BalancedBinaryTree.java](./tree/medium/LC110BalancedBinaryTree.java)             |
| [LC543] Diameter of Binary Tree                   | Tree  | Easy       | `O(n)`          | `O(h)`           | [LC543DiameterOfBinaryTree.java](./tree/medium/LC543DiameterOfBinaryTree.java)         |
| [LC124] Binary Tree Maximum Path Sum              | Tree  | Hard       | `O(n)`          | `O(h)`           | [LC124BinaryTreeMaximumPathSum.java](./tree/medium/LC124BinaryTreeMaximumPathSum.java) |
| [LC100] Same Tree                                 | Trees | Easy       | `O(n)`          | `O(h)`           | [LC100SameTree.java](./tree/medium/LC100SameTree.java)                                 |
| [LC103] Binary Tree Zigzag Level Order Traversal  | Trees | Medium     | `O(n)`          | `O(n)`           | [LC103ZigzagLevelOrder.java](./tree/medium/LC103ZigzagLevelOrder.java)                 |
| [GFG] Boundary Traversal of Binary Tree           | Trees | Medium     | `O(n)`          | `O(n)`           | [GFG_BoundaryTraversal.java](./tree/medium/GFG_BoundaryTraversal.java)                 |
| [LC987] Vertical Order Traversal of a Binary Tree | Trees | Hard       | `O(n log n)`    | `O(n)`           | [LC987VerticalOrderTraversal.java](./tree/medium/LC987VerticalOrderTraversal.java)     |
| [LC101] Symmetric Tree                            | Trees | Easy       | `O(N)`          | `O(H)`           | [LC101SymmetricTree.java](./tree/medium/LC101SymmetricTree.java)                       |

<br>

#### Binary Tree Views

| Problem Name                        | Topic | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                      |
| :---------------------------------- | :---- | :--------- | :-------------- | :--------------- | :--------------------------------------------------------------------------------- |
| [GFG] Top View of Binary Tree       | Trees | Medium     | `O(N log N)`    | `O(N)`           | [GFG_TopViewOfBinaryTree.java](./tree/view/GFG_TopViewOfBinaryTree.java)           |
| [GFG] Bottom View of Binary Tree    | Trees | Medium     | `O(N log N)`    | `O(N)`           | [GFG_BottomViewOfBinaryTree.java](./tree/view/GFG_BottomViewOfBinaryTree.java)     |
| [LC199] Binary Tree Right Side View | Trees | Medium     | `O(N)`          | `O(H)`           | [LC199BinaryTreeRightSideView.java](./tree/view/LC199BinaryTreeRightSideView.java) |

<br>

#### Binary Tree hard problems

| Problem Name                                                       | Topic       | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                                |
| :----------------------------------------------------------------- | :---------- | :--------- | :-------------- | :--------------- | :----------------------------------------------------------------------------------------------------------- |
| [LC257] Binary Tree Paths                                          | Trees       | Easy       | `O(N * H)`      | `O(H)`           | [LC257BinaryTreePaths.java](./tree/hard/LC257BinaryTreePaths.java)                                           |
| [LC236] Lowest Common Ancestor of a Binary Tree                    | Trees       | Medium     | `O(N)`          | `O(H)`           | [LC236LowestCommonAncestor.java](./tree/hard/LC236LowestCommonAncestor.java)                                 |
| [LC662] Maximum Width of Binary Tree                               | Trees + BFS | Medium     | `O(N)`          | `O(W)`           | [LC662MaximumWidthOfBinaryTree.java](./tree/hard/LC662MaximumWidthOfBinaryTree.java)                         |
| [GFG] Children Sum Property                                        | Tree        | Hard       | `O(n)`          | `O(h)`           | [GFG_ChildrenSumProperty.java](./tree/hard/GFG_ChildrenSumProperty.java)                                     |
| [LC863] All Nodes Distance K in Binary Tree                        | Tree        | Hard       | `O(n)`          | `O(n)`           | [LC863AllNodesDistanceK.java](./tree/hard/LC863AllNodesDistanceK.java)                                       |
| [GFG] Burning Tree                                                 | Tree        | Hard       | `O(n)`          | `O(n)`           | [GFG_BurningTree.java](./tree/hard/GFG_BurningTree.java)                                                     |
| [LC222] Count Complete Tree Nodes                                  | Binary Tree | Medium     | `O(log²n)`      | `O(log n)`       | [LC222CountCompleteTreeNodes.java](./tree/hard/LC222CountCompleteTreeNodes.java)                             |
| [GFG] Unique Binary Tree Requirements                              | Binary Tree | Easy       | `O(1)`          | `O(1)`           | [GFG_UniqueBinaryTreeRequirements.java](./tree/hard/GFG_UniqueBinaryTreeRequirements.java)                   |
| [LC105] Construct Binary Tree from Preorder and Inorder Traversal  | Binary Tree | Medium     | `O(n)`          | `O(n)`           | [LC105ConstructTreeFromPreorderInorder.java](./tree/hard/LC105ConstructBinaryTreeFromPreorderInorder.java)   |
| [LC106] Construct Binary Tree from Postorder and Inorder Traversal | Binary Tree | Medium     | `O(n)`          | `O(n)`           | [LC106ConstructTreeFromPostorderInorder.java](./tree/hard/LC106ConstructBinaryTreeFromInorderPostorder.java) |
| [LC114] Flatten Binary Tree to Linked List                         | Trees       | Medium     | `O(n)`          | `O(h)`           | [LC114FlattenBinaryTreeToLinkedList.java](./tree/hard/LC114FlattenBinaryTreeToLinkedList.java)               |
| [LC94] Morris Inorder Traversal                                    | Trees       | Easy       | `O(n)`          | `O(1)`           | [LC94BinaryTreeInorderMorrisTraversal.java](./tree/hard/LC94BinaryTreeInorderMorrisTraversal.java)           |
| [LC144] Morris Preorder Traversal                                  | Trees       | Easy       | `O(n)`          | `O(1)`           | [LC144BinaryTreeMorrisPreorderTraversal.java](./tree/hard/LC144BinaryTreeMorrisPreorderTraversal.java)       |

---

### 12. Binary Search Tree

#### Easy

| Problem Name                | Topic | Difficulty | Time Complexity | Space Complexity | Solution Link                                                       |
| :-------------------------- | :---- | :--------- | :-------------- | :--------------- | :------------------------------------------------------------------ |
| [LC700] Search in a BST     | BST   | Easy       | `O(h)`          | `O(1)`           | [LC700SearchInABST.java](./bst/easy/LC700SearchInABST.java)         |
| [GFG] Floor and Ceil in BST | BST   | Medium     | `O(h)`          | `O(1)`           | [GFG_FloorAndCeilInBST.java](./bst/easy/GFG_FloorAndCeilInBST.java) |

<br>

#### Binary serach Tree Medium problems

| Problem Name                                   | Topic                       | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                             |
| :--------------------------------------------- | :-------------------------- | :--------- | :-------------- | :--------------- | :-------------------------------------------------------------------------------------------------------- |
| [LC701] Insert into a BST                      | BST                         | Medium     | `O(h)`          | `O(1)`           | [LC701InsertIntoBST.java](./bst/medium/LC701InsertIntoBST.java)                                           |
| [LC450] Delete Node in a BST                   | BST                         | Medium     | `O(h)`          | `O(h)`           | [LC450DeleteNodeInBST.java](./bst/medium/LC450DeleteNodeInBST.java)                                       |
| [LC230] Kth Smallest Element in a BST          | BST                         | Medium     | `O(h + k)`      | `O(h)`           | [LC230KthSmallestElementInBST.java](./bst/medium/LC230KthSmallestElementInBST.java)                       |
| [LC98] Validate Binary Search Tree             | Trees                       | Medium     | `O(n)`          | `O(h)`           | [LC98ValidateBinarySearchTree.java](./bst/medium/LC98ValidateBinarySearchTree.java)                       |
| [LC235] Lowest Common Ancestor of a BST        | Trees                       | Medium     | `O(h)`          | `O(h)`           | [LC235LowestCommonAncestorOfBST.java](./bst/medium/LC235LowestCommonAncestorOfBST.java)                   |
| [LC1008] Construct BST from Preorder Traversal | Trees                       | Medium     | `O(n)`          | `O(h)`           | [LC1008ConstructBSTFromPreorderTraversal.java](./bst/medium/LC1008ConstructBSTFromPreorderTraversal.java) |
| [GFG] Predecessor and Successor in BST         | Trees                       | Medium     | `O(h)`          | `O(1)`           | [GFG_PredecessorAndSuccessor.java](./bst/medium/GFG_PredecessorAndSuccessor.java)                         |
| [LC1373] Maximum Sum BST in Binary Tree        | Trees + DFS                 | Hard       | `O(n)`          | `O(h)`           | [LC1373MaxSumBSTInBinaryTree.java](./bst/hard/LC1373MaxSumBSTInBinaryTree.java)                           |
| [GFG] Merge Two BSTs                           | Trees + Two-Stack Traversal | Medium     | `O(m + n)`      | `O(h1 + h2)`     | [GFG_MergeTwoBSTs.java](./bst/hard/GFG_MergeTwoBSTs.java)                                                 |

---

### 13. Graphs

#### Dfs Based Graphs problems

| Problem Name                                                   | Topic        | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                                                      |
| :------------------------------------------------------------- | :----------- | :--------- | :-------------- | :--------------- | :--------------------------------------------------------------------------------------------------------------------------------- |
| [LC547] Number of Provinces                                    | Graphs       | Medium     | `O(n²)`         | `O(n)`           | [LC547NumberOfProvinces.java](./graph/dfs/LC547NumberOfProvinces.java)                                                             |
| [LC200] Number of Islands                                      | Graphs + DFS | Medium     | `O(m * n)`      | `O(m * n)`       | [LC200NumberOfIslands.java](./graph/dfs/LC200NumberOfIslands.java)                                                                 |
| [GFG] Directed Graph Cycle Detection                           | Graphs + DFS | Medium     | `O(V + E)`      | `O(V)`           | [GFG_DirectedGraphCycleDetection.java](./graph/dfs/GFG_DirectedGraphCycleDetection.java)                                           |
| [LC2685] Number of Connected Components in an Undirected Graph | Graph - DFS  | Medium     | `O(n + e)`      | `O(n + e)`       | [LC2685NumberOfConnectedComponentsInAnUndirectedGraph.java](./graph/dfs/LC2685NumberOfConnectedComponentsInAnUndirectedGraph.java) |

<br>

#### Bfs Based Graphs problems

| Problem Name                | Topic                    | Difficulty | Time Complexity | Space Complexity | Solution Link                                                          |
| :-------------------------- | :----------------------- | :--------- | :-------------- | :--------------- | :--------------------------------------------------------------------- |
| [LC994] Rotting Oranges     | Graphs                   | Medium     | `O(m × n)`      | `O(m × n)`       | [LC994RottingOranges.java](./graph/bfs/LC994RottingOranges.java)       |
| [LC733] Flood Fill          | Graphs                   | Easy       | `O(m × n)`      | `O(m × n)`       | [LC733FloodFill.java](./graph/bfs/LC733FloodFill.java)                 |
| [LC130] Surrounded Regions  | Graph / BFS              | Medium     | `O(m * n)`      | `O(m * n)`       | [LC130SurroundedRegions.java](./graph/bfs/LC130SurroundedRegions.java) |
| [LC542] 01 Matrix           | Graph / Multi-source BFS | Medium     | `O(m * n)`      | `O(m * n)`       | [LC542ZeroOneMatrix.java](./graph/bfs/LC542ZeroOneMatrix.java)         |
| [LC1020] Number of Enclaves | Graphs + BFS             | Medium     | `O(m * n)`      | `O(m * n)`       | [LC1020NumberOfEnclaves.java](./graph/bfs/LC1020NumberOfEnclaves.java) |
| [LC127] Word Ladder         | Graphs + BFS             | Hard       | `O(m * n)`      | `O(n)`           | [LC127WordLadder.java](./graph/bfs/LC127WordLadder.java)               |

<br>

#### Undirected Graphs problems

| Problem Name                                        | Topic                          | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                                       |
| :-------------------------------------------------- | :----------------------------- | :--------- | :-------------- | :--------------- | :------------------------------------------------------------------------------------------------------------------ |
| [GFG] Cycle Detection in Undirected Graph (BFS)     | Graph / BFS                    | Medium     | `O(V + E)`      | `O(V + E)`       | [GFG_CycleDetectionBFS.java](./graph/undirected/GFG_CycleDetectionBFS.java)                                         |
| [GFG] Cycle Detection in Undirected Graph (DFS)     | Graph / DFS                    | Medium     | `O(V + E)`      | `O(V + E)`       | [GFG_CycleDetectionDFS.java](./graph/undirected/GFG_CycleDetectionDFS.java)                                         |
| [LC2492] Minimum Score of a Path Between Two Cities | Graphs (Undirected, Traversal) | Medium     | `O(V + E)`      | `O(V + E)`       | [LC2492MinimumScoreOfAPathBetweenTwoCities.java](./graph/undirected/LC2492MinimumScoreOfAPathBetweenTwoCities.java) |

<br>

#### Topological Sort Based Graph problems

| Problem Name                                      | Topic                          | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                        |
| :------------------------------------------------ | :----------------------------- | :--------- | :-------------- | :--------------- | :--------------------------------------------------------------------------------------------------- |
| [LC207] Course Schedule                           | Graphs + Topological Sort      | Medium     | `O(V + E)`      | `O(V + E)`       | [LC207CourseSchedule.java](./graph/topologicalsort/LC207CourseSchedule.java)                         |
| [LC210] Course Schedule II (Kahn's Algorithm)     | Graph + BFS + Topological Sort | Medium     | `O(V + E)`      | `O(V + E)`       | [LC210CourseScheduleII.java](./graph/topologicalsort/LC210CourseScheduleII.java)                     |
| [LC210] Course Schedule II (DFS Topological Sort) | Graph + DFS + Topological Sort | Medium     | `O(V + E)`      | `O(V + E)`       | [LC210CourseScheduleII.java](./graph/topologicalsort/LC210CourseScheduleII.java)                     |
| [LC802] Find Eventual Safe States                 | Graphs + DFS + Cycle Detection | Medium     | `O(V + E)`      | `O(V + E)`       | [LC802FindEventualSafeStates.java](./graph/topologicalsort/LC802FindEventualSafeStates.java)         |
| [LC269] Foreign Dictionary                        | Graphs + Topological Sort      | Hard       | `O(N * L)`      | `O(E)`           | [LC269ForeignDictionary.java](./graph/topologicalsort/LC269ForeignDictionary.java)                   |
| [LC1301] Number of Paths With Max Score           | Graphs + Topological Sort + DP | Hard       | `O(n²)`         | `O(n²)`          | [LC1301NumberOfPathsWithMaxScore.java](./graph/topologicalsort/LC1301NumberOfPathsWithMaxScore.java) |

<br>

#### Shortest path

| Problem Name                                     | Topic                                 | Difficulty | Time Complexity                       | Space Complexity | Solution Link                                                                                                     |
| :----------------------------------------------- | :------------------------------------ | :--------- | :------------------------------------ | :--------------- | :---------------------------------------------------------------------------------------------------------------- |
| [GFG] Shortest Path in Undirected Graph          | Graphs / BFS                          | Easy       | `O(V + E)`                            | `O(V + E)`       | [GFG_ShortestPathUndirectedGraph.java](./graph/shortestpath/GFG_ShortestPathUndirectedGraph.java)                 |
| [GFG] Shortest Path in DAG                       | Graphs / Dijkstra                     | Medium     | `O((V + E) log V)`                    | `O(V + E)`       | [GFG_ShortestPathDAG.java](./graph/shortestpath/GFG_ShortestPathDAG.java)                                         |
| [LC1091] Shortest Path in Binary Matrix          | Graphs / BFS                          | Medium     | `O(n²)`                               | `O(n²)`          | [LC1091ShortestPathBinaryMatrix.java](./graph/shortestpath/LC1091ShortestPathBinaryMatrix.java)                   |
| [LC1631] Path With Minimum Effort                | Graphs / Dijkstra                     | Medium     | `O(n² log n²)`                        | `O(n²)`          | [LC1631PathWithMinimumEffort.java](./graph/shortestpath/LC1631PathWithMinimumEffort.java)                         |
| [LC787] Cheapest Flights Within K Stops          | Graphs + BFS                          | Medium     | `O(E + V + E * K)`                    | `O(E + V)`       | [LC787CheapestFlightsWithinKStops.java](./graph/shortestpath/LC787CheapestFlightsWithinKStops.java)               |
| [LC743] Network Delay Time                       | Graphs + Dijkstra                     | Medium     | `O((V + E) log V)`                    | `O(V + E)`       | [LC743NetworkDelayTime.java](./graph/shortestpath/LC743NetworkDelayTime.java)                                     |
| [LC1976] Number of Ways to Arrive at Destination | Graphs + Dijkstra                     | Medium     | `O((V + E) log V)`                    | `O(V + E)`       | [LC1976NumberOfWaysToArriveAtDestination.java](./graph/shortestpath/LC1976NumberOfWaysToArriveAtDestination.java) |
| [LC2812] Find the Safest Path in a Grid          | Graphs + Multi-Source BFS + Dijkstra  | Medium     | `O(n² log n)`                         | `O(n²)`          | [LC2812FindTheSafestPathInAGrid.java](./graph/shortestpath/LC2812FindTheSafestPathInAGrid.java)                   |
| [LC3286] Find a Safe Walk Through a Grid         | Graph + BFS + Dijkstra                | Medium     | `O(m * n * log(m * n))`               | `O(m * n)`       | [LC3286FindASafeWalkThroughAGrid.java](./graph/shortestpath/LC3286FindASafeWalkThroughAGrid.java)                 |
| [LC3620] Network Recovery Pathways               | Graph + Shortest Path + Binary Search | Hard       | `O(E log E + log(E) × (V + E) log V)` | `O(V + E)`       | [LC3620NetworkRecoveryPathways.java](./graph/shortestpath/LC3620NetworkRecoveryPathways.java)                     |
| [LC3534] Path Existence Queries in a Graph II    | Graphs + DisjointSet                  | Hard       | `O(n^2)`                              | `O(n^2)`         | [LC3534PathExistenceQueriesInAGraphII.java](./graph/shortestpath/LC3534PathExistenceQueriesInAGraphII.java)       |

<br>

#### Minimum Spanning Tree

| Problem Name                | Topic                           | Difficulty | Time Complexity | Space Complexity | Solution Link                                                   |
| :-------------------------- | :------------------------------ | :--------- | :-------------- | :--------------- | :-------------------------------------------------------------- |
| [GFG] Minimum Spanning Tree | Graphs + MST + Prim's Algorithm | Medium     | `O(E log E)`    | `O(E)`           | [GFG_MinimumSpanningTree.java](./graph/mst/PrimsAlgorithm.java) |

<br>

#### Disjoint Set Union

| Problem Name                                            | Topic                | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                                                  |
| :------------------------------------------------------ | :------------------- | :--------- | :-------------- | :--------------- | :----------------------------------------------------------------------------------------------------------------------------- |
| Disjoint Set Union (Union Find)                         | Graphs + DSU         | Utility    | `O(α(N))`       | `O(N)`           | [DisjointSet.java](./graph/disjointset/DisjointSet.java)                                                                       |
| [LC947] Remove Most Stones                              | Graph + Disjoint Set | Medium     | `O(n)`          | `O(n)`           | [LC947RemoveMostStones.java](./graph/disjointset/LC947RemoveMostStones.java)                                                   |
| [LC1319] Number of Operations to Make Network Connected | Graph + Disjoint Set | Medium     | `O(e)`          | `O(n)`           | [LC1319NumberOfOperationsToMakeNetworkConnected.java](./graph/disjointset/LC1319NumberOfOperationsToMakeNetworkConnected.java) |
| [LC721] Accounts Merge                                  | Graphs + DSU         | Medium     | `O(n·k·α(n))`   | `O(n·k)`         | [LC721AccountsMerge.java](./graph/disjointset/LC721AccountsMerge.java)                                                         |
| [LC778] Swim in Rising Water                            | Graphs + DSU         | Hard       | `O(n²·α(n²))`   | `O(n²)`          | [LC778SwimInRisingWater.java](./graph/disjointset/LC778SwimInRisingWater.java)                                                 |
| [LC3532] Path Existence Queries in a Graph I            | Graphs (DSU)         | Medium     | `O(n + q)`      | `O(n)`           | [LC3532PathExistenceQueriesInAGraphI.java](./graph/disjointset/LC3532PathExistenceQueriesInAGraphI.java)                       |

---

### 14. Dynamic Programming

#### 1D DP

| Problem Name            | Topic | Difficulty | Time Complexity | Space Complexity | Solution Link                                                  |
| :---------------------- | :---- | :--------- | :-------------- | :--------------- | :------------------------------------------------------------- |
| [LC70] Climbing Stairs  | 1D DP | Easy       | `O(n)`          | `O(1)`           | [LC70ClimbingStairs.java](./dp/basics/LC70ClimbingStairs.java) |
| [LC198] House Robber    | 1D DP | Medium     | `O(n)`          | `O(1)`           | [LC198HouseRobber.java](./dp/basics/LC198HouseRobber.java)     |
| [LC213] House Robber II | 1D DP | Medium     | `O(n)`          | `O(1)`           | [LC213HouseRobberII.java](./dp/basics/LC213HouseRobberII.java) |

<br>

#### DP on Grids

| Problem Name            | Topic      | Difficulty | Time Complexity | Space Complexity | Solution Link                                                 |
| :---------------------- | :--------- | :--------- | :-------------- | :--------------- | :------------------------------------------------------------ |
| [LC62] Unique Paths     | DP + Grids | Medium     | `O(m * n)`      | `O(n)`           | [LC62UniquePaths.java](./dp/grids/LC62UniquePaths.java)       |
| [LC63] Unique Paths II  | DP + Grids | Medium     | `O(m * n)`      | `O(n)`           | [LC63UniquePathsII.java](./dp/grids/LC63UniquePathsII.java)   |
| [LC64] Minimum Path Sum | DP + Grids | Medium     | `O(m * n)`      | `O(n)`           | [LC64MinimumPathSum.java](./dp/grids/LC64MinimumPathSum.java) |
| [LC120] Triangle        | DP + Grids | Medium     | `O(n^2)`        | `O(n)`           | [LC120Triangle.java](./dp/grids/LC120Triangle.java)           |

<br>

#### DP on Subsequences

| Problem Name                                            | Topic                                 | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                                             |
| :------------------------------------------------------ | :------------------------------------ | :--------- | :-------------- | :--------------- | :------------------------------------------------------------------------------------------------------------------------ |
| [GFG] Subset Sum Equal Target                           | DP + Subsequence                      | Medium     | `O(n * sum)`    | `O(sum)`         | [GFG_SubsetSumEqualTarget.java](./dp/subsequence/GFG_SubsetSumEqualTarget.java)                                           |
| [LC416] Partition Equal Subset Sum                      | DP + Subsequence                      | Medium     | `O(n * sum)`    | `O(sum)`         | [LC416PartitionEqualSubsetSum.java](./dp/subsequence/LC416PartitionEqualSubsetSum.java)                                   |
| [GFG] Count Subsets with Given Sum                      | DP / Subsequences                     | Medium     | `O(n * target)` | `O(target)`      | [GFG_CountSubsetsWithGivenSum.java](./dp/subsequence/GFG_CountSubsetsWithGivenSum.java)                                   |
| [GFG] Count Partitions with Given Difference            | DP / Subsequences                     | Medium     | `O(n * target)` | `O(target)`      | [GFG_CountPartitionsWithGivenDifference.java](./dp/subsequence/GFG_CountPartitionsWithGivenDifference.java)               |
| [LC494] Target Sum                                      | DP / Subsequences                     | Medium     | `O(n * target)` | `O(target)`      | [LC494TargetSum.java](./dp/subsequence/LC494TargetSum.java)                                                               |
| [LC3336] Find the Number of Subsequences With Equal GCD | DP + Subsequences + GCD + Memoization | Hard       | `O(N × M²)`     | `O(N × M²)`      | [LC3336FindTheNumberOfSubsequencesWithEqualGCD.java](./dp/subsequence/LC3336FindTheNumberOfSubsequencesWithEqualGCD.java) |

<br>

#### DP on Unbounded Knapsack

| Problem Name             | Topic                   | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                         |
| :----------------------- | :---------------------- | :--------- | :-------------- | :--------------- | :------------------------------------------------------------------------------------ |
| [LC322] Coin Change      | DP / Unbounded Knapsack | Medium     | `O(n * amount)` | `O(amount)`      | [LC322CoinChange.java](./dp/unbounded_knapsack/LC322CoinChange.java)                  |
| [LC518] Coin Change II   | DP / Unbounded Knapsack | Medium     | `O(n * amount)` | `O(amount)`      | [LC518CoinChangeII.java](./dp/unbounded_knapsack/LC518CoinChangeII.java)              |
| [GFG] Unbounded Knapsack | Dynamic Programming     | Medium     | `O(N * W)`      | `O(W)`           | [GFG_UnboundedKnapsack.java](./dynamic-programming/medium/GFG_UnboundedKnapsack.java) |

<br>

#### DP On Longest Common Subsequences

| Problem Name                                                 | Topic                     | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                                               |
| :----------------------------------------------------------- | :------------------------ | :--------- | :-------------- | :--------------- | :-------------------------------------------------------------------------------------------------------------------------- |
| [LC1143] Longest Common Subsequence                          | DP + LCS                  | Medium     | `O(n*m)`        | `O(m)`           | [LC1143LongestCommonSubsequence.java](./dp/lcs/LC1143LongestCommonSubsequence.java)                                         |
| Print Longest Common Subsequence                             | DP + LCS                  | Medium     | `O(n*m)`        | `O(n*m)`         | [PrintLongestCommonSubsequence.java](./dp/lcs/PrintLongestCommonSubsequence.java)                                           |
| [GFG] Longest Common Substring                               | Dynamic Programming       | Medium     | `O(n * m)`      | `O(m)`           | [GFG_LongestCommonSubstring.java](./dp/lcs/GFG_LongestCommonSubstring.java)                                                 |
| [LC516] Longest Palindromic Subsequence                      | Dynamic Programming       | Medium     | `O(n²)`         | `O(n)`           | [LC516LongestPalindromicSubsequence.java](./dp/lcs/LC516LongestPalindromicSubsequence.java)                                 |
| [LC1312] Minimum Insertion Steps to Make a String Palindrome | Dynamic Programming       | Hard       | `O(n²)`         | `O(n²)`          | [LC1312MinimumInsertionStepstoMakeAStringPalindrome.java](./dp/lcs/LC1312MinimumInsertionStepstoMakeAStringPalindrome.java) |
| [LC583] Delete Operation for Two Strings                     | Dynamic Programming       | Medium     | `O(n * m)`      | `O(m)`           | [LC583DeleteOperationForTwoStrings.java](./dp/lcs/LC583DeleteOperationForTwoStrings.java)                                   |
| [LC1092] Shortest Common Supersequence                       | Dynamic Programming + LCS | Hard       | `O(m * n)`      | `O(m * n)`       | [LC1092ShortestCommonSupersequence.java](./dp/lcs/LC1092ShortestCommonSupersequence.java)                                   |

<br>

#### DP on String Matching

| Problem Name                  | Topic                | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                        |
| :---------------------------- | :------------------- | :--------- | :-------------- | :--------------- | :----------------------------------------------------------------------------------- |
| [LC115] Distinct Subsequences | DP + String Matching | Hard       | `O(n × m)`      | `O(m)`           | [LC115DistinctSubsequences.java](./dp/stringmatching/LC115DistinctSubsequences.java) |
| [LC72] Edit Distance          | DP + String Matching | Hard       | `O(n × m)`      | `O(m)`           | [LC72EditDistance.java](./dp/stringmatching/LC72EditDistance.java)                   |
| [LC44] Wildcard Matching      | DP + String Matching | Hard       | `O(n × m)`      | `O(m)`           | [LC44WildcardMatching.java](./dp/stringmatching/LC44WildcardMatching.java)           |

<br>

#### DP on Stocks

| Problem Name                                                 | Topic       | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                                              |
| :----------------------------------------------------------- | :---------- | :--------- | :-------------- | :--------------- | :------------------------------------------------------------------------------------------------------------------------- |
| [LC121] Best Time to Buy and Sell Stock                      | DP + Stocks | Easy       | `O(n)`          | `O(1)`           | [LC121BestTimeToBuyAndSellStock.java](./dp/stocks/LC121BestTimeToBuyAndSellStock.java)                                     |
| [LC122] Best Time to Buy and Sell Stock II                   | DP + Stocks | Medium     | `O(n)`          | `O(1)`           | [LC122BestTimeToBuyAndSellStockII.java](./dp/stocks/LC122BestTimeToBuyAndSellStockII.java)                                 |
| [LC123] Best Time to Buy and Sell Stock III                  | DP + Stocks | Hard       | `O(n)`          | `O(1)`           | [LC123BestTimeToBuyAndSellStockIII.java](./dp/stocks/LC123BestTimeToBuyAndSellStockIII.java)                               |
| [LC188] Best Time to Buy and Sell Stock IV                   | DP + Stocks | Hard       | `O(n * k)`      | `O(k)`           | [LC188BestTimeToBuyAndSellStockIV.java](./dp/stocks/LC188BestTimeToBuyAndSellStockIV.java)                                 |
| [LC309] Best Time to Buy and Sell Stock with Cooldown        | DP - Stocks | Medium     | `O(n)`          | `O(1)`           | [LC309BestTimeToBuyAndSellStockWithCooldown.java](./dp/stocks/LC309BestTimeToBuyAndSellStockWithCooldown.java)             |
| [LC714] Best Time to Buy and Sell Stock with Transaction Fee | DP - Stocks | Medium     | `O(n)`          | `O(1)`           | [LC714BestTimeToBuyAndSellStockWithTransactionFee.java](./dp/stocks/LC714BestTimeToBuyAndSellStockWithTransactionFee.java) |

<br>

#### DP on Longest increasing subsequence

| Problem Name                                     | Topic                      | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                                                                      |
| :----------------------------------------------- | :------------------------- | :--------- | :-------------- | :--------------- | :--------------------------------------------------------------------------------------------------------------------------------- |
| [LC300] Longest Increasing Subsequence           | DP / LIS                   | Medium     | `O(n^2)`        | `O(n)`           | [LC300LongestIncreasingSubsequence.java](./dp/longestincreasingsubsequence/LC300LongestIncreasingSubsequence.java)                 |
| [GFG] Get LIS (Print Actual Subsequence)         | DP / LIS                   | Medium     | `O(n^2)`        | `O(n)`           | [GFG_GetLIS.java](./dp/longestincreasingsubsequence/GFG_GetLIS.java)                                                               |
| [LC368] Largest Divisible Subset                 | Dynamic Programming        | Medium     | `O(n²)`         | `O(n)`           | [LC368LargestDivisibleSubset.java](./dp/longestincreasingsubsequence/LC368LargestDivisibleSubset.java)                             |
| [LC673] Number of Longest Increasing Subsequence | Dynamic Programming        | Medium     | `O(n²)`         | `O(n)`           | [LC673NumberOfLongestIncreasingSubsequence.java](./dp/longestincreasingsubsequence/LC673NumberOfLongestIncreasingSubsequence.java) |
| [LC1048] Longest String Chain                    | DP + LIS Pattern + Strings | Medium     | `O(n² × L)`     | `O(n)`           | [LC1048LongestStringChain.java](./dp/longestincreasingsubsequence/LC1048LongestStringChain.java)                                   |
| [GFG] Longest Bitonic Sequence                   | DP + LIS                   | Medium     | `O(n^2)`        | `O(n)`           | [GFG_LongestBitonicSequence.java](./dp/longestincreasingsubsequence/GFG_LongestBitonicSequence.java)                               |

---

### 15. Bit Manipulation

#### Conversion

| Problem Name            | Topic                         | Difficulty | Time Complexity | Space Complexity | Solution Link                                                                     |
| :---------------------- | :---------------------------- | :--------- | :-------------- | :--------------- | :-------------------------------------------------------------------------------- |
| [GFG] Decimal to Binary | Bit Manipulation + Conversion | Easy       | `O(log n)`      | `O(log n)`       | [GFG_DecimalToBinary.java](./bitmanipulation/conversion/GFG_DecimalToBinary.java) |
| [GFG] Binary to Decimal | Bit Manipulation + Conversion | Easy       | `O(n)`          | `O(1)`           | [GFG_BinaryToDecimal.java](./bitmanipulation/conversion/GFG_BinaryToDecimal.java) |

<br>

#### Basics

| Problem Name                               | Topic                     | Difficulty | Time Complexity            | Space Complexity | Solution Link                                                                                 |
| :----------------------------------------- | :------------------------ | :--------- | :------------------------- | :--------------- | :-------------------------------------------------------------------------------------------- |
| [GFG] Check Whether K-th Bit Is Set or Not | Bit Manipulation          | Basic      | `O(1)`                     | `O(1)`           | [GFG_CheckKthBit.java](./bitmanipulation/basics/GFG_CheckKthBit.java)                         |
| [GFG] Check If a Number Is Even or Odd     | Bit Manipulation          | Basic      | `O(1)`                     | `O(1)`           | [GFG_CheckEvenOrOdd.java](./bitmanipulation/basics/GFG_CheckEvenOrOdd.java)                   |
| [LC231] Power of Two                       | Bit Manipulation          | Easy       | `O(1)`                     | `O(1)`           | [LC231PowerOfTwo.java](./bitmanipulation/basics/LC231PowerOfTwo.java)                         |
| [GFG] Set the Rightmost Unset Bit          | Bit Manipulation + Basics | Easy       | `O(number of trailing 1s)` | `O(1)`           | [GFG_SetTheRightmostUnsetBit.java](./bitmanipulation/basics/GFG_SetTheRightmostUnsetBit.java) |
| [LC191] Number of 1 Bits                   | Bit Manipulation + Basics | Easy       | `O(number of set bits)`    | `O(1)`           | [LC191NumberOf1Bits.java](./bitmanipulation/basics/LC191NumberOf1Bits.java)                   |

<br>

#### Interview Favourites Bit-Manipulation Problems

| Problem Name                                 | Topic                                   | Difficulty | Time Complexity    | Space Complexity | Solution Link                                                                                                                |
| :------------------------------------------- | :-------------------------------------- | :--------- | :----------------- | :--------------- | :--------------------------------------------------------------------------------------------------------------------------- |
| [LC2220] Minimum Bit Flips to Convert Number | Bit Manipulation                        | Easy       | `O(k)`             | `O(1)`           | [LC2220MinimumBitFlipsToConvertNumber.java](./bitmanipulation/interviewfavourites/LC2220MinimumBitFlipsToConvertNumber.java) |
| [LC136] Single Number                        | Bit Manipulation + Interview Favourites | Easy       | `O(n)`             | `O(1)`           | [LC136SingleNumber.java](./bitmanipulation/interviewfavourites/LC136SingleNumber.java)                                       |
| [GFG] Find XOR From L To R                   | Bit Manipulation + Mathematics          | Easy       | `O(1)`             | `O(1)`           | [GFG_FindXORFromLToR.java](./bit-manipulation/easy/GFG_FindXORFromLToR.java)                                                 |
| [LC260] Single Number III                    | Bit Manipulation                        | Medium     | `O(n)`             | `O(1)`           | [LC260SingleNumberIII.java](./bitmanipulation/interviewfavourites/LC260SingleNumberIII.java)                                 |
| [LC3513] Number of Unique XOR Triplets I     | Bit Manipulation                        | Medium     | `O(1)`             | `O(1)`           | [LC3513UniqueXorTriplets.java](./bitmanipulation/interviewfavourites/LC3513UniqueXorTriplets.java)                           |
| [LC3514] Unique XOR Triplets II              | Bit Manipulation                        | Medium     | `O(n² + 2048 × n)` | `O(2048)`        | [LCUniqueXorTriplets.java](./bitmanipulation/interviewfavourites/LC3514UniqueXorTriplets.java)                               |

---

## Utility Classes

| Class                     | Purpose                                                       | Location                                                             |
| :------------------------ | :------------------------------------------------------------ | :------------------------------------------------------------------- |
| `EdgeListToAdjacencyList` | Converts edge list to adjacency list (undirected)             | [EdgeListToAdjacencyList.java](./graph/EdgeListToAdjacencyList.java) |
| `BFS`                     | Level-order BFS traversal — connected and disconnected graphs | [BFS.java](./graph/traversal/BFS.java)                               |
| `DFS`                     | Recursive DFS traversal — connected and disconnected graphs   | [DFS.java](./graph/traversal/DFS.java)                               |

---

## Structure

```
dsa-solutions-java/
├── arrays/
├── sorting/
├── binarysearch/
├── strings/
├── linkedlist/
├── recursion/
├── stack/
├── queue/
├── slidingwindow/
├── heaps/
├── binarytree/
├── binarysearchtree/
├── graphs/
└── dp/
```

**File naming convention**

`LC{number}{ProblemName}.java` for LeetCode — e.g. `LC1TwoSum.java`  
`GFG_{ProblemName}.java` for GeeksForGeeks — e.g. `GFG_CountOccurrencesInSortedArray.java`

---

## Progress

| Topic               | Status |
| :------------------ | :----- |
| Basics              | Done   |
| Arrays              | Done   |
| Sorting             | Done   |
| Binary Search       | Done   |
| Strings             | Done   |
| Linked Lists        | Done   |
| Recursion           | Done   |
| Stack & Queue       | Done   |
| Sliding Window      | Done   |
| Heaps               | Done   |
| Binary Trees        | Done   |
| Binary Search Tree  | Done   |
| Graphs              | Done   |
| Dynamic Programming | Done   |

---

## Dynamic Programming — Subtopics

| Subtopic           | Status |
| :----------------- | :----- |
| Introduction to DP | Done   |
| 1D DP              | Done   |
| 2D / 3D DP + Grids | Done   |
| DP on Subsequences | Done   |
| DP on Strings      | Done   |
| DP on Stocks       | Done   |
| DP on LIS          | Done   |

---

## Master Index

Each topic folder has its own README with a problem index table — problem name, difficulty, time complexity, space complexity, and a direct link to the solution file.

---

## Who this is for

Engineers who want to read solutions, not just run them.  
If you're looking for a one-liner accepted solution, this repo isn't it.  
If you want to understand the decision-making behind the code — it is.

---

## Contributing

Found a cleaner approach or a bug? PRs are welcome.  
Open an issue or suggest an alternative — the best solutions come from disagreement.
