import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MarkOutOfBoundsException, DuplicateSubjectException, IOException {
        Schoolboy Schoolboy1 = new Schoolboy("Smirnov", new String[]{"Mat", "Prog"}, new int[][]{{4, 4}, {3, 5}});
        Scanner in = new Scanner(System.in);
        String s = "";

        while (!"99".equals(s)) {
            System.out.println("1 - Вывод Фамилии");
            System.out.println("2 - Изменение Фамилии");
            System.out.println("3 - Вывод массива Предметов и оценок");
            System.out.println("4 - Изменение значения элемента массива Предметов");
            System.out.println("5 - Изменение значения элемента массива Оценок");
            System.out.println("6 - добавления предмета и оценки в соответствующие массивы");
            System.out.println("7 - получение размера массивов");
            System.out.println("8 - среднее арифметическое оценок");
            System.out.println("9 - запись информации об ученике в байтовый поток ");
            System.out.println("10 - чтение информации об ученике из байтового потока ");
            System.out.println("11 - запись информации об ученике в символьный поток");
            System.out.println("12 - чтение информации об ученике из символьного потока");
            System.out.println("13 - сериализация");
            System.out.println("14 - десерилизация");
            System.out.println("99 - EXIT");
            System.out.print("=> ");
            s = in.nextLine();

            var x = Integer.parseInt(s);
            switch (x) {
                case 1:
                    Schoolboy1.FalenameOut();
                    break;
                case 2:
                    Schoolboy1.FilenameMod();
                    break;
                case 3:
                    Schoolboy1.SubjectsAndMarksOut();
                    break;
                case 4:
                    Schoolboy1.SubjectsMod();
                    break;
                case 5:
                    Schoolboy1.MarksMod();
                    break;
                case 6:
                    Schoolboy1.MarksSubjectsAdd();
                    break;
                case 7:
                    Schoolboy1.ArrLength();
                    break;
                case 8:
                    Schoolboy1.MeanArithmeticMarks();
                    break;
                case 9:
                    Schoolboy1.input_Pupil();
                    break;
                case 10:
                    Schoolboy1.output_Pupil();
                    break;
                case 11:
                    Schoolboy1.read_Pupil();
                    break;
                case 12:
                    Schoolboy1.write_Pupil();
                    break;
                case 13:
                    Schoolboy1.output_Object(Schoolboy1, System.out);
                    break;
                case 14:
                    Schoolboy1.input_Object(Schoolboy1, System.out);
                    Schoolboy1.input_Object(Schoolboy1,System.out).printData();
                    break;
                case 99:
                    return;
                default:
                    System.out.println("No such menu");
            }
        }
    }
}