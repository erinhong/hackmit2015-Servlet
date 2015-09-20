import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Servlet for Tripster Android Application
 */

@WebServlet("/Servlet")
public class Servlet extends HttpServlet{ 
    private static final long serialVersionUID=1L; 
    private static final String flightAwareURL = "https://flightaware.com/live/flight/JBU1031"; 
    
    
    /**
     * @see HttpServlet#HttpServlet() 
     */
    public Servlet(){
        super(); 
        System.out.println("WOOHOO I got into servlet"); 
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("YOU HAVE GOTTEN TO DOGET"); 
        getURLContents(flightAwareURL);
        
        
        response.setContentType("test/html"); 
        response.getWriter().println("you have reached doGet()."); 
    }
    protected void doPost(HttpServletRequest request, HttpServlet response) throws ServletException, IOException{
        System.out.println("you have reached doPost()."); 
         
        }
    
    @SuppressWarnings("finally")
    private static String getURLContents(String flightAwareURLString) throws IOException{
        StringBuilder flightStatus = new StringBuilder();
        try{
        
        System.out.println("you have reached getURLContents()"); 
        URL flightAwareURL = new URL(flightAwareURLString); 
        java.net.URLConnection URLConnection = flightAwareURL.openConnection();
        URLConnection.connect();  
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(URLConnection.getInputStream()));
        String line;
        // read from the urlconnection via the bufferedreader
        int lineCounter=0;
        while ((line = bufferedReader.readLine()) != null)
        {
          lineCounter++; 
          if (lineCounter==205){
              flightStatus.append(line.substring(543, 552));
          
        }}
        bufferedReader.close();
        }finally{
            System.out.println(flightStatus.toString());
            return flightStatus.toString(); 
            }
    }}
    

/*




/**
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 
        try{
            System.out.println("DoPost() is running..."); 
            //PrintWriter out = response.getWriter(); //Sends it back to the android application 
            
            
            
          //-------------------TESTER CODE ----------------------------
            
            String parametersString= request.getParameter("PHONE_NUMBER,TIMESTAMP,SMS_TYPE,MESSAGE"); 
            System.out.println(parametersString);
            String[] parameters = parametersString.split(":",SPLIT_LIMIT); 
            System.out.println(parameters.length);
            System.out.println("Phone Number: "+parameters[0]);
            System.out.println("Time Stamp: "+parameters[1]);
            System.out.println("SMS Type: "+parameters[2]);
            System.out.println("Message: "+parameters[3]);
            
            //System.out.println("Fifth: "+parameters[4]);
            
            if (parameters.length ==4){
            phoneNumber = parameters[0]; 
            timestamp = parameters[1]; 
            smsType = parameters[2]; 
            message = parameters[3];
            }else{
                phoneNumber= "1234567890"; 
                timestamp = "1234567890"; 
                smsType = "INCOMING"; 
                message = "DID NOT WORK"; 
            }
            
            
            
            //timestamp = request.getParameter("TIMESTAMP"); 
            //smsType = request.getParameter("SMS_TYPE"); 
            //message = request.getParameter("MESSAGE"); 
            
            String phoneNumberList = ""; 
            for (char digit : phoneNumber.toCharArray()){
                phoneNumberList = phoneNumberList.concat(Character.toString(digit)); 
            }
            phoneNumberList = "{"+phoneNumberList+"}"; 
            System.out.println("LIST"+phoneNumberList); 
            
            
          //-------------------END OF TESTER CODE ----------------------------
           
            //Command to Run DB Script 
            //Runtime.getRuntime().exec(new String[]{"osascript",path}); 
            
          //Path to DB Writing Script 
            String pathAndParameters = 
                    "osascript /Users/ErinHong/Documents/workspace/Huggable/TerminalLaunch.command.scpt "
                    +phoneNumber+" "+timestamp+" "+smsType+" "+message+" "+phoneNumberList; 
            
            Runtime.getRuntime().exec(pathAndParameters); 
            System.out.println("I'm running script now");

            //Change getRuntime().exec's String[] arguments so that it includes all data you need. 
          //String phoneNumber = request.getParameter( _PHONE_NUMBER );
            
        }finally{
            //do something 
        }
    }
    


*/ 