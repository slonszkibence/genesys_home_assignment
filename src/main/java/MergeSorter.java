import java.util.ArrayList;
import java.util.List;

public class MergeSorter<I extends Comparable<I>> {
    private MergeSorter() {}

    public static<I extends Comparable<I>> List<I> sort(List<I> list) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        List<I> left = list.subList(0, mid);
        List<I> right = list.subList(mid, list.size());

        return merge(sort(left), sort(right));
    }
    private static<I extends Comparable<I>> List<I> merge(List<I> firstList, List<I> secondList) {
        List<I> result = new ArrayList<>();

        int i = 0, j = 0;
        while (i < firstList.size() && j < secondList.size()) {
            if (firstList.get(i).compareTo(secondList.get(j)) <= 0) {
                result.add(firstList.get(i++));
            }
            else {
                result.add(secondList.get(j++));
            }
        }
        while (i < firstList.size()) {
            result.add(firstList.get(i++));
        }
        while (j < secondList.size()) {
            result.add(secondList.get(j++));
        }
        return result;
    }
}
