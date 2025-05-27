module com.utils {
    exports com.utils;
}
package com.utils;

public class StringUtils {
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
module com.greetings {
    requires com.utils;
}
package com.greetings;

import com.utils.StringUtils;

public class Greeting {
    public static void main(String[] args) {
        String name = "alice";
        System.out.println("Hello, " + StringUtils.capitalize(name) + "!");
    }
}
