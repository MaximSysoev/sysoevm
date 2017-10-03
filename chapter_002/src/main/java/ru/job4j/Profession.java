package ru.job4j;

public class Profession {
    public String name;
    public String speciality;
    public String education;
    public int experince;

    public Profession() {

    }

    public Profession(String name, String speciality, String education, int experince) {
        this.name = name;
        this.speciality = speciality;
        this.education = education;
        this.experince = experince;
    }

    public String getName() {
        return name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getEducation() {
        return education;
    }

    public int getExperince() {
        return experince;
    }


    public static void main(String[] args) {
        Doctor doctor = new Doctor();
        Pacient pacient = new Pacient();
        doctor.name = "Иван";
        pacient.pacientName = "Василий";
        doctor.treat(pacient);
    }

}
