package Framework;

import java.util.ArrayList;

public class Max3Prob implements Problem{
    private final ArrayList<Integer> startingArr;

    public Max3Prob(ArrayList<Integer> startingArr) {
        this.startingArr = startingArr;
    }

    public ArrayList<Integer> getStartingArr() {
        return startingArr;
    }

}
