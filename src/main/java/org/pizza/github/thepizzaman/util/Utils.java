package org.pizza.github.thepizzaman.util;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.pizza.github.thepizzaman.Constants;

public class Utils
{
    public static ResourceLocation resource(String path)
    {
        return ResourceLocation.fromNamespaceAndPath(Constants.MODID,path);
    }

    public static Component translatable(String name)
    {
        return Component.translatable(Constants.MODID+"."+name);
    }

}
