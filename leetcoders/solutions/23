# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []
        idx = 0

        for node in lists:
            while node:
                heap.append((node.val, idx, node))
                temp = node.next
                node.next = None
                node = temp
                idx += 1
        
        heapq.heapify(heap)

        head = ListNode(-1, None)
        front = head

        while heap:
            el = heapq.heappop(heap)

            node = el[2]
            front.next = node
            front = front.next
        
        return head.next