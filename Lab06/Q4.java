/*
 * Answer for Q4
 * @author Eren Karakas 22002722
 * @version 1.0
 * 21/07/2021
 */


import java.io.File;

public class Q4 {

    /**
     * @param args Command line arguments
     */
    public static void main( String[] args ) {
        String directory = "/home/eren/Videos";
        File file = new File( directory );

        System.out.println( countFiles( file, 0 ) );
    }

    /**
     * Recursively counts the amount files in a directory tree
     *
     * @param file File to look
     * @param numOfFiles Number of files found until now
     * @return Number of files found until now
     */
    public static int countFiles( File file, int numOfFiles ) {
        // If it is a file, increment number of files
        if ( file.isFile() ) {
            numOfFiles += 1;
        }
        // If it is a directory, recurse
        else if ( file.isDirectory() ) {
            File[] files = file.listFiles();
            // Base case
            if ( files == null ) {
                return numOfFiles;
            }

            // Iterate through found files
            for ( File example : files ) {
                numOfFiles = countFiles( example, numOfFiles );
            }
        }

        return numOfFiles;
    }
}
