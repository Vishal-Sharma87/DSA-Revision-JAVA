package linkedlist.traversal;

import linkedlist.singlylinkedlist.ListNode;

// Created at: 18 - March - 2026
// Last revised at: 18 - March - 2026
// Time Complexity: O(n) where n is the length of the input array
// Space Complexity: O(n) for the linked list nodes created

/**
 * Utility class to convert an integer array to a singly linked list.
 * 
 * Problem Description:
 * Given an array of integers, create a linked list where each node contains
 * one element from the array in the same order.
 * 
 * Example:
 * Input: [1, 2, 3, 4]
 * Output: 1 -> 2 -> 3 -> 4 -> null
 * 
 * Constraints:
 * - Array can be empty
 * - Array length can be up to 10^6
 */
public class ArrayToLinkedList {

    /**
     * Converts an integer array to a singly linked list.
     * 
     * @param data the input integer array to be converted
     * @return the head node of the newly created linked list, or null if array is
     *         empty
     */
    public static ListNode convertArray2LinkedList(int[] data) {

        // Initialize head to null; will be set to first node if array is non-empty
        ListNode head = null;

        // Get the length of the input array
        int len = data.length;

        // Base case: empty array returns null
        if (len == 0)
            return head;

        // Create the first node with the first element and set it as head
        ListNode curr = new ListNode(data[0]);
        head = curr;

        // Iterate from index 1 to end, linking each new node
        for (int i = 1; i < len; i++) {
            // Create a new node with current array element
            curr.next = (new ListNode(data[i]));
            // Move to the newly created node
            curr = curr.next;
        }

        // Return the head of the linked list
        return head;
    }
}