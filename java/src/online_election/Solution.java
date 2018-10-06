package online_election;
import java.util.Arrays;

public class Solution {
    class TopVotedCandidate {
        final int[] record, times;

        public TopVotedCandidate(int[] persons, int[] times) {
            int votes[] = new int[persons.length + 1], lead = 0;
            record = new int[times.length];
            this.times = times;
            for (int i = 0; i < persons.length; i++) {
                votes[persons[i]]++;
                if (votes[persons[i]] >= votes[lead])
                    lead = persons[i];
                record[i] = lead;
            }
        }

        public int q(int t) {
            int i = Arrays.binarySearch(times, t);
            return i >= 0 ? record[i] : record[-i - 2];
        }
    }
}
