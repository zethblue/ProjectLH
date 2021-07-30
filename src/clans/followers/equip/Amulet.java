package clans.followers.equip;

public class Amulet implements Equip {

    private Enchantment enchantment;
    private Enchantment enchantment2;

    @Override
    public Equiparten whichEquipAmI() {
        return Equiparten.AMULET;
    }
}
