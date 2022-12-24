package com.company;

import java.util.Scanner;

public class Tracing {

    static String wall = "#";
    static String space = "  ";
    static String ray = ". ";

    static int fieldSizeX = 60;
    static int fieldSizeY = 24;

    static String[][] field = new String[fieldSizeY][fieldSizeX];

    static String textOut = "";
    static int fillFieldX = 0;
    static int fillFieldY = 0;
    public static void main(String[] args) {

        reGen();

        new WindowFrame();
        show();
    }

    public static void reGen() {
        fillFieldX = 0;
        fillFieldY = 0;

        while (fillFieldY == 0) {
            field[fillFieldY][fillFieldX] = wall;
            fillFieldX++;
            if (fillFieldX == fieldSizeX-1) {
                field[fillFieldY][fillFieldX] = wall;
                fillFieldX = 0;
                fillFieldY++;
                field[fillFieldY][fillFieldX] = wall;
            }
        }
        while (fillFieldY < fieldSizeY-1) {
            field[fillFieldY][fillFieldX] = space;
            fillFieldX++;
            if (fillFieldX == fieldSizeX-1) {
                field[fillFieldY][fillFieldX] = wall;
                fillFieldX = 0;
                fillFieldY++;
                field[fillFieldY-1][fillFieldX] = wall;
            }
        }
        while (fillFieldY == fieldSizeY-1) {
            field[fillFieldY][fillFieldX] = wall;
            fillFieldX++;
            if (fillFieldX == fieldSizeX) {
                fillFieldY++;
            }
        }
        // creating figures
        square(WindowFrame.xGenSquare+1,WindowFrame.yGenSquare+1, WindowFrame.xGenSize+1, WindowFrame.yGenSize+1);
        fillFieldX = 0;
        fillFieldY = 0;
        while (fillFieldY < fieldSizeY) {
            textOut += field[fillFieldY][fillFieldX];
            fillFieldX++;
            if (fillFieldX == fieldSizeX) {
                fillFieldX = 0;
                textOut += "\n";
                fillFieldY++;
            }
        }
    }

    public static void square(int x, int y, int sizeX, int sizeY) {
        x--; y--;
        for (int moveGen = 1; moveGen < sizeX; moveGen++) {
            if (x < fieldSizeX && y < fieldSizeY) {
                field[y][x] = wall;
            }
            x++;
        }
        for (int moveGen = 1; moveGen < sizeY; moveGen++) {
            if (x < fieldSizeX && y < fieldSizeY) {
                field[y][x] = wall;
            }
            y++;
        }
        for (int moveGen = 1; moveGen < sizeX; moveGen++) {
            if (x < fieldSizeX && y < fieldSizeY) {
                field[y][x] = wall;
            }
            x--;
        }
        for (int moveGen = 1; moveGen < sizeY; moveGen++) {
            if (x < fieldSizeX && y < fieldSizeY) {
                field[y][x] = wall;
            }
            y--;
        }
    }

    public static void show() {
        for (int show = 0; show < fieldSizeY; show++) {
            for (int show2 = 0; show2 < fieldSizeX; show2++) {
                if (field[show][show2].equals(space)) {
                    System.out.print(" ");
                } else if (field[show][show2].equals(ray)) {
                    System.out.print(".");
                } else {
                    System.out.print(field[show][show2]);
                }
            }
            System.out.println("");
        }
    }

//    public static boolean isNumber(String enter_right_check) {
//        for (char c: enter_right_check.toCharArray()) {
//            if (!Character.isDigit(c)) return false;
//        }
//        return true;
//    }
}
