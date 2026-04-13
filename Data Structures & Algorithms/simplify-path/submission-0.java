class Solution {
    public String simplifyPath(String path) {
        Stack<String> folders = new Stack<>();
        int index = 0;
        while (index < path.length()) {
            int nextIndex = path.indexOf('/', index);
            if (nextIndex == -1) {
                nextIndex = path.length();
            }
            String nextFolder = path.substring(index, nextIndex);
            switch (nextFolder) {
                case "..":
                    if (!folders.isEmpty()) {
                        folders.pop();
                    }
                    break;
                case "":
                    break;
                case ".":
                    break;
                case "/":
                    break;
                default:
                    folders.push(nextFolder);
            }
            index = nextIndex + 1;
        }

        String result = "";
        while (!folders.isEmpty()) {
            result =  "/" + folders.pop() + result;
        }
        return result.length() == 0 ? "/" : result;
    }
}