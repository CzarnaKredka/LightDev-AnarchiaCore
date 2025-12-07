package dev.lightdev.config.customitem;

import eu.okaeri.configs.OkaeriConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MenusSetup extends OkaeriConfig {

    private String title;
    private int rows;
    private List<MenuDecoration> decorations;

}
