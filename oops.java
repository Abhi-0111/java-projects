// This file demonstrates what a Class, Object, and Instance are
// using a simple real-world example.

class Student {
    
    // ------------------------------
    // FIELDS (State / Data Members)
    // These variables define what a Student HAS
    // ------------------------------
    String name;
    int age;

    // ------------------------------
    // METHOD (Behavior)
    // This defines what a Student CAN DO
    // ------------------------------
    void introduce() {
        System.out.println("Hi, I am " + name + " and I am " + age + " years old.");
    }
}


// ------------------------------
// Main class to run the program
// ------------------------------
public class ClassObjectInstanceDemo {

    public static void main(String[] args) {

        // -----------------------------------
        // CLASS:
        // Student is a blueprint.
        // No memory is allocated yet for name and age.
        // -----------------------------------


        // -----------------------------------
        // OBJECT CREATION:
        // 'new Student()' creates an OBJECT in heap memory.
        // 'student1' is a REFERENCE variable that stores
        // the memory address of that object.
        // -----------------------------------
        Student student1 = new Student();


        // -----------------------------------
        // INSTANCE:
        // student1 is an INSTANCE of the Student class.
        // It is a real, physical entity in memory.
        // -----------------------------------

        student1.name = "Karlz";
        student1.age = 21;

        student1.introduce();


        // -----------------------------------
        // Creating another object (another instance)
        // Each object has its own separate memory.
        // -----------------------------------
        Student student2 = new Student();

        student2.name = "AI Engineer";
        student2.age = 25;

        student2.introduce();


        // -----------------------------------
        // Important Concept:
        // student1 and student2 are two different
        // INSTANCES of the same CLASS.
        //
        // They share the same structure (class definition),
        // but hold different data in memory.
        // -----------------------------------
    }
}
