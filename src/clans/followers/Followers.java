package clans.followers;

public class Followers {

    private String name;
    private boolean isMale;
    private TalentRing talentRing;
    private SkillpointRing skillpointRing;
    private ExpRing expRing;
    private StatsRing statsRing;
    //Equipring!

    public TalentRing getTalentRing() {
        return talentRing;
    }

    public void setTalentRing(TalentRing talentRing) {
        this.talentRing = talentRing;
    }

    public SkillpointRing getSkillpointRing() {
        return skillpointRing;
    }

    public void setSkillpointRing(SkillpointRing skillpointRing) {
        this.skillpointRing = skillpointRing;
    }

    public ExpRing getExpRing() {
        return expRing;
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
}
