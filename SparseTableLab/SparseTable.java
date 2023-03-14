public class SparseTable {
    RegisterNode[] students;
    RegisterNode[] classes;

    public SparseTable(int studentAmount, int classAmount) {
        students = new RegisterNode[studentAmount];
        classes = new RegisterNode[classAmount];
    }

    public void addRegister(int stid, int cid) {
        if (!isRegister(stid, cid)) {
            RegisterNode newRegis = new RegisterNode(stid, cid);
            RegisterNode temp;
            if (students[stid] == null) // the student never register before
            {
                students[stid] = newRegis;
            } else if (cid < students[stid].courseID) // if the new class is the first class
            {
                newRegis.nextClass = students[stid];
                students[stid] = newRegis;
            } else {
                for (temp = students[stid]; temp.nextClass != null
                        && temp.nextClass.courseID < cid; temp = temp.nextClass) {
                }
                newRegis.nextClass = temp.nextClass;
                temp.nextClass = newRegis;
            }
            // work among the student under the same class
            if (classes[cid] == null) {
                classes[cid] = newRegis;
            } else if (stid < classes[cid].studentID) // if the new class is the first class
            {
                newRegis.nextStudent = classes[cid];
                classes[cid] = newRegis;
            } else {
                for (temp = classes[cid]; temp.nextStudent != null
                        && temp.nextStudent.studentID < stid; temp = temp.nextStudent) {
                }
                newRegis.nextStudent = temp.nextStudent;
                temp.nextStudent = newRegis;
            }
        }
    }

    public boolean isRegister(int stid, int cid) {
        RegisterNode temp;
        if (students[stid] == null)
            return false;
        for (temp = students[stid]; temp != null && temp.courseID < cid; temp = temp.nextClass) {
        }
        if (temp == null || temp.courseID > cid) {
            return false;
        } else {
            return true;
        }
    }

    public void printAllClass(int stid) {
        for (RegisterNode temp = students[stid]; temp != null; temp = temp.nextClass) {
            System.out.print(temp.courseID + " ");
        }
        System.out.println("");
    }

    public void printAllStudent(int cid) {
        for (RegisterNode temp = classes[cid]; temp != null; temp = temp.nextStudent) {
            System.out.print(temp.studentID + " ");
        }
        System.out.println("");
    }

    // Homework
    // public double calculateGPA(int stid) {
    // double gpa = 0.00;
    // double sum;

    // return gpa;
    // }
}
