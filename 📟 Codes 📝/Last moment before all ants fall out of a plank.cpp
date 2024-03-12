class Solution 
{
    //It calculates the last moment at which any particle on the line stops moving, given the positions of particles initially moving to the left ('left') and the positions of particles initially moving to the right ('right').
public:
    int getLastMoment(int n, vector<int>& left, vector<int>& right) 
    {
        const int maxLeft = left.empty() ? 0 : ranges::max(left);
      //'maxLeft' represents the rightmost position of a particle initially moving to the left. If 'left' is empty, it means there are no particles moving to the left, so 'maxLeft' is set to 0. Otherwise, it calculates the maximum value in the 'left' vector using 'ranges::max'.

        const int minRight = right.empty() ? n : ranges::min(right);
        //'minRight' represents the leftmost position of a particle initially moving to the right. If 'right' is empty, it means there are no particles moving to the right, so 'minRight' is set to 'n' (the length of the line). Otherwise, it calculates the minimum value in the 'right' vector using 'ranges::min'.

    return max(maxLeft, n - minRight);  
    //Finally, the function returns the maximum value between 'maxLeft' and the distance from the rightmost particle moving to the left to the leftmost particle moving to the right ('n - minRight'). This represents the last moment when any particle stops moving.

    }
};