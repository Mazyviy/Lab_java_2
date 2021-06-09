import java.io.FileNotFoundException;
import java.io.PrintStream;

interface Pupil {
    void FalenameOut();
    void FilenameMod();
    void MarksMod() throws MarkOutOfBoundsException;
    void SubjectsMod() throws DuplicateSubjectException;
    void SubjectsAndMarksOut();
    void MarksSubjectsAdd();
    void ArrLength();
    void MeanArithmeticMarks();

    void input_Pupil() throws FileNotFoundException;
    void output_Pupil();
    void write_Pupil();
    void read_Pupil();
    void output_Object(Schoolboy schoolboy1, PrintStream out);
    Pupil input_Object(Schoolboy schoolboy1, PrintStream out);

    void printData();
}