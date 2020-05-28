package com.company;

public class Essentials {

    private Window _w = new Window();

    public Essentials() {

    }

    public void mainMenu(Classroom myClass) {
        String[] mainMenuChoices = new String[]{"Add Student", "Remove Student", "Move Student", "Swap Students", "Import Classroom", "Exit"};
        int choice = 0;
        while (!mainMenuChoices[choice].equals("Exit")) {
            choice = _w.option(mainMenuChoices, myClass.toString() + "\nWhat would you like to do?");
            if (mainMenuChoices[choice].equals("Add Student")) {
                addMenu(myClass);
            } else if (mainMenuChoices[choice].equals("Remove Student")) {
                removeMenu(myClass);
            } else if (mainMenuChoices[choice].equals("Move Student")) {
                moveMenu(myClass);
            } else if (mainMenuChoices[choice].equals("Swap Students")) {
                swapMenu(myClass);
            } else if (mainMenuChoices[choice].equals("Import Classroom")) {
                importMenu(myClass);
            } else if (mainMenuChoices[choice].equals("Exit")) {
                _w.msg("Goodbye.");
                System.exit(0);
            } else {
                System.out.println("THIS SHOULD NEVER HAPPEN.");
            }
        }
    }

    public void addMenu(Classroom c) {
        String myName = _w.in("What is the FULL name of the student you would like to add?");
        _w.msg(c.addStudent(myName.substring(0, myName.indexOf(" ")), myName.substring(myName.indexOf(" ") + 1)));
        if (!myName.equals(myName.substring(0, myName.indexOf(" ")) + " " + myName.substring(myName.indexOf(" ") + 1))) {
            _w.msg("ALERT: Your input included a middle name. We have taken the liberty of removing it for you.");
        }
    }

    public void removeMenu(Classroom c) {
        String myName = _w.in("What is the FULL name of the student you would like to remove?");
        _w.msg(c.removeStudent(myName.substring(0, myName.indexOf(" ")), myName.substring(myName.indexOf(" ") + 1)));
    }

    public void moveMenu(Classroom c) {
        String myName = _w.in("What is the FULL name of the student you would like to remove?");
        int row = 0;
        try {
            row = Integer.parseInt(_w.in("Which row would you like them to be moved to?"));
        } catch (NumberFormatException e) {
            for (int i = 0; i < 10000; i++) {
                new Frame("this is what happens when you try to break a program on purpose", i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            System.exit(-1);
        }

        int col = 0;
        try {
            col = Integer.parseInt(_w.in("Which column would you like them to be moved to?"));
        } catch (NumberFormatException e) {
            for (int i = 0; i < 10000; i++) {
                new Frame("this is what happens when you try to break a program on purpose", i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            System.exit(-1);
        }

        _w.msg(c.moveStudent(myName.substring(0, myName.indexOf(" ")), myName.substring(myName.indexOf(" ") + 1), row, col));
    }

    public void swapMenu(Classroom c) {
        String firstStudentName = _w.in("Please input the FULL name of the first student.");
        String firstFirst = firstStudentName.substring(0, firstStudentName.indexOf(" "));
        String firstLast = firstStudentName.substring(firstStudentName.indexOf(" ") + 1);
        String lastStudentName = _w.in("Please input the FULL name of the student you would like " + firstStudentName + " to switch seats with.");
        String lastFirst = lastStudentName.substring(0, lastStudentName.indexOf(" "));
        String lastLast = lastStudentName.substring(lastStudentName.indexOf(" ") + 1);
        _w.msg(c.swapStudents(firstFirst, firstLast, lastFirst, lastLast));
    }

    public void importMenu(Classroom c) {
        String dataThing = _w.in("Please input your class in the following format:\n" +
                "Firstname Lastname/Firstname Lastname/Firstname Lastname\n" +
                "For example:\n" +
                "Kirsten Garcia/Fernando Lopez/Gracie Johnson\n" +
                "Make sure to input just as many students than you can fit in your classroom -- no\n" +
                "more, no less.");
        String[] names = new String[c.numberOfEmptySeats()];
        for (int i = 0; i < names.length; i++) {
            int slashIndex = dataThing.indexOf("/");
            if (slashIndex != -1) {
                names[i] = dataThing.substring(0, slashIndex);
                dataThing = dataThing.substring(slashIndex + 1);
                c.addStudent(names[i].substring(0, names[i].indexOf(" ")), names[i].substring(names[i].indexOf(" ") + 1));
            } else {
                names[i] = dataThing;
                c.addStudent(names[i].substring(0, names[i].indexOf(" ")), names[i].substring(names[i].indexOf(" ") + 1));
            }
        }
    }

}
