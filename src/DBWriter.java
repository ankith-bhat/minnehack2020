
import java.sql.*;

// Inspired by:
// https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-examples.html

public class DBWriter {

    Connection conn;
    Statement stmt;
    ResultSet rs;

    private final String create_users = "CREATE TABLE Users ("
    		+ "ID INT NOT NULL,"
    		+ "Name VARCHAR(100),"
    		+ "Password VARCHAR(100),"
    		+ "PRIMARY KEY (ID)"
    		+ ");";


    private final String create_user_interests = "CREATE TABLE UserInterests ("
    		+ "ID INT NOT NULL,"
    		+ "Name VARCHAR(100),"
    		+ "Interests VARCHAR(300),"
    		+ "PRIMARY KEY (ID, Interests),"
    		+ "FOREIGN KEY (ID) REFERENCES Users(ID)"
    		+ ");";

    // private final String create_individuals="CREATE TABLE Individuals ("
    //         + "ID VARCHAR(10) NOT NULL,"
    //         + "FirstName VARCHAR(45),"
    //         + "MiddleName VARCHAR(45),"
    //         + "LastName VARCHAR(45),"
    //         + "Sex CHAR(1),"
    //         + "Caste VARCHAR(15),"
    //         + "PRIMARY KEY (ID)"
    //         + ");";
    //
    // private final String create_individuals_events = "CREATE TABLE IndividualEvents ("
    //         + "ID VARCHAR(10) NOT NULL,"
    //         + "EventTag VARCHAR(45) NOT NULL,"
    //         + "Place VARCHAR(45),"
    //         + "Date VARCHAR(45),"
    //         + "PRIMARY KEY (ID, EventTag),"
    //         + "FOREIGN KEY (ID) REFERENCES Individuals(ID)"
    //         + ");";
    //
    // private final String create_family_spouse = "CREATE TABLE FamilySpouse ("
    //         + "FamilyID VARCHAR(10) NOT NULL,"
    //         + "Spouse1ID VARCHAR(10) NOT NULL,"
    //         + "Spouse2ID VARCHAR(10) NOT NULL,"
    //         + "PRIMARY KEY (FamilyID),"
    //         + "FOREIGN KEY (Spouse1ID) REFERENCES Individuals(ID),"
    //         + "FOREIGN KEY (Spouse2ID) REFERENCES Individuals(ID)"
    //         + ");";
    //
    // private final String create_family_child = "CREATE TABLE FamilyChild ("
    //         + "FamilyID VARCHAR(10) NOT NULL,"
    //         + "ChildID VARCHAR(10) NOT NULL,"
    //         + "ChildOrder VARCHAR(2) NOT NULL,"
    //         + "PRIMARY KEY (FamilyID, ChildID),"
    //         + "FOREIGN KEY (FamilyID) REFERENCES FamilySpouse(FamilyID),"
    //         + "FOREIGN KEY (ChildID) REFERENCES Individuals(ID)"
    //         + ");";
    //
    // private final String create_family_event = "CREATE TABLE FamilyEvents ("
    //         + "FamilyID VARCHAR(10) NOT NULL,"
    //         + "EventTag VARCHAR(45) NOT NULL,"
    //         + "Place CHAR(1),"
    //         + "Date VARCHAR(15),"
    //         + "PRIMARY KEY (FamilyID, EventTag),"
    //         + "FOREIGN KEY (FamilyID) REFERENCES FamilySpouse(FamilyID)"
    //         + ");";

    private final String drop_individuals = "DROP TABLE IF EXISTS Individuals";

    private final String drop_individuals_events = "DROP TABLE IF EXISTS IndividualEvents";

    private final String drop_family_spouse = "DROP TABLE IF EXISTS FamilySpouse";

    private final String drop_family_child = "DROP TABLE IF EXISTS FamilyChild";

    private final String drop_family_event = "DROP TABLE IF EXISTS FamilyEvents";

    public DBWriter(String user, String password) throws Exception {
        // Attempt connection
        conn = null;
        try {
            // get driver information
            Class.forName("com.mysql.cj.jdbc.Driver");
            String JdbcURL = "jdbc:mysql://localhost:3306/friendr" + "?autoReconnect=true&useSSL=false";

            conn =
                    DriverManager.getConnection(JdbcURL, user, password);

        }
//        catch (SQLException ex) {
//            // handle any errors
//            System.out.println("SQLException: " + ex.getMessage());
//            System.out.println("SQLState: " + ex.getSQLState());
//            System.out.println("VendorError: " + ex.getErrorCode());
//        }
        finally{

        }

        stmt = null;
        rs = null;

    }

    public void dropTables(){
        System.out.println("Dropping Tables...");

        // executeQuery(drop_family_event);
        // executeQuery(drop_family_child);
        // executeQuery(drop_family_spouse);
        // executeQuery(drop_individuals_events);
        // executeQuery(drop_individuals);

        System.out.println("Deletion finished...");
    }

    public void createTables(){
        System.out.println("Creating Tables...");

        executeQuery(create_users);
        executeQuery(create_user_interests);

        System.out.println("Creation finished...");
    }

    public boolean hasConnection(){
        return conn != null;
    }


    public boolean executeQuery(String query){

        // reset
        stmt = null;
        rs = null;

        boolean result = true;

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);

            // Now do something with the ResultSet ....
            // todo print success?
        }
        catch (SQLException ex){
            // error handling
            System.out.println("SQLException: " + ex.getMessage());
            // System.out.println("SQLState: " + ex.getSQLState());
            // System.out.println("VendorError: " + ex.getErrorCode());
            result = false;
        }
        finally {
            // release resources

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }

        return result;
    }
}
