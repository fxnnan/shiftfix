package dev.shiftfix;

public final class ModifierState {
    public static final int MOD_SHIFT = 1;
    public static final int MOD_CONTROL = 2;

    private static boolean shift;
    private static boolean control;

    private ModifierState() {}

    public static void onKey(int key, int action) {
        boolean down = action != 0;
        if (key == 340 || key == 344) shift = down;
        if (key == 341 || key == 345) control = down;
    }

    public static int extraModifiers() {
        return (shift ? MOD_SHIFT : 0) | (control ? MOD_CONTROL : 0);
    }
}
