import java.util.ArrayList;

/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author Damian Villarreal-Ayala
 *
 * Notes:
 * You want to find the longest span of days in which each day’s temperature is higher than on the previous day in that
 * sequence. The days you choose don’t have to be consecutive in the original list, but the order must be preserved.
 * ESSENTIALLY, you're making a consective list of higher temperatures, and you're allowed to ignore some on your way.
 *
 *
 * Window/Trunkated approach:
 * - Checking a window of 2, then 3, then etc.
 * - If I want some more support on this approach, ask Mr. Blick
 *
 * Assigning numbers their "trend" value and assign values the further in you go?
 * Ex.
 * 21, 25, 15, 23, 24
 * 1 ,  2,  1,  2, ?
 * You would give 24 a 3 for their "trend" value, but have it built off of the [15, 23] since
 * they have the same "trend" value as [21, 25] which remaining a lower digit.
 * Staying with the lower digit gives us more room to add on to the trend tracker.
 *
 * Would using a recursive method be a good idea?
 * Whenever we come across a new value that would "reset" the trend tracker, recurse and find the longest trend of
 * that section. Maybe we could go back and compare each respective trend tracker?
 * Look more into how a recursive method would work..
 * Updte: Recursive method likely not the best
 *
 * Dynamic Programming
 * - Idea of solving smaller parts of the problem to solve the larger, latter parts of the problem.
 * - This process is called memoization
 * Both are time: t(v^2)
 *
 * Adjacency Lists
 * - Space: (V + E)
 * Adjacency Matrix
 * - Space: O(V^2)
 *
 *
 */

public class WeatherPatterns {
    /**
     * Longest Warming Trend
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */
    public static int longestWarmingTrend(int[] temperatures) {
        // highestStreak is the longest sequence of increasingly larger ints, what we're returning.
        int highestStreak = 1;
        //thePath will hold the longest Path to the current temp (i), and will be compared against highestStreak
        int[] thePath = new int[temperatures.length];
//        ArrayList<Integer>[] list = new ArrayList[temperatures.length];

        //Just put in thePath[0] as 1 since there's no other option ?
        thePath[0] = 1;

        for(int i = 1; i < temperatures.length; i++)
        {
//            //To check output and help visualize
//            System.out.println(temperatures[i]);

            //To find the length of the Path to current temperature, if it exists.
            int trendLength = 0;

            // Replace with FindLongestTo once completed
            for(int j = 0; j < i; j++)
            {
                if(temperatures[i] > temperatures[j])
                {
                    trendLength = thePath[j];
                }

                thePath[i] = trendLength + 1;

                //If the length to thePath[i](current temp) is longer than the highestStreak, update highestStreak.
                if(thePath[i] > highestStreak)
                {
                    highestStreak = thePath[i];
                }
            }

//            if(temperatures[i] < lowestPoint)
//            {
//                lowestPoint = temperatures[i];
//                trendLength = 1;
//            }
            //If the current temperature is less than or equal to pointBreak, skip over it.
//            if (pointBreak >= temperatures[i])
//            {
//                i++;
//            }
//            else if (pointBreak < temperatures[i])
//            {
//                trendLength++;
//                pointBreak = temperatures[i];
//            }


//            if(temperatures[i] > lowestPoint)
//            {
//                trendLength++;
//            }
//            else if (temperatures[i] <= lowestPoint)
//            {
//                i++;
//            }
        }
        return highestStreak;
    }

//    should work to replace the for-loop currently in the
//    public static int LongestPathTo(int[] temperatures)
//    {
//        int len = 0;
//
//        return len + 1;
//    }
}
