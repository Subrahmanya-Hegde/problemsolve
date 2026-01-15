package com.hegde.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public cla
/**
 * https://takeuforward.org/plus/dsa/problems/generate-binary-strings-without-consecutive-1s
 */
public class BinaryStringsWithoutConsecutiveOnes {

    public List<String> generateBinaryStrings(int n) {
        List<String> answer = new ArrayList<>();
        generateBinary(new StringBuilder(), n, answer);
        return answer;
    }

    private void generateBinary(StringBuilder sb, int n, List<String> answer){
        if(sb.length() == n) {
            answer.add(sb.toString());
            return;
        }
        sb.append("0");
        generateBinary(sb, n, answer);
        sb.deleteCharAt(sb.length() - 1);

        if(sb.isEmpty() || sb.charAt(sb.length() - 1) != '1') {
            sb.append("1");
            generateBinary(sb, n, answer);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
