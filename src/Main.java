/*
Author    : Ahmet Hacioglu
Student ID: 041801123
Date      : 02.11.2020
Code Summary:
The main purpose of the program is simulates the projectile motion.
Firstly, user gives angle value (double) and then
the program simulates projectile motion simulation based on formulas and variables.
The program finally calculates and prints the distance of the simulation.
*/

//Program uses a class
import java.awt.*;
import java.util.Scanner;

public class Main {

    /** Main method */
    public static void main(String[] args) {

        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Declare and initialize variables
        double angle;
        double totalTime;
        final double DELTA_TIME = 0.01;
        final double VELOCITY = 4.0;
        final double GRAVITY = 9.81;
        double maxDistance;

        // user to enter a angle value
        System.out.println("Enter angle (in degrees such as 45.3): ");
        angle = input.nextDouble();
        if (angle > 360)
            angle = angle % 360;
        if (angle > 180)
            System.out.println("There will be no projectile motion at this angle");
        else {
            double radians = Math.toRadians(angle);
            totalTime = (2 * VELOCITY * Math.sin(radians)) / GRAVITY;
            maxDistance = Math.abs(VELOCITY * Math.cos(radians) * totalTime);
            //If the angle is bigger than 90, cos function is negative so the direction is negative. For proper working program I just mirror the graph.
            int canvas_width = 600;
            int canvas_height = 600;
            StdDraw.setCanvasSize(canvas_width, canvas_height);
            StdDraw.setXscale(0, 2);
            StdDraw.setYscale(0, 1);
            StdDraw.enableDoubleBuffering();
            StdDraw.textLeft(0.01, 0.98, "Angle: " + angle + " degree.");
            StdDraw.textLeft(0.01, 0.94, String.format("x: %.2f km", maxDistance));
            double circleRadius = 0.01;

            for (double time = 0; time <= totalTime; time += DELTA_TIME) {
                double xPosition = VELOCITY * Math.cos(radians) * time;
                double yPosition = (VELOCITY * Math.sin(radians) * time) - (GRAVITY * Math.pow(time, 2) / 2);
                StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                StdDraw.filledCircle(xPosition, yPosition, circleRadius);
                StdDraw.show();
                StdDraw.pause(10);
            }

        }
    }
}