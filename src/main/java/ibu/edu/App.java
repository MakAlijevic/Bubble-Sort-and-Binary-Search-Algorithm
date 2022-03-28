package ibu.edu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) throws IOException {

        //Sorting algorithm
        String path = "C:\\Users\\Korisnik\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED\\IP-COUNTRY-REGION-CITY-SHUFFLED.csv";
        String newPath = "C:\\Users\\Korisnik\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED\\Sorted IPs.csv";

        File file = new File(path);
        File newFile = new File(newPath);
        Scanner input = new Scanner(file);

        FileWriter fileWriter = new FileWriter(newFile);

        String[] ips;
        IPAddress[] ipAddresses = new IPAddress[30];

        int i = 0;
        while(input.hasNextLine() && i < 30){

            String data = input.nextLine();
            data = data.replace("\"", "");
            ips = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            long ipFrom = Long.parseLong(ips[0]);
            long ipTo = Long.parseLong(ips[1]);
            ipAddresses[i] = new IPAddress(ipFrom, ipTo, ips[2], ips[3], ips[4], ips[5]);
            i++;

        }
        input.close();

        BubbleSort.sort(ipAddresses);

        for(int a = 0; a < ipAddresses.length; a++){
            fileWriter.write("\"" + ipAddresses[a].ipFrom + "\"," + "\"" + ipAddresses[a].ipTo + "\"," + "\"" + ipAddresses[a].countryCode + "\"," + "\"" + ipAddresses[a].countryName + "\"," + "\"" + ipAddresses[a].regionName + "\"," + "\"" + ipAddresses[a].cityName + "\n");
        }
        fileWriter.close();



        //Searching algorithm
        String sortedPath = "C:\\Users\\Korisnik\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED\\Sorted IPs.csv";
        File sortedFile = new File(sortedPath);
        Scanner sortedInput = new Scanner(sortedFile);
        Scanner scanner = new Scanner(System.in);

        String[] sortedIps;
        IPAddress[] sortedIpAddresses = new IPAddress[30];

        int j = 0;
        while(sortedInput.hasNextLine() && j < 30){
            String sortedData = sortedInput.nextLine();
            sortedData = sortedData.replace("\"","");
            sortedIps = sortedData.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            long sortedIpFrom = Long.parseLong(sortedIps[0]);
            long sortedIpTo = Long.parseLong(sortedIps[1]);
            sortedIpAddresses[j] = new IPAddress(sortedIpFrom, sortedIpTo, sortedIps[2], sortedIps[3], sortedIps[4], sortedIps[5]);
            j++;
        }
        System.out.println("Enter IP address to search for location : ");
        String ipadd = scanner.nextLine();

        //IP octet extraction method
        int octet[] = new int[4];
        StringBuilder tmp = new StringBuilder();
        int counter = 0;
        for(int p = 0; p<ipadd.length();p++){
            if (ipadd.charAt(p) != '.') {
                tmp.append(ipadd.charAt(p));
            }
            if (ipadd.charAt(p) == '.' || p == ipadd.length() - 1) {
                octet[counter++] = Integer.parseInt(tmp.toString());
                tmp = new StringBuilder();
            }
        }
        int w = octet[0];
        int x = octet[1];
        int y = octet[2];
        int z = octet[3];
    }
}