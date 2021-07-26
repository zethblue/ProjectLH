package clans.followers;


/**
 * Every Follower has an ExpRing. static Values what is needed for each levelup
 */
public class ExpRing {

    public static final int NEEDEDFORLEVEL2 = 100;
    public static final int NEEDEDFORLEVEL3 = 120;
    public static final int NEEDEDFORLEVEL4 = 140;
    public static final int NEEDEDFORLEVEL5 = 160;
    public static final int NEEDEDFORLEVEL6 = 180;
    public static final int NEEDEDFORLEVEL7 = 200;
    public static final int NEEDEDFORLEVEL8 = 220;
    public static final int NEEDEDFORLEVEL9 = 240;
    public static final int NEEDEDFORLEVEL10 = 260;
    public static final int NEEDEDFORLEVEL11 = 280;
    public static final int NEEDEDFORLEVEL12 = 300;
    public static final int NEEDEDFORLEVEL13 = 330;
    public static final int NEEDEDFORLEVEL14 = 360;
    public static final int NEEDEDFORLEVEL15 = 390;
    public static final int NEEDEDFORLEVEL16 = 400;
    public static final int NEEDEDFORLEVEL17 = 400;
    public static final int NEEDEDFORLEVEL18 = 400;
    public static final int NEEDEDFORLEVEL19 = 400;
    public static final int NEEDEDFORLEVEL20 = 400;

    private int currentLevel;
    private int currentExp;


    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getCurrentExp() {
        return currentExp;
    }

    public void setCurrentExp(int currentExp) {
        this.currentExp = currentExp;
    }

    public void levelup(){
        currentLevel++;
        currentExp = 0;
        }

}
