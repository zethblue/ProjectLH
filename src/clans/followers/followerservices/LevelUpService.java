package clans.followers.followerservices;

import clans.followers.Followers;
import clans.followers.SkillpointRing;
import clans.followers.StatsRing;
import clans.followers.skillpointring.*;

import java.util.Random;

public class LevelUpService {

    private static Random random = new Random();

    // Utility Class
    private LevelUpService() {
    }

    /**
     * Levelup Service - Follower kommt rein, Follower wird retourniert.
     * needed: eigener SkillpointRing mit default0 Werten + Werten welche beim Levelup gepusht wird werden uebergeben
     * Dasselbe mit statsRingForLevelUp
     * @param follower
     * @return
     */
    public static Followers levelup(Followers follower, SkillpointRing skrForLvlUp, StatsRing statsRingForLevelUp){
        /*
         * Skillpoint-Upgrades
         */
        levelupWeapons(follower,skrForLvlUp);
        levelupEarthMagic(follower, skrForLvlUp.getEarthMagicSkillpointRing());
        levelupFireMagic(follower,skrForLvlUp.getFireMagicSkillpointRing());
        levelupWaterMagic(follower, skrForLvlUp.getWaterMagicSkillpointRing());
        levelupWindMagic(follower,skrForLvlUp.getWindMagicSkillpointRing());
        levelupStatusMagic(follower, skrForLvlUp.getStatusMagicSkillpointRing());
        levelupWhiteMagic(follower,skrForLvlUp.getWhiteMagicSkillpointRing());
        /*
         * Statpoint Upgrades
         */
        follower.getStatsRing().setDexterity(follower.getStatsRing().getDexterity()+ statsRingForLevelUp.getDexterity());
        follower.getStatsRing().setIntelligence(follower.getStatsRing().getIntelligence()+ statsRingForLevelUp.getIntelligence());
        follower.getStatsRing().setStrength(follower.getStatsRing().getStrength()+ statsRingForLevelUp.getStrength());
        follower.getStatsRing().setVitality(follower.getStatsRing().getVitality()+ statsRingForLevelUp.getVitality());
        //HP+MP Upgrades, also Vitality and Intelligence Stat Bonus, will be added only for current levelup
        follower.getStatsRing().setBasehp(follower.getStatsRing().getBasehp()+statsRingForLevelUp.getBasehp());
        follower.getStatsRing().setBasehp(follower.getStatsRing().getBasehp()+ statsRingForLevelUp.getVitality()*5);
        follower.getStatsRing().setBasemp(follower.getStatsRing().getBasemp()+ statsRingForLevelUp.getBasemp());
        follower.getStatsRing().setBasemp(follower.getStatsRing().getBasemp()+ statsRingForLevelUp.getIntelligence()*5);


        return follower;
    }

    /**
     * wenn Talent auf 1 dann: -5 bis 0 = 75% Chance, 0 bis 5 = 50% Chance, 5 bis 10 = 25% Chance, 11 - 12 = 10% Chance, 13 - 20 = 1% Chance;
     * Jeder Talentpunkt added jeweils 5 punkte extra Chance
     * @param talentValue
     * @param currentValue
     * @return
     */
    private static boolean skillUpYesOrNo(int talentValue, int currentValue){
        int valuePercentage = 0;
        if(currentValue <= 0){
            valuePercentage = 75;
        }
        else if (currentValue <= 5){
            valuePercentage = 50;
        }
        else if(currentValue <= 10){
            valuePercentage = 25;
        }
        else if(currentValue <= 12){
            valuePercentage = 10;
        }
        else{
            valuePercentage = 1;
        }

        valuePercentage = valuePercentage + talentValue * 5;

        return random.nextInt(101) < valuePercentage;
    }

