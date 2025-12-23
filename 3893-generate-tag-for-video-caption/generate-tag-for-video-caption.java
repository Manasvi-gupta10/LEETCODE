class Solution {
    public String generateTag(String caption) {

        if (caption == null || caption.trim().isEmpty()) {
            return "#";
        }

        String[] arr = caption.trim().split(" ");
        StringBuilder ans = new StringBuilder();
        ans.append("#");
        ans.append(arr[0].toLowerCase());
        for (int i = 1; i < arr.length; i++) {
            ans.append(capitalize(arr[i]));
        }
        if (ans.length() > 100) {
            return ans.substring(0, 100);
        }
        return ans.toString();
    }

    private String capitalize(String word) {
        if (word.length() == 0) return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
}