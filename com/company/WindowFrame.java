package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;

public class WindowFrame extends JFrame implements MouseMotionListener, MouseListener{

    static int xGenSquare = 0, xGenSquareSize = 0;
    static int yGenSquare = 0, yGenSquareSize = 0;
    static int xGenSize = 0, yGenSize = 0;
    static int tracingMove = 1;
    static int x = 1;
    static int y = 1;
    static int xClick = 1;
    static int yClick = 1;

    JLabel Label;
    JTextArea textArea = new JTextArea(Tracing.textOut);

    WindowFrame() {

        Label = new JLabel();
        Label.setBounds(0,0,497,519);
        Label.setOpaque(true);
        Label.setBackground(Color.black);
        Label.setVisible(true);
        Label.addMouseListener(this);
        Label.addMouseMotionListener(this);

        textArea.setFont(new Font("",Font.BOLD,15));
        textArea.setEnabled(false);
        textArea.setBackground(Color.black);

        this.add(Label);
        this.add(textArea);

        this.setTitle("rayTracing");
        this.setSize(497,519); // 480+17 = 497; 480+39 = 519

        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        xGenSquare = (e.getX()) / 8;
        yGenSquare = (e.getY()) / 20;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        xGenSquareSize = (e.getX()) / 8;
        yGenSquareSize = (e.getY()) / 20;
        if (xGenSquareSize > xGenSquare) {
            xGenSize = xGenSquareSize - xGenSquare;
        } else {
            xGenSize = xGenSquare - xGenSquareSize;
            xGenSquare = xGenSquareSize;
        }
        if (yGenSquareSize > yGenSquare) {
            yGenSize = yGenSquareSize - yGenSquare;
        } else {
            yGenSize = yGenSquare - yGenSquareSize;
            yGenSquare = yGenSquareSize;
        }
        Tracing.reGen();
        Tracing.fillFieldX = 0;
        Tracing.fillFieldY = 0;
        Tracing.textOut = "";
        while (Tracing.fillFieldY < Tracing.fieldSizeY) {
            Tracing.textOut += Tracing.field[Tracing.fillFieldY][Tracing.fillFieldX];
            Tracing.fillFieldX++;
            if (Tracing.fillFieldX == Tracing.fieldSizeX) {
                Tracing.fillFieldX = 0;
                Tracing.textOut += "\n";
                Tracing.fillFieldY++;
            }
        }

        Tracing.show();
        textArea.setText(Tracing.textOut);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        getClick();

        System.out.println(x + "," + y);
        System.out.println(yClick + "," + xClick);

        Tracing.reGen();

        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            xClick--;
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            yClick--;
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            xClick++;
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            yClick++;
        } getClick();

