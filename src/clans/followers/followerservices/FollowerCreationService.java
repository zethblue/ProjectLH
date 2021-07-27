package clans.followers.followerservices;

import clans.followers.*;
import clans.followers.skillpoints.*;
import clans.followers.talents.Talents;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Random;


/**
 * Class for creating Followers.
 */
public class FollowerCreationService {

    private static Random random = new Random();

    //Utility Class
    private FollowerCreationService(){}


    public static Followers createLvl1Random(){
        Followers follower = createFollowerBase();
        createRandomTalents(follower.getTalents(),20);
        createRandomSkillpoints(follower.getSkills(), follower.getMagieSkills(), 25);
        createRandomStatPoints(follower.getStatsRing(),25);
        controlMinMaxWerteSkills(follower.getSkills(), follower.getMagieSkills());

        return follower;
    }

    //TODO: createNamen Methoden mit Random erstellen und Namen einspielen
    public static String createNameForFollowerMale(){
        return "Max";
    }
    public static String createNameForFollowerFemale(){
        return "Laura";
    }
    //private methods to work with the big methods
    private static void loadAllRings(Followers follower){

        EnumMap<Skills, Integer> skillsIntegerEnumMap = createSkillsEnumMap();
        EnumMap<Magicskills,Integer> magicskillsEnumMap = createMagicEnumMap();

        follower.setSkills(skillsIntegerEnumMap);
        follower.setMagieSkills(magicskillsEnumMap);
        StatsRing sr = new StatsRing();
        sr.setBasehp(100);
        sr.setBasemp(10);
        sr.setDexterity(1);
        sr.setIntelligence(1);
        sr.setStrength(1);
        sr.setVitality(1);
        follower.setStatsRing(sr);
        follower.setExpRing(new ExpRing());
        follower.getExpRing().levelup();
        EnumMap<Talents,Integer> talents = new EnumMap(Talents.class);
        for(Talents t : Talents.values()){
            talents.put(t,0);
        }
        follower.setTalents(talents);
    }
    private static void createRandomTalents(EnumMap<Talents,Integer> talentMap, int talentpoints){
        while(talentpoints > 0){
            talentpoints--;
            randomTalentsSwitch(talentMap,1);
            }
    }
    private static void randomTalentsSwitch(EnumMap<Talents,Integer> talentMap, int i){
        int r = random.nextInt(talentMap.size());
        Talents[] t = Talents.values();
        talentMap.put(t[r], talentMap.get(t[r]) +i);
    }
    private static Followers createFollowerBase(){
        Followers follower = new Followers();
        follower.setMale(random.nextBoolean());
        if(follower.isMale()){
            follower.setName(createNameForFollowerMale());
        } else {
            follower.setName(createNameForFollowerFemale());
        }
        loadAllRings(follower);
        return follower;
    }
    //Chance auf Magische Skills 33% bei plus, bei minus 50/50
    private static void createRandomSkillpoints(EnumMap<Skills,Integer> skills, EnumMap<Magicskills, Integer> magicskills, int skillpoints){
        int minuspoints = skillpoints;
        skillpoints = skillpoints + minuspoints;
        while (skillpoints > 0){
            skillpoints--;
            int i = random.nextInt(3);
            switch (i){
                case 0:
                case 1:randomSkillsSwitch(skills,1); break;
                case 2: randomMagicSkillsSwitch(magicskills, 1); break;
                default: throw new RuntimeException("This should never be reached - FollowerCreationService::createRandomSkillpoints");
            }
        }
        while(minuspoints > 0){
            minuspoints--;
            if(random.nextBoolean()){
                randomSkillsSwitch(skills,-1);
            }else {
                randomMagicSkillsSwitch(magicskills,-1);
            }
        }


    }
    private static void randomSkillsSwitch(EnumMap<Skills,Integer> e, int i) {
        int r = random.nextInt(e.size());
        Skills[] t = Skills.values();
        e.put(t[r], e.get(t[r]) +i);
    }
    private static void randomMagicSkillsSwitch(EnumMap<Magicskills,Integer> e, int i){
        int r = random.nextInt(e.size());
        Magicskills[] t = Magicskills.values();
        e.put(t[r], e.get(t[r]) +i);

    }
    private static void createRandomStatPoints(StatsRing sr, int statpoints){
        while (statpoints > 0){
            statpoints--;
            switch (random.nextInt(6)){
                case 1:sr.setVitality(sr.getVitality()+1);sr.setBasehp(sr.getBasehp()+5);break;
                case 2:sr.setStrength(sr.getStrength()+1);break;
                case 3:sr.setDexterity(sr.getDexterity()+1);break;
                case 4:sr.setIntelligence(sr.getIntelligence()+1); sr.setBasemp(sr.getBasemp()+2);break;
                case 5:sr.setBasehp(sr.getBasehp()+25);break;
                case 0:sr.setBasemp(sr.getBasemp()+5);break;
                default: throw new RuntimeException("Default should never be reached in switch. FollowerCreationService::createRandomStatPoints");
            }
        }

    }
    private static void controlMinMaxWerteSkills(EnumMap<Skills,Integer> skills, EnumMap<Magicskills, Integer> magicskills){
        int minWert = -5;
        int maxWert = 9;
        for(Skills s : Skills.values()){
            if(skills.get(s) < minWert){
                skills.put(s, minWert);
            }
            if(skills.get(s) > maxWert){
                skills.put(s, maxWert);
            }
        }
        for(Magicskills s : Magicskills.values()){
            if(magicskills.get(s) < minWert){
                magicskills.put(s, minWert);
            }
            if(magicskills.get(s) > maxWert){
                magicskills.put(s, maxWert);
            }
        }
    }
    public static EnumMap<Skills, Integer> createSkillsEnumMap(){
        EnumMap<Skills, Integer> a = new EnumMap(Skills.class);
        for(Skills s : Skills.values()){
            a.put(s,0);
        }
        return a;

    }
    public static EnumMap<Magicskills, Integer>createMagicEnumMap(){
        EnumMap<Magicskills,Integer> a = new EnumMap(Magicskills.class);
        for(Magicskills s : Magicskills.values()){
            a.put(s,0);
        }
        return a;
    }

}
