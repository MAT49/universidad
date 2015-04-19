/* @author: Ha K Hwang 

Purpose
    The purpose of this program is to create blueprints for records data structure to be used in phonedir.java
    Objects created from this class has 3 String values, fName, lName, and phoneNo.
    Data encapsulation--use getter/setter to access private variables.
*/
package Phonedir;

public class records {
    
    private String fName;
    private String lName;
    private String phoneNo;
    //default constructor, can be empty String
    public records()
    {
        fName = "";
        lName = "";
        phoneNo = "";
    }
    //constructor
    public records(String firstName, String lastName, String phoneNumber)
    {
        fName = firstName;
        lName = lastName;
        phoneNo = phoneNumber;
    }

    /**
     * @return the lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @return the phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * @param phoneNo the phoneNo to set
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
