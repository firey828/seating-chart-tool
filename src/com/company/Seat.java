package com.company;

public class Seat {
    // ======== INSTANCE VARIABLES ========
    private int _myRow;
    private int _myCol;
    private Student _myStudent;
    private boolean _isOccupied;

    // ======== GETTERS ========
    public Student getStudent() {
        return _myStudent;
    }
    public boolean seatIsOccupied() {
        return _isOccupied;
    }

    // ======== SETTERS ========
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

    // ======== CONSTRUCTORS ========
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

    /*
     * Removes the Student currently occupying this Seat from this Seat.
     */
    public void removeStudent() {
        _myStudent = null;
        _isOccupied = false;
    }

    /*
     * Returns a String representation of this Seat object.
     */
    public String toString() {
        if (_isOccupied) {
            return " [" + _myStudent.getFirstName() + " " + _myStudent.getLastInitial() + ".] ";
        } else {
            return " [  ] ";
        }
    }

}
