package com.hegde.practice.binarysearch;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinCostToStoreFiles {

    public static long minimumCostToStoreFiles(
            int N,
            int encryptionCost,
            int flatCost,
            List<Integer> secretFiles
    ){
        if(secretFiles == null || secretFiles.isEmpty())
            return 0;

        secretFiles.sort(Comparator.naturalOrder());
        long totalFiles = (long) Math.pow(2, N);

        return minimumCostToStoreSegment(1L, totalFiles, encryptionCost, flatCost, secretFiles);
    }

    private static long minimumCostToStoreSegment(
            long leftFileIndex,
            long rightFileIndex,
            int encryptionCost,
            int flatCost,
            List<Integer> secretFiles ){

        int secreteFilesInTheRange = getSecretFilesInRange(leftFileIndex, rightFileIndex, secretFiles);
        int files = (int) (rightFileIndex - leftFileIndex + 1);
        if(secreteFilesInTheRange == 0)
            return flatCost;

        long fileStorageCost = (long) files * secreteFilesInTheRange * encryptionCost;

        if(files == 1)
            return (int) (fileStorageCost % Integer.MAX_VALUE);

        long mid = (leftFileIndex + rightFileIndex) / 2;
        long leftStorageCost = minimumCostToStoreSegment(
                leftFileIndex, mid, encryptionCost, flatCost, secretFiles);
        long rightStorageCost = minimumCostToStoreSegment(
                mid + 1, rightFileIndex, encryptionCost, flatCost, secretFiles);

        return Math.min(fileStorageCost, leftStorageCost + rightStorageCost);
    }

    //TODO: Complete this.
    private static int getSecretFilesInRange(
            long leftFileIndex,
            long rightFileIndex,
            List<Integer> secretFiles) {
        return 0;
    }
}
