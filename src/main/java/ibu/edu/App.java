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
        IPAddress[] ipAddresses = new IPAddress[4637054];

        int i = 0;
        while(input.hasNextLine()){
            String data = input.nextLine();
            data = data.replace("\"", "");
            ips = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            String ipFrom = ips[0];
            long ipfrom = Long.parseLong(ipFrom);
            String ipTo = ips[1];
            long ipto = Long.parseLong(ipTo);
            ipAddresses[i] = new IPAddress(ipfrom, ipto, ips[2], ips[3], ips[4], ips[5]);
            System.out.println(ipAddresses);
            i++;
        }
        input.close();

        BubbleSort.sort(ipAddresses);
    }
}