    private static void levelupWeapons(Followers follower, SkillpointRing skrForLvlUp){

        while(skrForLvlUp.getSwordSkill()>0){
            skrForLvlUp.setSwordSkill(skrForLvlUp.getSwordSkill()-1);
            if(skillUpYesOrNo(follower.getTalentRing().getSingleHandswordTalent(),follower.getSkillpointRing().getSwordSkill())){
                follower.getSkillpointRing().setSwordSkill(follower.getSkillpointRing().getSwordSkill()+1);
            }
        }
        while(skrForLvlUp.getBowSkill()>0){
            skrForLvlUp.setBowSkill(skrForLvlUp.getBowSkill()-1);
            if(skillUpYesOrNo(follower.getTalentRing().getBowTalent(), follower.getSkillpointRing().getBowSkill())){
                follower.getSkillpointRing().setBowSkill(follower.getSkillpointRing().getBowSkill()+1);
            }
        }
        while(skrForLvlUp.getDaggerSkill()>0){
            skrForLvlUp.setDaggerSkill(skrForLvlUp.getDaggerSkill()-1);
            if(skillUpYesOrNo(follower.getTalentRing().getBowTalent(),follower.getSkillpointRing().getDaggerSkill())){
                follower.getSkillpointRing().setDaggerSkill(follower.getSkillpointRing().getDaggerSkill()+1);
            }
        }

    }
    private static void levelupEarthMagic(Followers follower, EarthMagicSkillpointRing e){
        while (e.getLapis_lapium_golum()>0){
            e.setLapis_lapium_golum(e.getLapis_lapium_golum()-1);
            if(skillUpYesOrNo(follower.getTalentRing().getElementalEarthMagic(),follower.getSkillpointRing().getEarthMagicSkillpointRing().getLapis_lapium_golum())){
                follower.getSkillpointRing().getEarthMagicSkillpointRing().setLapis_lapium_golum(follower.getSkillpointRing().getEarthMagicSkillpointRing().getLapis_lapium_golum()+1);
            }
        }
        while (e.getSaxa_procidens()>0){
            e.setSaxa_procidens(e.getSaxa_procidens()-1);
            if(skillUpYesOrNo(follower.getTalentRing().getElementalEarthMagic(),follower.getSkillpointRing().getEarthMagicSkillpointRing().getSaxa_procidens())){
                follower.getSkillpointRing().getEarthMagicSkillpointRing().setSaxa_procidens(follower.getSkillpointRing().getEarthMagicSkillpointRing().getSaxa_procidens()+1);
            }
        }
        while (e.getSignum_fictilis()>0){
            e.setSignum_fictilis(e.getSignum_fictilis()-1);
            if(skillUpYesOrNo(follower.getTalentRing().getElementalEarthMagic(),follower.getSkillpointRing().getEarthMagicSkillpointRing().getSignum_fictilis())) {
                follower.getSkillpointRing().getEarthMagicSkillpointRing().setSignum_fictilis(follower.getSkillpointRing().getEarthMagicSkillpointRing().getSignum_fictilis() + 1);
            }
        }

    }
    private static void levelupFireMagic(Followers follower, FireMagicSkillpointRing e){
        while (e.getSagittaIgnis()>0){
            e.setSagittaIgnis(e.getSagittaIgnis()-1);
            if(skillUpYesOrNo(follower.getTalentRing().getElementalFireMagic(),follower.getSkillpointRing().getFireMagicSkillpointRing().getSagittaIgnis())){
                follower.getSkillpointRing().getFireMagicSkillpointRing().setSagittaIgnis(follower.getSkillpointRing().getFireMagicSkillpointRing().getSagittaIgnis()+1);
            }
        }
        while (e.getIctumArdere()>0){
            e.setIctumArdere(e.getIctumArdere()-1);
            if(skillUpYesOrNo(follower.getTalentRing().getElementalFireMagic(),follower.getSkillpointRing().getFireMagicSkillpointRing().getIctumArdere())){
                follower.getSkillpointRing().getFireMagicSkillpointRing().setIctumArdere(follower.getSkillpointRing().getFireMagicSkillpointRing().getIctumArdere()+1);
            }
        }
        while (e.getCastraIgnis()>0){
            e.setCastraIgnis(e.getCastraIgnis()-1);
            if(skillUpYesOrNo(follower.getTalentRing().getElementalFireMagic(),follower.getSkillpointRing().getFireMagicSkillpointRing().getCastraIgnis())) {
                follower.getSkillpointRing().getFireMagicSkillpointRing().setCastraIgnis(follower.getSkillpointRing().getFireMagicSkillpointRing().getCastraIgnis() + 1);
            }
        }

    }
    private static void levelupWaterMagic(Followers follower, WaterMagicSkillpointRing e){
        while(e.getCataractus()>0){
            e.setCataractus(e.getCataractus()-1);
            if(skillUpYesOrNo(follower.getTalentRing().getElementalWaterMagic(),follower.getSkillpointRing().getWaterMagicSkillpointRing().getCataractus())){
                follower.getSkillpointRing().getWaterMagicSkillpointRing().setCataractus(follower.getSkillpointRing().getWaterMagicSkillpointRing().getCataractus()+1);
            }
        }
        while(e.getPluviat()>0){
            e.setPluviat(e.getPluviat()-1);
            if(skillUpYesOrNo(follower.getTalentRing().getElementalWaterMagic(),follower.getSkillpointRing().getWaterMagicSkillpointRing().getPluviat())){
                follower.getSkillpointRing().getWaterMagicSkillpointRing().setPluviat(follower.getSkillpointRing().getWaterMagicSkillpointRing().getPluviat()+1);
            }
        }
        while(e.getRemedium_humiditatem()>0){
            e.setRemedium_humiditatem(e.getRemedium_humiditatem()-1);
            if(skillUpYesOrNo(follower.getTalentRing().getElementalWaterMagic(),follower.getSkillpointRing().getWaterMagicSkillpointRing().getRemedium_humiditatem())){
                follower.getSkillpointRing().getWaterMagicSkillpointRing().setRemedium_humiditatem(follower.getSkillpointRing().getWaterMagicSkillpointRing().getRemedium_humiditatem()+1);
            }
        }

    }
    private static void levelupWindMagic(Followers follower, WindMagicSkillpointRing e){
        while(e.getFestatum()>0){
            e.setFestatum(e.getFestatum()-1);
            if(skillUpYesOrNo(follower.getTalentRing().getElementalWindMagic(),follower.getSkillpointRing().getWindMagicSkillpointRing().getFestatum())){
                follower.getSkillpointRing().getWindMagicSkillpointRing().setFestatum(follower.getSkillpointRing().getWindMagicSkillpointRing().getFestatum()+1);
            }
        }
        while(e.getFulgurus_radialus()>0){
            e.setFulgurus_radialus(e.getFulgurus_radialus()-1);
            if(skillUpYesOrNo(follower.getTalentRing().getElementalWindMagic(),follower.getSkillpointRing().getWindMagicSkillpointRing().getFulgurus_radialus())){
                follower.getSkillpointRing().getWindMagicSkillpointRing().setFulgurus_radialus(follower.getSkillpointRing().getWindMagicSkillpointRing().getFulgurus_radialus()+1);
            }
        }
        while (e.getLiberi_tempest()>0){
            e.setLiberi_tempest(e.getLiberi_tempest()-1);
            if(skillUpYesOrNo(follower.getTalentRing().getElementalWindMagic(), follower.getSkillpointRing().getWindMagicSkillpointRing().getLiberi_tempest())){
                follower.getSkillpointRing().getWindMagicSkillpointRing().setLiberi_tempest(follower.getSkillpointRing().getWindMagicSkillpointRing().getLiberi_tempest()+1);
            }
        }
    }
    private static void levelupStatusMagic(Followers follower, StatusMagicSkillpointRing e){
        while(e.getDormirat()>0){
            e.setDormirat(e.getDormirat()-1);
            if(skillUpYesOrNo(follower.getTalentRing().getStatusMagic(),follower.getSkillpointRing().getStatusMagicSkillpointRing().getDormirat())){
                follower.getSkillpointRing().getStatusMagicSkillpointRing().setDormirat(follower.getSkillpointRing().getStatusMagicSkillpointRing().getDormirat()+1);
            }
        }
        while (e.getTelum_mortis()>0){
            e.setTelum_mortis(e.getTelum_mortis()-1);
            if(skillUpYesOrNo(follower.getTalentRing().getStatusMagic(), follower.getSkillpointRing().getStatusMagicSkillpointRing().getTelum_mortis())){
                follower.getSkillpointRing().getStatusMagicSkillpointRing().setTelum_mortis(follower.getSkillpointRing().getStatusMagicSkillpointRing().getTelum_mortis()+1);
            }
        }
        while(e.getVenenum_mortis()>0){
            e.setTelum_mortis(e.getTelum_mortis()-1);
            if(skillUpYesOrNo(follower.getTalentRing().getStatusMagic(),follower.getSkillpointRing().getStatusMagicSkillpointRing().getVenenum_mortis())){
                follower.getSkillpointRing().getStatusMagicSkillpointRing().setVenenum_mortis(follower.getSkillpointRing().getStatusMagicSkillpointRing().getVenenum_mortis()+1);
            }
        }
    }
    private static void levelupWhiteMagic(Followers follower, WhiteMagicSkillpointRing e){
        while (e.getDormus_vitae() > 0){
            e.setDormus_vitae(e.getDormus_vitae()-1);
            if(skillUpYesOrNo(follower.getTalentRing().getWhiteMagic(), follower.getSkillpointRing().getWhiteMagicSkillpointRing().getDormus_vitae())){
                follower.getSkillpointRing().getWhiteMagicSkillpointRing().setDormus_vitae(follower.getSkillpointRing().getWhiteMagicSkillpointRing().getDormus_vitae()+1);
            }
        }
        while (e.getPrismorum() > 0) {
            e.setPrismorum(e.getPrismorum()-1);
            if(skillUpYesOrNo(follower.getTalentRing().getWhiteMagic(),follower.getSkillpointRing().getWhiteMagicSkillpointRing().getPrismorum())){
                follower.getSkillpointRing().getWhiteMagicSkillpointRing().setPrismorum(follower.getSkillpointRing().getWhiteMagicSkillpointRing().getPrismorum()+1);
            }
        }
        while (e.getRex_res_mortem() > 0){
            e.setRex_res_mortem(e.getRex_res_mortem()-1);
            if(skillUpYesOrNo(follower.getTalentRing().getWhiteMagic(),follower.getSkillpointRing().getWhiteMagicSkillpointRing().getRex_res_mortem())){
                follower.getSkillpointRing().getWhiteMagicSkillpointRing().setRex_res_mortem(follower.getSkillpointRing().getWhiteMagicSkillpointRing().getRex_res_mortem()+1);
            }
        }
    }

}
