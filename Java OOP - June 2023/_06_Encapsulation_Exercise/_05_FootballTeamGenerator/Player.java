package _06_Encapsulation_Exercise._05_FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public double overallSkillLevel(){
        return (endurance + sprint + dribble + passing + shooting) / 5.0;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        statValidation(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        statValidation(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        statValidation(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        statValidation(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        statValidation(shooting, "Shooting");
        this.shooting = shooting;
    }

    private static void statValidation(int shooting, String prefix) {
        if (shooting < 0 || shooting > 100) {
            throw new IllegalArgumentException(prefix + " should be between 0 and 100.");
        }
    }

    public String getName() {
        return name;
    }


}
