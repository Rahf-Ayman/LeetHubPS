class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ;i < nums1.length ;i++){

                int idx = BinarySearch(nums1[i], nums2 , set);

                if (idx != -1 && !set.contains(idx)) {
                    list.add(nums1[i]);
                    set.add(idx);
                }

        }
        return list.stream().mapToInt(i -> i).toArray();
    }
    public static int BinarySearch(int i, int[] nums2, Set<Integer> usedIndices) {
        int l = 0;
    int r = nums2.length - 1;

    while (l <= r) {
        int mid = l + (r - l) / 2;

        if (nums2[mid] == i) {
            // search for the first unused index around mid
            int left = mid;
            while (left >= l && nums2[left] == i) {
                if (!usedIndices.contains(left)) return left;
                left--;
            }

            int right = mid + 1;
            while (right <= r && nums2[right] == i) {
                if (!usedIndices.contains(right)) return right;
                right++;
            }

            return -1; // all matching indices used
        } else if (nums2[mid] > i) {
            r = mid - 1;
        } else {
            l = mid + 1;
        }
    }

    return -1;
    }
}