"""
2487. Remove Nodes From Linked List

You are given the head of a linked list.

Remove every node which has a node with a greater value anywhere to the right side of it.

Return the head of the modified linked list.

 

Example 1:


Input: head = [5,2,13,3,8]
Output: [13,8]
Explanation: The nodes that should be removed are 5, 2 and 3.
- Node 13 is to the right of node 5.
- Node 13 is to the right of node 2.
- Node 8 is to the right of node 3.
Example 2:

Input: head = [1,1,1,1]
Output: [1,1,1,1]
Explanation: Every node has value 1, so no nodes are removed.
 

Constraints:

The number of the nodes in the given list is in the range [1, 105].
1 <= Node.val <= 105
"""
#solution
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseLinkedList(self, head):
        prev_node = None
        current_node = head
        next_node = None

        # Reverse the linked list
        while current_node:
            next_node = current_node.next
            current_node.next = prev_node
            prev_node = current_node
            current_node = next_node
        
        return prev_node

    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # Reverse the original linked list
        head = self.reverseLinkedList(head)

        max_value = 0
        prev_node = None
        current_node = head

        # Traverse the list to remove nodes
        while current_node:
            max_value = max(max_value, current_node.val)

            # Remove nodes with values less than max_value
            if current_node.val < max_value:
                # Skip current_node to delete it
                prev_node.next = current_node.next
                deleted_node = current_node
                current_node = current_node.next
                deleted_node.next = None

            # Move to the next node
            else:
                prev_node = current_node
                current_node = current_node.next
        
        # Reverse the modified linked list and return it
        return self.reverseLinkedList(head)
        
