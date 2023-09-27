package _06_Encapsulation_Exercise._04_PizzaCalories_ENUM;

public enum BakingTechnique {
    //•	Crispy – 0.9;
    //•	Chewy – 1.1;
    //•	Homemade – 1.0;

    Crispy(0.9),
    Chewy(1.1),
    Homemade(1.0);

    private double modifier;

    BakingTechnique(double modifier){
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }
}
