package org.pizza.github.thepizzaman.common.init;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.pizza.github.thepizzaman.Constants;

import java.util.function.Supplier;

public class ItemInit
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MODID);

    public static<T extends Item> DeferredItem<T> registerItem(String name, Supplier<T> sup)
    {
        return registerItem(name,sup,true);
    }

    public static<T extends Item> DeferredItem<T> registerItem(String name, Supplier<T> sup, boolean putInTab)
    {
        DeferredItem<T> regObj = ITEMS.register(name,sup);
        if(putInTab) TabInit.ITEMS.add(regObj);
        return regObj;
    }

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
