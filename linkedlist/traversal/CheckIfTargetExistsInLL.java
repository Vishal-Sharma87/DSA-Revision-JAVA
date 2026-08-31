package linkedlist.traversal;

import linkedlist.singlylinkedlist.ListNode;

// Created at: 18 - March - 2026
// Last revised at: 18 - March - 2026
// Time Complexity: O(n) where n is the number of nodes in the linked list
// Space Complexity: O(1) constant space, only one pointer variable used

/**
 * Utility class to search for a target value in a singly linked list.
 * 
 * Problem Description:
 * Given the head of a singly linked list and a target integer value, determine
 * if the target value exists in the linked list.
 * 
 * Example:
 * Input: head = 1 -> 2 -> 3 -> 4 -> null, target = 3
 * Output: true
 * 
 * Input: head = 1 -> 2 -> 3 -> 4 -> null, target = 5
 * Output: false
 * 
 * Constraints:
 * - Linked list can be empty (head = null)
 * - Number of nodes can be up to 10^6
 * - Node values can be negative or positive integers
 */
public class CheckIfTargetExistsInLL {

    /**
     * Checks if a target value exists in the linked list.
     * 
     * Approach:
     * /*
     * * ★ Linear Search (Optimal)
     * * Idea: Traverse the linked list from head to tail. Stop when we find the
     * * target value or reach the end of the list.
     * * Time: O(n) - worst case we traverse entire list
     * * Space: O(1) - no extra space except one pointer
     * * Key Insight: Simple and efficient for unordered linked lists. Best we can
     * * do without additional data structures.
     * 
     * 
     * @param head   the head node of the linked list to search in
     * @param target the integer value to search for
     * @return true if target exists in the linked list, false otherwise
     */
    public static boolean isExists(ListNode head, int target) {

        // Initialize temp pointer to traverse from head
        ListNode temp = head;

        // Traverse the list while temp is not null AND we haven't found the target
        while (temp != null && temp.data != target) {
            // Move to the next node
            temp = temp.next;
        }

        // Return true if temp is not null (target found), false if temp is null (end
        // reached)
        return temp != null;
    }
}