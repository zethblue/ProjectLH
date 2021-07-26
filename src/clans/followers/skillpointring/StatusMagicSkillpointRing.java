package clans.followers.skillpointring;

public class StatusMagicSkillpointRing {

    private int dormirat; //Spell sends an enemy to sleep. Wakes up after a hit
    private int Venenum_mortis; //Big Poison Bubble, poisons everything incl. allies
    private int telum_mortis; //Spell poisons a weapon, the weapon will poison enemies

    public int getDormirat() {
        return dormirat;
    }

    public void setDormirat(int dormirat) {
        this.dormirat = dormirat;
    }

    public int getVenenum_mortis() {
        return Venenum_mortis;
    }

    public void setVenenum_mortis(int venenum_mortis) {
        Venenum_mortis = venenum_mortis;
    }

    public int getTelum_mortis() {
        return telum_mortis;
    }

    public void setTelum_mortis(int telum_mortis) {
        this.telum_mortis = telum_mortis;
    }
}
