package clans.followers.skillpointring;

public class WaterMagicSkillpointRing {

    private int pluviat; //erzeugt Regen, gut um Feuermonster zu debuffen, brandwunden zu verringern, Evasion wird bei allen Kampfteilnehmern verringert
    private int remedium_humiditatem; //erzeugt heilende Feuchtigkeit um einen Charakter. Leichte Heilung der HP pro Runde
    private int cataractus; //Angriffsskill, Wasser übergießt einen Gegner, sehr wenig dmg jedoch werden Evasion sowie STR/DEX vom Gegner drastisch verringert.

    public int getPluviat() {
        return pluviat;
    }

    public void setPluviat(int pluviat) {
        this.pluviat = pluviat;
    }

    public int getRemedium_humiditatem() {
        return remedium_humiditatem;
    }

    public void setRemedium_humiditatem(int remedium_humiditatem) {
        this.remedium_humiditatem = remedium_humiditatem;
    }

    public int getCataractus() {
        return cataractus;
    }

    public void setCataractus(int cataractus) {
        this.cataractus = cataractus;
    }
}
