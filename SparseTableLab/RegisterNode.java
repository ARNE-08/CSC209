public class RegisterNode {
    int studentID;
    int courseID;
    int grade;
    RegisterNode nextStudent;
    RegisterNode nextClass;

    public RegisterNode(int stid, int cid, int g, RegisterNode ns, RegisterNode nc) {
        studentID = stid;
        courseID = cid;
        grade = g;
        nextStudent = ns;
        nextClass = nc;
    }

    public RegisterNode(int stid, int cid, int g) {
        this(stid, cid, g, null, null);
    }

    public RegisterNode(int stid, int cid) {
        this(stid, cid, 10, null, null); // grade is 0-9 according to the slide, we are letting grade default value be
                                         // 10 (mean there's no such thing)
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int g) {
        grade = g;
    }
}
