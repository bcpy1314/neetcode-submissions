class LinkedList {
    ListNode head;
    ListNode tail;
    
    public LinkedList() {
        this.head = new ListNode(-1);
        this.tail = this.head;
    }

    public int get(int index) {
        ListNode cur = head.next;
        int i = 0;
        while ( cur != null){
            if (i == index){
                return cur.val;
            }
            cur = cur.next;
            i++;
        }
        return -1;
    }

    public void insertHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head.next;
        head.next = newHead;
        if (newHead.next == null){
            tail = newHead;
        }
    }

    public void insertTail(int val) {
        this.tail.next = new ListNode(val);
        this.tail = this.tail.next;

    }

    public boolean remove(int index) {
        int i = 0;
        ListNode cur = this.head;
        while (i < index && cur != null){
            i++;
            cur = cur.next;
        }
        if (cur != null && cur.next != null){
            if(cur.next == this.tail){
                this.tail = cur;
            }
            cur.next = cur.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> result = new ArrayList<>();
        ListNode cur = this.head.next;
        while (cur != null){
            result.add (cur.val);
            cur = cur.next;
        }
        return result;
    }
}

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
    public ListNode(int val){
        this(val, null);
    }
}
