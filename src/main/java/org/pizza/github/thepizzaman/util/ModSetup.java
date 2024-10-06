package org.pizza.github.thepizzaman.util;

import net.neoforged.bus.api.IEventBus;
import org.pizza.github.thepizzaman.common.init.BlockInit;
import org.pizza.github.thepizzaman.common.init.ItemInit;
import org.pizza.github.thepizzaman.common.init.TabInit;

public class ModSetup
{

    public static void register(IEventBus eventBus)
    {
        ItemInit.register(eventBus);
        BlockInit.register(eventBus);
        TabInit.register(eventBus);
    }
}
