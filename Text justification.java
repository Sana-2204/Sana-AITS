import java.util.*;
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int count = words[index].length(), last = index + 1;
            while (last < words.length && count + words[last].length() + (last - index) <= maxWidth) {
                count += words[last].length();
                last++;
            }
            StringBuilder sb = new StringBuilder(words[index]);
            int spaces = last - index - 1;
            if (last == words.length || spaces == 0) {
                for (int i = index + 1; i < last; i++) {
                    sb.append(" ").append(words[i]);
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                int spaceSize = (maxWidth - count) / spaces;
                int extraSpaces = (maxWidth - count) % spaces;
                for (int i = index + 1; i < last; i++) {
                    for (int j = 0; j < spaceSize; j++) {
                        sb.append(" ");
                    }
                    if (extraSpaces > 0) {
                        sb.append(" ");
                        extraSpaces--;
                    }
                    sb.append(words[i]);
                }
            }
            result.add(sb.toString());
            index = last;
        }
        return result;
    }
}
