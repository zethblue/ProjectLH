package clans.followers.followerservices;

import clans.followers.Followers;
import clans.followers.StatsRing;
import clans.followers.skillpoints.Magicskills;
import clans.followers.skillpoints.Skills;
import clans.followers.talents.Talents;

import java.util.EnumMap;
import java.util.Random;

public class LevelUpService {

    private static Random random = new Random();

    // Utility Class
    private LevelUpService() {
    }

    /**
     * Levelup Service - Follower kommt rein, Follower wird retourniert.
     * needed:
     * EnumMap mit Skills, wo alle Skills drin sind, die Verbesserungsversuche beinhalten.
     * EnumMap  mit MagicSkills, wo alle Magieskills drin sind, die Verbesserungsversuche beinhalten.
     * Beide Maps muessen mitgeschickt werden, notfalls mit 0er Values, hauptsache alle Enums sind vorhanden
     * ein Statsring wird fuer die Anhebung der Stats benoetigt.
     * @param follower
     * @param lvlMagic
     * @param lvlSkills
     * @param lvlSR
     */
    public static Followers levelup(Followers follower, EnumMap<Skills, Integer> lvlSkills, EnumMap<Magicskills, Integer> lvlMagic, StatsRing lvlSR) {
        EnumMap<Talents, Integer> talents = follower.getTalents();
        /*
         * Skillpoint-Upgrades
         */
        for (Skills s : Skills.values()) {
            while (lvlSkills.get(s) > 0){
                lvlSkills.put(s,lvlSkills.get(s)-1);
                if(skillUpYesOrNo(talents.get(s.getDazugehoerigesTalent()),follower.getSkills().get(s))){
                    follower.getSkills().put(s,follower.getSkills().get(s)+1);
                }
            }

        }
        for(Magicskills s : Magicskills.values()){
            while(lvlMagic.get(s) > 0){
                lvlMagic.put(s, lvlMagic.get(s)-1);
                if(skillUpYesOrNo(talents.get(s.getDazugehoerigesTalent()), follower.getMagieSkills().get(s))){
                    follower.getMagieSkills().put(s, follower.getMagieSkills().get(s)+1);
                }
            }
        }

        /*
         * Statpoint Upgrades
         * TODO: braucht eindeutig noch einen Overhaul
         */
        follower.getStatsRing().setDexterity(follower.getStatsRing().getDexterity() + lvlSR.getDexterity());
        follower.getStatsRing().setIntelligence(follower.getStatsRing().getIntelligence() + lvlSR.getIntelligence());
        follower.getStatsRing().setStrength(follower.getStatsRing().getStrength() + lvlSR.getStrength());
        follower.getStatsRing().setVitality(follower.getStatsRing().getVitality() + lvlSR.getVitality());
        //HP+MP Upgrades, also Vitality and Intelligence Stat Bonus, will be added only for current levelup
        follower.getStatsRing().setBasehp(follower.getStatsRing().getBasehp() + lvlSR.getBasehp());
        follower.getStatsRing().setBasehp(follower.getStatsRing().getBasehp() + lvlSR.getVitality() * 5);
        follower.getStatsRing().setBasemp(follower.getStatsRing().getBasemp() + lvlSR.getBasemp());
        follower.getStatsRing().setBasemp(follower.getStatsRing().getBasemp() + lvlSR.getIntelligence() * 5);


        return follower;
    }

    /**
     * wenn Talent auf 1 dann: -5 bis 0 = 75% Chance, 0 bis 5 = 50% Chance, 5 bis 10 = 25% Chance, 11 - 12 = 10% Chance, 13 - 20 = 1% Chance;
     * Jeder Talentpunkt added jeweils 5 punkte extra Chance
     *
     * @param talentValue
     * @param currentValue
     * @return
     */
    private static boolean skillUpYesOrNo(int talentValue, int currentValue) {
        int valuePercentage = 0;
        if (currentValue <= 0) {
            valuePercentage = 75;
        } else if (currentValue <= 5) {
            valuePercentage = 50;
        } else if (currentValue <= 10) {
            valuePercentage = 25;
        } else if (currentValue <= 12) {
            valuePercentage = 10;
        } else if(currentValue <= 19) {
            valuePercentage = 1;
        } else{
            return false;
        }

        valuePercentage = valuePercentage + talentValue * 5;

        return random.nextInt(101) < valuePercentage;
    }
}