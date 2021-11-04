mf.txt
Who has access
Not shared
System properties
Type
Text
Size
2 KB
Storage used
2 KB
Location
My Drive
Owner
me
Modified
Mar 29, 2020 by me
Opened
10:07 PM by me
Created
Mar 29, 2020
Add a description
Viewers can download
package mergefiles;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class MergeFiles {

    public static void main(String[] args) throws Exception {
        File f1 = new File("file1.txt");
        File f2 = new File("file2.txt");
        if (!f1.exists()) {
            System.out.println("file doesn't exist");
            System.exit(0);
        }
        if (!f2.exists()) {
            System.out.println("file doesn't exist");
            System.exit(0);
        }
        File MF = new File("mergedFile.txt");
        if (MF.exists()) {
            System.out.println("file already exist");
            System.exit(0);
        }
        ArrayList<String> names = new ArrayList<>();
        try (
                Scanner input1 = new Scanner(f1);
                Scanner input2 = new Scanner(f2);
                PrintWriter output = new PrintWriter(MF);) {
            while (input1.hasNext()) {
                names.add(input1.nextLine());
            }
            while (input2.hasNext()) {
                names.add(input2.nextLine());

            }
            
            //check dublications
            for (int i = 0; i < names.size(); i++) {
                for (int j = 0; j < names.size(); j++) {
                    if (j == i) {
                        continue;
                    }
                    if (names.get(i).equals(names.get(j))) {
                        names.remove(j);
                    }
                }
            }
            //convert arraylist to array and printing the contents of merge file
            String[] array = new String[names.size()];
            for (int i = 0; i < names.size(); i++) {
                array[i] = names.get(i);

            }
            //write values to file
            try (PrintWriter pw = new PrintWriter(MF)) {

                for (String i : array) {
                    pw.write(i + "\n");
                }
                pw.close();}
            //print values 
            System.out.println(Arrays.toString(array));
            output.close();
            
        }

    }
}
    
    
