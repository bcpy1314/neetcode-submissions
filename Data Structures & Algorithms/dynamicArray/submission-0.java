class DynamicArray {
    int capacity;
    int length = 0;
    int[] array;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        this.array[i] = n;
    }

    public void pushback(int n) {
        if (length == capacity) {
            resize();
        }
        this.array[length++] = n;
    }

    public int popback() {
        return this.array[--length];
    }

    public void resize() {
        this.capacity *= 2;
        int[] newArray = new int[this.capacity];
        for (int i = 0; i < length; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    public int getSize() {
        return this.length;
    }

    public int getCapacity() {
        return this.capacity;
    }
}