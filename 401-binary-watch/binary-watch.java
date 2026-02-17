class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        
        
        int[] arr = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
        backtrack(arr, 0, 0, 0, num, result);
        return result;
    }

    public void backtrack(int[] arr, int position, int hours, int minutes, int limit, List<String> result) {
        
        if (limit == 0) {
            
            if(hours <= 11 && minutes <= 59) {
                StringBuilder builder = new StringBuilder();
                builder.append(hours).append(":").append(minutes <= 9 ? "0" + minutes : minutes);
                result.add(builder.toString());
            }
            return;
        }

        
        for (int i = position; i < arr.length; i++) {
            if (isHour(i)) hours += arr[i];
            else minutes += arr[i];

            backtrack(arr, i + 1, hours, minutes, limit - 1, result);

            if (isHour(i)) hours -= arr[i];
            else minutes -= arr[i];
        }
    }

    
    public boolean isHour(int position) {
        return position >= 0 && position <= 3;
    }
}