package clans.followers.skillpointring;

/**
 * sub-Ring for Fire Magic Skills
 */
public class FireMagicSkillpointRing {

    private int ictumArdere; //Single Target Melee Fire Skill - fuegt Status verbrennen zu
    private int sagittaIgnis; //Single Target Distance Fire Skill
    private int castraIgnis; // Beschwoere einen Feuerwicht.

    public int getIctumArdere() {
        return ictumArdere;
    }

    public void setIctumArdere(int ictumArdere) {
        this.ictumArdere = ictumArdere;
    }

    public int getSagittaIgnis() {
        return sagittaIgnis;
    }

    public void setSagittaIgnis(int sagittaIgnis) {
        this.sagittaIgnis = sagittaIgnis;
    }

    public int getCastraIgnis() {
        return castraIgnis;
    }

    public void setCastraIgnis(int castraIgnis) {
        this.castraIgnis = castraIgnis;
    }
}
