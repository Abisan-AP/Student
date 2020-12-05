/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentexercise;
/**
 *
 * @author Abisan Poothapillai
 */
public final class Student1 {            //5000
    private String name;
    private int age;
    private String gender;
    private String id;
    private String email;               //name@vaniercollege.qc.ca
    private Address address;
    private static int nextId = 1;      //one copy of it
    private final static String SCHOOL_NAME = "Vanier College";

    public Student1() {
        this.name = null;
        this.age = 0;
        this.gender = null;
        this.id = null;
        this.email = null;
        this.address = null;
    }
    
    public Student1(String name, String gender) {       //non static method
        this.name = name;
        this.age = 0;
        this.gender = gender;
        this.id = String.format("%06d", nextId++);      //static method
        this.email = null;
        generateEmail();
        this.address = null;
        
    }
    
    public Student1(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = String.format("%06d", nextId++);
        this.email = null;
        generateEmail();
        this.address = null;
    }
    
     public Student1(String name, int age, String gender, Address address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = String.format("%06d", nextId++);
        this.email = null;
        generateEmail();
        this.address = address;
    }
    
    public Student1(Student1 student1) {
        this.name = student1.name;
        this.age = student1.age;
        this.gender = student1.gender;
        this.id = student1.id;
        this.email =student1.email;
//        this.address = student1.address;                 // shallow copy
        this.address = new Address (student1.address);     // deep copy
    }

    /**
    * generate Email for a student
    **/
    public void generateEmail() {
        email = String.format("%s@vaniercollege.qc.ca", name);
    }
    
    public static boolean isNameValid(String name) {    // static method
        //System.out.println(SCHOOL_NAME);              // static var
        //System.out.println(age);                      // age: non-static
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!Character.isLetter(c) && c != ' ' && c != '-' && c != '\'')
                return false;
        }
        return true;
    }
    
     /**
     * To check if the student live far away from the school or not
     * 1. if the student live in Montreal, then print "not far"
     * 2. if the student live outside of Montreal, but inside QC, then print "not far, not close"
     * 3. if the student live outside of QC, then print "very far"
     */
    public void checkDistance() {
        if (address.getCity().equalsIgnoreCase("montreal"))
            System.out.println("not far");
        else if (address.getProvince().equalsIgnoreCase("qc"))
            System.out.println("not far, not clsoe");
        else
            System.out.println("very far");
    }
    
    public boolean equals(Student1 student1) {
        return this.name.equals(student1.name)&& 
                this.age == student1.age && 
                this.gender.equals(student1.gender) && 
                this.id.equals(student1.id) &&
                this.email.equals(student1.email) &&
                this.address.equals(student1.address);
    }

    @Override
    public String toString() {      // non-static method
        String str = "";
        
        str += String.format("Student from %s\n", SCHOOL_NAME);   // static var
        str += String.format("%-10s: %s\n", "Id", id);
        str += String.format("%-10s: %s\n", "Name", name);
        str += String.format("%-10s: %d\n", "Age", age);
        str += String.format("%-10s: %s\n", "Gender", gender);
        str += String.format("%-10s: %s\n", "Email", email);
        str += String.format("%-10s: %s\n", "Address", address);
        
        return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (isNameValid(name)) {
        this.name = name;
        email = String.format("%s@vaniercollege.qc.ca", name);
        }
        else 
            System.out.println("Sorry, the new name is invalid.... Request denayed");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        int atIdx = email.indexOf("@");
        name = email.substring(0, atIdx);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}