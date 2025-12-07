package dev.lightdev.config.customitem;

import eu.okaeri.configs.OkaeriConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MenuDecoration extends OkaeriConfig {

    private int id;
    private String name;
    private Material material;
    private List<Integer> slots;
}
