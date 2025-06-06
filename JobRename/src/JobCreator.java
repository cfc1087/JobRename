import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;


public class JobCreator {

    private ArrayList<JobCard> jobs = new ArrayList<>();
    private PrintStream ps = new PrintStream(new File("myNewProc.txt"));

    public JobCreator() throws FileNotFoundException {
    }

    public JobCreator(JobCard job) throws FileNotFoundException {
        this.jobs.add(job);
    }

    public ArrayList<JobCard> getJobs() {
        return jobs;
    }

    public void setJobs(ArrayList<JobCard> jobs) {
        this.jobs = jobs;
    }

    public void addJobs(JobCard jobcard) {
        this.jobs.add(jobcard);
    }

    public PrintStream getPs() {
        return ps;
    }

    public void setPs(PrintStream ps) {
        this.ps = ps;
    }

    public void renameJobs() {
        for (JobCard job : jobs) {
            String[] s = job.getScriptName().split("/");
            for (String n : s) {
                if (n.contains(".sh")) {
                    n.trim();
                    job.setJobName(n.substring(0, 4));
                }

            }
            String a = job.getAgent().substring(2, 5);
            String newName = job.getJobName() + a;
            job.setJobName(newName + "." + job.getArgs());
        }

    }

    public void printJobcards() {

        for (JobCard job : jobs) {
            System.out.println(job + "\n");
        }
    }

    public void createSelect() {
        System.out.print("SELECT (");

        int a = 0;
        for (int i = 0; i < jobs.size(); i++) {
            if (a < 2&&i!= jobs.size()-1) {
                System.out.print(jobs.get(i).getJobName() + ",");
                a++;
            }
            else if (a == 2&&i!= jobs.size()-1) {
                System.out.print(jobs.get(i).getJobName() + ",+" + "\n");
                a = 0;
            }
            if(i==jobs.size()-1){
                System.out.print(jobs.get(i).getJobName()+")");
            }


        }


    }
}
