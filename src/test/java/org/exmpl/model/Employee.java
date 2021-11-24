package org.exmpl.model;

import java.util.Objects;

public class Employee {
    private String surname;
    private String name;
    private String birthPlace;
    private String position;
    private String phone;
    private String email;
    private String birthday;
    private int quantityDays;
    private int shiftHours;
    private String shiftHoursFriday;
    private String info;

    public Employee(String surname, String name, String birthPlace, String position, String phone, String email,
                    String birthday, int quantityDays, int shiftHours, String shiftHoursFriday, String info)
    {
        this.surname = surname;
        this.name = name;
        this.birthPlace = birthPlace;
        this.position = position;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.quantityDays = quantityDays;
        this.shiftHours = shiftHours;
        this.shiftHoursFriday = shiftHoursFriday;
        this.info = info;
    }

    public Employee (String surname, String name, String position, String phone){
        this.surname = surname;
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.quantityDays = 5;
        this.shiftHours = 8;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getQuantityDays() {
        return quantityDays;
    }

    public void setQuantityDays(int quantityDays) {
        this.quantityDays = quantityDays;
    }

    public int getShiftHours() {
        return shiftHours;
    }

    public void setShiftHours(int shiftHours) {
        this.shiftHours = shiftHours;
    }

    public String getShiftHoursFriday() {
        return shiftHoursFriday;
    }

    public void setShiftHoursFriday(String shiftHoursFriday) {
        this.shiftHoursFriday = shiftHoursFriday;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                ", quantityDays=" + quantityDays +
                ", shiftHours=" + shiftHours +
                ", shiftHoursFriday='" + shiftHoursFriday + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(surname, employee.surname) && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, birthPlace, position, phone, email, birthday, quantityDays,
                shiftHours, shiftHoursFriday, info);
    }
}
