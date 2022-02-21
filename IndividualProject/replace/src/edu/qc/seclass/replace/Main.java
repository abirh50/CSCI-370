package edu.qc.seclass.replace;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        // TODO: Empty skeleton method
        if(args.length < 4){
            usage();
            return;
        }

        int countDashLast = 0;  // last "--" index
        int countDash = 0;      // number of "--"
        int countDashFirst = 0; // first "--" index
        for(int i=0; i < args.length; i++){
            if(args[i].equals("--")){
                countDashLast = i;
                if(countDash == 0){
                    countDashFirst = i;
                }
                countDash++;
            }
        }

        boolean iOpt = false;   // checking for "-i" OPT
        for(int i=0; i < countDashFirst; i++){
            if (args[i].equals("-i")) {
                iOpt = true;
                break;
            }
        }

        if(countDashLast < 2){
            usage();
            return;
        }

        if(countDashLast == 2 && (args[0].equals("") || args[0].equals("-b") || args[0].equals("-f") || args[0].equals("-l") || args[0].equals("-i"))){
            usage();
            return;
        }

        if(countDashLast == 2 || (countDashLast == 3 && args[0].equals("--")) || (countDashLast == 3 && args[0].equals("-i"))){
            int j = countDashLast+1; // when countDashLast = 2
            while (j < args.length) {
                String str = "";
                try {
                    str = new String(Files.readAllBytes(Paths.get(args[j])));
                } catch (IOException e) {
                    System.err.println("File " + Paths.get(args[j]).getFileName() + " not" + " found");
                }
                String from = args[countDashLast - 2];
                String to = args[countDashLast - 1];

                if(from.equals("")){
                    System.err.println("\"from\" can't be an empty string!!!");
                    return;
                }

                String str2;
                if(countDashLast == 3 && args[0].equals("-i")){
                    str2 = str.replaceAll("(?i)" + from, to); // (?i) makes it case insensitive
                }
                else {
                    str2 = str.replaceAll(from, to);
                }

                try {
                    File file = new File(args[j]);
                    FileWriter fW = new FileWriter(file);
                    fW.write(str2);
                    fW.flush();
                    fW.close();
                } catch (IOException e) {
                    System.err.println("File not found");
                }

                j++;
            }
        }

        int h = 0;
        while (h < countDashLast-2){
            if(!(args[h].equals("--") || args[h].equals("-b") || args[h].equals("-f") || args[h].equals("-l") || args[h].equals("-i"))){
                usage();
                return;
            }
            h++;
        }


        if (countDash == 1) {
            for (int i = 0; i < countDashLast + 2; i++) {
                if (args[i].equals("-b")) {
                    int j = countDashLast + 1; // when countDashLast > 2
                    while (j < args.length) {
                        String str = "";
                        try {
                            str = new String(Files.readAllBytes(Paths.get(args[j])));
                        } catch (IOException e) {
                            System.err.println("File " + Paths.get(args[j]).getFileName() + " not" + " found");
                        }

                        String from = args[countDashLast - 2];
                        String to = args[countDashLast - 1];

                        if(from.equals("")){
                            System.err.println("\"from\" can't be an empty string!!!");
                            return;
                        }

                        String str2 = str;
                        if(iOpt && countDashLast == 4){
                            str2 = str.replaceAll("(?i)" + from, to); // (?i) makes it case insensitive
                        }
                        if(countDashLast == 3 && args[0].equals("-b")) {
                            str2 = str.replaceAll(from, to);
                        }

                        try {
                            File file = new File(args[j]);

                            FileWriter fWBackup = new FileWriter(file + ".bck");
                            fWBackup.flush();
                            fWBackup.close();

                            FileWriter fW = new FileWriter(file);
                            if(from.equals(to)) {
                                fW.write("");
                            }
                            else {
                                fW.write(str2);
                            }
                            fW.flush();
                            fW.close();
                        } catch (IOException e) {
                            System.err.println("File not found");
                        }

                        j++;
                    }
                }
            }

            for (int i = 0; i < countDashLast + 2; i++) {
                if (args[i].equals("-f")) {
                    int j = countDashLast + 1; // when countDashLast > 2
                    while (j < args.length) {
                        String str = "";
                        try {
                            str = new String(Files.readAllBytes(Paths.get(args[j])));
                        } catch (IOException e) {
                            System.err.println("File " + Paths.get(args[j]).getFileName() + " not" + " found");
                        }

                        String from = args[countDashLast - 2];
                        String to = args[countDashLast - 1];

                        if(from.equals("")){
                            System.err.println("\"from\" can't be an empty string!!!");
                            return;
                        }

                        String str2;
                        if(iOpt){
                            str2 = str.replaceFirst("(?i)" + from, to); // (?i) makes it case insensitive
                        }
                        else {
                            str2 = str.replaceFirst(from, to);
                        }

                        try {
                            File file = new File(args[j]);
                            FileWriter fW = new FileWriter(file);
                            fW.write(str2);
                            fW.flush();
                            fW.close();
                        } catch (IOException e) {
                            System.err.println("File not found");
                        }

                        j++;
                    }
                }
            }

            for (int i = 0; i < countDashLast + 2; i++) {
                if (args[i].equals("-l")) {
                    int j = countDashLast + 1; // when countDashLast > 2
                    while (j < args.length) {
                        String str = "";
                        try {
                            str = new String(Files.readAllBytes(Paths.get(args[j])));
                        } catch (IOException e) {
                            System.err.println("File " + Paths.get(args[j]).getFileName() + " not" + " found");
                        }

                        String from = args[countDashLast - 2];
                        String to = args[countDashLast - 1];

                        if(from.equals("")){
                            System.err.println("\"from\" can't be an empty string!!!");
                            return;
                        }

                        String str2;
                        if(iOpt){
                            str2 = str.replaceFirst("(?i)(?s)(.*)" + from, "$1" + to); // (?i) makes it case insensitive
                        }
                        else {
                            str2 = str.replaceFirst("(?s)(.*)" + from, "$1" + to); // "(?s)(.*)" and "$1" regex to replace last
                        }

                        try {
                            File file = new File(args[j]);
                            FileWriter fW = new FileWriter(file);
                            fW.write(str2);
                            fW.flush();
                            fW.close();
                        } catch (IOException e) {
                            System.err.println("File not found");
                        }

                        j++;
                    }
                }
            }
        }
        else {
            for (int i = 0; i < countDashFirst; i++) {
                if (args[i].equals("-b")) {
                    int j = countDashLast + 1; // when countDashLast > 2
                    while (j < args.length) {
                        String str = "";
                        try {
                            str = new String(Files.readAllBytes(Paths.get(args[j])));
                        } catch (IOException e) {
                            System.err.println("File " + Paths.get(args[j]).getFileName() + " not" + " found");
                        }

                        String from = args[countDashLast - 2];
                        String to = args[countDashLast - 1];

                        if(from.equals("")){
                            System.err.println("\"from\" can't be an empty string!!!");
                            return;
                        }

                        String str2 = str;
                        if(iOpt && countDashFirst == 2){
                            str2 = str.replaceAll("(?i)" + from, to); // (?i) makes it case insensitive
                        }
                        if(countDashFirst == 1 && args[0].equals("-b")) {
                            str2 = str.replaceAll(from, to);
                        }

                        try {
                            File file = new File(args[j]);

                            FileWriter fWBackup = new FileWriter(file + ".bck");
                            fWBackup.flush();
                            fWBackup.close();

                            FileWriter fW = new FileWriter(file);
                            if(from.equals(to)) {
                                fW.write("");
                            }
                            else {
                                fW.write(str2);
                            }
                            fW.flush();
                            fW.close();
                        } catch (IOException e) {
                            System.err.println("File not found");
                        }

                        j++;
                    }
                }
            }

            for (int i = 0; i < countDashFirst; i++) {
                if (args[i].equals("-f")) {
                    int j = countDashLast + 1; // when countDashLast > 2
                    while (j < args.length) {
                        String str = "";
                        try {
                            str = new String(Files.readAllBytes(Paths.get(args[j])));
                        } catch (IOException e) {
                            System.err.println("File " + Paths.get(args[j]).getFileName() + " not" + " found");
                        }

                        String from = args[countDashLast - 2];
                        String to = args[countDashLast - 1];

                        if(from.equals("")){
                            System.err.println("\"from\" can't be an empty string!!!");
                            return;
                        }

                        String str2;
                        if(iOpt){
                            str2 = str.replaceFirst("(?i)" + from, to); // (?i) makes it case insensitive
                        }
                        else {
                            str2 = str.replaceFirst(from, to);
                        }

                        try {
                            File file = new File(args[j]);
                            FileWriter fW = new FileWriter(file);
                            fW.write(str2);
                            fW.flush();
                            fW.close();
                        } catch (IOException e) {
                            System.err.println("File not found");
                        }

                        j++;
                    }
                }
            }

            for (int i = 0; i < countDashFirst; i++) {
                if (args[i].equals("-l")) {
                    int j = countDashLast + 1; // when countDashLast > 2
                    while (j < args.length) {
                        String str = "";
                        try {
                            str = new String(Files.readAllBytes(Paths.get(args[j])));
                        } catch (IOException e) {
                            System.err.println("File " + Paths.get(args[j]).getFileName() + " not" + " found");
                        }

                        String from = args[countDashLast - 2];
                        String to = args[countDashLast - 1];

                        if(from.equals("")){
                            System.err.println("\"from\" can't be an empty string!!!");
                            return;
                        }

                        String str2;
                        if(iOpt){
                            str2 = str.replaceFirst("(?i)(?s)(.*)" + from, "$1" + to); // (?i) makes it case insensitive
                        }
                        else {
                            str2 = str.replaceFirst("(?s)(.*)" + from, "$1" + to); // "(?s)(.*)" and "$1" regex to replace last
                        }

                        try {
                            File file = new File(args[j]);
                            FileWriter fW = new FileWriter(file);
                            fW.write(str2);
                            fW.flush();
                            fW.close();
                        } catch (IOException e) {
                            System.err.println("File not found");
                        }

                        j++;
                    }
                }
            }
        }
    }

    private static void usage() {
        System.err.println("Usage: Replace [-b] [-f] [-l] [-i] <from> <to> -- " + "<filename> [<filename>]*" );
    }

}