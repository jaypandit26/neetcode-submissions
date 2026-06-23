class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums2.length < nums1.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int n = nums1.length;
        int m = nums2.length;

        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;

        int l = 0;
        int r = n;

        while(l <= r){
            int mid = (l + r) / 2;
            int j = half - mid;

            int nums1Left = mid > 0 ? nums1[mid - 1] : Integer.MIN_VALUE;
            int nums1Right = mid < n ? nums1[mid] : Integer.MAX_VALUE;

            int nums2Left = j > 0 ? nums2[j-1] : Integer.MIN_VALUE;
            int nums2Right = j < m ? nums2[j] : Integer.MAX_VALUE;

            if(nums1Left <= nums2Right && nums2Left <= nums1Right){
                if(total % 2 != 0){
                    return Math.max(nums1Left, nums2Left);
                }
                return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
            }else if(nums1Left > nums2Right){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }
}
