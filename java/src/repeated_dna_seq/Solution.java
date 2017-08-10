package repeated_dna_seq;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findRepeatedDnaSequences
                ("CGACGCAATTTAGAACGGGCCGCACTGCAACCATTGCTCAGACAACGCATGAGTTAAATTTCACAAGTGATAGTGGCTTGCGAGACGTGGGTTGGTGGTAGCGTACGCCCGCTATTCGCCCCTAACGTGACGGGATTATAAGGTCGCTTCCCGGAATGCGCAGACGAGTCTCCGGTTTAGCCTAGACGTCTCACGCGCGCAAGGCGTCAGTTCTCACTATCTCGCACAGGTGTATTCTATTAGTTATGGGTTCTCACTACAGTCGGTTACTTCCTCATCCATTTCTGCATACGGGTCAACTAACAGTGTCATGGGGTATTGGGAAGGATGCGTTTTTAAACCCTCTCAGTAGCGCGAGGATGCCCACAAATACGACGGCGGCCACGGATCTAATGCGAAGCTAGCGACGCTTTCCAGCAACGAGCGCCCCACTTATGACTGCGTGGGGCGCTCCGCTTTCCTAGAGAACATAGATGGTGTTTTCGAATCGTAACCACTTA"));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> r = new LinkedList<>();
        Set<Integer> once = new HashSet<>(), twice = new HashSet<>();
        int v = 0, i = 0;
        char[] map = new char[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        for (; i < Math.min(9, s.length()); i++) {
            v <<= 2;
            v |= map[s.charAt(i) - 'A'];
        }
        for (; i < s.length(); i++) {
            v = ((v & 0b111111111111111111) << 2) | map[s.charAt(i) - 'A'];
            if (!once.add(v) && twice.add(v))
                r.add(s.substring(i - 9, i + 1));
        }
        return r;
    }
}
