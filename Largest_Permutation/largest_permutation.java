public static List<Integer> largestPermutation(int k, List<Integer> arr) {
        int n = arr.size();
        int[] position = new int[n + 1];
        for (int i = 0; i < n; i++) {
            position[arr.get(i)] = i;
        }
        int a = 0;
        while (k > 0 && a < n) {
            if (arr.get(a) != n - a) {
                int temp = arr.get(a);
                int swapIndex = position[n - a];
                arr.set(a, n - a);
                arr.set(swapIndex, temp);
                position[temp] = swapIndex;
                position[n - a] = a;
                k--;
            }
            a++;
        }
        return arr;
    }

