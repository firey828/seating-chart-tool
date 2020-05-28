package com.company;

public class Classroom {

    private Seat[][] _seatingChart;

    public Classroom () {
        _seatingChart = new Seat[5][5];
        for (int r = 0; r < _seatingChart.length; r++) {
            for (int c = 0; c < _seatingChart.length; c++) {
                _seatingChart[c][r] = new Seat(c, r);
            }
        }
    }

    public boolean studentExists(String firstName, String lastName) {
        for (int x = 0; x < _seatingChart.length; x++) {
            for (int y = 0; y < _seatingChart[x].length; y++) {
                if (_seatingChart[x][y].seatIsOccupied()
                        && _seatingChart[x][y].getStudent().getLastName().equals(lastName)
                        && _seatingChart[x][y].getStudent().getFirstName().equals(firstName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[] findStudent(String firstName, String lastName) {
        if (studentExists(firstName, lastName)) {
            for (int x = 0; x < _seatingChart.length; x++) {
                for (int y = 0; y < _seatingChart[x].length; y++) {
                    if (_seatingChart[x][y].seatIsOccupied()
                            && _seatingChart[x][y].getStudent().getLastName().equals(lastName)
                            && _seatingChart[x][y].getStudent().getFirstName().equals(firstName)) {
                        int[] coords = new int[2];
                        coords[0] = x;
                        coords[1] = y;
                        return coords;
                    }
                }
            }
        } else {
            return new int[]{-1, -1};
        }
        return new int[]{-1, -1};
    }

    public boolean seatIsEmpty(int row, int col) {
        try {
            return !_seatingChart[row][col].seatIsOccupied();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int numberOfEmptySeats() {
        int n = 0;
        for (int x = 0; x < _seatingChart.length; x++) {
            for (int y = 0; y < _seatingChart[x].length; y++) {
                if (seatIsEmpty(x, y)) {
                    n = n + 1;
                }
            }
        }
        return n;
    }

    public Student getStudentAt(int row, int col) {
        if (!seatIsEmpty(row, col)) {
            try {
                return _seatingChart[row][col].getStudent();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public String addStudent(String firstName, String lastName) {
        for (int x = 0; x < _seatingChart.length; x++) {
            for (int y = 0; y < _seatingChart.length; y++) {
                if (seatIsEmpty(x, y)) {
                    _seatingChart[x][y].setStudent(new Student(firstName, lastName));
                    return "Successfully added " + firstName + " " + lastName + " to the class.";
                }
            }
        }
        return "There is not enough room to add " + firstName + " " + lastName + " to the class.";
    }

    public String removeStudent(String firstName, String lastName) {
        if (studentExists(firstName, lastName)) {
            for (int x = 0; x < _seatingChart.length; x++) {
                for (int y = 0; y < _seatingChart[x].length; y++) {
                    if (!seatIsEmpty(x, y)) {
                        if (getStudentAt(x, y).getLastName().equals(lastName) && getStudentAt(x, y).getFirstName().equals(firstName)) {
                            _seatingChart[x][y].removeStudent();
                            return firstName + " " + lastName + " has been removed from your class.";
                        }
                    }
                }
            }
        } else {
            return "There are no students in your class named " + firstName + " " + lastName + ".";
        }
        return "This should never happen."; // ide kept whining about how this method was "missing a return statement"
                                            // before i put this line. no clue why; shouldn't all conditions be covered
                                            // by the first if-else??
    }

    public String moveStudent(String firstName, String lastName, int row, int col) {
        if (seatIsEmpty(row, col)) {
            _seatingChart[row][col].setStudent(new Student(firstName, lastName));
            int[] coords = findStudent(firstName, lastName);
            if (coords[0] == row && coords[1] == col) {
                return firstName + " " + lastName + " is already there.";
            } else if (coords[0] == -1 && coords[1] == -1) {
                return firstName + " " + lastName + " is not in your class.";
            } else {
                _seatingChart[coords[0]][coords[1]].removeStudent();
                return firstName + " " + lastName + " has been moved.";
            }
        } else {
            return firstName + " " + lastName + " cannot be seated here, as " +
                    getStudentAt(row, col).getFirstName() + " " + getStudentAt(row, col).getLastName() + " is already " +
                    "sitting there.\n" +
                    "Please use the Swap Students option instead.";
        }
    }

    public String swapStudents(String firstFirstName, String firstLastName, String lastFirstName, String lastLastName) {
        if (studentExists(firstFirstName, firstLastName) && studentExists(lastFirstName, lastLastName)) {
            int[] firstCoords = findStudent(firstFirstName, firstLastName);
            int[] lastCoords = findStudent(lastFirstName, lastLastName);
            Student firstStudent = _seatingChart[firstCoords[0]][firstCoords[1]].getStudent();
            Student lastStudent = _seatingChart[lastCoords[0]][lastCoords[1]].getStudent();
            _seatingChart[firstCoords[0]][firstCoords[1]].removeStudent();
            _seatingChart[lastCoords[0]][lastCoords[1]].removeStudent();
            _seatingChart[firstCoords[0]][firstCoords[1]].setStudent(lastStudent);
            _seatingChart[lastCoords[0]][lastCoords[1]].setStudent(firstStudent);
            return firstFirstName + " " + firstLastName + " has had their seat swapped with that of " + lastFirstName + " " + lastLastName + ".";
        } else {
            return "One or more of the students you specified does not exist.";
        }
    }

    public String toString() {
        String msg = "";
        for (int x = 0; x < _seatingChart.length; x++) {
            for (int y = 0; y < _seatingChart[x].length; y++) {
                msg += _seatingChart[x][y].toString();
            }
            msg += "\n";
        }
        return msg.substring(0, msg.length() - 1);
    }

}
