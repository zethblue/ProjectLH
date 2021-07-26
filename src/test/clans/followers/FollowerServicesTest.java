package test.clans.followers;

import clans.followers.Followers;
import clans.followers.followerservices.FollowerCreationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FollowerServicesTest {

    @Test
    public void createAFollower(){
        Followers follower1 = FollowerCreationService.createLvl1Random();
        Assertions.assertNotNull(follower1.getName());
        Assertions.assertNotNull(follower1.getExpRing());
        Assertions.assertEquals(1,follower1.getExpRing().getCurrentLevel());
        Assertions.assertEquals(0,follower1.getExpRing().getCurrentExp());
        Assertions.assertNotNull(follower1.getSkillpointRing());
        Assertions.assertNotNull(follower1.getSkillpointRing().getEarthMagicSkillpointRing());
        Assertions.assertNotNull(follower1.getSkillpointRing().getFireMagicSkillpointRing());
        Assertions.assertNotNull(follower1.getSkillpointRing().getWindMagicSkillpointRing());
        Assertions.assertNotNull(follower1.getSkillpointRing().getWaterMagicSkillpointRing());
        Assertions.assertNotNull(follower1.getSkillpointRing().getStatusMagicSkillpointRing());
        Assertions.assertNotNull(follower1.getSkillpointRing().getWhiteMagicSkillpointRing());
        Assertions.assertTrue(follower1.getSkillpointRing().getBowSkill() >= -5);
        Assertions.assertTrue(follower1.getSkillpointRing().getDaggerSkill() >= -5);
        Assertions.assertTrue(follower1.getSkillpointRing().getMiningSkill() >= -5);
        Assertions.assertTrue(follower1.getSkillpointRing().getSingleHandMaceSkill() >= -5);
        Assertions.assertTrue(follower1.getSkillpointRing().getSwordSkill() >= -5);
        Assertions.assertTrue(follower1.getSkillpointRing().getTwoHandSwordSkill() >= -5);

    }
}
