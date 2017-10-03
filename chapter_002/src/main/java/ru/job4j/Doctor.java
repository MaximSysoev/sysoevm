package ru.job4j;

public class Doctor extends Profession {

    public Doctor () {

    }

    public Hospital treat(Pacient pacient) {
        System.out.println("Доктор " + this.getName() + " лечит пациента «" + pacient.getPacient() + "»");
        return new Hospital();
    }

}
