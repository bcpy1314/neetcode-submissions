class Deque {
    private ListNode dummyHead;
    private ListNode dummyTail;

    public Deque() {
        this.dummyHead = new ListNode(0);
        this.dummyTail = new ListNode(0);

        this.dummyHead.next = this.dummyTail;
        this.dummyTail.pre = this.dummyHead;
    }

    public boolean isEmpty() {
        return this.dummyHead.next == this.dummyTail;
    }

    public void append(int value) {
       ListNode newNode = new ListNode(value);
       newNode.pre = this.dummyTail.pre;
       newNode.next = this.dummyTail;
       this.dummyTail.pre.next = newNode;
       this.dummyTail.pre = newNode;
    }

    public void appendleft(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = this.dummyHead.next;
        newNode.pre = this.dummyHead;
        this.dummyHead.next.pre = newNode;
        this.dummyHead.next = newNode;
        
    }

    public int pop() {
        if(isEmpty()){
            return -1;
        }
        ListNode targetNode = this.dummyTail.pre;
        ListNode preNode = targetNode.pre;
        int value = targetNode.val;
        this.dummyTail.pre = preNode;
        preNode.next = this.dummyTail;
        return value;
    }

    public int popleft() {
        if (isEmpty()){
            return -1;
        }
        ListNode targetNode = this.dummyHead.next;
        ListNode nextNode = targetNode.next;
        int value = targetNode.val;
        this.dummyHead.next = nextNode;
        nextNode.pre = this.dummyHead;
        return value;
    }
}

class ListNode {
    ListNode pre;
    ListNode next;
    int val;

    public ListNode(int val){
        this.val = val;
        this.next = null;
        this.pre = null;
    }
}
