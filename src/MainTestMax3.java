import Framework.Max3DivDC;
import Framework.Max3Prob;
import Framework.Max3Sol;

import java.util.ArrayList;

public class MainTestMax3 {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        Max3Prob p = new Max3Prob(arr);
        System.out.println("Starting problem: " + p.getStartingArr());
        Max3DivDC dc = new Max3DivDC();
        dc.solve(p);
    }
}
