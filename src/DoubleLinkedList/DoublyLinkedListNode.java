/*
 Given a reference to the head of a doubly-linked list and an integer, , create a new DoublyLinkedListNode object having data value  and insert it at the proper location to maintain the sort.

Example

 refers to the list 

Return a reference to the new list: .

Function Description

Complete the sortedInsert function in the editor below.

sortedInsert has two parameters:

DoublyLinkedListNode pointer head: a reference to the head of a doubly-linked list

int data: An integer denoting the value of the  field for the DoublyLinkedListNode you must insert into the list.

Returns

DoublyLinkedListNode pointer: a reference to the head of the list
Note: Recall that an empty list (i.e., where ) and a list with one element are sorted lists.

Input Format

The first line contains an integer , the number of test cases.

Each of the test case is in the following format:

The first line contains an integer , the number of elements in the linked list.
Each of the next  lines contains an integer, the data for each node of the linked list.
The last line contains an integer, , which needs to be inserted into the sorted doubly-linked list.
Constraints

Sample Input

STDIN   Function
-----   --------
1       t = 1
4       n = 4
1       node data values = 1, 3, 4, 10
3
4
10
5       data = 5
Sample Output

1 3 4 5 10
Explanation

The initial doubly linked list is:  .

The doubly linked list after insertion is: 
 */
package DoubleLinkedList;

import SingleLinkedList.SinglyLinkedListNode;

/**
 *
 * @author George
 */
public class DoublyLinkedListNode {

    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
        this.prev = null;
    }

    static void printList(DoublyLinkedListNode head) {
        System.out.print("List: ");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
        DoublyLinkedListNode new_node = new DoublyLinkedListNode(data);
        DoublyLinkedListNode head = llist;

        if (llist == null) {
            llist = new_node;
            return llist;
        } else if (llist.data >= new_node.data) {
            new_node.next = head;
            new_node.next.prev = new_node;
            llist = new_node;
        } else {
            while (head.next != null && head.next.data < new_node.data) {
                head = head.next;
            }
            new_node.next = head.next;

            if (head.next != null) {
                new_node.next.prev = new_node;
            }

            head.next = new_node;
            new_node.prev = head;
        }

        return llist;
    }

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
        DoublyLinkedListNode temp = null;
        DoublyLinkedListNode current = llist;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if(temp != null)
            llist = temp.prev;
        
        return llist;
    }

    
    public static void main(String[] args) {
        DoublyLinkedListNode head = null;

        head = sortedInsert(head, 1);        
        head = sortedInsert(head, 3);      
        head = sortedInsert(head, 2);      
        head = sortedInsert(head, 3);      
        head = sortedInsert(head, 4);
        head = sortedInsert(head, 1);
        printList(head);
        head = reverse(head);
        printList(head);
    }
}
