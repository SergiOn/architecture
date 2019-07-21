package com.family.data;

import java.util.AbstractMap;
import java.util.Map;

public class Data {

//    public static final Map<String, Map<String, String>> families = Stream.of(
//            new AbstractMap.SimpleImmutableEntry<>("Ukrainian", Stream.of(
//                    new AbstractMap.SimpleImmutableEntry<>("name", "Indo-European Languages"),
//                    new AbstractMap.SimpleImmutableEntry<>("description", "This diverse and widespread language group includes most European languages as well as some from further East.")
//            ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)
//    );

    public static final Map<String, Map<String, String>> families = Map.ofEntries(
            new AbstractMap.SimpleImmutableEntry<>("Ukrainian", Map.of(
                    "name", "Indo-European Languages",
                    "description", "This diverse and widespread language group includes most European languages as well as some from further East."
            )),
            new AbstractMap.SimpleImmutableEntry<>("French", Map.of(
                    "name", "Indo-European Languages",
                    "description", "This diverse and widespread language group includes most European languages as well as some from further East."
            )),
            new AbstractMap.SimpleImmutableEntry<>("Spanish", Map.of(
                    "name", "Indo-European Languages",
                    "description", "This diverse and widespread language group includes most European languages as well as some from further East."
            )),
            new AbstractMap.SimpleImmutableEntry<>("German", Map.of(
                    "name", "Indo-European Languages",
                    "description", "This diverse and widespread language group includes most European languages as well as some from further East."
            )),
            new AbstractMap.SimpleImmutableEntry<>("Italian", Map.of(
                    "name", "Indo-European Languages",
                    "description", "This diverse and widespread language group includes most European languages as well as some from further East."
            )),
            new AbstractMap.SimpleImmutableEntry<>("Portuguese", Map.of(
                    "name", "Indo-European Languages",
                    "description", "This diverse and widespread language group includes most European languages as well as some from further East."
            )),
            new AbstractMap.SimpleImmutableEntry<>("Hindi", Map.of(
                    "name", "Indo-European Languages",
                    "description", "This diverse and widespread language group includes most European languages as well as some from further East."
            )),
            new AbstractMap.SimpleImmutableEntry<>("Persian (Farsi)", Map.of(
                    "name", "Indo-European Languages",
                    "description", "This diverse and widespread language group includes most European languages as well as some from further East."
            )),
            new AbstractMap.SimpleImmutableEntry<>("Russian", Map.of(
                    "name", "Indo-European Languages",
                    "description", "This diverse and widespread language group includes most European languages as well as some from further East."
            )),
            new AbstractMap.SimpleImmutableEntry<>("Japanese", Map.of(
                    "name", "Ural-Altaic Languages",
                    "description", "A controversial language family. Experts do not agree on which language family Japanese belongs to. We included it here in the Ural-Altaic family, but some linguists think it belongs better in the Austronesian family whilst others think it canot be classified. Likewise, there is some disagreement on whether Turkish and Korean belong to this group as well."
            )),
            new AbstractMap.SimpleImmutableEntry<>("Korean", Map.of(
                    "name", "Ural-Altaic Languages",
                    "description", "A controversial language family. Experts do not agree on which language family Japanese belongs to. We included it here in the Ural-Altaic family, but some linguists think it belongs better in the Austronesian family whilst others think it canot be classified. Likewise, there is some disagreement on whether Turkish and Korean belong to this group as well."
            )),
            new AbstractMap.SimpleImmutableEntry<>("Turkish", Map.of(
                    "name", "Ural-Altaic Languages",
                    "description", "A controversial language family. Experts do not agree on which language family Japanese belongs to. We included it here in the Ural-Altaic family, but some linguists think it belongs better in the Austronesian family whilst others think it canot be classified. Likewise, there is some disagreement on whether Turkish and Korean belong to this group as well."
            )),
            new AbstractMap.SimpleImmutableEntry<>("Mongolian", Map.of(
                    "name", "Ural-Altaic Languages",
                    "description", "A controversial language family. Experts do not agree on which language family Japanese belongs to. We included it here in the Ural-Altaic family, but some linguists think it belongs better in the Austronesian family whilst others think it canot be classified. Likewise, there is some disagreement on whether Turkish and Korean belong to this group as well."
            )),
            new AbstractMap.SimpleImmutableEntry<>("Kazakh", Map.of(
                    "name", "Ural-Altaic Languages",
                    "description", "A controversial language family. Experts do not agree on which language family Japanese belongs to. We included it here in the Ural-Altaic family, but some linguists think it belongs better in the Austronesian family whilst others think it canot be classified. Likewise, there is some disagreement on whether Turkish and Korean belong to this group as well."
            )),
            new AbstractMap.SimpleImmutableEntry<>("Hungarian", Map.of(
                    "name", "Ural-Altaic Languages",
                    "description", "A controversial language family. Experts do not agree on which language family Japanese belongs to. We included it here in the Ural-Altaic family, but some linguists think it belongs better in the Austronesian family whilst others think it canot be classified. Likewise, there is some disagreement on whether Turkish and Korean belong to this group as well."
            )),
            new AbstractMap.SimpleImmutableEntry<>("Arabic", Map.of(
                    "name", "Afro-Asiatic Languages",
                    "description", "These languages are spoken in North Africa and include the Berber languages spoken by desert nomads of the Sahara."
            )),
            new AbstractMap.SimpleImmutableEntry<>("Hausa", Map.of(
                    "name", "Afro-Asiatic Languages",
                    "description", "These languages are spoken in North Africa and include the Berber languages spoken by desert nomads of the Sahara."
            )),
            new AbstractMap.SimpleImmutableEntry<>("Swahili", Map.of(
                    "name", "Niger-Congo Languages",
                    "description", "Most African languages belong to this group, which may be the largest in the world in terms of distinct languages."
            )),
            new AbstractMap.SimpleImmutableEntry<>("Mandarin", Map.of(
                    "name", "Sino Tibetan Languages",
                    "description", "Like its name suggests, this family groups the languages of China and Tibet."
            )),
            new AbstractMap.SimpleImmutableEntry<>("Cantonese (Yue)", Map.of(
                    "name", "Sino Tibetan Languages",
                    "description", "Like its name suggests, this family groups the languages of China and Tibet."
            )),
            new AbstractMap.SimpleImmutableEntry<>("Bahasa Indonesia", Map.of(
                    "name", "Austronesian Languages",
                    "description", "Mostly spoken on the islands of Southeast Asia and the Pacific, only a few Austronesian languages are spoken on mainland Asia."
            ))
    );
}
