package codingquestions.leetcode;

/**
 * 649. Dota2 Senate
 * Solved
 * Medium
 * Topics
 * Companies
 * In the world of Dota2, there are two parties: the Radiant and the Dire.
 * <p>
 * The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:
 * <p>
 * Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
 * Announce the victory: If this senator found the senators who still have rights to vote are all from the same party, he can announce the victory and decide on the change in the game.
 * Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party. Then if there are n senators, the size of the given string will be n.
 * <p>
 * The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.
 * <p>
 * Suppose every senator is smart enough and will play the best strategy for his own party. Predict which party will finally announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire".
 **/
public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        if (allCharacterSame(senate))
            if (senate.charAt(0) == 'R')
                return "Radiant";
            else
                return "Dire";
        StringBuilder updatedSenate = nextPossible(senate, 0, 0);
        return predictPartyVictory(updatedSenate.toString());
    }

    public boolean allCharacterSame(String senate) {
        for (int i = 0; i < senate.length() - 1; i++)
            if (senate.charAt(i) != senate.charAt(i + 1))
                return false;
        return true;
    }

    public StringBuilder nextPossible(String senate, int rCount, int dCount) {
        StringBuilder sb = new StringBuilder();
        int rCounter = rCount;
        int dCounter = dCount;
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R' && dCounter > 0)
                dCounter--;
            else if (senate.charAt(i) == 'D' && rCounter > 0)
                rCounter--;
            else if (senate.charAt(i) == 'R' && dCounter == 0) {
                sb.append(senate.charAt(i));
                rCounter++;
            } else if (senate.charAt(i) == 'D' && rCounter == 0) {
                sb.append(senate.charAt(i));
                dCounter++;
            }
        }
        if ((rCounter > 0 || dCounter > 0) && (!allCharacterSame(sb.toString())))
            return nextPossible(sb.toString(), rCounter, dCounter);
        return sb;
    }
}
