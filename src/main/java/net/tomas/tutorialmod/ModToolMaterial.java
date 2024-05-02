package net.tomas.tutorialmod;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import net.tomas.tutorialmod.item.ModItems;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    RUBY(MiningLevels.IRON,400, ToolMaterials.GOLD.getMiningSpeedMultiplier(), 3.5f, 25, () -> Ingredient.ofItems((ModItems.RUBY))),
    BAMBOO(MiningLevels.WOOD, 100,ToolMaterials.WOOD.getMiningSpeedMultiplier(), ToolMaterials.STONE.getAttackDamage(), ToolMaterials.GOLD.getEnchantability(), () -> Ingredient.ofItems(Items.BAMBOO));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredients;

    ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed1, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredients) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed1;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredients = repairIngredients;
    }


    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredients.get();
    }
}
