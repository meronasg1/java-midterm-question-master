package parser.xml;

import databases.ConnectToSqlDB;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;


public class ProcessStudentInfo {

    /*
     * Under XmlReader class, the parseData() will return list of Student Info which will contain Student first name, last name and score.
     * You need to implement the method name "convertIntToChar()" which will convert String score into char Grade.('A'for 90 to 100,'B'for 80 to 89 and
     * 'C' for 70 to 79.
     *
     * Here in the main method fill in the code that outlined to read xml data parsed into 2 separate ArrayList, then store into map.
     * Once map has all data, retrieve those data and out put to console.
     *
     * Do any necessary steps that require for below successful output.
     * ......................................................
     * Student (id= 1) "Ibrahim" "Khan"        		Grade= B
     * Student (id= 2) "Asif" "Roni"          		Grade= A
     * Student (id= 3) "Gumani" "Hose"              Grade= A
     * Student (id= 4) "Sukanto" "Shaha"            Grade= B
     * Student (id= 5) "MD" "Hossain"               Grade= C
     * ......................................................
     *
     *
     * Use MySql Database to store data and to retrieve data.
     *
     */

    public static void main(String[] args) throws Exception {



        //Path of XML data to be read.
        String pathSelenium = System.getProperty("user.dir") + "/src/parser/xml/selenium.xml";
        String pathQtp = System.getProperty("user.dir") + "/src/parser/xml/qtp.xml";
        String tag = "id";
        //Create ConnectToSqlDB Object
        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
        //Declare a Map with List<String> into it.
        Map<String, List<Student>> list = new LinkedHashMap<String, List<Student>>();
				
				/*Declare 2 ArrayList with Student data type to store Selenium student into one of the ArrayList and
				  Qtp student into another ArrayList. */

        List<Student> seleniumStudents = new ArrayList<Student>();
        List<Student> qtpStudents = new ArrayList<Student>();

        //Create XMLReader object.
        XmlReader xmlReader = new XmlReader();

        //Parse Data using parseData method and then store data into Selenium ArrayList.
        seleniumStudents = xmlReader.parseData(tag, pathSelenium);


        System.out.println(seleniumStudents);

        //Parse Data using parseData method and then store data into Qtp ArrayList.
        qtpStudents=xmlReader.parseData(tag, pathQtp);
        //add Selenium ArrayList data into map.
        Map<String, List<Student>> seleniumMap = new HashMap<String, List<Student>>();

        for (Student student: seleniumStudents) {
            seleniumMap.put(student.getId(), seleniumStudents);
        }


        //add Qtp ArrayList data into map.
        Map<String, List<Student>> qtpMap = new HashMap<String, List<Student>>();
        for (Student student: qtpStudents) {
            seleniumMap.put(student.getId(), qtpStudents);
        }
        //Retrieve map data and display output.
        System.out.println(seleniumMap.entrySet());
        System.out.println(qtpMap.entrySet());


        //Store Qtp data into Qtp table in Database insertDataFromArrayListToSqlTable
        connectToSqlDB.insertDataFromStudentListToSqlTable3(qtpStudents, "qtpTable");

        //Store Selenium data into Selenium table in Database
        connectToSqlDB.insertDataFromStudentListToSqlTable3(seleniumStudents, "selenium");

        List<Student> stListQtp = new ArrayList<>();
        //Retrieve Qtp students from Database
        stListQtp = connectToSqlDB.readStudentsFromSqlTable("qtpTable");
        for (Student st : stListQtp) {
            System.out.println(st.getFirstName() + " " + st.getLastName() + " " + st.getScore() + " " + st.getId());
        }

        //Retrieve Selenium students from Database
        List<Student> stListSelenium = new ArrayList<>();
        stListSelenium = connectToSqlDB.readStudentsFromSqlTable("selenium");
        for (Student st1 : stListSelenium) {
            System.out.println(st1.getFirstName() + " " + st1.getLastName() + " " + st1.getScore() + " " + st1.getId());
        }
    }

}
