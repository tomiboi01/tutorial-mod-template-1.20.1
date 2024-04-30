package net.tomas.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.tomas.tutorialmod.TutorialMod;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RUBYPICKAXE = registerItem("ruby_pickaxe", new Item(new FabricItemSettings()));

    public static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(RUBY);

    }
    public static void addItemsToToolsItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(RUBYPICKAXE);

    }

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }
    public static void registerModItems()
    {
        TutorialMod.LOGGER.info("Registering mod items for " + TutorialMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsItemGroup);
    }
}
