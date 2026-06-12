class Solution {
    public boolean isValid(String s) {
        // using a stack
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (!stack.isEmpty() && ((c == ')' && stack.peek() == '(') || (c == ']' && stack.peek() == '[') || (c == '}' && stack.peek() == '{'))){
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size() == 0;
    }
}