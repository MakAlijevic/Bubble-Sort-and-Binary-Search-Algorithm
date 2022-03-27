package ibu.edu;

public class BubbleSort{

    static boolean swapped;

    public static void sort(Comparable[] elements) {
        for (int i = 0; i < elements.length; i++) {
            for (int j = 1; j < elements.length - i; j++) {
                if (elements[j - 1].compareTo(elements[j])>0) {
                    swap(elements, j - 1, j);
                }
            }
            if (swapped == false) {
                break;
            }
        }
    }
    public static void swap(Comparable[] elements, int a, int b) {
        Comparable tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
        swapped = true;
    }
}
