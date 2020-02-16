import java.util.*;


class MyStack{
  // Custom Stack Implementation
  final static int MAX = 100;       // predefined Max Stack size = 100
  int top = -1;
  char st[] = new char[MAX];

  void push(char x){

    if(top == MAX-1){
      System.out.println("Stack Overflow");
    }
    else{
      top++;
      st[top] = x;
    }
  }

  char pop(){

    if(isEmpty()){
      System.out.println("Stack Underflow");
      return '\0';
    }
    else{
      char temp = st[top];
      top--;
      return temp;
    }
  }

  int size(){
    return(top+1);
  }
  boolean isEmpty(){
    return(top == -1);
  }
}

class Program{

  public static void main(String[] args) {

    char expression[];

    Scanner sc = new Scanner(System.in);
    System.out.print("\nEnter expression : ");
    expression = (sc.nextLine()).toCharArray();       // toCharArray() converts a String to char array
    System.out.println();

    if(checkParenthesis(expression)){
      System.out.println("The Expression has Balanced Parentheses");
    }
    else{
      System.out.println("The Expression has Unbalanced Parentheses");
    }

  }

  public static boolean matchParenthesis(char a, char b){
    // helper method to match a pair of Parenthesis
    if(a == '[' && b == ']'){
      return true;
    }
    else if(a == '(' && b == ')'){
      return true;
    }
    else if(a == '{' && b == '}'){
      return true;
    }
    else{
      return false;
    }
  }

  public static boolean checkParenthesis(char exp[]){
    // helper method to check whether Expression has balanced Parentheses or not
    MyStack stack = new MyStack();
    int n = exp.length;
    char temp;
    for(int i = 0; i < n; i++){

      if(exp[i] == '[' || exp[i] == '(' || exp[i] == '{'){
        stack.push(exp[i]);
      }
      if(exp[i] == ']' || exp[i] == ')' || exp[i] == '}'){

        if(stack.isEmpty()){
          return false;
        }
        else{
          temp = stack.pop();

          if(!matchParenthesis(temp, exp[i])){
            return false;
          }
        }
      }
    }

    if(stack.isEmpty()){
      return true;
    }
    else{
      return false;
    }

  }

}
