package org.mostafaism.problemsolving.ArraysAndStrings.RotateMatrix;

public class Point {

    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * Returns a rotation of this point by 90 degrees clockwise around its origin.
     * 
     * @return a rotation of this point by 90 degrees clockwise around its origin
     */
    public Point rotate90() {
        return new Point(-y, x);
    }

    /**
     * Returns a rotation of this point by 90 degrees clockwise around axis.
     * 
     * @param axis the axis to rotate about.
     * @return a rotation of this point by 90 degrees clockwise around axis
     */
    public Point rotate90(Point axis) {
        Point pRelativeToAxis = this.transformCoordinates(axis);
        Point pRelativeToAxisRotated = pRelativeToAxis.rotate90();
        Point originalOrigin = axis.negate();
        return pRelativeToAxisRotated.transformCoordinates(originalOrigin);
    }

    /**
     * Returns this point relative to the new origin.
     * 
     * @param newOrigin the new origin to get this point relative to
     * @return this point relative to the new origin
     */
    public Point transformCoordinates(Point newOrigin) {
        return new Point(this.x - newOrigin.getX(), this.y - newOrigin.getY());
    }

    /**
     * Returns the point opposite to this point.
     * 
     * @return the point opposite to this point
     */
    public Point negate() {
        return new Point(-this.x, -this.y);
    }

}
