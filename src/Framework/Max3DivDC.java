package Framework;

import java.util.ArrayList;
import java.util.List;

public class Max3DivDC extends DivConqTemplate {

    private int FIRST_THIRD = 0;
    private int SECOND_THIRD = 1;
    private int THIRD_THIRD = 2;

    protected boolean isSimple(Problem p) {
        return ((Max3Prob) p).getStartingArr().size() == 1;
    }

    protected Solution simplySolve(Problem p) {
        return new Max3Sol(((Max3Prob) p).getStartingArr());
    }

    @Override
    protected Problem[] decompose(Problem p) {
        ArrayList<Integer> array = ((Max3Prob) p).getStartingArr();
        int n = array.size();
        Problem[] pp = new Problem[3];

        if (n % 2 == 0) {
            // Si el vector tiene longitud par, entonces el tercer problema tendrá la mitad del tamaño de los otros dos problemas
            int size = n / 2;
            pp[FIRST_THIRD] = new Max3Prob(new ArrayList<>(array.subList(0, size)));
            pp[SECOND_THIRD] = new Max3Prob(new ArrayList<>(array.subList(size, n)));
            pp[THIRD_THIRD] = new Max3Prob(new ArrayList<>(array.subList(n - size, n)));
        } else {
            // Si el vector tiene longitud impar, entonces todos los problemas tendrán el mismo tamaño
            pp[FIRST_THIRD] = new Max3Prob(new ArrayList<>(array.subList(0, n / 3)));
            pp[SECOND_THIRD] = new Max3Prob(new ArrayList<>(array.subList(n / 3, 2 * n / 3)));
            pp[THIRD_THIRD] = new Max3Prob(new ArrayList<>(array.subList(2 * n / 3, n)));
        }

        return pp;
    }


    @Override
    protected Solution combine(Problem p, Solution[] ss) {
        ArrayList<Integer> array = ((Max3Prob) p).getStartingArr();
        ArrayList<Integer> leftArray = ((Max3Sol) ss[FIRST_THIRD]).getMax3();
        ArrayList<Integer> rightArray = ((Max3Sol) ss[SECOND_THIRD]).getMax3();
        ArrayList<Integer> middleArray = ((Max3Sol) ss[THIRD_THIRD]).getMax3();


        // Se obtienen los máximos de cada subvector y se comparan entre ellos
        int max1 = leftArray.stream().max(Integer::compareTo).orElse(Integer.MIN_VALUE);
        int max2 = rightArray.stream().max(Integer::compareTo).orElse(Integer.MIN_VALUE);
        int max3 = middleArray.stream().max(Integer::compareTo).orElse(Integer.MIN_VALUE);

        // Se obtiene el máximo de los tres máximos
        int max = Math.max(max1, Math.max(max2, max3));
        ArrayList<Integer> maxArray = new ArrayList<>(List.of(max));
        return new Max3Sol(maxArray);
    }


}
