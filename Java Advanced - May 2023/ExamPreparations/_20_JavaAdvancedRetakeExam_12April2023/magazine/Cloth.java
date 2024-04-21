package ExamPreparations._20_JavaAdvancedRetakeExam_12April2023.magazine;

public class Cloth {

    private String color;
    private int size;
    private String type;

    public Cloth(String color, int size, String type) {
        setColor(color);
        setSize(size);
        setType(type);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Product: %s with size %s, color %s",type,size,color);
    }
}
