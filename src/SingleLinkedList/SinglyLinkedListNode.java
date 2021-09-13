/*
his challenge is part of a MyCodeSchool tutorial track and is accompanied by a video lesson.

This is an to practice traversing a linked list. Given a pointer to the head node of a linked list, 
print each node's  element, one per line. If the head pointer is null (indicating the list is empty), there is nothing to print.

Function Description:
Complete the printLinkedList function in the editor below.
printLinkedList has the following parameter(s):
SinglyLinkedListSinglyLinkedListNode head: a reference to the head of the list
Print
For each node, print its  value on a new line (console.log in Javascript).
Input Format
The first line of input contains , the number of elements in the linked list.
The next  lines contain one element each, the  values for each node.
Note: Do not read any input from stdin/console. Complete the printLinkedList function in the editor below.
Constraints
, where  is the  element of the linked list.
Sample Input

2
16
13
Sample Output

16
13
Explanation

There are two elements in the linked list. They are represented as 16 -> 13 -> NULL. 
So, the printLinkedList function should print 16 and 13 each on a new line.
 */
package SingleLinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author George
 */
public class SinglyLinkedListNode {

    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    static void printList(SinglyLinkedListNode node) {
        System.out.println("List:");
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        // Allocate node
        SinglyLinkedListNode new_node = new SinglyLinkedListNode(data);

        // Used in step 5
        SinglyLinkedListNode last = head;

        // Put in the data
        new_node.data = data;

        // This new node is going to be
        // the last node, so make next of
        // it as null
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (head == null) {
            head = new_node;
            return head;
        }

        // Else traverse till the last node
        while (last.next != null) {
            last = last.next;
        }

        // Change the next of last node
        last.next = new_node;
        return head;
    }

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode new_node = new SinglyLinkedListNode(data);

        /* 3. Make next of new SinglyLinkedListNode as head */
        new_node.next = llist;

        /* 4. Move the head to point to new SinglyLinkedListNode */
        llist = new_node;
        return llist;
    }

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        SinglyLinkedListNode temp = new SinglyLinkedListNode(data);
        temp.next = llist;

        SinglyLinkedListNode current = temp;
        for (int i = 0; i < position; ++i) {
            current = current.next;
        }

        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        node.data = data;
        node.next = current.next;
        current.next = node;

        return temp.next;
    }

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        // If linked list is empty
        if (llist == null) {
            return null;
        }

        // Store head node
        SinglyLinkedListNode temp = llist;

        // If head needs to be removed
        if (position == 0) {
            llist = temp.next;   // Change head
            return llist;
        }

        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        // If position is more than number of nodes
        if (temp == null || temp.next == null) {
            return llist;
        }

        // SinglyLinkedListNode temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        SinglyLinkedListNode next = temp.next.next;

        temp.next = next;  // Unlink the deleted node from list

        return llist;
    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode current = llist;
        SinglyLinkedListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        llist = prev;
        return llist;
    }

    public static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        while (head1 != null && head2 != null && head1.data == head2.data) {
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1 == head2;
    }

    public static void reversePrint(SinglyLinkedListNode llist) {
        if (llist == null) {
            return;
        }
        printList(reverse(llist));
    }

    public static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        if (head1.data < head2.data) {
            head1.next = mergeLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeLists(head1, head2.next);
            return head2;
        }

    }

    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        SinglyLinkedListNode result = llist;
        int count = 0;
        while (llist.next != null) {
            if (count < positionFromTail) {
                count++;
            } else {
                result = result.next;
            }
            llist = llist.next;
        }
        return result.data;
    }

    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
        SinglyLinkedListNode previous = null;
        SinglyLinkedListNode current = llist;

        // take an empty set to store linked list nodes for future reference
        Set<Integer> set = new HashSet<>();

        // do till the linked list is empty
        while (current != null) {
            // if the current node is seen before, ignore it
            if (set.contains(current.data)) {
                previous.next = current.next;
            } else {
                // insert the current node into the set and proceed to the next node
                set.add(current.data);
                previous = current;
            }
            current = previous.next;
        }

        return llist;
    }

    static boolean hasCycle(SinglyLinkedListNode head) {

        HashSet<SinglyLinkedListNode> s = new HashSet();
        while (head != null) {
            // If we have already has this node
            // in hashmap it means their is a cycle
            // (Because you we encountering the
            // node second time).
            if (s.contains(head)) {
                return true;
            }

            // If we are seeing the node for
            // the first time, insert it in hash
            s.add(head);

            head = head.next;
        }

        return false;
    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        int head1Len = 0, head2Len = 0;
        SinglyLinkedListNode head1copy = head1, head2copy = head2;
        while (head1copy != null) {
            head1copy = head1copy.next;
            head1Len++;
        }
        while (head2copy != null) {
            head2copy = head2copy.next;
            head2Len++;
        }
        while (head1Len > head2Len) {
            head1 = head1.next;
            head1Len--;
        }
        while (head2Len > head1Len) {
            head2 = head2.next;
            head2Len--;
        }
        while (head1 != null) {
            if (head1 == head2) {
                return head1.data;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        SinglyLinkedListNode head = null;
        head = insertNodeAtTail(head, 1);
        head = insertNodeAtTail(head, 2);
        head = insertNodeAtTail(head, 5);
        head = insertNodeAtTail(head, 7);
        //System.out.println("Node at 2 = " + getNode(head, 2));
        //head = insertNodeAtHead(head, 303);
        SinglyLinkedListNode head2 = null;
        head2 = insertNodeAtTail(head2, 2);
        head2 = insertNodeAtTail(head2, 3);
        head2 = insertNodeAtTail(head2, 4);
        //System.out.println(compareLists(head, head2));
        //head = insertNodeAtPosition(head, 1, 2);
        //printList(head);
        //head = deleteNode(head, 0);
        printList(head);
        //reversePrint(head);
        //System.out.print(" Merged ");
        //printList(mergeLists(head, head2));
        System.out.print("- Unqiue ");
        printList(removeDuplicates(head));
        System.out.println("- Hicycle " + hasCycle(head));
        System.out.println("- Merging point " + findMergeNode(head, head2));
    }

}
