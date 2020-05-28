package com.company;

public class Student {

    private String _firstName;
    private String _lastName;

    public Student (String first, String last) {

        Window _w = new Window();

        if (first.length() > 20) {
            _firstName = first.substring(0, 21);
            _w.msg("The length of the student's first name cannot exceed twenty characters. Trimmed to " + first.substring(0, 21) + ".");
        }

        if (last.length() > 20) {
            _lastName = last.substring(0, 20);
            _w.msg("The length of the student's last name cannot exceed twenty characters. Trimmed to " + first.substring(0, 20) + ".");
        }

        if (first.length() <= 0) {
            _firstName = "?";
            _w.msg("The student's first name cannot be left blank. A placeholder has been created for the student's first name.");
        }

        if (last.length() <= 0) {
            _lastName = "?";
            _w.msg("The student's last name cannot be left blank. A placeholder has been created for the student's last name.");
        }

        if (first.length() > 0 && first.length() <= 20) {
            _firstName = first;
        }

        if (last.length() > 0 && last.length() <= 20) {
            _lastName = last;
        }
    }

    public String getFirstName() {
        return _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public String getLastInitial() {
        return _lastName.substring(0,1);
    }

    public String toString() {
        return _firstName + " " + getLastInitial() + ". ";
    }

}
