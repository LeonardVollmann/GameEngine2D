package nona.gameengine2d.input;

public class Keyboard {
	
	// The Keyboard input handling is a bit inefficient, but the only way without using a massive switch block
	
	public static final int OFFSET = 0x20;
	
	/** Printable keys. */
	public static final int
		KEY_SPACE         = 0x20 - OFFSET,
		KEY_APOSTROPHE    = 0x27 - OFFSET,
		KEY_COMMA         = 0x2C - OFFSET,
		KEY_MINUS         = 0x2D - OFFSET,
		KEY_PERIOD        = 0x2E - OFFSET,
		KEY_SLASH         = 0x2F - OFFSET,
		KEY_0             = 0x30 - OFFSET,
		KEY_1             = 0x31 - OFFSET,
		KEY_2             = 0x32 - OFFSET,
		KEY_3             = 0x33 - OFFSET,
		KEY_4             = 0x34 - OFFSET,
		KEY_5             = 0x35 - OFFSET,
		KEY_6             = 0x36 - OFFSET,
		KEY_7             = 0x37 - OFFSET,
		KEY_8             = 0x38 - OFFSET,
		KEY_9             = 0x39 - OFFSET,
		KEY_SEMICOLON     = 0x3B - OFFSET,
		KEY_EQUAL         = 0x3D - OFFSET,
		KEY_A             = 0x41 - OFFSET,
		KEY_B             = 0x42 - OFFSET,
		KEY_C             = 0x43 - OFFSET,
		KEY_D             = 0x44 - OFFSET,
		KEY_E             = 0x45 - OFFSET,
		KEY_F             = 0x46 - OFFSET,
		KEY_G             = 0x47 - OFFSET,
		KEY_H             = 0x48 - OFFSET,
		KEY_I             = 0x49 - OFFSET,
		KEY_J             = 0x4A - OFFSET,
		KEY_K             = 0x4B - OFFSET,
		KEY_L             = 0x4C - OFFSET,
		KEY_M             = 0x4D - OFFSET,
		KEY_N             = 0x4E - OFFSET,
		KEY_O             = 0x4F - OFFSET,
		KEY_P             = 0x50 - OFFSET,
		KEY_Q             = 0x51 - OFFSET,
		KEY_R             = 0x52 - OFFSET,
		KEY_S             = 0x53 - OFFSET,
		KEY_T             = 0x54 - OFFSET,
		KEY_U             = 0x55 - OFFSET,
		KEY_V             = 0x56 - OFFSET,
		KEY_W             = 0x57 - OFFSET,
		KEY_X             = 0x58 - OFFSET,
		KEY_Y             = 0x59 - OFFSET,
		KEY_Z             = 0x5A - OFFSET,
		KEY_LEFT_BRACKET  = 0x5B - OFFSET,
		KEY_BACKSLASH     = 0x5C - OFFSET,
		KEY_RIGHT_BRACKET = 0x5D - OFFSET,
		KEY_GRAVE_ACCENT  = 0x60 - OFFSET,
		KEY_WORLD_1       = 0xA1 - OFFSET,
		KEY_WORLD_2       = 0xA2 - OFFSET,
		KEY_ESCAPE        = 0x100 - OFFSET,
		KEY_ENTER         = 0x101 - OFFSET,
		KEY_TAB           = 0x102 - OFFSET,
		KEY_BACKSPACE     = 0x103 - OFFSET,
		KEY_INSERT        = 0x104 - OFFSET,
		KEY_DELETE        = 0x105 - OFFSET,
		KEY_RIGHT         = 0x106 - OFFSET,
		KEY_LEFT          = 0x107 - OFFSET,
		KEY_DOWN          = 0x108 - OFFSET,
		KEY_UP            = 0x109 - OFFSET,
		KEY_PAGE_UP       = 0x10A - OFFSET,
		KEY_PAGE_DOWN     = 0x10B - OFFSET,
		KEY_HOME          = 0x10C - OFFSET,
		KEY_END           = 0x10D - OFFSET,
		KEY_CAPS_LOCK     = 0x118 - OFFSET,
		KEY_SCROLL_LOCK   = 0x119 - OFFSET,
		KEY_NUM_LOCK      = 0x11A - OFFSET,
		KEY_PRINT_SCREEN  = 0x11B - OFFSET,
		KEY_PAUSE         = 0x11C - OFFSET,
		KEY_F1            = 0x122 - OFFSET,
		KEY_F2            = 0x123 - OFFSET,
		KEY_F3            = 0x124 - OFFSET,
		KEY_F4            = 0x125 - OFFSET,
		KEY_F5            = 0x126 - OFFSET,
		KEY_F6            = 0x127 - OFFSET,
		KEY_F7            = 0x128 - OFFSET,
		KEY_F8            = 0x129 - OFFSET,
		KEY_F9            = 0x12A - OFFSET,
		KEY_F10           = 0x12B - OFFSET,
		KEY_F11           = 0x12C - OFFSET,
		KEY_F12           = 0x12D - OFFSET,
		KEY_F13           = 0x12E - OFFSET,
		KEY_F14           = 0x12F - OFFSET,
		KEY_F15           = 0x130 - OFFSET,
		KEY_F16           = 0x131 - OFFSET,
		KEY_F17           = 0x132 - OFFSET,
		KEY_F18           = 0x133 - OFFSET,
		KEY_F19           = 0x134 - OFFSET,
		KEY_F20           = 0x135 - OFFSET,
		KEY_F21           = 0x136 - OFFSET,
		KEY_F22           = 0x137 - OFFSET,
		KEY_F23           = 0x138 - OFFSET,
		KEY_F24           = 0x139 - OFFSET,
		KEY_F25           = 0x13A - OFFSET,
		KEY_KP_0          = 0x140 - OFFSET,
		KEY_KP_1          = 0x141 - OFFSET,
		KEY_KP_2          = 0x142 - OFFSET,
		KEY_KP_3          = 0x143 - OFFSET,
		KEY_KP_4          = 0x144 - OFFSET,
		KEY_KP_5          = 0x145 - OFFSET,
		KEY_KP_6          = 0x146 - OFFSET,
		KEY_KP_7          = 0x147 - OFFSET,
		KEY_KP_8          = 0x148 - OFFSET,
		KEY_KP_9          = 0x149 - OFFSET,
		KEY_KP_DECIMAL    = 0x14A - OFFSET,
		KEY_KP_DIVIDE     = 0x14B - OFFSET,
		KEY_KP_MULTIPLY   = 0x14C - OFFSET,
		KEY_KP_SUBTRACT   = 0x14D - OFFSET,
		KEY_KP_ADD        = 0x14E - OFFSET,
		KEY_KP_ENTER      = 0x14F - OFFSET,
		KEY_KP_EQUAL      = 0x150 - OFFSET,
		KEY_LEFT_SHIFT    = 0x154 - OFFSET,
		KEY_LEFT_CONTROL  = 0x155 - OFFSET,
		KEY_LEFT_ALT      = 0x156 - OFFSET,
		KEY_LEFT_SUPER    = 0x157 - OFFSET,
		KEY_RIGHT_SHIFT   = 0x158 - OFFSET,
		KEY_RIGHT_CONTROL = 0x159 - OFFSET,
		KEY_RIGHT_ALT     = 0x15A - OFFSET,
		KEY_RIGHT_SUPER   = 0x15B - OFFSET,
		KEY_MENU          = 0x15C - OFFSET,
		KEY_LAST          = 0x15C;
	
	public static final int NUM_KEYS = KEY_LAST - OFFSET; 
	
	private static boolean keys[];
	private static boolean lastKeys[];
	
	public static void init() {
		keys = new boolean[NUM_KEYS];
		lastKeys = new boolean[NUM_KEYS];
	}
	
	public static void update() {
		lastKeys = keys;
	}
	
	public static void setKey(int key, boolean press) {
		keys[key - OFFSET] = press;
	}
	
	public static boolean getKey(int key) {
		return keys[key];
	}
	
	public static boolean getKeyPress(int key) {
		return keys[key] && !lastKeys[key];
	}
	
	public static boolean getKeyRelease(int key) {
		return !keys[key] && lastKeys[key];
	}
	
}