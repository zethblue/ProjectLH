package clans.followers;

import clans.followers.skillpointring.*;

/**
 * Every follower has a SkillpointRing.
 * Meaning: For every Skill you use you have a Value, which affects the dmg/effect of the skill. Greater Value is better Skill
 * There are also Skills for non-battle related purposes
 * Skillpoints should be in Range of -5 to 20 max.
 */
public class SkillpointRing {

    private int swordSkill;
    private int twoHandSwordSkill;
    private int bowSkill;
    private int singleHandMaceSkill;
    private int daggerSkill;
    private int miningSkill;
    private int smithingWeaponSkill;
    private int smithingArmorSkill;
    private FireMagicSkillpointRing fireMagicSkillpointRing;
    private WaterMagicSkillpointRing waterMagicSkillpointRing;
    private EarthMagicSkillpointRing earthMagicSkillpointRing;
    private WindMagicSkillpointRing windMagicSkillpointRing;
    private StatusMagicSkillpointRing statusMagicSkillpointRing;
    private WhiteMagicSkillpointRing whiteMagicSkillpointRing;

    public int getSwordSkill() {
        return swordSkill;
    }

    public void setSwordSkill(int swordSkill) {
        this.swordSkill = swordSkill;
    }

    public int getTwoHandSwordSkill() {
        return twoHandSwordSkill;
    }

    public void setTwoHandSwordSkill(int twoHandSwordSkill) {
        this.twoHandSwordSkill = twoHandSwordSkill;
    }

    public int getBowSkill() {
        return bowSkill;
    }

    public void setBowSkill(int bowSkill) {
        this.bowSkill = bowSkill;
    }

    public int getSingleHandMaceSkill() {
        return singleHandMaceSkill;
    }

    public void setSingleHandMaceSkill(int singleHandMaceSkill) {
        this.singleHandMaceSkill = singleHandMaceSkill;
    }

    public int getDaggerSkill() {
        return daggerSkill;
    }

    public void setDaggerSkill(int daggerSkill) {
        this.daggerSkill = daggerSkill;
    }

    public FireMagicSkillpointRing getFireMagicSkillpointRing() {
        return fireMagicSkillpointRing;
    }

    public void setFireMagicSkillpointRing(FireMagicSkillpointRing fireMagicSkillpointRing) {
        this.fireMagicSkillpointRing = fireMagicSkillpointRing;
    }

    public WaterMagicSkillpointRing getWaterMagicSkillpointRing() {
        return waterMagicSkillpointRing;
    }

    public void setWaterMagicSkillpointRing(WaterMagicSkillpointRing waterMagicSkillpointRing) {
        this.waterMagicSkillpointRing = waterMagicSkillpointRing;
    }

    public EarthMagicSkillpointRing getEarthMagicSkillpointRing() {
        return earthMagicSkillpointRing;
    }

    public void setEarthMagicSkillpointRing(EarthMagicSkillpointRing earthMagicSkillpointRing) {
        this.earthMagicSkillpointRing = earthMagicSkillpointRing;
    }

    public WindMagicSkillpointRing getWindMagicSkillpointRing() {
        return windMagicSkillpointRing;
    }

    public void setWindMagicSkillpointRing(WindMagicSkillpointRing windMagicSkillpointRing) {
        this.windMagicSkillpointRing = windMagicSkillpointRing;
    }

    public StatusMagicSkillpointRing getStatusMagicSkillpointRing() {
        return statusMagicSkillpointRing;
    }

    public void setStatusMagicSkillpointRing(StatusMagicSkillpointRing statusMagicSkillpointRing) {
        this.statusMagicSkillpointRing = statusMagicSkillpointRing;
    }

    public WhiteMagicSkillpointRing getWhiteMagicSkillpointRing() {
        return whiteMagicSkillpointRing;
    }

    public void setWhiteMagicSkillpointRing(WhiteMagicSkillpointRing whiteMagicSkillpointRing) {
        this.whiteMagicSkillpointRing = whiteMagicSkillpointRing;
    }

    public int getMiningSkill() {
        return miningSkill;
    }

    public void setMiningSkill(int miningSkill) {
        this.miningSkill = miningSkill;
    }

    public int getSmithingWeaponSkill() {
        return smithingWeaponSkill;
    }

    public void setSmithingWeaponSkill(int smithingWeaponSkill) {
        this.smithingWeaponSkill = smithingWeaponSkill;
    }

    public int getSmithingArmorSkill() {
        return smithingArmorSkill;
    }

    public void setSmithingArmorSkill(int smithingArmorSkill) {
        this.smithingArmorSkill = smithingArmorSkill;
    }
}
