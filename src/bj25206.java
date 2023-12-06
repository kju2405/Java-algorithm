import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] gradeAlphabet = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
        double[] gradeScore = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};
        double totalScore = 0;
        double totalSubjectGrade = 0;

        for (int i = 0; i < 20; i++) {
            String line = bufferedReader.readLine();
            String[] score = line.split(" ");

            if (score[2].equals("P")) {
                continue;
            }
            double subjectGrade = Double.parseDouble(score[1]);
            totalSubjectGrade += subjectGrade;
            for (int j = 0; j < gradeAlphabet.length; j++) {
                if (score[2].equals(gradeAlphabet[j])) {
                    totalScore += subjectGrade * gradeScore[j];
                }
            }
        }

        double average = totalScore / totalSubjectGrade;

        System.out.printf("%.6f", average);
        bufferedReader.close();
    }
}
