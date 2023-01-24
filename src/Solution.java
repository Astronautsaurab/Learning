import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        while (i<nums1.length && j<nums2.length) {
            if(nums1[i]==nums2[j]) {
                arrayList.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i]<nums2[j]) {
                i++;

            } else {
                j++;
            }
        }
        int[] ans = new int[arrayList.size()];
        for(int k=0;k<arrayList.size();k++) {
            ans[k]=arrayList.get(k);
        }
        return ans;
    }

    public int[] plusOne(int[] digits) {   //999
        int length = digits.length;
        for(int i=length-1; i>=0; i--) {
            if(digits[i]<9) {
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int[] newNumber = new int[length+1];
        newNumber[0]=1;
        return newNumber;
    }

    public int[] moveZeroes(int[] nums) {   //[0,1,0,3,12]
        int l = nums.length;
        int index=0;
        for (int i=0; i<l; i++) {
            if(nums[i]!=0) {
                nums[index] = nums[i];
                index++;
            }
        }
        while (index < l) {
            nums[index] = 0;
            index++;
        }
        return nums;
    }

    public int[] twoSum(int[] nums, int target) {
        int l = nums.length;
        HashMap<Integer, Integer> elem = new HashMap<>();
        for (int i = 0; i<l; i++) {
            elem.put(nums[i], i);
        }
        for (int i = 0; i<l; i++) {
            int compliment = target = nums[i];
            if (elem.containsKey(compliment) && elem.get(compliment)!=i) {
                return new int[] {i, elem.get(compliment)};
            }
        }
        throw new IllegalArgumentException("NO SUM");
    }

    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in column " + j) ||
                        !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }

    public boolean balancedParenthesis(String s) {
        Stack<Character> charStack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
                charStack.push(s.charAt(i));
            } else if (s.charAt(i) == ']') {
                if (charStack.empty() || charStack.pop() != '[') {
                    return false;
                }
            } else if (s.charAt(i) == ')') {
                if (charStack.empty() || charStack.pop() != '(') {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (charStack.empty() || charStack.pop() != '{') {
                    return false;
                }
            }

        }
        return charStack.empty();
    }

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
        }
    }

    public void reverseList(Node head) {
        Node next = null;
        Node current = head;
        Node prev = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public String reverseString(String s) {
        int end = s.length()-1;
        int start = 0;
        char[] c = s.toCharArray();
        while (start<end) {
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
        return new String(c);
    }

    public boolean validPalindrome(String s) {
        int head = 0;
        int tail = s.length()-1;
        while (head<tail) {
            while (!Character.isLetterOrDigit(s.charAt(head))) {
                head++;
            }
            while (!Character.isLetterOrDigit(s.charAt(tail))) {
                tail--;
            }
            if (Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail))) {
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }

    public boolean hasNeedle(String hayStack, String needle) {
        int l = hayStack.length();
        for (int i=0; i<l; i++) {
            if (hayStack.charAt(i) == needle.charAt(0)) {
                if (hayStack.startsWith(needle, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;
        while(slow != null || fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
