package org.pizza.github.thepizzaman.common.init;

import net.minecraft.client.gui.components.tabs.Tab;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.pizza.github.thepizzaman.Constants;

import java.util.function.Supplier;

public class BlockInit
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Constants.MODID);

    public static<T extends Block>DeferredBlock<T> registerBlock(String name, Supplier<T> supplier)
    {
        DeferredBlock<T> regObj = BLOCKS.register(name,supplier);
        ItemInit.registerItem(name,()-> new BlockItem(regObj.get(),new Item.Properties()),false);
        TabInit.BLOCKS.add(regObj);
        return  regObj;
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
