class ArrayStack {
    List<Integer> stk = new ArrayList<>();
    int size;
    public ArrayStack() {
        stk = new ArrayList<>();
        size = 0;
    }

    public void push(int x) {
       stk.add(x);
       size++;
    }

    public int pop() {
      int lst = stk.get(stk.size() - 1);
      stk.remove(stk.size() - 1);
      size--;
      return lst;
    }

    public int top() {
        return stk.get(stk.size() - 1);
    }

    public boolean isEmpty() {
        return stk.size() == 0;
    }
}
