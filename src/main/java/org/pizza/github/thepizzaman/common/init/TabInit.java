package org.pizza.github.thepizzaman.common.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.pizza.github.thepizzaman.Constants;
import org.pizza.github.thepizzaman.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class TabInit
{
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(
            BuiltInRegistries.CREATIVE_MODE_TAB, Constants.MODID
    );

    public static final List<Supplier<? extends Item>> ITEMS = new ArrayList<>();
    public static final List<Supplier<? extends Block>> BLOCKS = new ArrayList<>();

    public static final DeferredHolder<CreativeModeTab,CreativeModeTab> BLOCK_TAB = TABS.register("block_tab",()-> CreativeModeTab.builder()
            .title(Utils.translatable("blockGroup"))
            .icon(()-> ItemStack.EMPTY)
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .displayItems((param,output)->{
                BLOCKS.forEach(block-> output.accept(block.get()));
            })
            .build());

    public static final DeferredHolder<CreativeModeTab,CreativeModeTab> ITEM_TAB = TABS.register("item_tab",()-> CreativeModeTab.builder()
            .title(Utils.translatable("itemGroup"))
            .icon(()-> ItemStack.EMPTY)
            .withTabsBefore(BLOCK_TAB.getKey())
            .displayItems((param,output)->{
                ITEMS.forEach(block-> output.accept(block.get()));
            })
            .build());

    public static void register(IEventBus eventBus)
    {
        TABS.register(eventBus);
    }
}
