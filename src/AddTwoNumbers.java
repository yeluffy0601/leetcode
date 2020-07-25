/**
 * 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        /**
         * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
         * 输出：7 -> 0 -> 8
         * 原因：342 + 465 = 807
         */
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(4, a);
        ListNode c = new ListNode(2, b);
        System.out.println("number1: " + c);

        ListNode d = new ListNode(4);
        ListNode e = new ListNode(6, d);
        ListNode f = new ListNode(5, e);
        System.out.println("number2: " + f);

        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode result = atn.addTwoNumbers(c, f);
        System.out.println("result: " + result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val = l1.val + l2.val;
        ListNode result = new ListNode(val % 10);
        int num = val / 10;
        ListNode pre;
        ListNode current = result;
        boolean l1End = false;
        boolean l2End = false;
        while (l1.next != null || l2.next != null || num > 0) {
            if (l1.next != null) {
                l1 = l1.next;
            } else {
                l1End = true;
            }
            if (l2.next != null) {
                l2 = l2.next;
            } else {
                l2End = true;
            }
            pre = current;
            val = (l1End ? 0 : l1.val) + (l2End ? 0 : l2.val) + num;
            current = new ListNode(val % 10);
            pre.next = current;
            num = val / 10;
        }
        return result;
    }

    public static class ListNode {

        int val;

        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val);
            if (next != null) {
                sb.append("->");
                sb.append(next.toString());
            }
            return sb.toString();
        }
    }

}
