package design_hash_set;
public class Solution {
    class MyHashSet {
        final Bucket[] buckets = new Bucket[10000];

        public void add(int key) {
            int i = idx(key);
            if (buckets[i] == null)
                buckets[i] = new Bucket();
            ListNode prev = find(buckets[i], key);
            if (prev.next == null)
                prev.next = new ListNode(key, key);
            else prev.next.val = key;
        }

        public void remove(int key) {
            int i = idx(key);
            if (buckets[i] == null) return;
            ListNode prev = find(buckets[i], key);
            if (prev.next == null) return;
            prev.next = prev.next.next;
        }

        /** Returns true if this set did not already contain the specified element */
        public boolean contains(int key) {
            int i = idx(key);
            if (buckets[i] == null)
                return false;
            ListNode node = find(buckets[i], key);
            return node.next != null;
        }

        int idx(int key) { return Integer.hashCode(key) % buckets.length;}

        ListNode find(Bucket bucket, int key) {
            ListNode node = bucket.head, prev = null;
            while (node != null && node.key != key) {
                prev = node;
                node = node.next;
            }
            return prev;
        }

        class Bucket {
            final ListNode head = new ListNode(-1, -1);
        }

        class ListNode {
            int key, val;
            ListNode next;

            ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}
