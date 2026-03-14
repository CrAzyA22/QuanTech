package de.dagegenstand.qtech.common.data.tiers;

public enum EnergyTier {
    ULV("ulv", "Ultra Low Voltage", 32, "copper"),
    LV("lv", "Low Voltage", 128, "silver"),
    MV("mv", "Medium Voltage", 512, "energetic_alloy"),
    KHV("khv", "Kinda High Voltage", 1024, "electrum"),
    HV("hv", "High Voltage", 4096, "vibrant_alloy"),
    AHV("ahv", "Actually High Voltage", 9216, "aluminum"),
    VHV("vhv", "Very High Voltage", 65536, "platinum"),
    EHV("ehv", "Extremely High Voltage", 262144, "osmium"),
    KCV("kcv", "Kinda Crazy Voltage", 524288, "signalum"),
    CV("cv", "Crazy Voltage", 1048576, "azbantium_enderium_alloy"),
    UV("uv", "Ultimate Voltage", 4194304, "rutherfordium"),
    VUV("vuv", "Very Ultimate Voltage", 16777216, "rhenium_platinum_alloy"),
    EXV("exv", "Extremely Ultimate Voltage", 33554432, "tunneled_signalum"),
    RMV("rmv", "Really Mega Voltage", 67108864, "tungsten_adamantium_alloy"),
    VMV("vmv", "Very Mega Voltage", 134217728, "mithril_lunarite_alloy"),
    EMV("emv", "Extremely Mega Voltage", 268435456, "naquadah_quantum_steel"),
    UHV("uhv", "Ultra High Voltage", 536870912, "tiberium_tritanium_alloy"),
    EUHV("euhv", "Extremely Ultra High Voltage", 1073741824, "prometheum"),
    IUHV("iuhv", "Insanely Ultra High Voltage", 2000000000, "herculite_rutherfordium_alloy"),
    MAX("max", "Maximum Voltage", Integer.MAX_VALUE, "quantic_insanity_infinity_alloy");

    final String id;
    final String displayName;

    final String mainMaterial;

    final int supportedVoltage;

    EnergyTier(String id, String displayName, int supportedVoltage, String mainMaterial) {
        this.id = id;
        this.displayName = displayName;
        this.supportedVoltage = supportedVoltage;
        this.mainMaterial = mainMaterial;

    }
}
