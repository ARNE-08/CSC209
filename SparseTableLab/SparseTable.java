public class SparseTable {
    RegisterNode[] students;
    RegisterNode[] classes;

    public SparseTable(int studentAmount, int classAmount) {
        students = new RegisterNode[studentAmount];
        classes = new RegisterNode[classAmount];
    }

    public RegisterNode addRegister(int stid, int cid) {
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
            return newRegis;
        }
        return null;
    }

    public RegisterNode addRegister(int stid, int cid, int grade) {
        RegisterNode n = addRegister(stid, cid);
        n.setGrade(grade);
        return n;
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
    public double calculateGPA(int stid) {
        double[] gradePoint = { 4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0 };
        double sum = 0;
        int classnum = 0;
        for (RegisterNode temp = students[stid]; temp != null; temp = temp.nextClass) {
            sum += gradePoint[temp.grade];
            classnum++;
        }
        return sum / classnum;
    }

    // public double calculateGPADIY(int stid) {
    // int classnum = 0;
    // double sum = 0.00;
    // for (RegisterNode temp = students[stid]; temp != null; temp = temp.nextClass)
    // {
    // classnum++;
    // switch (temp.grade) {
    // case 0:
    // sum += 4.00;
    // break;
    // case 1:
    // sum += 3.70;
    // break;
    // case 2:
    // sum += 3.30;
    // break;
    // case 3:
    // sum += 3.00;
    // break;
    // case 4:
    // sum += 2.70;
    // break;
    // case 5:
    // sum += 2.30;
    // break;
    // case 6:
    // sum += 2.00;
    // break;
    // case 7:
    // sum += 1.70;
    // break;
    // case 8:
    // sum += 1.00;
    // break;
    // case 9:
    // break;
    // }
    // }
    // System.out.println(sum);
    // double gpa = sum / classnum;
    // return gpa;
    // }
}
