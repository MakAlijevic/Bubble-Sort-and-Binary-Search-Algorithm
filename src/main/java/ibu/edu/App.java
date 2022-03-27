package ibu.edu;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws IOException {
        String path = "C:\\Users\\Korisnik\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED\\IP-COUNTRY-REGION-CITY-SHUFFLED.csv";

        File file = new File(path);
        Scanner input = new Scanner(file);

        String[] ips;
        IPAddress[] ipAddresses = new IPAddress[20];

        int i = 0;
        while(input.hasNextLine() && i < 20){
            String data = input.nextLine();
            data = data.replace("\"", "");
            ips = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            long ipFrom = Long.parseLong(ips[0]);
            long ipTo = Long.parseLong(ips[1]);
            ipAddresses[i] = new IPAddress(ipFrom, ipTo, ips[2], ips[3], ips[4], ips[5]);
            System.out.println(ipAddresses[i]);
            i++;

        }
        input.close();

        BubbleSort.sort(ipAddresses);
    }
}
