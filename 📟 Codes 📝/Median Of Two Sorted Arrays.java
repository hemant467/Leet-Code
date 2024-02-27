class Solution {
  public double findMedianSortedArrays(int[] num1, int[] num2) {
    final int n1 = num1.length;
    final int n2 = num2.length;
    if (n1 > n2)
      return findMedianSortedArrays(num2, num1);

    int l = 0;
    int r = n1;

    while (l <= r) {
      final int partition1 = (l + r) / 2;
      final int partition2 = (n1 + n2 + 1) / 2 - partition1;
      final int maxLeft1 = partition1 == 0 ? Integer.MIN_VALUE : num1[partition1 - 1];
      final int maxLeft2 = partition2 == 0 ? Integer.MIN_VALUE : num2[partition2 - 1];
      final int minRight1 = partition1 == n1 ? Integer.MAX_VALUE : num1[partition1];
      final int minRight2 = partition2 == n2 ? Integer.MAX_VALUE : num2[partition2];
      if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1)
        return (n1 + n2) % 2 == 0
            ? (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) * 0.5
            : Math.max(maxLeft1, maxLeft2);
      else if (maxLeft1 > minRight2)
        r = partition1 - 1;
      else
        l = partition1 + 1;
    }

    throw new IllegalArgumentException();
  }
}