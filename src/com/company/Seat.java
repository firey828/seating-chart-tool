package com.company;

public class Seat {
    private int _myRow;
    private int _myCol;
    private Student _myStudent;
    private boolean _isOccupied;

    public Seat(int row, int col, Student student) {
        _myRow = row;
        _myCol = col;
        _myStudent = student;
        _isOccupied = true;
    }

    public Seat(int row, int col) {
        _myRow = row;
        _myCol = col;
        _myStudent = null;
        _isOccupied = false;
    }

    public Student getStudent() {
        return _myStudent;
    }

    public Student setStudent(Student student) {
        Student former = student;
        if (_isOccupied) {
            former = _myStudent;
        } else {
            former = null;
        }
        _myStudent = student;
        _isOccupied = true;
        return former;
    }

    public void removeStudent() {
        _myStudent = null;
        _isOccupied = false;
    }

    public boolean seatIsOccupied() {
        return _isOccupied;
    }

    public String toString() {
        if (_isOccupied) {
            return " [" + _myStudent.getFirstName() + " " + _myStudent.getLastInitial() + ".] ";
        } else {
            return " [  ] ";
        }
    }

}
