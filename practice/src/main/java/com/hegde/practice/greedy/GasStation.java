package com.hegde.practice.greedy;

/**
 * https://neetcode.io/problems/gas-station/question
 */
class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int stations = gas.length;

        for(int i = 0; i < stations; i++){
            int j = i, coveredStation = 0, gasInCar = 0;
            while (coveredStation < stations){
                gasInCar = gasInCar + gas[j] - cost[j];
                if (gasInCar < 0) break;

                j = (j + 1) % stations;
                coveredStation++;
            }
            if(coveredStation == stations)
                return i;
        }
        return -1;
    }

    /**
     * Conditions:
     * gasInCar = gas[i] - cost[i] : this should be positive if we want to cover all the stations
     * Goal - find the station right after the last deficit point.
     * Example:
     * gas  = [1, 2, 1, 3, 4, 5, 6, 7]
     * cost = [2, 4, 5, 4, 7, 4, 4, 4]
     * costDifference = [-1,-2,-4,-1,-3, 1, 2, 3]
     * If we start anywhere before 5th index, we cannot go because everywhere cost is high.
     * So start from 5th index and traverse. If the total gas cost is +ve then return 5th index
     * or return -1 because we cannot traverse.
     */
    public int canCompleteCircuitGreedy(int[] gas, int[] cost) {
        int gasInCar = 0, totalGasCost = 0, stations = gas.length, startingStation = 0;

        for(int i = 0; i < stations; i++){
            int costDifference = gas[i] - cost[i];
            gasInCar += costDifference;
            totalGasCost += costDifference;

            if(gasInCar < 0){
                startingStation = (i + 1) % stations;
                gasInCar = 0;
            }
        }
        return totalGasCost >= 0 ? startingStation : -1;
    }
}

