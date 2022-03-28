package ibu.edu;

public class BinarySearch {
    public static IPAddress binarySearch(IPAddress[] ips, long key) {
        int low = 0;
        int high = ips.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ips[mid].ipFrom > key && ips[mid].ipTo > key) {
                high = mid - 1;
            } else if (ips[mid].ipFrom < key && ips[mid].ipTo < key) {
                low = mid + 1;
            } else {
                return ips[mid];
            }
        }
        return null;
    }
}
