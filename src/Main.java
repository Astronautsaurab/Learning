public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] n1 = new int[]{1,2,2,1};
        int[] n2 = new int[]{2,2};
        int[] n3 = new int[]{0,1,0,3,12};
        //solution.intersect(n1, n2);
        //System.out.println(solution.reverseString("Saurabhm"));
        //System.out.println(solution.validPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.hasNeedle("A man, a plan, a canal: Panama", "man"));
        //solution.moveZeroes(n3);

    }
}
