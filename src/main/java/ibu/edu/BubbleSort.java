package ibu.edu;

public class BubbleSort{

    static boolean swapped = false;

    public static void sort(Comparable[] elements) {

        Comparable temp;

        for (int i=0;i<elements.length;i++)
        {
            for(int j = 1; j < (elements.length-i);j++ )
            {
                if(elements[j-1].compareTo(elements[j])>0)
                {
                    temp=elements[j-1];
                    elements[j-1]=elements[j];
                    elements[j]=temp;
                    swapped = true;
                }

            }
            if(swapped == false){
                break;
            }
        }
    }
}
