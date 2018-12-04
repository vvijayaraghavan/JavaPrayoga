package codility.painless.iterations;

public class BinaryGap {

    public static void main(String a[]) {

        int num = 32;
        String binNum = Integer.toBinaryString(num);

        System.out.println(num);
        System.out.println(binNum + "\t length of binary num: " + binNum.length());
        System.out.println("binary gap is: " + getBinaryGap(binNum));
    }

    private static int getBinaryGap(String binNum) {

        int prevCount = 0;

        if (binNum.charAt(0) == '0') {
            return 0;
        } else if (binNum.length() <= 2) {
            return 0;
        } else {

            //Start the iteration process
            int startPos = 1;
            int endPos = binNum.length() - 1;
            int startCounting = 0;
            int currPos = startPos;

            while (currPos <= endPos) {

                char currChar = binNum.charAt(currPos);
                if (currChar == '0') {

                    startCounting++;
                } else {

                    if (prevCount < startCounting) {
                        prevCount = startCounting;
                    }

                    //improve efficiency
                    //avoid un-necessary looping
                    if (prevCount >= endPos - currPos) {
                        System.out.println("Exiting from position: " + currPos);
                        break;
                    }

                    startCounting = 0;
                }

                currPos++;
            }
        }
        return prevCount;
    }

}