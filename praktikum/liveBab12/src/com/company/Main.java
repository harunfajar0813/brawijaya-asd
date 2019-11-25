package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int counter = 0;

    void sort(int arr[])
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;
            counter++;

            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] valueSplit = input.readLine().split(" ");
        int[] nilai = new int[valueSplit.length];
        for (int i = 0; i < nilai.length; i++) {
            nilai[i] = Integer.parseInt(valueSplit[i]);
        }

        Main ob = new Main();
        ob.sort(nilai);

        System.out.println(counter);
    }
}
