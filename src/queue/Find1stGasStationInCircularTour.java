package queue;

/**
 * Suppose there is a circle. There are n petrol pumps on that circle.
 * You are given two sets of data
 *
 * 1. The amount of petrol that every petrol pump has
 * 2. Distance from that petrol pump to the next petrol pump
 *
 * Calculate the first point from where a truck will be able to complete the circle (The truck will stop at each petrol pump and it has infinite capacity).
 * Expected time complexity is O(n).
 * Assume for 1 litre petrol, the truck can go 1 unit of distance
 *
 * For example, let there be 4 petrol pumps with amount of petrol and distance to next petrol pump value pairs as
 * Input: {4, 6}, {6, 5}, {7, 3} and {4, 5}.
 * {4, 3}, {3, 5}, {6, 7}, {5, 8}
 *
 * The first point from where truck can make a circular tour is 2nd petrol pump.
 * Output should be “start = 1” (index of 2nd petrol pump).
 *
 */

public class Find1stGasStationInCircularTour {

    static class GasStation {
        int gas;
        int distance;

        public GasStation(int gas, int distance) {
            this.gas = gas;
            this.distance = distance;
        }
    }

    public static int find1stGasStationToCompleteTour(GasStation[] g) {
        int n = g.length;

        int start = 0;
        int end = 1;
        int currentGasLevel = g[start].gas - g[start].distance;

        while (start != end || currentGasLevel < 0) {

            while (start != end && currentGasLevel < 0) {
                currentGasLevel -= g[start].gas - g[start].distance;
                start = (start + 1) % n;

                if(start == 0) {
                    return -1;
                }
             }

            currentGasLevel += g[end].gas - g[end].distance;
            end = (end + 1) % n;
        }

        return start;
    }

    public static void main(String[] args)
    {

//        GasStation[] arr = {new GasStation(6, 4),
//                new GasStation(3, 6),
//                new GasStation(7, 3)};

        GasStation[] arr = {
                new GasStation(4, 3),
                new GasStation(3, 5),
                new GasStation(6, 7),
                new GasStation(7, 8)
        };

        int start = find1stGasStationToCompleteTour(arr);

        System.out.println(start == -1 ? "No Solution" : "Start = " + start);

    }
}
