package linkedlist.traversal;

import linkedlist.singlylinkedlist.ListNode;

// Created at: 18 - March - 2026
// Last revised at: 18 - March - 2026
// Time Complexity: O(n) where n is the number of nodes in the linked list
// Space Complexity: O(1) constant space, only one pointer variable used

/**
 * Utility class to print the contents of a singly linked list.
 * 
 * Problem Description:
 * Given the head of a singly linked list, print all node values in order,
 * with each value followed by a space, then a newline at the end.
 * 
 * Example:
 * Input: head = 1 -> 2 -> 3 -> 4 -> null
 * Output:
 * Printing Singly LinkedList
 * 1 2 3 4
 * 
 * Input: head = null
 * Output:
 * Printing Singly LinkedList
 * (empty line)
 * 
 * Constraints:
 * - Linked list can be empty (head = null)
 * - Number of nodes can be up to 10^6
 * - Node values can be any integer
 */
public class PrintLinkedList {

    /**
     * Prints all values in a singly linked list to console.
     * 
     * Approach:
     * /*
     * * ★ Linear Traversal with Console Output (Optimal)
     * * Idea: Traverse the linked list from head to tail, printing each node's
     * * value followed by a space. Print newline after last node.
     * * Time: O(n) - must visit and print each node exactly once
     * * Space: O(1) - only one temporary pointer regardless of list size
     * * Key Insight: Simple and efficient for debugging/displaying list contents.
     * * Space for output is not counted in space complexity.
     * 
     * 
     * @param head the head node of the linked list to print
     * @return void; prints to standard output
     */
    public static void singlyLinkedList(ListNode head) {

        // Print header message indicating the operation
        System.out.println("Printing Singly LinkedList");

        // Initialize temp pointer to traverse from head
        ListNode temp = head;

        // Traverse the entire list until we reach the end (temp becomes null)
        while (temp != null) {
            // Print current node's data followed by a space
            System.out.print(temp.data + " ");
            // Move pointer to the next node
            temp = temp.next;
        }

        // Print newline after all nodes to separate output
        System.out.println();
    }
}