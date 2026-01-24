class Solution {
    public int numberOfMatches(int n) {
        Integer teamsRemaining = n;
        Integer matches = 0;
        while (teamsRemaining != 1) {
            if (teamsRemaining % 2 == 0) {
                matches += teamsRemaining /2;
                teamsRemaining = teamsRemaining/2;
            } else {
                matches += (teamsRemaining-1)/2;
                teamsRemaining = (teamsRemaining - 1) / 2 + 1;
            }
        }
        return matches;
    }
}