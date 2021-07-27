package test.clans.followers;

import clans.followers.Followers;
import clans.followers.StatsRing;
import clans.followers.followerservices.FollowerCreationService;
import clans.followers.followerservices.LevelUpService;
import clans.followers.skillpoints.Magicskills;
import clans.followers.skillpoints.Skills;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

public class FollowerServicesTest {

    @Test
    public void createAFollower(){
        Followers follower1 = FollowerCreationService.createLvl1Random();
        Assertions.assertNotNull(follower1.getName());
        Assertions.assertNotNull(follower1.getExpRing());
        Assertions.assertEquals(1,follower1.getExpRing().getCurrentLevel());
        Assertions.assertEquals(0,follower1.getExpRing().getCurrentExp());
        Assertions.assertNotNull(follower1.getSkills());
        Assertions.assertNotNull(follower1.getMagieSkills());
        Assertions.assertTrue(follower1.getSkills().containsKey(Skills.MINING));
        Assertions.assertTrue(follower1.getMagieSkills().containsKey(Magicskills.WHITE1));



    }

    @Test
    public void createAThousandLvl1Followers(){
        for(int i = 0; i <= 1000; i++) {
            Followers follower1 = FollowerCreationService.createLvl1Random();
            for(Skills s : Skills.values()){
                Assertions.assertTrue(follower1.getSkills().get(s) >= -5 & follower1.getSkills().get(s) <= 9);
            }
            for(Magicskills s : Magicskills.values()){
                Assertions.assertTrue(follower1.getMagieSkills().get(s) >= -5 & follower1.getMagieSkills().get(s) <= 9);
            }
        }
    }

    @Test
    public void levelupTest(){
        EnumMap<Skills, Integer> lvlupSkills = FollowerCreationService.createSkillsEnumMap();
        EnumMap<Magicskills, Integer> magicSkills = FollowerCreationService.createMagicEnumMap();
        lvlupSkills.put(Skills.TWOHANDSWORD,500);
        magicSkills.put(Magicskills.FIRE3,500);
        StatsRing sr = new StatsRing();

        /**
         * Testing maxlimit
         */
        for(int i = 0; i <= 50; i++){

            Followers follower = FollowerCreationService.createLvl1Random();
            LevelUpService.levelup(follower, lvlupSkills, magicSkills, sr);
            Assert.assertTrue(follower.getSkills().get(Skills.TWOHANDSWORD) <= 20);
            Assert.assertTrue(follower.getMagieSkills().get(Magicskills.FIRE3) <= 20);
        }
    }
}
