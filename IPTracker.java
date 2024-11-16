import java.net.InetAddress;
import java.time.LocalDate;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class IPTracker{

    private String Hostname;
    private String HostIp;
    private String date;
    private File logFile;
    public String logMessage;

    public IPTracker(String Hostname){
        this.Hostname = Hostname;
        this.HostIp = getIp();
        this.date = LocalDate.now().toString(); 
        this.logFile = new File("ipTracker.log");
        this.logMessage = String.format("%s\t%s\t%s", this.date, this.HostIp, this.Hostname);
    }


    private String getIp(){
        try{
            InetAddress ip = InetAddress.getByName(this.Hostname);
            return ip.getHostAddress();
        }
        catch(Exception e){
            return "0.0.0.0";
        }
        
        
    }

    public void writeIp(){
        try{
            FileWriter writeLog = new FileWriter(logFile, true);
            BufferedWriter appedLog = new BufferedWriter(writeLog);
            appedLog.write(this.logMessage);
            appedLog.newLine();
            appedLog.close();

        }
        catch(Exception exception){
            System.out.println("Error while writing to log file\n" + exception);
        }
    }
    
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("Need Domain name / FQDN as argument to run!");
            System.exit(1);
        }
        else{
            IPTracker tracker = new IPTracker(args[0]);
            tracker.writeIp();
        }


    }


}