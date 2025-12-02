import java.util.*;
 
public class ReservoirFill {
 
    // Method to compute how much water can be stored
    public static int calculateWater(int[] baseHeights) {
        int n = baseHeights.length;
        if (n <= 2) return 0;  // Need at least 3 bars to trap water
 
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
 
        // Two-pointer approach
        while (left < right) {
            if (baseHeights[left] < baseHeights[right]) {
                if (baseHeights[left] >= leftMax) {
                    leftMax = baseHeights[left];
                } else {
                    water += leftMax - baseHeights[left];
                }
                left++;
            } else {
                if (baseHeights[right] >= rightMax) {
                    rightMax = baseHeights[right];
                } else {
                    water += rightMax - baseHeights[right];
                }
                right--;
            }
        }
 
        return water;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        System.out.println("Enter number of points on the reservoir base:");
        int n = sc.nextInt();
 
        int[] heights = new int[n];
 
        System.out.println("Enter the height values (uneven base):");
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
 
        int waterHeld = calculateWater(heights);
        System.out.println("Total water the reservoir can hold: " + waterHeld + " units.");
    }
}
