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

        String[] ips = new String[50];
        IPAddress[] ipAddresses = new IPAddress[50];

        int i = 0;
        while(input.hasNextLine()){
            String data = input.nextLine();
            data = data.replace("\"", "");
            ips = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            String ipFrom = ips[0];
            long ipfrom = Long.parseLong(ipFrom);
            String ipTo = ips[1];
            long ipto = Long.parseLong(ipTo);
            System.out.println(ipto);
            i++;
        }
        input.close();
    }
}
