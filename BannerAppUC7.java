public class OOPSBannerApp {
    static class CharacterPatternMap {
        Character character;
        String[] pattern;
        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }
        public Character getCharacter() {
            return character;
        }
        public String[] getPattern() {
            return pattern;
        }
    }
    public static CharacterPatternMap[] createCharacterPatternMaps() {
        CharacterPatternMap[] characterPatternMap = new CharacterPatternMap[4];

        characterPatternMap[0] = new CharacterPatternMap('O', new String[] {
            "  ***  ",
            " ** ** ",
            "**   **",
            "**   **",
            "**   **",
            " ** ** ",
            "  ***  "
        });

        characterPatternMap[1] = new CharacterPatternMap('P', new String[] {
            "****** ",
            "**  ** ",
            "**  ** ",
            "****** ",
            "**     ",
            "**     ",
            "**     "
        });

        characterPatternMap[2] = new CharacterPatternMap('S', new String[] {
            "***** ",
            "**     ",
            "**     ",
            " ***   ",
            "   **  ",
            "   **  ",
            "***** "
        });

        characterPatternMap[3] = new CharacterPatternMap(' ', new String[] {
            "       ",
            "       ",
            "       ",
            "       ",
            "       ",
            "       ",
            "       "
        });

        return characterPatternMap;
    }
    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] charMaps) {
        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }
        // If character not found, return space pattern
        return getCharacterPattern(' ', charMaps);
    }
    public static void printMessage(String message, CharacterPatternMap[] charMaps) {
        int patternHeight = 7;
        for (int line = 0; line < patternHeight; line++) {
            StringBuilder row = new StringBuilder();
            for (int c = 0; c < message.length(); c++) {
                String[] pattern = getCharacterPattern(message.charAt(c), charMaps);
                if (c > 0) {
                    row.append("  ");
                }
                row.append(pattern[line]);
            }
            System.out.println(row.toString());
        }
    }
    public static void main(String[] args) {
        // Create CharacterPatternMap array
        CharacterPatternMap[] charMaps = createCharacterPatternMaps();
        // Define the message to be displayed
        String message = "OOPS";
        // Print the banner message
        printMessage(message, charMaps);
    }
}
