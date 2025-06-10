import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        /*JobCard jobcard = new JobCard("AIX_JOB", "joba", "ur5a4_crcfg", "/test/test/test/delacach01.sh", "myUser", "crcfg");
        System.out.println(jobcard.getScriptName().trim());
        String[] s = jobcard.getScriptName().split("/");
        for (String n : s) {
            if (n.contains(".sh")) {
                n.trim();
                jobcard.setJobName(n.substring(0, 4));
                System.out.println(n);
                System.out.println(jobcard.getJobName());
            }

        }
        String a = jobcard.getAgent().substring(2, 5);
        System.out.println(a);
        String newName = jobcard.getJobName() + a;
        jobcard.setJobName(newName + "." + jobcard.getArgs());
        System.out.println(jobcard.getJobName());*/


        JobCreator jc = new JobCreator();


        try {

            File file = new File("C:\\Users\\Christopher\\IdeaProjects\\JobRename\\src\\test.txt");
            JobCard jobcard = new JobCard();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {

                String word = scanner.next();
                if (word.equalsIgnoreCase("AIX_JOB")) {
                    //System.out.println("JOB NAME = " + scanner.next());
                    jobcard.setJobType(word);
                    jobcard.setJobName(scanner.next());
                    //System.out.println(scanner.next());

                } else if (word.equalsIgnoreCase("AGENT")) {
                    //System.out.println("READING AGENT ");
                    jobcard.setAgent(scanner.next());
                    //System.out.println(scanner.next());

                } else if (word.equalsIgnoreCase("SCRIPTNAME")) {
                    // System.out.println("READING SCRIPT ");
                    jobcard.setScriptName(scanner.next());
                    //System.out.println("SCRIPT = " + scanner.next());

                } else if (word.equalsIgnoreCase("USER")) {
                    // System.out.print("READING USER ");
                    jobcard.setUser(scanner.next());
                    //System.out.println(scanner.next());

                } else if (word.equalsIgnoreCase("ARGS")) {
                    // System.out.print("READING ARGS ");
                    jobcard.setArgs(scanner.next());
                    // System.out.println(scanner.next());

                } else if (word.equalsIgnoreCase("ENDJOB")) {
                    jc.addJobs(jobcard);
                    jobcard = new JobCard();
                    //System.out.println(jobcard.toString());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }

        try (PrintStream ps = new PrintStream("myNewJobs.txt")) {

            //System.out.println("PRINTING JOBS");
            jc.renameJobs();
            //jc.printJobcards();
            System.out.println("************");
            jc.writeJobs(ps);

            // jc.writeSelect(ps);
            // System.out.println(jc.getJobs().size());
            //jc.createSelect();
            ps.close();
        }

    }
}
