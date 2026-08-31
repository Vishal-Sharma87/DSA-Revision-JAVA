package linkedlist.traversal;

import linkedlist.singlylinkedlist.ListNode;

// Created at: 18 - March - 2026
// Last revised at: 18 - March - 2026
// Time Complexity: O(n) where n is the number of nodes in the linked list
// Space Complexity: O(1) constant space, only counter and pointer variables used

/**
 * Utility class to calculate the length of a singly linked list.
 * 
 * Problem Description:
 * Given the head of a singly linked list, find the total number of nodes
 * present in the linked list.
 * 
 * Example:
 * Input: head = 1 -> 2 -> 3 -> 4 -> 5 -> null
 * Output: 5
 * 
 * Input: head = null
 * Output: 0
 * 
 * Constraints:
 * - Linked list can be empty (head = null)
 * - Number of nodes can be up to 10^6
 */
public class LinkedListLength {

    /**
     * Calculates the length of a singly linked list.
     * 
     * Approach:
     * /*
     * * ★ Single Pass Traversal (Optimal)
     * * Idea: Traverse the entire linked list from head to tail, incrementing
     * * a counter for each node visited.
     * * Time: O(n) - must visit each node exactly once
     * * Space: O(1) - only two variables regardless of list size
     * * Key Insight: Simple and efficient. This is the only way to find length
     * * without modifying the list structure.
     * 
     * 
     * @param head the head node of the linked list
     * @return the total number of nodes in the linked list
     */
    public int getLengthOfSinglyLL(ListNode head) {

        // Initialize counter to track the number of nodes
        int len = 0;

        // Initialize mover pointer to traverse from head
        ListNode mover = head;

        // Traverse the entire list until we reach the end (mover becomes null)
        while (mover != null) {
            // Increment counter for each node encountered
            len++;
            // Move pointer to the next node
            mover = mover.next;
        }

        // Return the total count of nodes
        return len;
    }
}