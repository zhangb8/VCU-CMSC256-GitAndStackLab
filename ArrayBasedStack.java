import java.util.Arrays;
import java.util.*;
class ArrayBasedStack<E> implements StackInterface<E>{
  private E[] data;
  private int topOfStack;
  private static final int INITIAL_CAPACITY = 5;
  private boolean initialized;
  
  public ArrayBasedStack(int capacity){
   if (capacity <= 0){
      throw new IllegalArgumentException("Capacity must be greater than 0");
   }
   topOfStack = -1;
   E[] data = (E[])new Object[capacity];
  }
  
  public ArrayBasedStack(){
    this(INITIAL_CAPACITY);
  }
  
  public void doubleSize(){
   data = Arrays.copyOf(data, data.length * 2);
  }
  
  public void expandArray(){
   data = Arrays.copyOf(data, data.length + 1);
  }
  public void push(E element){
   if (topOfStack >= data.length - 1){
      expandArray();
   }
   else{
      data[++topOfStack] = element;
   }
  } 
  
  public boolean isEmpty(){
   return topOfStack == -1;
  }
  
  public E pop(){
   if (isEmpty()){
      throw new EmptyStackException();
   }
   else{
      data[topOfStack] = null;
   }
   return data[--topOfStack];
  }
  
  public E peek(){
   if(isEmpty()){
      throw new EmptyStackException();
   }
   return data[topOfStack];
  }
  
  public void clear(){
   if(!isEmpty()){
      for(int i = 1; i < data.length; i++){
         pop();
      }
   }
  }

}