class MinStack {
    public Stack s1;
    public Stack s2;
    public MinStack() {s1 = new Stack(); s2 = new Stack();}
    public void push(int x) {
            s1.push(x);
            if(s2.size() == 0)
                s2.push(x);
            else
            {
                int temp_min = (int)s2.peek();
                if(x <= temp_min)
                    s2.push(x);
            }
    }

    public void pop() {
        int tmp = (int)s1.peek(); s1.pop();
        if((int)s2.peek() == tmp)
            s2.pop();
    }

    public int top() {
        return (int)s1.peek();
    }

    public int getMin() {
        return (int)s2.peek();
    }
    /*
    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.
    */
    // two stack, first for normal one, second for min value..
    //  1, 2, 3;    stack1: 1, 2, 1, 3   stack2:  1, 1       if(stack1.top == stack2.top) stack2.pop()
    //                         2 is bigger than stack2.top, so 2 is not push to stack2. unless <= stack2.top.
    //
}