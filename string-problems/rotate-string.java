class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        String ref = s + s;

        return ref.contains(goal);
    }
}
