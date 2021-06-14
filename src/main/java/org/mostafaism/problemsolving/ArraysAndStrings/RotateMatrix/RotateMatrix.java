package org.mostafaism.problemsolving.ArraysAndStrings.RotateMatrix;

public class RotateMatrix {

    private static final int DEGREES_CIRCLE = 360;
    public static final int DEGREES_ROTATION = 90;

    public void rotateMatrix(int[][] matrix) {
        for (int row = 0; row < Math.ceil(matrix.length / 2.0); row++) {
            for (int column = 0; column < Math.floor(matrix.length / 2.0); column++) {
                rotateFullCircle(row, column, matrix);
            }
        }
    }

    private void rotateFullCircle(int row, int column, int[][] matrix) {
        Point axis = getRotationAxis(matrix);
        Point p1 = new Point(column, row);
        Point p2 = p1.rotate90(axis);
        int p1Value = getValue(matrix, p1);
        int p2Value = getValue(matrix, p2);
        for (int k = 0; k < DEGREES_CIRCLE / DEGREES_ROTATION; k++) {
            setValue(matrix, p2, p1Value);
            p1 = p1.rotate90(axis);
            p2 = p2.rotate90(axis);
            p1Value = p2Value;
            p2Value = getValue(matrix, p2);
        }
    }

    private Point getRotationAxis(int[][] matrix) {
        double distanceToMidPoint = getDistanceToMidPoint(matrix);
        Point axis = new Point(distanceToMidPoint, distanceToMidPoint);
        return axis;
    }

    private double getDistanceToMidPoint(int[][] matrix) {
        return (matrix.length - 1) / 2.0;
    }

    private void setValue(int[][] matrix, Point point, int value) {
        matrix[(int) Math.round(point.getY())][(int) Math.round(point.getX())] = value;
    }

    private int getValue(int[][] matrix, Point point) {
        return matrix[(int) Math.round(point.getY())][(int) Math.round(point.getX())];
    }
}
