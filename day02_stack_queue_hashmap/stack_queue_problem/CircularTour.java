package day02_stack_queue_hashmap.stack_queue_problem;

class CircularTour {
    public static int findStartingPump(int[] petrol, int[] distance) {
        int n = petrol.length;
        int totalFuel = 0, currentFuel = 0, start = 0;

        for (int i = 0; i < n; i++) {
            totalFuel += petrol[i] - distance[i];
            currentFuel += petrol[i] - distance[i];

            // If we run out of fuel, reset starting point
            if (currentFuel < 0) {
                start = i + 1;
                currentFuel = 0;
            }
        }
        return totalFuel >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        int start = findStartingPump(petrol, distance);

        if (start == -1) {
            System.out.println("No solution exists, can't complete the tour.");
        } else {
            System.out.println("Start at petrol pump index: " + start);
        }
    }
}
