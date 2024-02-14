package easy.strings;

public class LongestCommonPrefix {
    

    /**
     * Initialize variable p to the value of the first index in the strs array
     * Loop from second index to the end of the arrays length - remember we stored the first index value in p
     * On the context of i, the current string in the iteration, we check if p exists by using the indexOf method
     *      - indexOf returns 0 if the string is found and -1 if not
     * if not 0, then we chop off the last character of p using the substring method
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String [] strs ) {
        String p = strs[0];
        for(int i = 1; i < strs.length; i++) {
            while(strs[i].indexOf(p) != 0) {
                p = p.substring(0, p.length() -1);
            }
        }
        return p;
    }
}
