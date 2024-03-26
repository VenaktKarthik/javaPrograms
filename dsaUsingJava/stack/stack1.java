class Stack{
    static final int max=5;
    int top;
    int[] arr=new int[max];
    Stack(){
        top=-1;
    }
    boolean isFull(){
        return top == max - 1;
    }
    boolean isEmpty(){
        return top == -1;
    }
    void push(int n){
        if(isFull()) System.out.println("Overflow");
        else{
            arr[++top]=n;
        }
    }
    int pop(){
        if(isEmpty()) return -1;
        return arr[top--];
    }
    int peek(){
        if(isEmpty()) return -1;
        return arr[top];
    }
    int size(){
        return top+1;
    }
}
public class stack1{
    public static void main(String[] args){
        Stack s = new Stack();
        s.push(5);
        s.push(10);
        s.push(15);
        s.push(20);
        s.push(25);
        System.out.println(s.pop() + " Popped from stack");
        s.push(30);
        System.out.println(s.size());
        System.out.println(s.peek() + " is top element");
        System.out.println((s.isEmpty()) ? "Stack is Empty" : "Stack is not Empty");
        System.out.println((s.isFull()) ? "Stack is Full" : "Stack is not Full");
    }
}
