// feeling great 🥰🥰 all i needed gpt's help was in how to use split function since . is special in regex, it alone doesnt work.
// took me soome time tho

class CompareVersionNumbers {
    public static int comp(String[] v1, String[] v2, int i) {
        if (i == v1.length && i == v2.length) {
            return 0;
        } else if (i == v1.length) {
            while (i < v2.length ) {
                if (Integer.parseInt(v2[i]) > 0) {
                    return -1;
                }
                i++;
            }
            return 0;
        } else if (i == v2.length) {
            while (i < v1.length ) {
                if (Integer.parseInt(v1[i]) > 0) {
                    return 1;
                }
                i++;
            }
            return 0;
        } else if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
            return -1;
        } else if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
            return 1;
        } else {
            return comp(v1, v2, i + 1);
        }

    }

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        if (Integer.parseInt(v1[0]) < Integer.parseInt(v2[0])) {
            return -1;
        } else if (Integer.parseInt(v1[0]) > Integer.parseInt(v2[0])) {
            return 1;
        } else {
            int i = 1;
            return comp(v1, v2, i);
        }

    }
}
