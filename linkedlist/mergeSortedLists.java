package linkedlist;

public class mergeSortedLists {

    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
    public static ListNode add(ListNode l1, ListNode l2){
        ListNode res = null;
        ListNode temp = null;
        while(l1 != null && l2 != null){
            if(temp == null){
                if(l1.val < l2.val){
                    res = temp = l1;
                    l1 = l1.next;
                }
                else{
                    res = temp = l2;
                    l2 = l2.next;
                }
            }
            else{
                if(l1.val < l2.val){
                    temp.next = l1;
                    l1 = l1.next;
                }
                else{
                    temp.next = l2;
                    l2 = l2.next;
                }
                temp = temp.next;
            }
        } 
        temp.next = l1 == null ? l2 : l1;
        ListNode temp2 = res;
        while (temp2 != null){
            System.out.println("val "+temp2.val);
            temp2 = temp2.next;
        }  
        return res;
    }
    
    public static void main(String [] args){
        
    }
}
