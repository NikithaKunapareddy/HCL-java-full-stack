class student{
    String name;
    int rollno;
    String branch;
    String city;
    student(String name, int rollno, String branch,String city){
        this.name=name;
        this.rollno=rollno;
        this.branch=branch;
        this.city=city;
    }
    public static void main(String args[]){
        student s1=new student("Nikita", 1, "CSE", "Hyderabad");
        student s2=new student("Teja", 2, "ECE", "Hyderabad");
        student s3=new student("Balu", 3, "EEE", "Hyderabad");
        student s4=new student("Rohit", 4, "MECH", "Hyderabad");
        student s5=new student("Udaya", 5, "CIVIL", "Hyderabad");

        System.out.println(s1.name+" "+s1.rollno+" "+s1.branch+" "+s1.city);
        System.out.println(s2.name+" "+s2.rollno+" "+s2.branch+" "+s2.city);
        System.out.println(s3.name+" "+s3.rollno+" "+s3.branch+" "+s3.city);
        System.out.println(s4.name+" "+s4.rollno+" "+s4.branch+" "+s4.city);
        System.out.println(s5.name+" "+s5.rollno+" "+s5.branch+" "+s5.city);    
    }

}