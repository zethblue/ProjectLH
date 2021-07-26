package clans.followers;

/**
 * Status Points for each Follower are saved in this Ring
 */
public class StatsRing {

    private int basehp;
    private int basemp;

    private int strength;
    private int dexterity;
    private int intelligence;
    private int vitality;

    public int getBasehp() {
        return basehp;
    }

    public void setBasehp(int basehp) {
        this.basehp = basehp;
    }

    public int getBasemp() {
        return basemp;
    }

    public void setBasemp(int basemp) {
        this.basemp = basemp;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }
}
