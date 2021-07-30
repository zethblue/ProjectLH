package clans.followers;

import clans.followers.skillpoints.Magicskills;
import clans.followers.skillpoints.Skills;
import clans.followers.talents.Talents;

import java.util.EnumMap;

public class Followers {

    private String name;
    private boolean isMale;
    private EnumMap<Talents,Integer> talents;
    private EnumMap<Magicskills,Integer> magieSkills;
    private EnumMap<Skills,Integer> skills;
    private ExpRing expRing;
    private StatsRing statsRing;
    private EquipRing equipRing;


    /**
     * do not create with "new" - create with FollowerCreationService!
     */
    public Followers() {}


    public ExpRing getExpRing() {
        return expRing;
    }

    public void setTalents(EnumMap<Talents, Integer> talents) {
        this.talents = talents;
    }

    public EnumMap<Magicskills, Integer> getMagieSkills() {
        return magieSkills;
    }

    public void setMagieSkills(EnumMap<Magicskills, Integer> magieSkills) {
        this.magieSkills = magieSkills;
    }

    public EnumMap<Skills, Integer> getSkills() {
        return skills;
    }

    public void setSkills(EnumMap<Skills, Integer> skills) {
        this.skills = skills;
    }

    public void setExpRing(ExpRing expRing) {
        this.expRing = expRing;
    }

    public StatsRing getStatsRing() {
        return statsRing;
    }

    public void setStatsRing(StatsRing statsRing) {
        this.statsRing = statsRing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public EnumMap<Talents, Integer> getTalents() {
        return talents;
    }

    public EquipRing getEquipRing() {
        return equipRing;
    }

    public void setEquipRing(EquipRing equipRing) {
        this.equipRing = equipRing;
    }
}
