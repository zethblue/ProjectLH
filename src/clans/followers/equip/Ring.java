package clans.followers.equip;

import allgemein.Elements;

public class Ring implements Equip {

    private Elements element;
    private Enchantment enchantment;

    public Ring(Elements element, Enchantment enchantment) {
        this.element = element;
        this.enchantment = enchantment;
    }

    public Elements getElement() {
        return element;
    }

    public void setElement(Elements element) {
        this.element = element;
    }

    public Enchantment getEnchantment() {
        return enchantment;
    }

    public void setEnchantment(Enchantment enchantment) {
        this.enchantment = enchantment;
    }

    @Override
    public Equiparten whichEquipAmI() {
        return Equiparten.RING;
    }
}
