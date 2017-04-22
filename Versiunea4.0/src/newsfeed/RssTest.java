package newsfeed;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
public class RssTest {
    static Object[][] stiri=new Object[1000][2];
    public static int i;
    public static void main(String [] args) {
		  	int ok=1;
			System.out.println("Introduce optiunea");
			
			while(ok==1){
				System.out.println("1- Automat (un rss)");
				System.out.println("2- Citire de la tastatura( 2 rss-uri)");
				System.out.println("3- Compune RSS");
				System.out.println("4- Get Titlu ");
				System.out.println("5- Get Descriere ");
				
				Scanner read= new Scanner(System.in);
				int optiune=read.nextInt();
				
				switch (optiune){
				 case 1:  XmlReader parser = new XmlReader("http://therealnews.com/rss/therealnewsitunesaudio.rss");
				   		  GetRss feed = parser.readFeed();
				   		  System.out.println(feed);

				   		  String numeFisier;
					 	  Scanner numeF=new Scanner(System.in);
					      System.out.println("Fisierul va fi salvat sub numele de ..");
					      numeFisier=numeF.nextLine();

					      try 
					        {
						 FileWriter writer = new FileWriter("D:\\"+numeFisier); 
				   		  for (SetRss message : feed.getMessages()) {
				   		  	writer.write( message.getDescription()+ "     ");
						   writer.append("\r\n");
						 }
						 	  writer.close();
						 	  }
						 catch(IOException ex) {
					            System.out.println("Nu am putut scrie in"+ "D:\\"+numeFisier + "'");}
				   	 			
				   	 		  for (SetRss message : feed.getMessages()) {
				   			  System.out.println(message);
				   		  }
			           break;

				 case 2:  String path;
				 		  String path2;

				 		   System.out.println("Introduceti link-urile de unde vor fi citite RSS-urile...");
				 		  Scanner aa =new Scanner(System.in); 
				 		  path= aa.next();

				 		  Scanner aaa =new Scanner(System.in); 
				 		  path2= aaa.next();

					 	  XmlReader parser11 = new XmlReader(path);
				   		  GetRss feed11 = parser11.readFeed();
				   		  System.out.println(feed11);

				   		  XmlReader parser12 = new XmlReader(path2);
				   		  GetRss feed12 = parser12.readFeed();
				   		  System.out.println(feed12);
				   		  String numeFisier1;
						 Scanner numeF1=new Scanner(System.in);
						 System.out.println("Fisierul va fi salvat sub numele de ..");
						 numeFisier1=numeF1.nextLine();
						 try 
						        {
							 FileWriter writer = new FileWriter("D:\\"+numeFisier1); 
							 for(SetRss message : feed11.getMessages()) {
							   writer.write( message.getDescription()+ "     ");
							   writer.append("\r\n");
							 }
							 writer.close();
						 }
							 catch(IOException ex) {
						            System.out.println("Nu am putut scrie in"+ "D:\\"+numeFisier1 + "'");}
					   	 
					   		  for (SetRss message : feed11.getMessages()) {
					   			  System.out.println(message);
					   		  }
					   		  
					   		String numeFisier2;
							 Scanner numeF2=new Scanner(System.in);
							 System.out.println("Fisierul va fi salvat sub numele de ..");
							 numeFisier2=numeF2.nextLine();
							 try 
							        {
								 FileWriter writer = new FileWriter("D:\\"+numeFisier2); 
								 for(SetRss message : feed11.getMessages()) {
								   writer.write( message.getDescription()+ "     ");
								   writer.append("\r\n");
								 }
								 writer.close();
							 }
								 catch(IOException ex) {
							            System.out.println("Nu am putut scrie in"+ "D:\\"+numeFisier2 + "'");}
						   	 
						   		  for (SetRss message : feed12.getMessages()) {
						   			  System.out.println(message);
						   		  }
				   	  break;
				 case 3: String title,description,link;
				 		 System.out.println("Titlu");
				 		 Scanner aa1 =new Scanner(System.in);
				         title =aa1.next();
				         System.out.println("Descriere");
				 		 description=aa1.next();
				 		 System.out.println("Link");
				 		 link= aa1.next();
				 		 Calendar cal = new GregorianCalendar();
						 Date creationDate = cal.getTime();
						 SimpleDateFormat date_format = new SimpleDateFormat("EEE', 'dd' 'MMM' 'yyyy' 'HH:mm:ss' 'Z", Locale.US);
						 String pubdate = date_format.format(creationDate);
						 GetRss rssFeeder = new GetRss(title, link, description,  pubdate);
						 SetRss feed111 = new SetRss();
						 feed111.setTitle("RSSFeed");
						 feed111.setDescription("This is a description");
						 feed111.setLink("http://students.info.uaic.ro/~andrei.damoc");
						 rssFeeder.getMessages().add(feed111);
						 XmlWriter writer = new XmlWriter(rssFeeder, "C:\\articles.rss");
						    
						   try {
						      writer.write();
						      System.out.println("RSS a fost creat in C:/");
						    } catch (Exception e) {
						      e.printStackTrace();
						    }
						 break;
				 case 4: 
					  String path1;
			 		  Scanner aa11 =new Scanner(System.in); 
			 		  System.out.println("Introduceti linkul de unde va fi citit RSS...");
			 		  path1= aa11.next();
					  XmlReader parser1 = new XmlReader(path1);
			   	      GetRss feed1 = parser1.readFeed();
			   		  int i=1;
			   		  for (SetRss message : feed1.getMessages()) {
			   			  System.out.println("Titlu "+i+"   "+message.getTitle());
			   			  i++;
			   		  }
		           break;
				 case 5: 
					  String path11;
			 		  Scanner aa111 =new Scanner(System.in); 
			 		  System.out.println("Introduceti linkul de unde va fi citit RSS...");
			 		  path11= aa111.next();
					  XmlReader parser1111 = new XmlReader(path11);
			   		  GetRss feed1111 = parser1111.readFeed();
			   		  int i1=1;
			   		  for (SetRss message : feed1111.getMessages()) {
			   			  System.out.println("Deascrierea "+i1+"   "+message.getDescription());
			   			  i1++;
			   		  }
		           break;	 
		         default: 
		        	 System.out.println("Invata sa citesti pa!");	
		        	 ok=0;  
				}
			}
                   
          
          
          }
    public static Object[][] getContent (String site){
        XmlReader parser1 = new XmlReader(site);
			   	      GetRss feed1 = parser1.readFeed();
			   		  int i=0;
			   		  for (SetRss message : feed1.getMessages()) {
			   			  stiri[i][0]=message.getTitle();
			   			  stiri[i][1]=message.getDescription();
                                                  i++;
			   		  }
        return stiri;
    }
    
} 