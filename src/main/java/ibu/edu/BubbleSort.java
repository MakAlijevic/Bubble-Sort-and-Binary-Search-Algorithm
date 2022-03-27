package ibu.edu;

public class BubbleSort {
    public static void sort(Comparable[] elements) {

        Boolean swap = false;

        for (int i=0;i<elements.length;i++) {
            for(int j = 1; j<elements.length-i;j++ ) {
                if(elements[j-1].compareTo(elements[j])>0) {
                    Comparable temp=elements[j-1];
                    elements[j-1]=elements[j];
                    elements[j]=temp;
                    swap = true;
                }
                if(swap == false){
                    break;
                }
            }
        }
    }
}
