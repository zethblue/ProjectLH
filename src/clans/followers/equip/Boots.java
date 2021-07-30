package clans.followers.equip;

public class Boots implements Equip {

    private Armorklasse armorklasse;
    private int basisdef;
    private Enchantment enchantment;


    public Boots(Armorklasse armorklasse, int basisdef, Enchantment enchantment) {
        this.armorklasse = armorklasse;
        this.basisdef = basisdef;
        this.enchantment = enchantment;
    }

    public Armorklasse getArmorklasse() {
        return armorklasse;
    }

    public void setArmorklasse(Armorklasse armorklasse) {
        this.armorklasse = armorklasse;
    }

    public int getBasisdef() {
        return basisdef;
    }

    public void setBasisdef(int basisdef) {
        this.basisdef = basisdef;
    }

    public Enchantment getEnchantment() {
        return enchantment;
    }

    public void setEnchantment(Enchantment enchantment) {
        this.enchantment = enchantment;
    }

    @Override
    public Equiparten whichEquipAmI() {
        return Equiparten.BOOTS;
    }
}
