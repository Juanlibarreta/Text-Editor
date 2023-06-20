package Models;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.stage.FileChooser;

public class Model {
    private FileChooser fil = new FileChooser();

    public File abrirDoc(){
        File f = fil.showOpenDialog(null);

        if(f != null){
            if(f.getAbsolutePath().contains(".txt")){
                System.out.println("Archivo de texto");
            }else{
                return null;
            }
        }
        return f;
    }

    public String openFile(File f) throws FileNotFoundException {
        String n = "";
        try(Scanner sc = new Scanner(f)){
            while(sc.hasNext()){
                n += sc.nextLine();
                n+= "\n";
            }
        }
        return n;
    }

    public void saveDoc(String text) throws FileNotFoundException {
        File f = fil.showSaveDialog(null);
        if(!f.exists()){
            new PrintWriter(f).close();
        }
        try(PrintWriter pw = new PrintWriter(f)){
            pw.write(text);
        }
    }
}
