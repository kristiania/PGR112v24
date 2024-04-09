package examples.oop.abstraction.example2;

public class Player extends Entity
{
    private int experience = 0;
    private int level = 1;


    public int getLevel() {
        return this.level;
    }


    public void addExperience(int value) {
        this.experience += value;

        this.levelUpCheck();
    }


    private void levelUpCheck() {
        if (this.experienceNeeded(this.level) >= this.experience) {
            this.levelUp();
        }
    }

    private int experienceNeeded(int level) {
        return 10 + (50*level) + + (10*(level + 1)) + (5*(level*2));
    }

    private void levelUp() {
        this.level ++;

        this.levelUpCheck();
    }
}
