import javax.security.auth.Subject;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class MarkOutOfBoundsException extends Exception {
    @Override
    public String getMessage() {
        return "Mark is out of bound!";
    }
}

class DuplicateSubjectException extends Exception {
    @Override
    public String getMessage() {
        return "Subject name has been already used!";
    }
}

public abstract class Student implements Pupil, Serializable {
    public static String Falename;
    public static int[][] Marks;
    public static String[] Subjects;

    Student(String f, String[] s, int[][] m) {
        this.Falename = f;
        this.Marks = m;
        this.Subjects = s;
    }

    public void FalenameOut() {
        System.out.println(this.Falename);
    }

    public void FilenameMod() {
        Scanner in = new Scanner(System.in);
        System.out.print("Ввод Фамилии: ");
        this.Falename = in.next();
    }

    public void MarksMod(){
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Ввод [num] массива оценок для изменения: ");
            int num = in.nextInt();
            int bez = 0;
            if (num < 0 || num > Marks.length) {
                throw (new MarkOutOfBoundsException());
            }
            for (int i = 0; i < this.Marks[num].length; ++i) {
                if (this.Marks[num][i] != 0) {
                    bez++;
                }
            }
            System.out.println("Ввод значения оценки: ");
            for (int i = 0; i < bez; ++i) {
                int elem = in.nextInt();
                this.Marks[num][i] = elem;
            }
        } catch (MarkOutOfBoundsException e) {
            System.err.println(e.getMessage());
            System.out.println("Выход за границы массива оценок, в массиве " + this.Marks.length + " элемент(ов)");
        }
    }

    public void SubjectsAndMarksOut() {
        for (int i = 0; i < Subjects.length; ++i) {
            System.out.print(Subjects[i] + ": ");
            for (int j = 0; j < Marks[i].length; j++) {
                if (Marks[i][j] != 0)
                    System.out.print(Marks[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void SubjectsMod() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Ввод [num] массива преметов для изменения: ");
            int num = in.nextInt();
            System.out.println("Ввод предмета: ");
            String elem = in.next();
            for (String sub : Subjects) {
                if (sub.equals(elem)) {
                    throw (new DuplicateSubjectException());
                }
            }
            for (int i = 0; i < this.Subjects.length; ++i) {
                if (i == num) {
                    this.Subjects[i] = elem;
                }
            }
        } catch (DuplicateSubjectException e) {
            System.err.println(e.getMessage());
        }
    }
    public void MeanArithmeticMarks() {
        double mean = 0.00;
        int q = 0;
        for (int i = 0; i < Marks.length; i++) {
            for (int j = 0; j < Marks[i].length; j++) {
                if (Marks[i][j] != 0) {
                    q++;
                    mean += Marks[i][j];
                }
            }
            mean /= q;
            System.out.println("Среднее значение оценок предмета " + Subjects[i] + ": " + mean);
            mean = 0.00;
            q = 0;
        }
    }

    public void MarksSubjectsAdd() {
        Scanner in = new Scanner(System.in);
        System.out.print("Сколько добавить количество предметов: ");
        int koll = in.nextInt();
        int[][] arrMarks = new int[koll][20];
        String[] arrSubjects = new String[koll];
        System.out.println("Ввод " + koll + " предметов: ");
        for(int i = 0; i < arrSubjects.length; ++i) {
            arrSubjects[i] = in.next();
        }
        System.out.println("Ввод оценок к предметам: ");
        for(int i = 0; i < arrMarks.length; ++i) {
            System.out.print("Сколько оценок добавить к предмету - " + arrSubjects[i] + ": ");
            int qwe= in.nextInt();
            for(int j = 0; j < qwe; ++j) {
                arrMarks[i][j] = in.nextInt();
            }
        }
        int[][] new_arrMarks = new int[arrMarks.length + this.Marks.length][];
        System.arraycopy(arrMarks, 0, new_arrMarks, 0, arrMarks.length);
        System.arraycopy(this.Marks, 0, new_arrMarks, arrMarks.length, this.Marks.length);
        this.Marks = Arrays.copyOf(new_arrMarks, new_arrMarks.length);
        String[] new_arrSubjects = new String[arrSubjects.length + this.Subjects.length];
        System.arraycopy(arrSubjects, 0, new_arrSubjects, 0, arrSubjects.length);
        System.arraycopy(this.Subjects, 0, new_arrSubjects, arrSubjects.length, this.Subjects.length);
        this.Subjects = Arrays.copyOf(new_arrSubjects, new_arrSubjects.length);
    }

    public void ArrLength() {
        System.out.println("Длина массива предметов: " + this.Subjects.length);
        for (int i = 0; i < Marks.length; ++i) {
            System.out.print(" Длина массива оценок предмета " + Subjects[i] + ": ");
            int sum = 0;
            for (int j = 0; j < Marks[i].length; ++j) {
                if (Marks[i][j] != 0) {
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
}