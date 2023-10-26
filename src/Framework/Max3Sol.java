package Framework;

import java.util.ArrayList;

public class Max3Sol implements Solution{
    private ArrayList<Integer> max3;

    public Max3Sol(ArrayList<Integer> max3) {
        this.max3 = max3;
    }
    public ArrayList<Integer> getMax3() {
        return max3;
    }
    public String toString() {
        return "El máximo del vector es: " + max3;
    }
}
