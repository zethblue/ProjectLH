package clans.followers.skillpointring;

public class WindMagicSkillpointRing {

    private int festatum; //Skill erhoeht die Evasion eines Charakters
    private int liberi_tempest; //Skill erzeugt einen kurzen gewaltigen Strahl heisser Luft, welche Gegner wegblaest. Multiangriff auf alle Gegner
    private int fulgurus_radialus; //Blitz schlaegt in Gegner ein, hoher Single Target Skill dmg.

    public int getFestatum() {
        return festatum;
    }

    public void setFestatum(int festatum) {
        this.festatum = festatum;
    }

    public int getLiberi_tempest() {
        return liberi_tempest;
    }

    public void setLiberi_tempest(int liberi_tempest) {
        this.liberi_tempest = liberi_tempest;
    }

    public int getFulgurus_radialus() {
        return fulgurus_radialus;
    }

    public void setFulgurus_radialus(int fulgurus_radialus) {
        this.fulgurus_radialus = fulgurus_radialus;
    }
}
