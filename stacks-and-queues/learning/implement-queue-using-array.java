class ArrayQueue {
    List<Integer> queue;
    int size;
    public ArrayQueue() {
        queue = new ArrayList<>();
        size = 0;
    }

    public void push(int x) {
       queue.add(x);
       size++;
    }

    public int pop() {
      int fst = queue.get(0);
      queue.remove(0);
      size--;
      return fst;
    }

    public int peek() {
        return queue.get(0);
    }

    public boolean isEmpty() {
        return queue.size() == 0;
    }
}