        //
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick--;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 4) {
                xClick--;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick--;
                tracingMove++;
            }
            if (tracingMove == 6) {
                tracingMove = 1;
            }
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick++;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 4) {
                xClick++;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick++;
                tracingMove++;
            }
            if (tracingMove == 6) {
                tracingMove = 1;
            }
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick++;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 4) {
                xClick++;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick++;
                tracingMove++;
            }
            if (tracingMove == 6) {
                tracingMove = 1;
            }
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick--;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 4) {
                xClick--;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick--;
                tracingMove++;
            }
            if (tracingMove == 6) {
                tracingMove = 1;
            }
        } getClick();

        //
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick--;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 4) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick--;
                tracingMove++;
            }
            if (tracingMove == 6) {
                tracingMove = 1;
            }
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick--;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick--;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick--;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 4) {
                xClick--;
                tracingMove++;
            }
            if (tracingMove == 5) {
                tracingMove = 1;
            }
        } getClick();

        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick++;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 4) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick++;
                tracingMove++;
            }
            if (tracingMove == 6) {
                tracingMove = 1;
            }
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick++;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick++;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick++;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 4) {
                xClick++;
                tracingMove++;
            }
            if (tracingMove == 5) {
                tracingMove = 1;
            }
        } getClick();

        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick++;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 4) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick++;
                tracingMove++;
            }
            if (tracingMove == 6) {
                tracingMove = 1;
            }
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick++;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick++;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick++;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 4) {
                xClick++;
                tracingMove++;
            }
            if (tracingMove == 5) {
                tracingMove = 1;
            }
        } getClick();

        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick--;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 4) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick--;
                tracingMove++;
            }
            if (tracingMove == 6) {
                tracingMove = 1;
            }
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick--;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick--;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick--;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 4) {
                xClick--;
                tracingMove++;
            }
            if (tracingMove == 5) {
                tracingMove = 1;
            }
        } getClick();

        //
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick--;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 4) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 6) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 7) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 8) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 9) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 10) {
                xClick--;
                tracingMove++;
            }
            if (tracingMove == 11) {
                tracingMove = 1;
            }
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick--;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 4) {
                yClick--;
                xClick--;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 6) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 7) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 8) {
                yClick--;
                xClick--;
                tracingMove++;
            } else if (tracingMove == 9) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 10) {
                xClick--;
                tracingMove++;
            }
            if (tracingMove == 11) {
                tracingMove = 1;
            }
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick--;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick--;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 4) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick--;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 6) {
                xClick--;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 7) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 8) {
                xClick--;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 9) {
                xClick--;
                tracingMove++;
            }
            if (tracingMove == 10) {
                tracingMove = 1;
            }
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick--;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 2) {
                yClick--;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick--;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 4) {
                yClick--;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick--;
                yClick--;
                tracingMove++;
            }
            if (tracingMove == 6) {
                tracingMove = 1;
            }
        } getClick();

        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick++;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 4) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 6) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 7) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 8) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 9) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 10) {
                xClick++;
                tracingMove++;
            }
            if (tracingMove == 11) {
                tracingMove = 1;
            }
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick++;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 4) {
                yClick--;
                xClick++;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 6) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 7) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 8) {
                yClick--;
                xClick++;
                tracingMove++;
            } else if (tracingMove == 9) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 10) {
                xClick++;
                tracingMove++;
            }
            if (tracingMove == 11) {
                tracingMove = 1;
            }
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick++;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick++;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 4) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick++;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 6) {
                xClick++;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 7) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 8) {
                xClick++;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 9) {
                xClick++;
                tracingMove++;
            }
            if (tracingMove == 10) {
                tracingMove = 1;
            }
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick++;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 2) {
                yClick--;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick++;
                yClick--;
                tracingMove++;
            } else if (tracingMove == 4) {
                yClick--;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick++;
                yClick--;
                tracingMove++;
            }
            if (tracingMove == 6) {
                tracingMove = 1;
            }
        } getClick();

        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick++;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 4) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 6) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 7) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 8) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 9) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 10) {
                xClick++;
                tracingMove++;
            }
            if (tracingMove == 11) {
                tracingMove = 1;
            }
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick++;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 4) {
                yClick++;
                xClick++;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 6) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 7) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 8) {
                yClick++;
                xClick++;
                tracingMove++;
            } else if (tracingMove == 9) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 10) {
                xClick++;
                tracingMove++;
            }
            if (tracingMove == 11) {
                tracingMove = 1;
            }
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick++;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick++;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 4) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick++;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 6) {
                xClick++;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 7) {
                xClick++;
                tracingMove++;
            } else if (tracingMove == 8) {
                xClick++;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 9) {
                xClick++;
                tracingMove++;
            }
            if (tracingMove == 10) {
                tracingMove = 1;
            }
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick++;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 2) {
                yClick++;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick++;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 4) {
                yClick++;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick++;
                yClick++;
                tracingMove++;
            }
            if (tracingMove == 6) {
                tracingMove = 1;
            }
        } getClick();

        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick--;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 4) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 6) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 7) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 8) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 9) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 10) {
                xClick--;
                tracingMove++;
            }
            if (tracingMove == 11) {
                tracingMove = 1;
            }
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick--;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 4) {
                yClick++;
                xClick--;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 6) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 7) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 8) {
                yClick++;
                xClick--;
                tracingMove++;
            } else if (tracingMove == 9) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 10) {
                xClick--;
                tracingMove++;
            }
            if (tracingMove == 11) {
                tracingMove = 1;
            }
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick--;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 2) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick--;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 4) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick--;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 6) {
                xClick--;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 7) {
                xClick--;
                tracingMove++;
            } else if (tracingMove == 8) {
                xClick--;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 9) {
                xClick--;
                tracingMove++;
            }
            if (tracingMove == 10) {
                tracingMove = 1;
            }
        } getClick();
        while (!Tracing.field[yClick][xClick].equals(Tracing.wall)) {
            Tracing.field[yClick][xClick] = Tracing.ray;
            if (tracingMove == 1) {
                xClick--;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 2) {
                yClick++;
                tracingMove++;
            } else if (tracingMove == 3) {
                xClick--;
                yClick++;
                tracingMove++;
            } else if (tracingMove == 4) {
                yClick++;
                tracingMove++;
            } else if (tracingMove == 5) {
                xClick--;
                yClick++;
                tracingMove++;
            }
            if (tracingMove == 6) {
                tracingMove = 1;
            }
        } getClick();

        //

        Tracing.fillFieldX = 0;
        Tracing.fillFieldY = 0;
        Tracing.textOut = "";
        while (Tracing.fillFieldY < Tracing.fieldSizeY) {
            Tracing.textOut += Tracing.field[Tracing.fillFieldY][Tracing.fillFieldX];
            Tracing.fillFieldX++;
            if (Tracing.fillFieldX == Tracing.fieldSizeX) {
                Tracing.fillFieldX = 0;
                Tracing.textOut += "\n";
                Tracing.fillFieldY++;
            }
        }

        Tracing.show();
        textArea.setText(Tracing.textOut);
    }

    public static void getClick() {
        xClick = (x - 1) / 8;
        yClick = (y - 1) / 20;
        tracingMove = 1;
    }
}
