class Solution {
    private class Pair{
        String word;
        int step;
        Pair(String wrd, int s){
            word = wrd;
            step = s;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> st = new HashSet<>(wordList);
        q.add(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            String word = q.peek().word;
            int steps = q.peek().step;
            q.remove();

            if(word.equals(endWord)) return steps;

            for(int i = 0; i < word.length(); i++){
                char[] arr = word.toCharArray();
                char original = arr[i];
                for(char ch = 'a'; ch <= 'z'; ch++){
                    arr[i] = ch;
                    String newWord = new String(arr);
                    if(st.contains(newWord)){
                        st.remove(newWord);
                        q.add(new Pair(newWord, steps + 1));
                    }
                }
                arr[i] = original;
            }
        }
        return 0;
    }
}
