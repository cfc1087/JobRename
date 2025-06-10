public class JobCard {
    private String jobType;
    private String jobName;
    private String agent;
    private String scriptName;
    private String user;
    private String args;

    public JobCard() {
    }

    public JobCard(String jobType, String jobName, String agent, String scriptName, String user, String args) {
        this.jobType = jobType;
        this.jobName = jobName;
        this.agent = agent;
        this.scriptName = scriptName;
        this.user = user;
        this.args = args;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }



    @Override
    public String toString() {
        String jobname = this.jobType.toUpperCase() + " " + this.jobName + "\n";
        String agent = " AGENT " + this.agent + "\n";
        String scriptName = " SCRIPTNAME " + this.scriptName + "\n";
        String user = " USER " + this.user + "\n";
        String args = " ARGS " + this.args + "\n";

        String jobCard = jobname + agent + scriptName + user + args + " ENDJOB";

        return jobCard;
    }
}
