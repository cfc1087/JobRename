import java.io.*;
import java.util.ArrayList;


public class JobCreator {

    private ArrayList<JobCard> jobs = new ArrayList<>();


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


    public void renameJobs() {
        for (JobCard job : jobs) {
            String[] s = job.getScriptName().split("/");
            for (String n : s) {
                if (n.contains(".sh")) {
                    n.trim();
                    job.setJobName(n.substring(0, 4));
                }

            }
            String agent = job.getAgent();
            String a = agent.substring(2, agent.indexOf("_"));
            String newName = job.getJobName() + a;
            String opa = "opa";
            if (job.getArgs().equals("NotFound") && job.getScriptName().toLowerCase().contains(opa)) {
                job.setJobName(newName.toUpperCase() + "." + opa.toUpperCase());
            } else {
                job.setJobName(newName.toUpperCase() + "." + job.getArgs().toUpperCase());
            }
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
            if (a < 2 && i != jobs.size() - 1) {
                System.out.print(jobs.get(i).getJobName() + ",");
                a++;
            } else if (a == 2 && i != jobs.size() - 1) {
                System.out.print(jobs.get(i).getJobName() + ",+" + "\n");
                a = 0;
            }
            if (i == jobs.size() - 1) {
                System.out.print(jobs.get(i).getJobName() + ")");
            }


        }


    }

    public void writeJobs(PrintStream ps) {
        for (JobCard job : jobs) {
            ps.println(job + "\n");
        }
    }

    public void writeSelect(PrintStream ps) {
        ps.print(" SELECT (");

        int a = 0;
        for (int i = 0; i < jobs.size(); i++) {
            if (a < 2 && i != jobs.size() - 1) {
                ps.print(jobs.get(i).getJobName() + ",");
                a++;
            } else if (a == 2 && i != jobs.size() - 1) {
                ps.print(jobs.get(i).getJobName() + ",+" + "\n" + "\t\t ");
                a = 0;
            }
            if (i == jobs.size() - 1) {
                ps.print(jobs.get(i).getJobName() + ")");
            }
        }

    }

}
