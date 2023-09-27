package _06_Encapsulation_Exercise._01_ClassBox;

public class Box {
    //-	length: double
    //-	width:  double
    //-	height:  double
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        fieldValidation(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        fieldValidation(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        fieldValidation(height, "Height");
        this.height = height;
    }

    private static void fieldValidation(double field, String prefix) {
        if (field <= 0) {
            throw new IllegalArgumentException(prefix + " cannot be zero or negative.");
        }
    }

    //Volume = lwh
    //Lateral Surface Area = 2lh + 2wh
    //Surface Area = 2lw + 2lh + 2wh

    //+	calculateSurfaceArea (): double
    public double calculateSurfaceArea() {
        return 2 * length * width + 2 * length * height + 2 * width * height;
    }

    //+	calculateLateralSurfaceArea (): double
    public double calculateLateralSurfaceArea() {
        return 2 * length * height + 2 * width * height;
    }

    //+	calculateVolume (): double
    public double calculateVolume() {
        return width * height * length;
    }
}
