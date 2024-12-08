/**
 * Class that contains the schema of the database
 * 
 * @author Angus J. Martin
 */
public class DBschema {

    /**
     * Method to create the Axemen table
     * 
     * @return String
     */
    public static String createAxemenTable() {
        return """
                CREATE TABLE IF NOT EXISTS Axemen (
                    AxemenID INT PRIMARY KEY AUTOINCREMENT,
                    FirstName VARCHAR(100) NOT NULL,
                    MiddleName VARCHAR(100),
                    LastName VARCHAR(100) NOT NULL,
                    Status ENUM('Active', 'Inactive', 'Retired') NOT NULL,
                    Gender ENUM('JACK', 'JILL') NOT NULL,
                    Address VARCHAR(255),
                    City VARCHAR(255),
                    Region VARCHAR(255),
                    PostalCode CHAR(4) CHECK (Postcode LIKE '[0-9][0-9][0-9][0-9]'),
                    Email VARCHAR(255),
                    Phone CHAR(10),
                );
                """;
    }

    /**
     * Method to create the Shows table
     * 
     * @return String
     */
    public static String createShowTable() {
        return """
                CREATE TABLE IF NOT EXISTS Shows (
                    ShowID INT PRIMARY KEY AUTO_INCREMENT,
                    ShowName VARCHAR(255) NOT NULL,
                    Location VARCHAR(255) NOT NULL,
                    Date Date  NOT NULL,
                    ShowType ENUM('Demo', 'Competition') NOT NULL,
                    Circuit VARCHAR(255)
                );
                """;
    }

    /**
     * Method to create the Events table
     * 
     * @return String
     */
    public static String createEventsTable() {
        return """
                CREATE TABLE IF NOT EXISTS Events (
                    EventID INT PRIMARY KEY AUTO_INCREMENT,
                    ShowID INT NOT NULL,
                    BlockID INT NOT NULL,
                    EventName VARCHAR(255),
                    Fee Int,
                    Heats INT NOT NULL CHECK (Heats >= 1),
                    EventType ENUM('Underhand', 'Standing', 'Single Saw', 'Double Saw', 'Springboard', 'Jack & Jill', 'Jill & Jill', 'Chain Saw', 'Axe Throwing') NOT NULL,
                    Category ENUM('Open', 'Restricted', 'Junior', 'Ladies', 'Masters', 'Championship') NOT NULL,
                    FOREIGN KEY (ShowID) REFERENCES Shows(ShowID),
                    FOREIGN KEY (BlockID) REFERENCES Blocks(BlockID)
                );
                """;
    }

    /**
     * Method to create the Blocks table
     * 
     * @return String
     */
    public static String createBlocksTable() {
        return """
                CREATE TABLE IF NOT EXISTS Blocks (
                    BlockID INT PRIMARY KEY AUTO_INCREMENT,
                    WoodType ENUM('Softwood', 'Hardwood') NOT NULL,
                    Diameter INT NOT NULL
                );
                """;
    }

    /**
     * Method to create the Results table
     * 
     * @return String
     */
    public static String createResultsTable() {
        return """
                CREATE TABLE IF NOT EXISTS Results (
                    EventID INT NOT NULL,
                    ShowID INT NOT NULL,
                    AxemenID INT NOT NULL,
                    Heat ENUM('1', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'Final') NOT NULL,
                    Place INT NOT NULL,
                    Stand INT CHECK (Stand >= 1),
                    PRIMARY KEY (EventID, ShowID, AxemenID),
                    FOREIGN KEY (EventID) REFERENCES Events(EventID),
                    FOREIGN KEY (ShowID) REFERENCES Shows(ShowID),
                    FOREIGN KEY (AxemenID) REFERENCES Axemen(AxemenID),
                );
                """;
    }

    /**
     * Method to create the PrizeMoney table
     * 
     * @return String
     */
    public static String createPrizeMoneyTable() {
        return """
                CREATE TABLE IF NOT EXISTS PrizeMoney (
                    EventID INT NOT NULL,
                    ShowID INT NOT NULL,
                    Place INT NOT NULL,
                    Prize INT NOT NULL,
                    PRIMARY KEY (EventID, ShowID, Place),
                    FOREIGN KEY (EventID) REFERENCES Events(EventID),
                    FOREIGN KEY (ShowID) REFERENCES Shows(ShowID),
                );
                """;
    }

    /**
     * Method to create the Handicaps table
     * 
     * @return String
     */
    public static String createHandicapsTable() {
        return """
                CREATE TABLE IF NOT EXISTS Handicaps (
                    AxemenID INT NOT NULL,
                    EventType NOT NULL,
                    WoodType,
                    Diameter,
                    Handicap INT NOT NULL,
                    PRIMARY KEY (AxemenID, EventType, WoodType, Diameter, Handicap),
                    FOREIGN KEY (AxemenID) REFERENCES Axemen(AxemenID),
                    FOREIGN KEY (EventType) REFERENCES Events(EventType),
                    FOREIGN KEY (WoodType) REFERENCES Blocks(WoodType),
                    FOREIGN KEY (Diameter) REFERENCES Blocks(Diameter),
                );
                """;
    }
}