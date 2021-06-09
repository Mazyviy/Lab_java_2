import java.io.*;

public class Pupils {
    public void input_Pupil() throws IOException {
        FileOutputStream fos = new FileOutputStream("qwe.bin");
        try (DataOutputStream dos = new DataOutputStream(fos)) {
            dos.writeUTF(Schoolboy.Falename);
            for (int i = 0; i < Schoolboy.Subjects.length; ++i) {
                dos.writeUTF(Schoolboy.Subjects[i]);
                for (int j = 0; j < Schoolboy.Marks[i].length; j++) {
                    if (Schoolboy.Marks[i][j] != 0) {
                        dos.writeInt(Schoolboy.Marks[i][j]);
                    }
                }
            }
            System.out.println("Запись в файл выполнена");
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void output_Pupil() throws IOException {
        try(DataInputStream dis = new DataInputStream(new FileInputStream("qwe.bin"))) {
            String f = dis.readUTF();
            String[] s = new String[Schoolboy.Subjects.length];
            int[][] m = new int[Schoolboy.Subjects.length][Schoolboy.Marks.length];

            for (int i = 0; i <s.length; ++i) {
                s[i] = dis.readUTF();
                for (int j = 0; j < m[i].length; j++) {
                    m[i][j] = dis.readInt();
                }
            }

            System.out.println(f);
            for (int i = 0; i < Schoolboy.Subjects.length; ++i) {
                System.out.print(s[i] + ": ");
                for (int j = 0; j < Schoolboy.Marks[i].length; j++) {
                    if (m[i][j] != 0) {
                        System.out.print(m[i][j] + " ");
                    }
                }
                System.out.println();
            }
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void write_Pupil () {
        try(FileOutputStream fos = new FileOutputStream("qwe.txt");
            PrintStream printStream = new PrintStream(fos))
        {
            printStream.print(Schoolboy.Falename + " ");
            for (int i = 0; i <Schoolboy.Subjects.length; ++i) {
                printStream.print(Schoolboy.Subjects[i] + " ");
                for (int j = 0; j < Schoolboy.Marks[i].length; j++) {
                    printStream.print(Schoolboy.Marks[i][j] + " ");
                }
            }
            System.out.print("Запись в файл произведена\n");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void read_Pupil() {
        try(BufferedReader fin = new BufferedReader (new FileReader("qwe.txt")))
        {
            String rawData = fin.readLine();
            String[] tokens = rawData.split(" ");
            String name = tokens[0];
            for(int i = 0; i < tokens.length; i++) {
                System.out.println(tokens[i]);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void output_Object(Pupil v, OutputStream out){
        try(ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream("qwe.dat")))
        {
            fout.writeObject(v);
            out.write("Сериализация завершена\n".getBytes());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public Pupil input_Object(Pupil v, OutputStream out) {
        try(ObjectInputStream fin = new ObjectInputStream(new FileInputStream("qwe.dat")))
        {
            v = (Student)fin.readObject();
            out.write("Десериализация завершена\n".getBytes());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return v;
    }
}
