public class Vaccine {
    private String name, preventedDisease, company;
    private double dose;

    public Vaccine(String n, String di) {
        name = n;
        preventedDisease = di;
    }

    public Vaccine(String n, String di, String c, double d) {
        name = n;
        preventedDisease = di;
        company = c;
        setDose(d);
    }

    public void setDose(double d) {
        if (d <= 20)
            dose = d;
        else {
            dose = 0;
            System.out.println("Dose is not valid");
        }
    }

    public double getDose() {
        return dose;
    }

    public String getName() {
        return (name);
    }

    public String getPreventedDisease() {
        return (preventedDisease);
    }

    public String getCompany() {
        return (company);
    }

    public void setName(String i) {
        name = i;
    }

    public void setPreventedDisease(String i) {
        preventedDisease = i;
    }

    public void setCompany(String i) {
        company = i;
    }
}