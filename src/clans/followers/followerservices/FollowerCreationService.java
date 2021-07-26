package clans.followers.followerservices;

import clans.followers.*;
import clans.followers.skillpointring.*;

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
        createRandomTalents(follower.getTalentRing(),20);
        createRandomSkillpoints(follower.getSkillpointRing(),25);
        createRandomStatPoints(follower.getStatsRing(),25);

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

        follower.setSkillpointRing(new SkillpointRing());
        follower.getSkillpointRing().setEarthMagicSkillpointRing(new EarthMagicSkillpointRing());
        follower.getSkillpointRing().setFireMagicSkillpointRing(new FireMagicSkillpointRing());
        follower.getSkillpointRing().setWaterMagicSkillpointRing(new WaterMagicSkillpointRing());
        follower.getSkillpointRing().setWindMagicSkillpointRing(new WindMagicSkillpointRing());
        follower.getSkillpointRing().setStatusMagicSkillpointRing(new StatusMagicSkillpointRing());
        follower.getSkillpointRing().setWhiteMagicSkillpointRing(new WhiteMagicSkillpointRing());
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
        follower.setTalentRing(new TalentRing());
    }
    private static void createRandomTalents(TalentRing talentRing, int talentpoints){
        while(talentpoints > 0){
            talentpoints--;
            randomTalentsSwitch(talentRing,1);
            }
    }
    private static void randomTalentsSwitch(TalentRing talentRing, int i){
        switch (random.nextInt(17)){
            case 0: talentRing.setBowTalent(talentRing.getBowTalent()+i);break;
            case 1: talentRing.setDaggerTalent(talentRing.getDaggerTalent()+i);break;
            case 2: talentRing.setAlchemy(talentRing.getAlchemy()+i);break;
            case 3: talentRing.setElementalEarthMagic(talentRing.getElementalEarthMagic()+i);break;
            case 4: talentRing.setElementalFireMagic(talentRing.getElementalFireMagic()+i);break;
            case 5: talentRing.setElementalWaterMagic(talentRing.getElementalWaterMagic()+i);break;
            case 6: talentRing.setStatusMagic(talentRing.getStatusMagic()+i);break;
            case 7: talentRing.setWhiteMagic(talentRing.getWhiteMagic()+i);break;
            case 8: talentRing.setSingleHandMaceTalent(talentRing.getSingleHandMaceTalent()+i);break;
            case 9: talentRing.setEnchantment(talentRing.getEnchantment()+i);break;
            case 10: talentRing.setTwoHandSwordTalent(talentRing.getTwoHandSwordTalent()+i);break;
            case 11: talentRing.setTeaching(talentRing.getTeaching()+i);break;
            case 12: talentRing.setElementalWindMagic(talentRing.getElementalWindMagic()+i);break;
            case 13: talentRing.setMining(talentRing.getMining()+i);break;
            case 14: talentRing.setSmithingWeapons(talentRing.getSmithingWeapons()+i);break;
            case 15: talentRing.setSingleHandswordTalent(talentRing.getSingleHandswordTalent()+i);break;
            case 16: talentRing.setSmithingArmors(talentRing.getSmithingArmors()+i);break;
            default: throw new RuntimeException("Default should never be reached in switch. FollowerCreationService::randomTalentSwitch");

        }
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
    private static void createRandomSkillpoints(SkillpointRing skillpointRing, int skillpoints){
        int minuspoints = skillpoints;
        skillpoints = skillpoints + minuspoints;
        while (skillpoints > 0){
            skillpoints--;
            randomSkillsSwitch(skillpointRing,1);
        }
        while(minuspoints > 0){
            minuspoints--;
            randomSkillsSwitch(skillpointRing,-1);
        }


    }
    private static void randomSkillsSwitch(SkillpointRing skillpointRing, int i) {
        switch (random.nextInt(13)) {
            case 0:
                skillpointRing.setSwordSkill(skillpointRing.getSwordSkill() + i);
                break;
            case 1:
                skillpointRing.setTwoHandSwordSkill(skillpointRing.getTwoHandSwordSkill() + i);
                break;
            case 2:
                skillpointRing.setBowSkill(skillpointRing.getBowSkill() + i);
                break;
            case 3:
                skillpointRing.setSingleHandMaceSkill(skillpointRing.getSingleHandMaceSkill() + i);
                break;
            case 4:
                skillpointRing.setDaggerSkill(skillpointRing.getDaggerSkill() + i);
                break;
            case 5:
                skillpointRing.setMiningSkill(skillpointRing.getMiningSkill() + i);
                break;
            case 6:
                //Smithing 50:50 chance auf armor oder weapons
                if (random.nextBoolean()) {
                    skillpointRing.setSmithingArmorSkill(skillpointRing.getSmithingArmorSkill() + i);
                } else {
                    skillpointRing.setSmithingWeaponSkill(skillpointRing.getSmithingWeaponSkill() + i);
                }
                break;
            case 7:
                //Fire Magic Skills
                int a = random.nextInt(3);
                if (a == 1) {
                    skillpointRing.getFireMagicSkillpointRing().setCastraIgnis(skillpointRing.getFireMagicSkillpointRing().getCastraIgnis() + i);
                } else if (a == 2) {
                    skillpointRing.getFireMagicSkillpointRing().setIctumArdere(skillpointRing.getFireMagicSkillpointRing().getIctumArdere() + i);
                } else {
                    skillpointRing.getFireMagicSkillpointRing().setSagittaIgnis(skillpointRing.getFireMagicSkillpointRing().getSagittaIgnis() + i);
                }
                break;
            case 8:
                //Water Magic Skills
                int b = random.nextInt(3);
                if (b == 1) {
                    skillpointRing.getWaterMagicSkillpointRing().setCataractus(skillpointRing.getWaterMagicSkillpointRing().getCataractus()+i);
                } else if (b == 2) {
                    skillpointRing.getWaterMagicSkillpointRing().setPluviat(skillpointRing.getWaterMagicSkillpointRing().getPluviat()+i);
                }else {
                    skillpointRing.getWaterMagicSkillpointRing().setRemedium_humiditatem(skillpointRing.getWaterMagicSkillpointRing().getRemedium_humiditatem()+i);
                }
                break;
            case 9:
                //Earth Magic Skills
                int c = random.nextInt(3);
                if (c == 1) {
                    skillpointRing.getEarthMagicSkillpointRing().setSaxa_procidens(skillpointRing.getEarthMagicSkillpointRing().getSaxa_procidens()+i);
                }else if(c == 2){
                    skillpointRing.getEarthMagicSkillpointRing().setLapis_lapium_golum(skillpointRing.getEarthMagicSkillpointRing().getLapis_lapium_golum()+i);
            }else{
                    skillpointRing.getEarthMagicSkillpointRing().setSignum_fictilis(skillpointRing.getEarthMagicSkillpointRing().getSignum_fictilis()+i);
                }
                break;
            case 10:
                //Wind Magic Skills
                int d = random.nextInt(3);
                if (d == 1) {
                    skillpointRing.getWindMagicSkillpointRing().setFestatum(skillpointRing.getWindMagicSkillpointRing().getFestatum()+i);
                } else if (d == 2) {
                    skillpointRing.getWindMagicSkillpointRing().setFulgurus_radialus(skillpointRing.getWindMagicSkillpointRing().getFulgurus_radialus()+i);
                } else {
                    skillpointRing.getWindMagicSkillpointRing().setLiberi_tempest(skillpointRing.getWindMagicSkillpointRing().getLiberi_tempest()+i);
                }
                break;
            case 11:
                //Status Magic Skills
                int e = random.nextInt(3);
                if (e == 1) {
                    skillpointRing.getStatusMagicSkillpointRing().setVenenum_mortis(skillpointRing.getStatusMagicSkillpointRing().getVenenum_mortis()+i);
                }else if(e == 2){
                    skillpointRing.getStatusMagicSkillpointRing().setTelum_mortis(skillpointRing.getStatusMagicSkillpointRing().getTelum_mortis()+i);
                }else {
                    skillpointRing.getStatusMagicSkillpointRing().setDormirat(skillpointRing.getStatusMagicSkillpointRing().getDormirat()+i);
                }
                break;
            case 12:
                //White Magic Skills
                int f= random.nextInt(3);
                WhiteMagicSkillpointRing w = skillpointRing.getWhiteMagicSkillpointRing();
                if (f == 1) {
                    w.setRex_res_mortem(w.getRex_res_mortem()+i);
                } else if (f == 2) {
                    w.setPrismorum(w.getPrismorum()+i);
                } else {
                    w.setDormus_vitae(w.getDormus_vitae()+i);
                }break;
            default: throw new RuntimeException("Default should never be reached in switch. FollowerCreationService::randomSkillsSwitch");
        }

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

}
